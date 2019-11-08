package math;

/**
 * @author YuXiaodan
 * @ClassName math.Prime
 * @Description
 * @date 2019年07月26日 2019/7/26
 */
public class Prime {

	public static void main(String[] args) {

		int res = FindNextPrime(11);
		System.out.println(res);
	}

	static int FindNextPrime(int i) {

		//需要返回的质数
		int res;
		//除数，从2开始递增直到res
		int divisor;
		//是否质数
		boolean flag;

		for(res = i; ;res++) {
			flag = true;
			for(divisor = 2; divisor < Math.sqrt(res); divisor++) {
				if(res % divisor == 0) {
					flag = false;
					break;
				}
			}

			if (flag && res > i) {
				return res;
			}
		}
	}
}
