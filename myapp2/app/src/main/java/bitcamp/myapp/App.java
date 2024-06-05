/*
 * This source file was generated by the Gradle 'init' task
 */
package bitcamp.myapp;


import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String boldAnsi = "\u001B[1m";
        String redAnsi = "\u001B[31m";
        String resetAnsi = "\u001B[0m";

        String appTitle = "[팀 프로젝트 관리 시스템]";
        String line = "--------------------------------------";
        String[] menu = {"회원", "팀", "프로젝트", "게시판", "도움말", "종료"};

        System.out.println(boldAnsi + line + resetAnsi);
        System.out.println(boldAnsi + appTitle + resetAnsi);
        System.out.println();

        for (int i = 0; i <menu.length; i++) {
            if (i == 5) {
                System.out.println(boldAnsi + redAnsi + (i+1) + ". " + menu[i] + resetAnsi);
            } else {
                System.out.println((i+1) + ". " + menu[i]);
            }

        }
        System.out.println(boldAnsi + line + resetAnsi);

        int menuNo;

        do {

            System.out.println("> ");
            menuNo = sc.nextInt();

            switch (menuNo) {
                case 1:
                    System.out.println(menu[0]);
                    break;
                case 2:
                    System.out.println(menu[1]);
                    break;
                case 3:
                    System.out.println(menu[2]);
                    break;
                case 4:
                    System.out.println(menu[3]);
                    break;
                case 5:
                    System.out.println(menu[4]);
                    break;
                case 6:
                    System.out.println(menu[5]);
                    break;
                default:
                    System.out.println("메뉴 번호가 옳지 않습니다.");
                    break;
            }


        } while (menuNo != 6);



    }

}
