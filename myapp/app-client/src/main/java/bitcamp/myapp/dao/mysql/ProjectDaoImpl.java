package bitcamp.myapp.dao.mysql;

import bitcamp.myapp.dao.ProjectDao;
import bitcamp.myapp.vo.Project;
import bitcamp.myapp.vo.User;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectDaoImpl implements ProjectDao {

  private SqlSession sqlSession;

  public ProjectDaoImpl(SqlSession sqlSession) {
    this.sqlSession = sqlSession;
  }

  @Override
  public boolean insert(Project project) throws Exception {
    sqlSession.insert("ProjectDao.insert", project);
    return true;
  }

  @Override
  public List<Project> list() throws Exception {
    return sqlSession.selectList("ProjectDao.list");
  }

  @Override
  public Project findBy(int no) throws Exception {
    return sqlSession.selectOne("ProjectDao.findBy", no);
  }

  @Override
  public boolean update(Project project) throws Exception {
    int count = sqlSession.update("ProjectDao.update", project);
    return count > 0;
  }

  @Override
  public boolean delete(int no) throws Exception {
    int count = sqlSession.delete("ProjectDao.delete", no);
    return count > 0;
  }

  @Override
  public boolean insertMembers(int projectNo, List<User> members) throws Exception {
    Map<String, Object> values = new HashMap<>();
    values.put("projectNo", projectNo);
    values.put("members", members);

    sqlSession.insert("ProjectDao.insertMembers", values);
    return true;
  }

  @Override
  public List<User> getMembers(int projectNo) throws Exception {
    return sqlSession.selectList("ProjectDao.getMembers", projectNo);
  }

  @Override
  public boolean deleteMembers(int projectNo) throws Exception {
    int count = sqlSession.delete("ProjectDao.deleteMembers", projectNo);
    return count > 0;
  }
}
