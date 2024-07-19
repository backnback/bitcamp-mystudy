package study.patterns.ex02.after;

public class Printer6 {

  Printer2 origin;
  String sign;

  public Printer6(String sign, String header) {
    origin = new Printer2(header);
    this.sign = sign;
  }


  void print(String content) {
    origin.print(content);

    System.out.println();
    System.out.printf("from %s\n", sign);
    System.out.println();

  }

}
