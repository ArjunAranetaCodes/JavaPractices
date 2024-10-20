## Problem: 
Creating an Array of Comparable Objects

## Description: 
Create a program that demonstrates the use of interface type arrays to store and manipulate comparable objects.

## Input:

Comparable information:

Integer: 5

String: "Hello"

Double: 3.14

## Output:

Comparable array:

Integer: 5

String: "Hello"

Double: 3.14

## Code Answer:
```Java
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
```

File Name: ComparableArray.java

This program demonstrates the use of interface type arrays to store and manipulate comparable objects. The Comparable interface represents a comparable object, and the Integer, String, and Double classes implement the Comparable interface. The ComparableArray class creates an array of Comparable objects.

Note: Interface type arrays are used to store and manipulate objects that implement a common interface. This is useful for creating arrays of objects that share a common behavior or functionality.