package solved20_29;

public class Solution29 {//两数相除

    public int divide(int dividend, int divisor) {
        //Integer.MIN_VALUE == -2147483648,Integer.MAX_VALUE == 2147483647
        //对Integer.MIN_VALUE,-1做除法的话应得2147483648,超出了Integer的表示范围
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean b = (dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0);


        //这里全转换成负数进行处理,是因为Integer.MIN_VALUE取绝对值超出了Integer的表示范围
        dividend = -Math.abs(dividend);
        divisor = -Math.abs(divisor);

        int res = 0;
        while (dividend <= divisor) {
            int i = 1;
            //当divisor取-1090366779或其他某些数时,左移一位的时候
            //超出了Integer的取值范围,转变成了正数,会导致结果错误
            long tmp = divisor;
            while (dividend <= tmp) {
                dividend -= tmp;
                res += i;
                tmp <<= 1;
                i <<= 1;
            }
        }
        return b ? res : -res;
    }

    public static void main(String[] args) {
        Solution29 solution = new Solution29();
//        int i = solution.divide(1100540749, -1090366779);
        int i = solution.divide(Integer.MIN_VALUE, 1);
        System.out.println(i);
    }
}
