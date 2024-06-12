package study.lang.method;

public class Test02 {

  public static void main(String[] args) {

    m1("홍길동", 20); // m1 메서드 signature를 보면 argument가 있어야 한다.
                   // parameter 값을 넣을 때 순서와 개수, 타입이 맞아야 한다.
    m1("김민수", 55);
    m1("Baby", 3);
  }

  // Parameter가 있는 메서드 정의
  static void m1(String name, int age) {
    System.out.printf("%s(%d)님 반갑습니다.\n", name, age);
  }

}
