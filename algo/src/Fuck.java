import java.io.FileWriter;

/**
 * @author YuXiaodan
 * @ClassName Fuck
 * @Description
 * @date 2019年08月23日 2019/8/23
 */
public class Fuck {

	private static FileWriter fileWriter;

	public static void main(String[] args) throws InterruptedException {

		BoundedBlockingQueue1188 queue = new BoundedBlockingQueue1188(3);


		queue.enqueue(1);

		System.out.println(queue.dequeue());


	}
}
