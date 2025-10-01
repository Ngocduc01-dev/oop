import java.util.HashSet;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adajcent chars that are the same.
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        int maxLen = 0;
        int curLen = 0;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                curLen++;
                if (curLen > maxLen) {
                    maxLen = curLen;
                }
            } else {
                curLen = 1;
            }
        }
        return maxLen; // YOUR CODE HERE
	}

	
	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
		if (str == null || str.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c =  str.charAt(i);
            if (Character.isDigit(c)) {
                int count = c - '0';
                if (i + 1 < str.length()) {
                    char next = str.charAt(i + 1);
                    for (int k = 0;  k < count; k++) {
                        sb.append(next);
                    }
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString(); // YOUR CODE HERE
	}
	
	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
        if (a == null || b == null || len <= 0) return false;
        if (a.length() < len || b.length() < len) return false;

        HashSet <String> set = new HashSet<>();
        for (int i = 0; i <= a.length() - len; i++) {
            set.add(a.substring(i,i+len));
        }
        for (int j = 0; j <= b.length() - len; j++) {
            if (set.contains(b.substring(j,j + len))) {
                return true;
            }
        }
		return false; // YOUR CODE HERE
	}
    public static void main(String[] args) {
        System.out.println(blowup("a3tx2z")); // attttxzzz
        System.out.println(blowup("12x"));    // 2xxx
        System.out.println(blowup("a0b2"));   // abbb
        System.out.println(blowup("3"));      // "" (bởi vì chữ số ở cuối)
        System.out.println(maxRun("xxyyyz")); // 3
        System.out.println(maxRun("xyz"));    // 1
        System.out.println(maxRun(""));       // 0
        System.out.println(maxRun("aaaaa"));  // 5
        System.out.println(stringIntersect("abcdef", "xyzcd", 2)); // true ("cd")
        System.out.println(stringIntersect("abcdef", "xyzcd", 3)); // false
        System.out.println(stringIntersect("hello", "yellow", 2)); // true ("el", "ll", "lo")
        System.out.println(stringIntersect("abc", "def", 1));      // false
    }
}
