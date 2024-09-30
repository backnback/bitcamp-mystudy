package bitcamp.myapp.dao;

import bitcamp.myapp.vo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

  boolean insert(User user) throws Exception;

  List<User> list() throws Exception;

  User findBy(int no) throws Exception;

  User findByEmailAndPassword(@Param("email") String email, @Param("password") String password) throws Exception;

  boolean update(User user) throws Exception;

  boolean delete(int no) throws Exception;

}
