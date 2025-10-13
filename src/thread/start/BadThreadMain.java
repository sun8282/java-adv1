package thread.start;

public class BadThreadMain {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        HelloThread helloThread = new HelloThread();
        System.out.println(Thread.currentThread().getName());
        helloThread.run();


    }
}
