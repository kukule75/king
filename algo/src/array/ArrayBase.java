package array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author kinden
 */
public class ArrayBase {

    public static void main(String[] args) {

        Integer[] a = {1,2,3};

//        ArrayList<Object> arrayList = new ArrayList<>();

        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(a));

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println("" + arrayList.get(i));
        }
    }
}
