package lt.vcs.karolis.kavosAparatas.exceptions;

/**
 * Created by karolis somka on 7/25/2017.
 */
public class TrukstaProduktu extends Exception{
    public TrukstaProduktu() {
        super();
    }

    public TrukstaProduktu(String message) {
        super(message);
    }

    public TrukstaProduktu(String message, Throwable cause) {
        super(message, cause);
    }

    public TrukstaProduktu(Throwable cause) {
        super(cause);
    }
}
