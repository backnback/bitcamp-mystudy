package study.oop.lamda;

public class Test05 {

  static class MyCalculator {
    public static int plus(int a, int b) {
      return a + b;
    }

    public static int minus(int a, int b) {
      return a - b;
    }

    public static int multiple(int a, int b) {
      return a * b;
    }

    public static int divide(int a, int b) {
      return a / b;
    }
  }

  interface Calculator {
    int compute(int x, int y);
  }


  public static void main(String[] args) {

    // class My implements Calculator {
    // @Override
    // public int compute(int x, int y) {
    // return x + y;
    // }
    // }
    // Calculator c1 = new My(); // 인스턴스 메서드는 인스턴스가 있어야 사용 가능
    // int result = c1.compute(100, 200);
    // System.out.println(result);
    //
    // class My implements Calculator {
    // @Override
    // public int compute(int x, int y) {
    // return MyCalculator.plus(x, y);
    // }
    // }
    //
    // Calculator c2 = new My(); // 인스턴스 메서드는 인스턴스가 있어야 사용 가능
    // int result = c2.compute(100, 200);
    // System.out.println(result);



    // Calculator c3 = new Calculator() {
    // @Override
    // public int compute(int x, int y) {
    // return MyCalculator.plus(x, y);
    // }
    // };
    // int result = c3.compute(100, 200);
    // System.out.println(result);



    // Calculator c4 = (x, y) -> MyCalculator.plus(x, y);
    // int result = c4.compute(100, 200);
    // System.out.println(result);


    Calculator c5 = MyCalculator::plus;
    int result = c5.compute(100, 200);
    System.out.println(result);


  }

}
