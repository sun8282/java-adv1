package thread.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CasMainV2 {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        System.out.println("atomicInteger = " + atomicInteger);

        int result = atomicInteger.incrementAndGet();
        System.out.println("result = " + result);

        int result2 = atomicInteger.incrementAndGet();
        System.out.println("result2 = " + result2);
    }
}
