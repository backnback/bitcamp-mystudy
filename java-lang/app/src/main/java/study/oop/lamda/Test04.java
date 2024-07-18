package study.oop.lamda;

public class Test04 {


  interface InterestCalculator {
    double compute(int money);
  }

  // [팩토리 메서드]
  // 1) 일반 클래스 (로컬 클래스의 특징 이용 안함)
  static InterestCalculator create1(double rate) {
    class My implements InterestCalculator {

      double rate;

      public My(double rate) {
        this.rate = rate;
      }

      @Override
      public double compute(int money) {
        return money + (money * rate);
      }
    }
    return new My(rate);
  }



  // 2) 일반 클래스 + 로컬 클래스의 특징 이용
  static InterestCalculator create2(double rate) {
    class My implements InterestCalculator {
      @Override
      public double compute(int money) {
        return money + (money * rate);
      }
    }
    return new My();
  }

  // 위의 파라미터가 아니라, 실제 생성자에 값을 넣어주는 코드로 바뀐다.???



  // 3) 익명 클래스
  static InterestCalculator create3(double rate) {
    InterestCalculator c = new InterestCalculator() {
      @Override
      public double compute(int money) {
        return money + (money * rate);
      }
    };
    return c;
  }



  // 4) 익명 클래스 직접 대입
  static InterestCalculator create4(double rate) {
    return new InterestCalculator() {
      @Override
      public double compute(int money) {
        return money + (money * rate);
      }
    };
  }



  // 5) 람다
  static InterestCalculator create5(double rate) {
    InterestCalculator c = money -> money + (money * rate);
    return c;
  }



  // 6) 람다 직접 대입
  static InterestCalculator create6(double rate) {
    return money -> money + (money * rate);
  }


  public static void main(String[] args) {
    InterestCalculator c1 = create1(0.035);
    System.out.println(c1.compute(1000_0000));

    System.out.println(create2(0.035).compute(1000_0000));
    System.out.println(create3(0.035).compute(1000_0000));
    System.out.println(create4(0.035).compute(1000_0000));
    System.out.println(create5(0.035).compute(1000_0000));
    System.out.println(create6(0.035).compute(1000_0000));
  }

}
