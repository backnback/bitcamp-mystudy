// 0) 패턴 적용 전
// 1) private 생성자 + Factory Method 설계 패턴
//
package study.patterns.ex01;

import study.patterns.ex01.step5.Car;
import study.patterns.ex01.step5.CarFactory;
import study.patterns.ex01.step5.K7Factory;
import study.patterns.ex01.step5.SonataFactory;

public class Test05 {
  public static void main(String[] args) {
    SonataFactory sonataFactory = SonataFactory.getInstance();
    K7Factory k7Factory = K7Factory.getInstance();
    K7Factory k7Factory2 = K7Factory.getInstance();
    K7Factory k7Factory3 = K7Factory.getInstance();

    System.out.println(k7Factory == k7Factory2); // 주소가 같다.
    System.out.println(k7Factory == k7Factory3); // 객체는 1개만 생성

    printCar(sonataFactory);
    printCar(k7Factory);
  }

  static void printCar(CarFactory carFactory) {
    Car car = carFactory.createCar();
    System.out.println(car);
  }
}
