package mission2.demo.Repository;

import mission2.demo.Model.Instruments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InstrumentsRepository {
    @Autowired
    JdbcTemplate template = new JdbcTemplate();

    /*Getting all instruments from table*/
    public List<Instruments> getAllInstruments(){
        List<Instruments> instruments = template.query("select id, brand ,type , price from instruments",(result,rowNum)->new Instruments(result.getInt("id"),
                result.getString("brand"),result.getString("type"),result.getDouble("price")));
        return instruments;
    }
    /*Getting a specific item by item id from table*/
    public Instruments getInstruments(int id){
        String query = "SELECT * FROM INSTRUMENTS WHERE ID=?";
        Instruments instruments = template.queryForObject(query,new Object[]{id},new BeanPropertyRowMapper<>(Instruments.class));

        return instruments;
    }
    /*Adding an instrument into database table*/
    public String addInstruments(Instruments instruments) {
        String query = "INSERT INTO instruments(id, brand, type, price)" + "VALUES (?,?,?,?)";
        template.update(query,
                instruments.getId(),
                instruments.getBrand(),
                instruments.getType(),
                instruments.getPrice());
        return query;
    }
    /*Updating an instrument into database table*/
    public void updateInstruments(int id,Instruments instruments){
        String query = "UPDATE INSTRUMENTS SET" + " brand = ?,type = ?, price = ?"+" WHERE id = ?";
        template.update(query,
                instruments.getBrand(),
                instruments.getType(),
                instruments.getPrice(),
                instruments.getId());
    }
    /*delete an item from database*/
    public int deleteInstruments(int id){
        String query = "DELETE FROM INSTRUMENTS WHERE ID =?";
        return template.update(query,id);
    }

}