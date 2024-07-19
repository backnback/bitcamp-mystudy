package study.patterns.ex02.after2;

public class Test06 {


  public static void main(String[] args) {
    ContentPrinter printer0 = new ContentPrinter();
    HeaderPrinter printer1 = new HeaderPrinter(printer0, "편지");
    SignPrinter printer = new SignPrinter(printer1, "홍길동");
    printer.print("안녕하세요!");
  }

}
