package study.lang.method;

public class Test07 {
  public static void main(String[] args) {

    // sum = 1 + 2 + 3 + 4 + ... + 10
    int sum = 0;
    for (int i = 1; i <= 10; i++) {
      sum += i;

    }
    System.out.println(sum);


    // sum(10) = 10 + sum(9)
    // = 10 + 9 + sum(8)
    // = 10 + 9 + 8 + sum(7)
    // = 10 + 9 + 8 + ... + sum(1)
    // sum(n) = n + sum(n - 1)

    System.out.println(sum(10));

  }


  // 재귀 호출 (같은 함수를 여러 번 호출)
  static int sum(int n) {
    if (n == 1) {
      return 1; // 없으면 무한 루프 (n = 1일 때 멈춘다)
    }
    return n + sum(n - 1);
  }
}
