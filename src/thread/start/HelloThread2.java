package thread.start;

public class HelloThread2 extends Thread{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": run()");
    }
}
