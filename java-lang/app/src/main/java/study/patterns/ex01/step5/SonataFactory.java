package study.patterns.ex01.step5;

public class SonataFactory implements CarFactory {

  private SonataFactory() {}

  private static SonataFactory instance;

  public static SonataFactory getInstance() {
    if (instance == null) {
      instance = new SonataFactory();
    }
    return instance;
  }


  @Override
  public Sedan createCar() {
    Sedan s = new Sedan();

    s.maker = "현대자동차";
    s.model = "소나타";
    s.cc = 1998;
    s.auto = true;
    s.sunroof = false;

    return s;
  }
}
