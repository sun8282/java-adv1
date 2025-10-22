package thread.volatile1;

import static util.ThreadUtils.sleep;

public class VolatileCountMain {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();

        sleep(1000);

        task.flag = false;
    }

    static class MyTask implements Runnable {

        boolean flag = true;
        long count;

        @Override
        public void run() {
            count ++;

            if (count % 100_000_000 == 0) {

            }
        }
    }
}
