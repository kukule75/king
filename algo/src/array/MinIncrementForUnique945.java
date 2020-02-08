package array;

import java.util.*;

/**
 * @author kinden
 */
public class MinIncrementForUnique945 {

    public static void main(String[] args) {

        int[] A = {3,2,1,2,1,7};

        System.out.println(minIncrementForUnique(A));
//        System.out.println(minIncrementForUniqueA(A));
    }

    // 暴力，最坏复杂度O(n^2)
    public static int minIncrementForUnique(int[] A) {

        Set<Integer> set = new HashSet<>();

        int min = 0;
        for (int i = 0; i < A.length; i++) {
            int temp = A[i];
            while (set.contains(temp)) {
                temp++;
                min++;
            }
            set.add(temp);
        }

        return min;
    }

    // 1 1 2 2 3 7
    public static int minIncrementForUniqueA(int[] A) {

        Arrays.sort(A);
        int actions = 0;
        for(int i=0; i< A.length - 1;i++) {
            if(A[i] >= A[i+1]) {
                actions +=A[i] - A[i+1] + 1;
                A[i+1] = A[i] + 1;
            }
        }
        return actions;
    }
}
