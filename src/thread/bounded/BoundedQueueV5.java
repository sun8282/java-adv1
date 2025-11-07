package thread.bounded;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BoundedQueueV5 implements BoundedQueue {

    private final Lock lock = new ReentrantLock();
    private final Condition producerCond = lock.newCondition();
    private final Condition consumerCond = lock.newCondition();

    private final Queue<String> queue = new ArrayDeque<>();
    private final int max;

    public BoundedQueueV5(int max) {
        this.max = max;
    }

    @Override
    public void put(String data) {
        lock.lock();
        try {
            while(queue.size() == max) {
                log("큐가 가득참, 생산자 대기");
                try {
                    producerCond.await();
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            queue.offer(data);
            consumerCond.signal();
        } finally {
            lock.unlock();
        }


    }

    @Override
    public String take() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                consumerCond.await();
                log("큐에 데이터 없음, 소비자 대기");
                sleep(1000);
            }
            producerCond.signal();
            return queue.poll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return "BoundedQueueV1{" +
                "queue=" + queue +
                ", max=" + max +
                '}';
    }
}
