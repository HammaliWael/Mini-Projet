import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generateur2 implements GenerateurDeCondidat {
    private int NombreDeCouples;



    public Generateur2(int n) {

        this.NombreDeCouples =n ;
    }
    @Override
    public List<MyTuple> generer(List<Nom> L1, List<Nom> L2) {

        List<MyTuple> result= new ArrayList<MyTuple>();
        if (L1 == null || L1.isEmpty() || L2 == null || L1.isEmpty()) {
            return new ArrayList<MyTuple>();
        }
        Random random = new Random();
        for(int i=0;i< NombreDeCouples; i++) {

            result.add(new MyTuple(L2.get(random.nextInt(L2.size())) , L1.get(random.nextInt(L1.size())),0.0)) ;
        }

        return result;
    }

}
