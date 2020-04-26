package mission2.demo.Controller;

import mission2.demo.Exception.instrumentsNotFoundException;
import mission2.demo.Model.Instruments;

import mission2.demo.Repository.InstrumentsRepository;
/*import mission2.demo.Service.InstrumentsService;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Optional<Instruments>> getInstruments(@RequestParam("id") int id) {
    /*public Instruments getInstruments(@PathVariable int id) {*/
        Optional<Instruments> eg = Optional.ofNullable(instrumentsRepository.getInstruments(id));
        if (eg.isEmpty()) {
            throw new instrumentsNotFoundException(id);
        } else {
            return ResponseEntity.ok(eg);
        }
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