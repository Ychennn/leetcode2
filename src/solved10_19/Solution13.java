package solved10_19;

import java.util.HashMap;

public class Solution13 {//罗马数字转整数

    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && map.get(s.charAt(i + 1)) > map.get(s.charAt(i))) {
                res += (map.get(s.charAt(i + 1)) - map.get(s.charAt(i)));
                i++;
            } else {
                res += map.get(s.charAt(i));
            }
        }

        return res;
    }


    public static void main(String[] args) {
        Solution13 solution = new Solution13();
        int i = solution.romanToInt("MCMXCIV");
        System.out.println(i);
    }
}
