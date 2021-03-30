class Pair<T, U> {
    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(U second) {
        this.second = second;
    }
}

public class Main {
    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("John", 25);
        System.out.println("First: " + pair.getFirst() + ", Second: " + pair.getSecond());
    }
}
