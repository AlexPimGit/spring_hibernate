package hiber.dao;

import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository//указывает, что класс используется для работы с поиском, получением и хранением данных.
// Аннотация может использоваться для реализации шаблона DAO. Для указания контейнеру на класс-бин
// может использоваться любая из аннотаций Controller, Repository, Service (усточняет смысловую нагрузку)
public class CarDaoImpl implements CarDao {
    @Autowired// автоматически подтягивает бин-объект sessionFactory из метода import org.hibernate.SessionFactory;
    private SessionFactory sessionFactory;

    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    public List<Car> listCar() {
        TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("FROM Car");
        return query.getResultList();
    }
}
