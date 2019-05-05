package simple.java.compar;

import org.apache.commons.lang.builder.CompareToBuilder;

public class Employee implements Comparable<Employee> {

    private int id;
    private String name;
    private Position position;
    
    public Employee(int _id, String _name, Position _position) {
        id = _id;
        name = _name;
        position = _position;
    }
    
    @Override
    public int compareTo(Employee o) {
        return new CompareToBuilder()
                .append(id, o.id)
                .toComparison();
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
//        return ToStringBuilder.reflectionToString(this);
        return "[" + id + ", " + name + ", " + position + "]";
    }
}
