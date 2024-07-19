package study.patterns.ex02.after;

public class Printer4 {

  Printer origin;
  String footer;

  public Printer4(String footer) {
    this.footer = footer;
  }


  void print(String content) {
    origin.print(content);

    System.out.printf("========== %s =========\n", footer);
  }

}
