package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;

    @Column(name = "name")//можно не указывать Column name, если оно совпадает с названием столбца в таблице
    private String name;

    @Column(name = "series")
    private int series;

    ///////////
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="id")
//    private User user;
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
///////////
    public Car() {
    }

    public Car(Long carId, String name, int series) {
        this.carId = carId;
        this.name = name;
        this.series = series;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }
}

