package foo1114;

/**
 * @author kinden
 */
public class FooC {

    private Object lock = new Object();

    private int flag = 0;

    public FooC() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        synchronized (lock) {
            while (flag != 0) {
                lock.wait();
            }
            printFirst.run();
            flag = 1;
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.

        synchronized (lock) {
            while (flag != 1) {
                lock.wait();
            }
            printSecond.run();
            flag = 2;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.

        synchronized (lock) {
            while (flag != 2) {
                lock.wait();
            }
            printThird.run();
            flag = 0;
//            lock.notifyAll();
        }
    }


    public static void main(String[] args) {

        FooC fooC = new FooC();

        Thread thread3 = new Thread(()->{
            try {
                fooC.third(()->{
                    System.out.println("three");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(()->{
            try {
                fooC.second(()->{
                    System.out.println("two");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread1 = new Thread(()->{
            try {
                fooC.first(()->{
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
