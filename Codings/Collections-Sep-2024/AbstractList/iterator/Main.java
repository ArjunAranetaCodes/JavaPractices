import java.util.AbstractList;
import java.util.Iterator;

public class Main extends AbstractList<Integer> {
    private int[] arr = {1, 2, 3, 4, 5};
    
    @Override
    public Integer get(int index) {
        return arr[index];
    }
    
    @Override
    public Iterator<Integer> iterator() {
        return new MyIterator();
    }
    
    private class MyIterator implements Iterator<Integer> {
        private int i = 0;
        
        @Override
        public boolean hasNext() {
            return i < arr.length;
        }
        
        @Override
        public Integer next() {
            return arr[i++];
        }
    }
    
    public static void main(String[] args) {
        List<Integer> list = new Main();
        for (Integer num : list) {
            System.out.print(num + " ");
        }
    }
}