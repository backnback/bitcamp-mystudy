package study.lang.string;

public class Test02 {

  public static void main(String[] args) {

    String s = "aaa";
    String s2 = "aaa";

    System.out.println(s == s2); // 레퍼런스에 들어있는 값을 비교한다. (즉, 인스턴스 주소 비교)
                                 // 이 경우는 같다고 나온다. true


  }

}
