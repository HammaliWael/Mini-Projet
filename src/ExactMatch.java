import java.util.Comparator;

public class ExactMatch implements ComparateurDeDeuxNoms {
    public double comparer1(String s1, String s2) {
        if(s1.equals(s2)) return 1.0;
        return 0.0;
}}
