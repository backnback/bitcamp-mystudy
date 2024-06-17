package study.oop.clazz.vo;

public class Score {

  public String name;
  public int kor;
  public int eng;
  public int math;
  private int sum;
  private float aver;

  public Score(String name, int kor, int eng, int math) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
  }



  public void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = (float) this.sum / 3;
  }

  public int getSum() {
    return this.sum;
  }


  public float getAver() {
    return this.aver;
  }


  public String getName() {
    return name;
  }



  public void setName(String name) {
    this.name = name;
  }



  public int getKor() {
    return kor;
  }



  public void setKor(int kor) {
    this.kor = kor;
    this.compute();
  }



  public int getEng() {
    return eng;
  }



  public void setEng(int eng) {
    this.eng = eng;
    this.compute();
  }



  public int getMath() {
    return math;
  }



  public void setMath(int math) {
    this.math = math;
    this.compute();
  }


}
