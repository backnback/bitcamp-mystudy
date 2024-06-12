package study.lang.method;

public class Test09 {

  public static void main(String[] args) {
    int[] values = new int[] {100, 110, 120};
    m1(values);

    System.out.println(values[0]);

  }

  static void m1(int[] values) { // int 배열의 주소를 받는 변수가 필요
    values[0] = 200;
  }

}
