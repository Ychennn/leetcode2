package solved20_29;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {//括号生成
    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        func(n, n, new StringBuilder());
        return res;
    }

    private void func(int left, int right, StringBuilder stringBuilder) {
        if (left == 0 && right == 0) {
            res.add(stringBuilder.toString());
            return;
        } else if (left < 0 || right < 0 || left > right)
            //left < 0 || right < 0判断是否使用了正确的括号数
            //left > right判断括号序列是否非法
            return;


        //递归+回溯
        func(left - 1, right, stringBuilder.append('('));
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        func(left, right - 1, stringBuilder.append(')'));
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    }

    public static void main(String[] args) {
        Solution22 solution = new Solution22();
        List<String> list = solution.generateParenthesis(1);
        System.out.println(list);
    }
}
