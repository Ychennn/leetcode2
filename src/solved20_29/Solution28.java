package solved20_29;

public class Solution28 {//找出字符串中第一个匹配项的下标

    public int strStr(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            boolean b = true;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    b = false;
                    break;
                }
            }

            if (b) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution28 solution = new Solution28();
        String haystack = "sadbutsad", needle = "dsad";
        int i = solution.strStr(haystack, needle);
        System.out.println(i);
    }
}
