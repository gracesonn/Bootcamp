package mission2.demo.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table
public class Instruments{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String brand;

    @Column
    private String type;

    @Column
    private double price;


    public Instruments (int id,String brand, String type,double price) {
        this.id = id;
        this.brand = brand;
        this.type = type;
        this.price = price;
    }


    public void setType(String type) {
        this.type = type;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", price='" + price + '\''+
                '}';
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }


}
