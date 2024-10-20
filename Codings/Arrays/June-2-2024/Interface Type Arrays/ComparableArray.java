public class ComparableArray {
    public static void main(String[] args) {
        Comparable[] comparables = new Comparable[3];

        comparables[0] = new Integer(5);
        comparables[1] = new String("Hello");
        comparables[2] = new Double(3.14);

        for (Comparable comparable : comparables) {
            System.out.println(comparable.getClass().getName() + ": " + comparable);
        }
    }
}

public interface Comparable {
    int compareTo(Object o);
}

public class Integer implements Comparable {
    private int value;

    public Integer(int value) {
        this.value = value;
    }

    public int compareTo(Object o) {
        if (o instanceof Integer) {
            return value - ((Integer) o).value;
        } else {
            throw new IllegalArgumentException("Cannot compare Integer with " + o.getClass().getName());
        }
    }
}

public class String implements Comparable {
    private String value;

    public String(String value) {
        this.value = value;
    }

    public int compareTo(Object o) {
        if (o instanceof String) {
            return value.compareTo((String) o);
        } else {
            throw new IllegalArgumentException("Cannot compare String with " + o.getClass().getName());
        }
    }
}

public class Double implements Comparable {
    private double value;

    public Double(double value) {
        this.value = value;
    }

    public int compareTo(Object o) {
        if (o instanceof Double) {
            return Double.compare(value, ((Double) o).value);
        } else {
            throw new IllegalArgumentException("Cannot compare Double with " + o.getClass().getName());
        }
    }
}