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