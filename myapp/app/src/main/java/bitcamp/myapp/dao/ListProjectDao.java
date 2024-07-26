package bitcamp.myapp.dao;

import bitcamp.myapp.vo.Project;
import bitcamp.myapp.vo.User;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ListProjectDao implements ProjectDao {

  private static final String DEFAULT_DATANAME = "projects";
  private int seqNo;
  private List<Project> projectList = new ArrayList<>();
  private String path;
  private String dataName;

  public ListProjectDao(String path, UserDao userDao) {
    this(path, DEFAULT_DATANAME, userDao);
  }

  public ListProjectDao(String path, String dataName, UserDao userDao) {
    this.path = path;
    this.dataName = dataName;

    try (XSSFWorkbook workbook = new XSSFWorkbook(path)) {
      XSSFSheet sheet = workbook.getSheet(dataName);

      for (int i = 1; i <= sheet.getLastRowNum(); i++) {
        Row row = sheet.getRow(i);
        try {
          Project project = new Project();
          project.setNo(Integer.parseInt(row.getCell(0).getStringCellValue()));
          project.setTitle(row.getCell(1).getStringCellValue());
          project.setDescription(row.getCell(2).getStringCellValue());
          project.setStartDate(row.getCell(3).getStringCellValue());
          project.setEndDate(row.getCell(4).getStringCellValue());

          String[] members = row.getCell(5).getStringCellValue().split(",");
          for (String memberNo : members) {
            User member = userDao.findBy(Integer.parseInt(memberNo));
            if (member != null) {
              project.getMembers().add(member);
            }
          }
          projectList.add(project);

        } catch (Exception e) {
          System.out.printf("%s 번 게시글의 데이터 형식이 맞지 않습니다.\n", row.getCell(0).getStringCellValue());
        }
      }

      seqNo = projectList.getLast().getNo();

    } catch (Exception e) {
      System.out.println("게시글 데이터 로딩 중 오류 발생!");
      e.printStackTrace();
    }
  }

  public void save() throws Exception {
    try (FileInputStream in = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(in)) {

      int sheetIndex = workbook.getSheetIndex(dataName);
      if (sheetIndex != -1) {
        workbook.removeSheetAt(sheetIndex);
      }

      XSSFSheet sheet = workbook.createSheet(dataName);

      // 셀 이름 출력
      String[] cellHeaders = {"no", "title", "description", "start_date", "end_date", "members"};
      Row headerRow = sheet.createRow(0);
      for (int i = 0; i < cellHeaders.length; i++) {
        headerRow.createCell(i).setCellValue(cellHeaders[i]);
      }

      // 데이터 저장
      int rowNo = 1;
      for (Project project : projectList) {
        Row dataRow = sheet.createRow(rowNo++);
        dataRow.createCell(0).setCellValue(String.valueOf(project.getNo()));
        dataRow.createCell(1).setCellValue(project.getTitle());
        dataRow.createCell(2).setCellValue(project.getDescription());
        dataRow.createCell(3).setCellValue(project.getStartDate());
        dataRow.createCell(4).setCellValue(project.getEndDate());

        StringBuilder strBuilder = new StringBuilder();
        for (User member : project.getMembers()) {
          if (strBuilder.length() > 0) {
            strBuilder.append(",");
          }
          strBuilder.append(member.getNo());
        }
        dataRow.createCell(5).setCellValue(strBuilder.toString());
      }

      // 엑셀 파일로 데이터를 출력하기 전에
      // workbook을 위해 연결한 입력 스트림을 먼저 종료한다.
      in.close();

      try (FileOutputStream out = new FileOutputStream(path)) {
        workbook.write(out);
      }
    }
  }

  @Override
  public boolean insert(Project project) throws Exception {
    project.setNo(++seqNo);
    projectList.add(project);
    return true;
  }

  @Override
  public List<Project> list() throws Exception {
    return projectList;
  }

  @Override
  public Project findBy(int no) throws Exception {
    for (Project project : projectList) {
      if (project.getNo() == no) {
        return project;
      }
    }
    return null;
  }

  @Override
  public boolean update(Project project) throws Exception {
    int index = projectList.indexOf(project);
    if (index == -1) {
      return false;
    }

    projectList.set(index, project);
    return true;
  }

  @Override
  public boolean delete(int no) throws Exception {
    int index = projectList.indexOf(new Project(no));
    if (index == -1) {
      return false;
    }
    projectList.remove(index);
    return true;
  }
}
