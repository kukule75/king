package foo1114;

/**
 * @author kinden
 */
public class FooD {

    private volatile int flag = 0;

    public FooD() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        while (flag != 0) {

        }
        printFirst.run();
        flag = 1;
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.

        while (flag != 1){

        }
        printSecond.run();
        flag = 2;
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.

        while (flag != 2){

        }
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
