package bitcamp.myapp.service;

import bitcamp.myapp.dao.UserDao;
import bitcamp.myapp.vo.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultUserService implements UserService {

  private final PasswordEncoder passwordEncoder;
  private final UserDao userDao;


  @Transactional
  public void add(User user) throws Exception {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    userDao.insert(user);
  }

  public List<User> list() throws Exception {
    return userDao.list();
  }

  public User get(int userNo) throws Exception {
    return userDao.findBy(userNo);
  }

  @Override
  public User get(String email) throws Exception {
    return userDao.findByEmail(email);
  }

  public User exists(String email, String password) throws Exception {
    return userDao.findByEmailAndPassword(email, password);
  }

  @Transactional
  public boolean update(User user) throws Exception {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return userDao.update(user);
  }

  @Transactional
  public boolean delete(int userNo) throws Exception {
    return userDao.delete(userNo);
  }
}
