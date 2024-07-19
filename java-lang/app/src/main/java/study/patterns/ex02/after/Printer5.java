package study.patterns.ex02.after;

public class Printer5 {

  Printer origin;
  String sign;

  public Printer5(String sign) {
    this.sign = sign;
  }


  void print(String content) {
    origin.print(content);
    System.out.println();
    System.out.printf("from %s\n", sign);
    System.out.println();
  }

}
