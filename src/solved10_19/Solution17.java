package solved10_19;

import java.util.ArrayList;
import java.util.List;

public class Solution17 {//电话号码的字母组合

    String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return res;

        String[] map = {
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };
        func(digits, 0, new StringBuilder());
        return res;
    }

    private void func(String digits, int index, StringBuilder stringBuilder) {
        if (index == digits.length()) {
            res.add(stringBuilder.toString());
            return;
        }
        String s = map[digits.charAt(index) - '2'];

        for (int i = 0; i < s.length(); i++) {
            stringBuilder.append(s.charAt(i));
            //递归
            func(digits, index + 1, stringBuilder);
            //回溯
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }


    public static void main(String[] args) {
        Solution17 solution = new Solution17();
        List<String> list = solution.letterCombinations("23");
        System.out.println(list);
    }
}
