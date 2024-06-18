package bitcamp.myapp.vo;

// 메모리 설계도
public class User {

  // Non-static 필드(field; 변수) = 인스턴스(instance) 필드
  // => new 명령을 통해 Heap 메모리에 생성된다.
  private String name;
  private String email;
  private String password;
  private String tel;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }
}
