package com.eomcs.lang.ex05;

// # 비트 이동 연산자 : >>, >>>, <<
//
public class Exam0432 {
  public static void main(String[] args) {
    // >>> 연산 사용 예
    // - 음수 값의 일부를 추출할 때 유용

    int color = 0b10110011_10101111_11110010_00001000;

    System.out.println(color >> 24); // -77
                                     // [11111111_11111111_11111111_10110011]_10101111_11110010_00001000

    System.out.println(color >> 24 & 0x000000ff); // 179
                                                  // [00000000_00000000_00000000_10110011]


    System.out.println(color >>> 24); // 179
                                      // [00000000_00000000_00000000_10110011]_10101111_11110010_00001000


  }
}
