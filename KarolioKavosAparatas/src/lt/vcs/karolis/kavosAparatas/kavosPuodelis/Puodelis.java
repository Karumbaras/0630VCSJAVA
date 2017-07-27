package lt.vcs.karolis.kavosAparatas.kavosPuodelis;

/**
 * Created by karolis somka on 7/19/2017.
 */
public abstract class Puodelis {
    public final int MAX_PUODELIO_TALPA = 10;

    protected void rodykInformacija() {
        System.out.println("Puodelio talpa: " + MAX_PUODELIO_TALPA);
    }
}
