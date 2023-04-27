public class StackSample {
    public static void main(String[] args) {
        TwoStacks twoStacks = new TwoStacks(5);
        twoStacks.push1(1);
        twoStacks.push2(2);
        twoStacks.push1(3);
        twoStacks.push2(4);

        System.out.println("Popped from stack 1: " + twoStacks.pop1());
        System.out.println("Popped from stack 2: " + twoStacks.pop2());
    }

    static class TwoStacks {
        private int[] array;
        private int top1, top2;
        private int size;

        public TwoStacks(int capacity) {
            size = capacity;
            array = new int[capacity];
            top1 = -1;
            top2 = size;
        }

        public void push1(int item) {
            if (top1 < top2 - 1) {
                array[++top1] = item;
            } else {
                throw new IllegalStateException("Stack 1 is full");
            }
        }

        public void push2(int item) {
            if (top1 < top2 - 1) {
                array[--top2] = item;
            } else {
                throw new IllegalStateException("Stack 2 is full");
            }
        }

        public int pop1() {
            if (top1 >= 0) {
                return array[top1--];
            } else {
                throw new IllegalStateException("Stack 1 is empty");
            }
        }

        public int pop2() {
            if (top2 < size) {
                return array[top2++];
            } else {
                throw new IllegalStateException("Stack 2 is empty");
            }
        }
    }
}
