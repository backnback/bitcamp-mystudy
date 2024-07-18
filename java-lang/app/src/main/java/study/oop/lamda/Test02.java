package study.oop.lamda;

public class Test02 {

  interface Player {
    void play();
  }

  public static void main(String[] args) {

    Player p1 = () -> System.out.println("1111");
    test(p1);


  }

  static void test(Player player) {
    player.play();
  }
}
