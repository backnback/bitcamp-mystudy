package study.oop.nested;

public class test01 {

  // 인터페이스 정의
  interface Printer {
    void print();
  }

  public static void main(String[] args) {

    // 로컬 클래스 정의
    class PrinterImpl implements Printer {
      @Override
      public void print() {
        System.out.println("Hello!");
      }
    }

    Printer obj = new PrinterImpl();
    obj.print(); // Hello!



  }

}
