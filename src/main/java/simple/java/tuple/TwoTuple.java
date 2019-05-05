package simple.java.tuple;

public class TwoTuple<A, B> extends OneTuple<A> {

    public final B b;
     
    public TwoTuple(A a, B b) {
        super(a);
        this.b = b;
    }
}
