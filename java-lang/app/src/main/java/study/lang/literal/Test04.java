package study.lang.literal;

// 실습

// 문자 A를 유니코드로 표현하라.
// 

public class Test04 {

    public static void main(String[] args) {
        // 코드를 완성하라.
        System.out.println('A'); // A
        System.out.println('\u0041'); // 유니코드 문자 리터럴
        System.out.println('a'); // a
        System.out.println('\u0061'); // 소문자 a의 유니코드 문자 리터럴
        System.out.println('1'); // 1
        System.out.println('\u0031'); // 숫자 1의 유니코드 문자 리터럴
        System.out.println('가'); // 가
        System.out.println('\uAC00'); // 한글'가'의 유니코드 문자 리터럴
        System.out.println('똥'); // 똥
        System.out.println('\uB625'); // 한글'똥'의 유니코드 문자 리터럴
        System.out.println('\u00A9'); // copyright 문자를 유니코드로 뽑기

    }

}
