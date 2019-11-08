package array;

/**
 * @author kinden
 *
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
public class AddBinary {

    public static void main(String[] args) {


//        System.out.println('0' ^ '0' ^ 0);

//        System.out.println(addBinaryA("1010", "1011"));
        System.out.println(addBinary("111", "1"));
    }

    public static String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = (i >= 0 ? a.charAt(i) - '0' : 0) + (j >= 0 ? b.charAt(j) - '0': 0) + carry;
            sb.append(sum%2);
            carry = sum/2;
        }
        sb.append(carry == 1 ? 1 : "");

        return sb.reverse().toString();
    }

    //未完成
//    public static String addBinaryA(String a, String b) {
//
//        StringBuilder sb = new StringBuilder();
//        int carry = 0;
//        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
//            sb.append((i >= 0 ? a.charAt(i): '0') ^ (j >= 0 ? b.charAt(j) : '0') ^ carry);
//            carry =
//        }
//        sb.append(carry == 1 ? 1 : "");
//
//        return sb.reverse().toString();
//    }
}
