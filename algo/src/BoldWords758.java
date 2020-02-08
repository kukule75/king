/**
 * @author kinden
 */
public class BoldWords758 {

    public static void main(String[] args) {


        String[] words = {"ab", "bc"};
        String S = "aabcd";
        System.out.println(boldWords(words, S));

    }

    public static String boldWords(String[] words, String S) {

        int[] status = new int[S.length()];

        for (int i = 0; i < words.length; i++) {
            int start = S.indexOf(words[i], 0);
            while (start != -1) {
                for (int j = start; j < start + words[i].length(); j++) {
                    status[j] = 1;
                }

                start = S.indexOf(words[i], start + 1);
            }
        }

        StringBuilder sb = new StringBuilder();

        char[] ch = S.toCharArray();
        if (status[0] == 1) {
            sb.append("<b>");
        }
        for (int i = 0; i < status.length; i++) {
            sb.append(ch[i]);
            if (i == status.length - 1) {
                if (status[i] == 1) {
                    sb.append("</b>");
                }
                break;
            }
            if (status[i] == 0 && status[i+1] == 1) {
                sb.append("<b>");
            }
            if (status[i] == 1 && status[i+1] == 0) {
                sb.append("</b>");
            }
        }


        return sb.toString();
    }
}
