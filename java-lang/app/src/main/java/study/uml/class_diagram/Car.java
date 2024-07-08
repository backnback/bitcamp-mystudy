package study.uml.class_diagram;

public class Car {
  Insurance insurance;
  Navigation navigation;
  Engine engine;


  public Car(Engine engine) {
    this.engine = engine;
  }


  public Engine getEngine() {
    return engine;
  }


  public Insurance getInsurance() {
    return insurance;
  }

  public Navigation getNavigation() {
    return navigation;
  }

  public void setNavigation(Navigation navigation) {
    this.navigation = navigation;
  }

  public void setInsurance(Insurance insurance) {
    this.insurance = insurance;
  }


  public void fuelUp(GasStation gasStation) {
    gasStation.inject();
  }
}
