package study.lang.operator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ChatClient {
  public static void main(String[] args) {
    try {
      Socket socket = new Socket("localhost", 7777);
      System.out.println("서버에 연결되었습니다.");

      BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

      BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

      Thread serverListener = new Thread(() -> {
        try {
          while (true) {
            String input = reader.readLine();
            if (input == null) {
              break;
            }
            synchronized (System.out) {
              System.out.println("상대방: " + input);
            }
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
      });
      serverListener.start();

      while (true) {
        System.out.print("나: ");
        String message = consoleReader.readLine();
        if (message == null || message.equalsIgnoreCase("quit")) {
          break;
        }
        synchronized (System.out) {
          writer.write(message + "\n");
          writer.flush();
        }
      }

      serverListener.interrupt(); // 클라이언트가 종료되면 서버 리스너 스레드도 종료

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
