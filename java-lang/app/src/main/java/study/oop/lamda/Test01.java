package study.oop.lamda;

public class Test01 {


  interface Player {
    void play();
  }


  public static void main(String[] args) {

    // 1) 일반 클래스
    class MyPlayer implements Player {
      @Override
      public void play() {
        System.out.println("1");
      }
    }
    Player p1 = new MyPlayer();
    p1.play();



    // 2) 익명 클래스
    Player p2 = new Player() {
      @Override
      public void play() {
        System.out.println("2");
      }
    };
    p2.play();



    // 2-1) 익명 클래스 (레퍼런스 없이 바로 쓰기)
    new Player() {
      @Override
      public void play() {
        System.out.println("익명클래스3");
      }
    }.play();



    // 3) 람다
    Player p3 = () -> {
      System.out.println("3");
    };
    p3.play();



    // 3-1) 람다 (중괄호 생략)

    Player p4 = () -> System.out.println("람다2");
    p4.play();


  }

}
