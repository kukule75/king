package king.other;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author YuXiaodan
 * @ClassName LockTest
 * @Description
 * @date 2018年09月10日 2018/9/10
 */
public class LockTest {

	private static Logger logger = LoggerFactory.getLogger(LockTest.class);

	private Lock lock = new ReentrantLock();

	public void run1() throws InterruptedException {
		try {
			lock.lock();
			System.out.println("当前线程：" + Thread.currentThread().getName() + "进入run1方法");
			Thread.sleep(6000);
		} finally {
			lock.unlock();
		}
	}

	public void run2() throws InterruptedException {
		try {
			lock.lock();
			System.out.println("当前线程：" + Thread.currentThread().getName() + "进入run2方法");
			Thread.sleep(1000);
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) throws InterruptedException {

		final LockTest lockTest = new LockTest();

		Thread thread1 = new Thread(()->{
			try {
				lockTest.run1();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		},
				"t1");
		thread1.start();

		Thread.sleep(1000);

		lockTest.run2();
	}
}
