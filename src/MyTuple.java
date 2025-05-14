import java.util.Objects;

public class MyTuple {
    private Nom item1;
    private Nom item2;
    private double value;

    public MyTuple(Nom item1, Nom item2, double value) {
        this.item1 = item1;
        this.item2 = item2;
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

    public void setValue(double value) {
        this.value = value;
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyTuple)) return false;
        MyTuple other = (MyTuple) o;
        return Objects.equals(item1.getId(), other.item1.getId()) &&
                Objects.equals(item2.getId(), other.item2.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(item1.getId(), item2.getId());
    }
}