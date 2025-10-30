package thread.bounded;

import java.util.ArrayList;

public class BoundedMain {

    public static void main(String[] args) {
        BoundedQueueV1 queue = new BoundedQueueV1(2);

        prodecerFirst(queue);
        cunsumerFirst(queue);

    }

    private static void cunsumerFirst(BoundedQueueV1 queue) {
        ArrayList<Thread> threads = new ArrayList<>();
        startProducer(queue, threads);
    }

    private static void startProducer(BoundedQueueV1 queue, ArrayList<Thread> threads) {

    }

    private static void prodecerFirst(BoundedQueueV1 queue) {

    }
}
