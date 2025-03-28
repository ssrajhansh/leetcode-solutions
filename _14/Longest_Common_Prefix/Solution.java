package _14.Longest_Common_Prefix;

import java.util.Arrays;

/**
 *
 * 14. Longest Common Prefix
 * <p>&nbsp;</p>
 * <p>Write a function to find the longest common prefix string amongst an array of strings.</p>
 *
 * <p>If there is no common prefix, return an empty string <code>""</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre><strong>Input:</strong> strs = ["flower","flow","flight"]
 * <strong>Output:</strong> "fl"
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre><strong>Input:</strong> strs = ["dog","racecar","car"]
 * <strong>Output:</strong> ""
 * <strong>Explanation:</strong> There is no common prefix among the input strings.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= strs.length &lt;= 200</code></li>
 * 	<li><code>0 &lt;= strs[i].length &lt;= 200</code></li>
 * 	<li><code>strs[i]</code> consists of only lowercase English letters if it is non-empty.</li>
 * </ul>
 *
 *
 */

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestCommonPrefix(new String[]{"cir","car"}));
        System.out.println(s.longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(s.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(s.longestCommonPrefix(new String[]{"flower","flower","flower"}));

    }

    public String longestCommonPrefix_old(String[] strs) {
        String commonPrefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < commonPrefix.length() && j < strs[i].length();  j++) {
                if(commonPrefix.charAt(j) != strs[i].charAt(j))break;
                temp.append(commonPrefix.charAt(j));
            }
            if(commonPrefix.isEmpty()){
                return "";
            }
            commonPrefix = temp.toString();
        }
        return commonPrefix;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        if(strs.length == 1) return strs[0];

        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int c = 0;
        while(c < first.length())
        {
            if (first.charAt(c) == last.charAt(c))
                c++;
            else
                break;
        }
        return c == 0 ? "" : first.substring(0, c);
    }
}
