import java.util.HashSet;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {

    /**
     * Given a string, returns the length of the largest run.
     * A a run is a series of adajcent chars that are the same.
     *
     * @param str
     * @return max run length
     */
    public static int maxRun(String str) {
        int tmp=1,max_=1;
        for(int i=1;i<str.length();i++){
            if(str.charAt(i) == str.charAt(i-1)){
                tmp++;
            }
            else tmp = 1;
            if(tmp>max_) max_ = tmp;
        }
        return max_; // YOUR CODE HERE
    }


    /**
     * Given a string, for each digit in the original string,
     * replaces the digit with that many occurrences of the character
     * following. So the string "a3tx2z" yields "attttxzzz".
     *
     * @param str
     * @return blown up string
     */
    public static String blowup(String str) {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (Character.isDigit(c)) {
                char d = str.charAt(i + 1);

                if (Character.isDigit(d)) continue;
                else {
                    int tmp = c - '0';
                    for (tmp = tmp; tmp > 0; tmp--) {
                        res.append(d);
                    }
                }
            } else res.append(c);
        }
        return res.toString(); // YOUR CODE HERE
    }

    /**
     * Given 2 strings, consider all the substrings within them
     * of length len. Returns true if there are any such substrings
     * which appear in both strings.
     * Compute this in linear time using a HashSet. Len will be 1 or more.
     */
    public static boolean stringIntersect(String a, String b, int len) {
        HashSet<String> res = new HashSet<>();

        for(int i=0;i<a.length()-len;i++){
            res.add(a.substring(i,i+len));
        }

        for(int i=0;i<a.length()-len;i++){
            if(res.contains(b.substring(i,i+len))) return true;
        }
        return false; // YOUR CODE HERE
    }

    public static void main(String[] args) {
        String test = blowup("12x");
        System.out.println(test);
    }
}
