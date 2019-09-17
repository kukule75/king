package king.other;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YuXiaodan
 * @ClassName GenericTest
 * @Description
 * @date 2018年09月26日 2018/9/26
 */
public class GenericTest {

	public static void main(String[] args) {

		List list = new ArrayList<>();

		list.add("a");
		list.add("b");
		list.add(1);

		list.forEach(item -> {
			System.out.println(item);
		});
	}
}
