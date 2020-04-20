package mission2.demo.Controller;

import mission2.demo.Model.Instruments;

import mission2.demo.Repository.InstrumentsRepository;
/*import mission2.demo.Service.InstrumentsService;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class InstrumentsController{

    @Autowired
    InstrumentsRepository instrumentsRepository;

    @GetMapping("/instruments/getAllInstruments")
    public List<Instruments> getAllInstruments(){
        return instrumentsRepository.getAllInstruments();
    }

    @GetMapping("/instruments/getInstruments")
    public Instruments getInstruments(@RequestParam("id") int id) {
        return instrumentsRepository.getInstruments(id);
    }
    @PostMapping("/instruments/addInstruments")
    public String addInstruments (@RequestBody Instruments instruments) {
        return instrumentsRepository.addInstruments(instruments);
    }
    @PutMapping("/instruments/updateInstruments/{id}")
    public void updateInstruments (@PathVariable int id, @RequestBody Instruments instruments) {
        instrumentsRepository.updateInstruments(id,instruments);

    }

    @DeleteMapping("/instruments/deleteInstruments/{id}")
    public int deteteInstruments(@PathVariable int id){
        return  instrumentsRepository.deleteInstruments(id);
    }


}