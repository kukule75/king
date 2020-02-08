package foo1114;

import java.util.concurrent.Semaphore;

/**
 * @author kinden
 */
public class FooB {

    private Semaphore S2;

    private Semaphore S3;

    public FooB() {
        S2 = new Semaphore(0);
        S3 = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        S2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        S2.acquire();
        printSecond.run();
        S3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        S3.acquire();
        printThird.run();
    }


    public static void main(String[] args) {

        FooB fooB = new FooB();

        Thread thread3 = new Thread(()->{
            try {
                fooB.third(()->{
                    System.out.println("three");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(()->{
            try {
                fooB.second(()->{
                    System.out.println("tw0");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread1 = new Thread(()->{
            try {
                fooB.first(()->{
                    System.out.println("one");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread3.start();
        thread2.start();
        thread1.start();
    }
}
