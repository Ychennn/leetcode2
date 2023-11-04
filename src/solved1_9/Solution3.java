package solved1_9;

import java.util.HashMap;

public class Solution3 {//无重复字符的最长子串

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0, start = 0, end = 0;

        for (; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(start, map.get(s.charAt(end)) + 1);
            }

            res = Math.max(res, end - start + 1);
            map.put(s.charAt(end), end);
        }

        return res;
    }
}
