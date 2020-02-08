package recurse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author kinden
 */
public class Triangle119 {

    public static void main(String[] args) {

        List<Integer> res = getRowA(1);
//        List<Integer> res = getRowB(3);

        res.forEach(System.out::print);

    }


    //
    public static List<Integer> getRowB(int rowIndex) {

        List<Integer> cur = new ArrayList<>();
        cur.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j > 0; j--) {
                cur.set(j, cur.get(j - 1) + cur.get(j));
            }
            cur.add(1);//补上每层的最后一个 1
        }
        return cur;
    }

    // 解法二，这种写法会少一层，答案不对，注意与上面getRowB的区别
    //    1
    //   1 1
    //  1 2 1
    // 1 3 3 1
    public static List<Integer> getRowA(int rowIndex) {

        List<Integer> list = new ArrayList<>(rowIndex );

        list.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1 ; j > 0; j--) {
                if (j == i - 1) {
                    list.add(j, 1);
                } else {
                    list.set(j, list.get(j - 1) + list.get(j));
                }
            }
        }

        return list;

    }

    // 解法一，很自然想到两个list，一个记录前一次的结果，一个保存当前结果
    public static List<Integer> getRow(int rowIndex) {

        List<Integer> pre = new LinkedList<>();
        List<Integer> cur = new LinkedList<>();

        for (int i = 1; i <= rowIndex; i++) {
            cur = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    cur.add(1);
                } else {
                    cur.add(pre.get(j - 1) + pre.get(j));
                }
            }

            pre = cur;
        }

        return cur;

    }
}
