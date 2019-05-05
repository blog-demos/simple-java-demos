package simple.java.generic;

public class InfoImpl<T> implements Info<T> {

    private T var;
    
    public InfoImpl(T var) {
        setVar(var);
    }
    
    @Override
    public T getVar() {
        return var;
    }

    public void setVar(T var) {
        this.var = var;
    }
}
