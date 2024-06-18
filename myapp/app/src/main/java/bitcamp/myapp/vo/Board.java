package bitcamp.myapp.vo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Board {

  private String title;
  private String content;
  private String writeDate;
  private String viewNo;



  public String getViewNo() {
    return viewNo;
  }

  public void setViewNo(String viewNo) {
    this.viewNo = viewNo;
  }

  public String getWriteDate() {
    return writeDate;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void calculateNow() {
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    this.writeDate = now.format(formatter);
  }

}
