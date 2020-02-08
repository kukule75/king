package foo1114;

import java.util.concurrent.CountDownLatch;

/**
 * @author kinden
 */
public class FooA {

    private CountDownLatch C2;

    private CountDownLatch C3;

    public FooA() {
        C2 = new CountDownLatch(1);
        C3 = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        C2.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        C2.await();
        printSecond.run();
        C3.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        C3.await();
        printThird.run();
    }


    public static void main(String[] args) {

        FooA fooA = new FooA();

        Thread thread3 = new Thread(()->{
            try {
                fooA.third(()->{
                    System.out.println("three");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(()->{
            try {
                fooA.second(()->{
                    System.out.println("two");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread1 = new Thread(()->{
            try {
                fooA.first(()->{
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
