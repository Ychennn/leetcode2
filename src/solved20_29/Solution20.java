package solved20_29;

import java.util.HashMap;
import java.util.Stack;

class Solution20 {//有效的括号

    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) return false;
                else {
                    if (stack.peek() == map.get(s.charAt(i))) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution20 solution = new Solution20();
        String s = "()[]{}";
        boolean b = solution.isValid(s);
        System.out.println(b);
    }
}