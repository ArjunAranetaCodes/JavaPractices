## Problem: 
Implementing a Color Enumerator

## Description: 
Create a program that demonstrates the use of EnumMap to implement a color enumerator.

## Input:

Colors: Red, Green, Blue, Yellow, Orange, Purple

## Output:

Color enumerator:

Red = 0xFF0000

Green = 0x00FF00

Blue = 0x0000FF

Yellow = 0xFFFF00

Orange = 0xFFA500

Purple = 0x800080

## Code Answer:
```Java
import java.util.EnumMap;
import java.util.Map;

public class ColorEnumerator {
    private EnumMap<Color, Integer> colorMap;

    public ColorEnumerator() {
        colorMap = new EnumMap<>(Color.class);
        colorMap.put(Color.RED, 0xFF0000);
        colorMap.put(Color.GREEN, 0x00FF00);
        colorMap.put(Color.BLUE, 0x0000FF);
        colorMap.put(Color.YELLOW, 0xFFFF00);
        colorMap.put(Color.ORANGE, 0xFFA500);
        colorMap.put(Color.PURPLE, 0x800080);
    }

    public int getColorCode(Color color) {
        return colorMap.get(color);
    }

    public static void main(String[] args) {
        ColorEnumerator enumerator = new ColorEnumerator();

        for (Color color : Color.values()) {
            System.out.println(color + " = " + Integer.toHexString(enumerator.getColorCode(color)));
        }
    }
}

enum Color {
    RED,
    GREEN,
    BLUE,
    YELLOW,
    ORANGE,
    PURPLE
}
```

File Name: ColorEnumerator.java

This program demonstrates the use of EnumMap to implement a color enumerator. The ColorEnumerator class uses an EnumMap to store the color and its corresponding hex code, and provides a method to retrieve the color code. The main() method tests the enumerator by printing the color and its corresponding hex code.

Note: EnumMap is a specialized Map implementation for enumerations, and is useful for creating enumerators, dictionaries, and other similar data structures that need to be accessed by enumeration values.