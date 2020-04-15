package mission2.demo.Model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor // <--- THIS is it
public class Instruments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;// will be set when persisting

    private String type;
    private Double price;

    public Instruments(Long id, String type, Double price) {
        this.id = id;
        this.type = type;
        this.price = price;
    }

    public Object getId() {
        return id;
    }
}