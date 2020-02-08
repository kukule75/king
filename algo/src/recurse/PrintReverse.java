package recurse;

/**
 * @author kinden
 */
public class PrintReverse {

    public static void main(String[] args) {

        char[] ch = {'a','b','c','d','e'};

        printReverse(ch);
    }

    public static void printReverse(char[] ch) {

        helper(0, ch);
    }

    private static void helper(int index, char[] ch) {

        if (ch ==null || index >= ch.length) {
            return;
        }

        helper(index+1, ch);
        System.out.println(ch[index]);
    }
}
