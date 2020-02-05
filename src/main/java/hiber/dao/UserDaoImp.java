package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository//указывает, что класс используется для работы с поиском, получением и хранением данных.
// Аннотация может использоваться для реализации шаблона DAO. Для указания контейнеру на класс-бин
// может использоваться любая из аннотаций Controller, Repository, Service (усточняет смысловую нагрузку)
public class UserDaoImp implements UserDao {

    @Autowired// автоматически подтягивает бин-объект sessionFactory из метода import org.hibernate.SessionFactory;
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("FROM User");
        return query.getResultList();
    }

    @Override
    public User getUserForCarNameAndSeries(String name, Integer series) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Car WHERE name= :nameParam AND series= :seriesParam");
        query.setParameter("nameParam", name);
        query.setParameter("seriesParam", series);
        Car car = (Car) query.uniqueResult();
        return car.getUser();
    }
}
