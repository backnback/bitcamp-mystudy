package study.lang.operator;


// 실습
// - 산술 연산자를 사용하여 연산을 수행한 후 결과를 확인하라.
//
// 학습 내용
// - 같은 타입끼리만 연산할 수 있다.
// - 타입이 다르면 컴파일러는 같은 타입으로 자동 변환한다. (implicit type conversion, 암시적 형변환)
//   (byte, char, short) -->  int  -->  long  -->  float  -->  double
// 
// - 개발자가 명시적으로 타입을 변환할 수 있다. (explicit type conversion, 명시적 형변환)
// - 


public class Test03 {

  public static void main(String[] args) { 
    byte b = 1; 
    char c = 2;
    short s = 3;
    int i = 4;
    long l = 5;
    float f = 6.0f;
    double d = 7.0;
    
    // short r = b + c + s;  // (byte, char, short)은 무조건 연산 전에 int로 바뀐다.
    int r = b + c + s;

    long r2 = i + l;  // int와 long의 연산 결과는 long이다. 
    
    // long r3 = f;  // 부동소수점을 정수 메모리에 저장할 수 없다. (정수값을 부동소수점 메모리에 저장가능)
    float r4 = l;  // 값이 잘릴 수 있다. (에러는 안 뜸)
    
    
    System.out.println("--------------------------");

    


  }

}
