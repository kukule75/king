import java.util.LinkedList;
import java.util.List;

/**
 * @author kinden
 */
public class PermuteChar46 {

    public static void main(String[] args) {

        String s = "abc";

        List<List<Character>> res = permute(s.toCharArray());
    }

    public static List<List<Character>> permute(char[] chars) {

        List<List<Character>> res = new LinkedList<>();

        LinkedList<Character> temp = new LinkedList<>();

        permuteHelper(chars, res, temp);

        return res;
    }


    public static void permuteHelper(char[] chars, List<List<Character>> res, LinkedList<Character> temp) {


        if (temp.size() == chars.length) {
            res.add(new LinkedList<>(temp));
        }

        for (int i = 0; i < chars.length; i++) {
            if (temp.contains(chars[i])) {
                continue;
            }

            temp.add(chars[i]);
            permuteHelper(chars, res, temp);
            temp.removeLast();
        }
    }
}
