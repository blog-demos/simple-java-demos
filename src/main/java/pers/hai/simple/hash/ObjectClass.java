package pers.hai.simple.hash;

public class ObjectClass {

    private String label;
    
    public ObjectClass(String label) {
        this.label = label;
    }
    
    public String getLabel() {
        return label;
    }
    
    @Override
    public String toString() {
        return label;
    }
    
    @Override
    public int hashCode() {
        return String.valueOf(label.hashCode() + 100).hashCode();
    }
    
    public static void main(String[] args) {
        ObjectClass class1 = new ObjectClass("A");
        ObjectClass class2 = new ObjectClass("A");
        
        System.out.println(class1);
        System.out.println(class2);
        
        System.out.println(class1.hashCode());
        System.out.println(class2.hashCode());
    }
}
