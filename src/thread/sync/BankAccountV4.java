package thread.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BankAccountV4 implements BankAccount {

    private int balance;

    public BankAccountV4(int initialBalance) {
        this.balance = initialBalance;
    }

    private final Lock lock = new ReentrantLock();

    @Override
    public boolean withdraw(int amount) {
        log("거래 시작: " + getClass().getSimpleName());

        lock.lock();

        try {
            if(balance < amount) {
                log("[검증 실패]");
                return false;
            }

            sleep(1000);
            balance = balance - amount;
        } finally {
            lock.unlock();
        }
        log("거래 종료");
        return true;
    }

    @Override
    public int getBalance() {
        lock.lock();
        try{
            return balance;
        } finally {
            lock.unlock();
        }
    }
}
