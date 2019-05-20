package pers.hai.simple.generic;

public class Student implements Human {

    private String name = "";
    
    @SuppressWarnings("unused")
    private void setName(String _name) {
        name = _name;
    }
    
    public String getName() {
        return name;
    }
}
