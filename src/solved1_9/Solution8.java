package solved1_9;


public class Solution8 {//字符串转换整数 (atoi)

    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) return 0;

        long res = 0;
        //sign标志位,标记正负
        int i = 0, sign = 1;

        if (i < s.length() && s.charAt(i) == '+') {
            i++;
        } else if (i < s.length() && s.charAt(i) == '-') {
            sign = -sign;
            i++;
        }
        //判断剩余的字符,遇到非数字字符结束循环
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            //解决类似于00001这种数据
            if (res == 0) {
                res = Character.getNumericValue(s.charAt(i));
            } else {
                res *= 10;
                res += Character.getNumericValue(s.charAt(i));
            }
            if (res * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (res * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            i++;
        }
        return (int) (res * sign);
    }

    public static void main(String[] args) {
        Solution8 solution = new Solution8();
        String s = "21474836460";
        int i = solution.myAtoi(s);
        System.out.println(i);
    }
}
