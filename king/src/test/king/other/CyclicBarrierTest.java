package king.other;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author YuXiaodan
 * @ClassName CyclicBarrierTest
 * @Description
 * @date 2018年09月17日 2018/9/17
 */
public class CyclicBarrierTest {

	public static void main(String[] args) {

		CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
			System.out.println("所有业务执行完毕...");
		});

		IntStream.range(0,3).forEach(i -> {
			new Thread(() -> {
				try {
					System.out.println("业务正在执行...");
					Thread.sleep(5000);
					System.out.println("业务执行完毕...");
					cyclicBarrier.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
			}).start();
		});

	}
}
