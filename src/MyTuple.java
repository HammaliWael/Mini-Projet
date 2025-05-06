public class MyTuple {
        Noms item1;
        double value;

        public MyTuple(Noms item1, double value) {
            this.item1 = item1;
            this.value = value;

        }
        public Noms getItem1() {
            return item1;
        }
        public double getValue() {
            return value;
    }
    public String toString() {
        return "(" + item1.getNom() + ", ID: " + item1.getId() + ", Score: " + value + ")";
    }
}

