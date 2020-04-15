package mission2.demo.Controller;

import mission2.demo.Model.Instruments;

import mission2.demo.Service.InstrumentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class InstrumentsController {

    @Autowired
    InstrumentsService instrumentsService;

    @GetMapping("/gracesonn/instruments")
    public List<Instruments> all_instruments() {

        return InstrumentsService.getAllInstruments();
    }
    @GetMapping("/gracesonn/instruments/{id}")
    public Instruments getInstruments(@PathVariable("id") Long id) {

        return InstrumentsService.getInstruments(id);
    }
    @PostMapping("/gracesonn/instruments")
    public void addInstruments(@RequestBody Instruments instruments){
        instrumentsService.addInstruments(instruments);
    }

    @PutMapping("/gracesonn/instruments/{id}")
    public void updateInstruments(@RequestBody Instruments instruments, @PathVariable("id") Long id){
        instrumentsService.updateInstruments(instruments, id);
    }

    @DeleteMapping("/gracesonn/instruments/{id}")
    public void deleteInstruments(@PathVariable("id") Long id){
        instrumentsService.deleteInstruments(id);
    }
}
