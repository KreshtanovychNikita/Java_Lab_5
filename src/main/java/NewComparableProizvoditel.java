import java.util.Comparator;

public class NewComparableProizvoditel implements  Comparator<Proizvoditel>{

    @Override
    public int compare(Proizvoditel o1, Proizvoditel o2) {
        return o1.compareTo(o2);
    }
}
