package mission2.demo.Exception;

public class instrumentsNotFoundException extends RuntimeException {
    public instrumentsNotFoundException(int id) {
        super("Could not find instrument " + id);
    }
}
