package array;

/**
 * @author kinden
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {

//        String[] strs = {"aca","cba"};
        String[] strs = {"abcd","abcd","ab"};
//        String res = longestCommonPrefix(strs);
        String res = longestCommonPrefixA(strs);

        System.out.println(res);
    }

    /**
     * 从第一个元素开始挨个遍历，看看是不是后一个字符串的子串
     *
     * @param strs
     * @return
     */
    private static String longestCommonPrefixA(String[] strs) {

        int len = strs.length;

        if (len == 0) {
            return "";
        }

        String prefix = strs[0];

        for (int i = 0; i < len; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

    private static String longestCommonPrefix(String[] strs) {

        int len = strs.length;

        if (len == 0) {
            return "";
        }

        StringBuilder builder = new StringBuilder();

        int minLen = strs[0].length();
        int minIndex = 0;

        for(int i = 0; i < len; i++) {
            if (strs[i].length() < minLen) {
                minLen = strs[i].length();
                minIndex = i;
            }
        }

        String cur = strs[minIndex];

        int k = 0;
        while (k < minLen) {
            char flag = cur.charAt(k);
            int i = 0;
            for (; i < len && ((flag ^ strs[i].charAt(k)) == 0); i++) {
            }
            if (i == len) {
                builder.append(flag);
            } else {
                break;
            }
            k++;
        }

        return builder.toString();
    }
}
