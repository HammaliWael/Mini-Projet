public class MyTuple {
        Nom item1;
        Nom item2;
        double value;

        public MyTuple(Nom item1,Nom item2, double value) {
            this.item1 = item1;
            this.item2=item2;
            this.value = value;

        }
        public Nom getItem1() {
            return item1;
        }
        public Nom getItem2() {
            return item2;
        }
        public double getValue() {
            return value;
    }

        public void setItem2(Nom item2) {
            this.item2 = item2;
        }

    public void setValue(double value) {
        this.value = value;
    }

    public String toString() {
        return "(" + item1.getNom() + ", ID: " + item1.getId() + ", Score: " + value + ")";
    }
}

