package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired// автоматически подтягивает бин-объект userDao из ???
   private UserDao userDao;

   @Transactional//Перед исполнением метода помеченного данной аннотацией начинается транзакция,
   // после выполнения метода транзакция коммитится, при выбрасывании RuntimeException откатывается
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)// только чтение?? без изменения БД??
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }
   @Transactional(readOnly = true)// только чтение?? без изменения БД??
   @Override
   public User getUserForCarNameAndSeries(String name, Integer series) {
      return userDao.getUserForCarNameAndSeries(name, series);
   }

}
