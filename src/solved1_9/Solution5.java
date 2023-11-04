package solved1_9;

public class Solution5 {//最长回文子串

    //动态规划
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        int start = 0, maxlen = 1;

        //dp[i][j]代表索引i到j的子串是否为回文子串
        //从第j列开始进行操作,因为需要用到dp[i+1][j-1]
        //即左下的值,同时j - i + 1 < 3 这一步操作主要是考虑到
        //当只有2个字符时,他们如果相等直接dp[i][j] = true;
        //因为不存在"dp[i+1][j-1]"
        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(j) == s.charAt(i)) {
//                    if (j - i + 1 < 3) {
                    if (j - i + 1 == 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }

                    if (dp[i][j] && j - i + 1 > maxlen) {
                        start = i;
                        maxlen = j - i + 1;
                    }
                }
            }
        }
        return s.substring(start, start + maxlen);
    }

    //中心扩散法
    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = func(s, i, i);
            int len2 = func(s, i, i + 1);
            int maxlen = Math.max(len1, len2);
            if (maxlen > end - start + 1) {
                //这里计算方法能同时满足以1个字符为中心和以2个字符为中心的情况
                //实际上计算公式不同,但因为maxlen为奇偶数和除法向下取整的特性,可以用统一的公式进行计算
                start = i - (maxlen - 1) / 2;
                end = i + maxlen / 2;
            }
        }
        return s.substring(start, end + 1);
    }


    private int func(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        //注意下面的长度公式,因为退出循环的时候l和r分别多移动了一位
        //应该是 (r-1)-(l+1)+1 => r - l - 1
        return r - l - 1;
    }

    public static void main(String[] args) {
        Solution5 solution = new Solution5();
        String s = solution.longestPalindrome("babad");
        System.out.println(s);
    }
}
