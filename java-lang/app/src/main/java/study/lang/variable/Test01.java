package study.lang.variable;

public class Test01 {

  public static void main(String[] args) {
    // 실습
    // - primitive type의 변수를 선언하라.
    // 각 변수의 최대값, 최소값을 할당하라.
    // 각 변수에 최소값, 최대값 범위를 벗어나는 값을 넣은 후 오류를 확인하라.
    // 예) byte b1 = -128;
    // byte b2 = 127;

    byte b1 = -128; // 1 byte
    byte b2 = 127;
    // byte b3 = 128;
    // byte b4 = -130;


    short s1 = 32767; // 2 byte
    short s2 = -32768;
    // short s3 = 32768;
    // short s4 = -32769;


    int i1 = 21_4748_3647; // 4 byte
    int i2 = -2147483648;
    // int i3 = 2147483648;
    // int i4 = -2147483649;


    long l1 = 9223372036854775807L; // 8 byte
    long l2 = -9223372036854775808L;
    // long l3 = 9223372036854775808L;
    // long l4 = -9223372036854775809L;


    float f1 = 3.4028235E38f; // 유효 자릿수 7자리
    float f2 = 1.4E-45f;
    // float f3 = 3.4028236E38f;
    // float f4 = 1.4E-46f; // -45승에서 -46승으로 바뀌어야 오류
    float f3 = 12345.67898f;
    System.out.println(f3);

    float f4 = 9876.543f;
    double d4 = 987654323456.789;
    System.out.println(f4);
    System.out.println(d4);

    double d1 = 1.7976931348623157E308; // 유효 자릿수 15자리
    double d2 = 4.9E-324;
    // double d3 = 1.7976931348623159E308;
    // double d4 = 4.9E-325;


    boolean bo1 = true;
    boolean bo2 = false;
    // boolean bo3 = d;
    // boolean bo4 = null; // boolean는 true와 false만 가능


    char ch1 = 0;
    char ch2 = 65535;
    // char ch3 = -1;
    // char ch4 = 65536;


  }

}
