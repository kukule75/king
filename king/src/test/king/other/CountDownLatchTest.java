package king.other;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @author YuXiaodan
 * @ClassName CountDownLatchTest
 * @Description
 * @date 2018年09月17日 2018/9/17
 */
public class CountDownLatchTest {

	@Test
	public void a() {

		CountDownLatch countDownLatch = new CountDownLatch(2);

//		new Thread(() -> {
//
//			try {
//				System.out.println("子线程" + Thread.currentThread().getName() + "正在执行...");
//				Thread.sleep(3000);
//				countDownLatch.countDown();
//				System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕...");
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//
//		}, "t1").start();

		new Thread(() -> {

			try {
				System.out.println("子线程" + Thread.currentThread().getName() + "正在执行...");
				Thread.sleep(3000);
				countDownLatch.countDown();
				System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "t2").start();

		System.out.println("等待两个子线程执行完毕...");
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("两个子线程执行完毕，主线程继续...");
	}
}
