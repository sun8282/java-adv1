package thread.bounded;

import java.util.ArrayList;
import java.util.List;

import static util.ThreadUtils.sleep;

public class BoundedMain {

    public static void main(String[] args) {
        BoundedQueueV2 queue = new BoundedQueueV2(2);

        producerFirst(queue);
        consumerFirst(queue);

    }

    private static void consumerFirst(BoundedQueueV1 queue) {
        ArrayList<Thread> threads = new ArrayList<>();
        startProducer(queue, threads);
    }

    private static void producerFirst(BoundedQueueV1 queue) {
        List<Thread> threads = new ArrayList<>();
        startProducer(queue, threads);
        startConsumer(queue, threads);

    }

    private static void startConsumer(BoundedQueueV1 queue, List<Thread> threads) {
        System.out.println();
        for (int i = 1; i < 3; i++) {
            Thread consumer = new Thread(new ConsumerTask(queue), "consumer" + i);
            threads.add(consumer);
            consumer.start();
            sleep(100);
        }
    }

    private static void startProducer(BoundedQueueV1 queue, List<Thread> threads) {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            Thread producer = new Thread(new ProducerTask(queue, "data" + i));
            threads.add(producer);
            producer.start();
            sleep(100);
        }
    }


}
