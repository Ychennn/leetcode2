package solved10_19;

public class Solution14 {//最长公共前缀

    //方法1
    //借助func方法,依次遍历字符串数组中的每个字符串
    //对于每个遍历到的字符串,更新最长公共前缀
    //当遍历完所有的字符串以后,即可得到字符串数组中的最长公共前缀
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            res = func(res, strs[i]);
            if (res.length() == 0) break;
        }
        return res;
    }

    //求出str1,str2的最长公共前缀
    public String func(String str1, String str2) {
        int len = Math.min(str1.length(), str2.length());
        int i = 0;
        while (i < len && str1.charAt(i) == str2.charAt(i)) {
            i++;
        }
        return str1.substring(0, i);
    }

    //方法2
    //循环比较每一个str的第i位,如果不相等则返回strs[0].substring(0, i);
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";


        int minlen = Integer.MAX_VALUE;
        String res = null;
        for (String str : strs) {
            if (str.length() < minlen) {
                res = str;
                minlen = str.length();
            }
        }
        for (int i = 0; i < minlen; i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != strs[j - 1].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        //有种情况如P{ab,a}此时不会出现strs[j].charAt(i) != strs[j - 1].charAt(i)
        //也就不会返回strs[0].substring(0, i);
        //所以这里选择记录最短那个字符串,当没有执行上述操作的时候返回即可
        return res;
    }


    public static void main(String[] args) {
        Solution14 solution = new Solution14();
        String[] strs = {"ab", "a"};
        String s = solution.longestCommonPrefix2(strs);
        System.out.println(s);
    }
}
