package lt.vcs.karolis.kavosAparatas.exceptions;

/**
 * Created by karolis somka on 7/25/2017.
 */
public class ReikiaPlautiAparata extends Exception {
    public ReikiaPlautiAparata() {
    }

    public ReikiaPlautiAparata(String message) {
        super(message);
    }

    public ReikiaPlautiAparata(String message, Throwable cause) {
        super(message, cause);
    }

    public ReikiaPlautiAparata(Throwable cause) {
        super(cause);
    }
}
