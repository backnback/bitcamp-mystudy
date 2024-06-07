package study.lang.operator;


// 실습
// - 산술 연산자를 사용하여 연산을 수행한 후 결과를 확인하라.
//
// 학습 내용
// - byte, short, char를 산술연산할 때 int로 변환한 후 수행한다.
// - 같은 타입끼리만 연산할 수 있다.
// - 따라서 int와 int의 연산 결과는 int이다. (중요)
// - 다른 타입으로 변환하는 것을 '형변환(type casting)'이라 한다.
// -


public class Test02 {

  public static void main(String[] args) { // byte 타입끼리의 연산을 해도 결과는 int로 취급됨.
    byte b1 = 100; // 따라서 int인 결과를 byte 타입 변수에 넣어서 컴파일 오류
    byte b2 = 20;
    byte b3;

    // 다음 테스트 해 보고, 컴파일 오류가 나는 이유를 설명하
    // 컴파일 오류가 나지 않도록 해결하라.
    b3 = 100 - 20; // 리터럴 끼리의 연산 결과는 리터럴이다.
    b3 = (byte) (b1 + b2); // byte, char, short는 int로 변환된 후 실행된다.
    System.out.println(b3);
    // 해결 방법
    // int로 취급되는 연산결과를 byte로 형변환을 해주고 넣는다.

    System.out.println("--------------------------");

    int r = b1 + b2; // ok

    char c = 20;
    short s = 30;
    // short r2 = c + s; //

    System.out.println("--------------------------");

    long i1 = 22_0000_0000L; // 4 byte 리터럴 유효 범위를 넘어서므로 8 byte 리터럴로 변환
    long i2 = 21_0000_0000;
    long i3 = i1 + i2;
    System.out.println(i3);



  }

}
