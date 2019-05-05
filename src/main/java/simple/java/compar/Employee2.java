package simple.java.compar;

public class Employee2 {

    private int id;
    private String name;
    private Position position;
    
    public Employee2(int _id, String _name, Position _position) {
        id = _id;
        name = _name;
        position = _position;
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
        return "[" + id + ", " + name + ", " + position + "]";
    }
}
