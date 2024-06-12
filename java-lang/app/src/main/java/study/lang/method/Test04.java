package study.lang.method;

public class Test04 {

  public static void main(String[] args) {

    System.out.println(m1("홍길동", 20));


  }

  static String m1(String name, int age) {
    // String message = name + "(" + age + ")님 반가워요!"; // printf 처럼 사용하고 싶다면 아래 이용.
    // String 클래스의 format() 메서드를 사용하면 가능하다.
    return String.format("%s(%d)님 반가워요", name, age);
  }

}
