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
    private Integer series;

    @OneToOne(mappedBy = "car")//В классе, который не владеет связью в аннотации небходимо указать настройку mappedBy
    private User user;

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", name='" + name + '\'' +
                ", series=" + series +
                "}";
    }

    public Car() {
    }

    public Car(Long carId, String name, Integer series) {
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

    public void setSeries(Integer series) {
        this.series = series;
    }

}

