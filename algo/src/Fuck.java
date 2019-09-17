import java.util.*;

/**
 * @author YuXiaodan
 * @ClassName Fuck
 * @Description
 * @date 2019年08月23日 2019/8/23
 */
public class Fuck {

	public static void main(String[] args) {

//		ArrayList<Integer> list = new ArrayList<Integer>();
//		list.add(2);
//		Iterator<Integer> iterator = list.iterator();
//		while(iterator.hasNext()){
//			Integer integer = iterator.next();
//			if(integer==2)
//				list.remove(integer);
//		}

		int[] src = {1,2,3,4,5,};

		int[] des = new int[5];

		System.arraycopy(src, 0, des, 0, 5);


		final int[] copyOf = Arrays.copyOf(src, 5);

		Arrays.stream(copyOf).forEach(System.out::print);
//		System.out.println(des.toString());

	}
}
