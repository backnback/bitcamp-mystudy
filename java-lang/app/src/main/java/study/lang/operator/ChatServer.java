package study.lang.operator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
  public static void main(String[] args) {
    try {
      ServerSocket serverSocket = new ServerSocket(7777);
      System.out.println("서버가 시작되었습니다.");

      Socket socket1 = serverSocket.accept();
      System.out.println("클라이언트 1이 접속했습니다.");

      Socket socket2 = serverSocket.accept();
      System.out.println("클라이언트 2가 접속했습니다.");

      BufferedReader reader1 = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
      BufferedWriter writer1 =
          new BufferedWriter(new OutputStreamWriter(socket1.getOutputStream()));

      BufferedReader reader2 = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
      BufferedWriter writer2 =
          new BufferedWriter(new OutputStreamWriter(socket2.getOutputStream()));

      new Thread(() -> {
        try {
          while (true) {
            synchronized (System.out) {
              String input = reader1.readLine();
              System.out.println("클라이언트 1: " + input);
              writer2.write(input + "\n");
              writer2.flush();
            }
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
      }).start();

      new Thread(() -> {
        try {
          while (true) {
            synchronized (System.out) {
              String input = reader2.readLine();
              System.out.println("클라이언트 2: " + input);
              writer1.write(input + "\n");
              writer1.flush();
            }
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
      }).start();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
