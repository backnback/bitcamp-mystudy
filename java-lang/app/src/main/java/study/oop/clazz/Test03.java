package study.oop.clazz;

public class Test03 {

  // Nested Class
  class B {
  } // non-static nested class
  static class C {
  } // static nested class

  Object obj1 = new Object() {};

  void m1() {
    class D {
    } // loacal class


    Object obj2 = new Object() {}; // anonymous class : 어디든 가능하다.

  }


}


// package member class
class A {
}
