package mission2.demo.Service;

import mission2.demo.Model.Instruments;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class InstrumentsService {


    private static List<Instruments> instrumentsList = new ArrayList<>(Arrays.asList(

            new Instruments(111L, "piano", 200000000.00),
            new Instruments(112L, "guitar", 20000.00),
            new Instruments(113L, "trumpet", 200000.00)

    )
    );

    public static List<Instruments> getAllInstruments() {
        return instrumentsList;
    }


    public static Instruments getInstruments(Long id) {
        return instrumentsList.stream().filter(instruments -> instruments.getId().equals(id)).findFirst().get();
    }

    public void addInstruments(Instruments instruments) {
        instrumentsList.add(instruments);
    }

    public void updateInstruments(Instruments instruments, Long id) {
        int counter = 0;
        for (Instruments instruments1 : instrumentsList) {
            if (instruments1.getId().equals(id)) {
                instrumentsList.set(counter, instruments);
            }
            counter++;
        }
    }

    public void deleteInstruments(Long id) {
        instrumentsList.removeIf(instruments ->instruments.getId().equals(id));
    }
}

    