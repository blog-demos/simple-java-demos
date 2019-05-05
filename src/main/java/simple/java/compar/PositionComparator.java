package simple.java.compar;

import java.util.Comparator;

public class PositionComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o2.getPosition().compareTo(o1.getPosition());
    }

}
