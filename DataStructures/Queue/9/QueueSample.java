public class QueueSample {
    private static final int MAX_SIZE = 5;
    private int front, rear;
    private int[] queue;

    public QueueSample() {
        queue = new int[MAX_SIZE];
        front = rear = -1;
    }

    public void enqueue(int item) {
        if ((rear + 1) % MAX_SIZE == front) {
            System.out.println("Queue is full");
            return;
        }
        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % MAX_SIZE;
        }
        queue[rear] = item;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int item = queue[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % MAX_SIZE;
        }
        return item;
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    public static void main(String[] args) {
        QueueSample circularQueue = new QueueSample();

        circularQueue.enqueue(10);
        circularQueue.enqueue(20);
        circularQueue.enqueue(30);

        System.out.println("Dequeued item: " + circularQueue.dequeue());
    }
}
