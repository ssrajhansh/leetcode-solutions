package _3.Longest_Substring_Without_Repeating_Characters;

import java.util.Arrays;

/**
 * <div class="flex items-start justify-between gap-4"><div class="flex items-start gap-2"><div class="text-title-large font-semibold text-text-primary dark:text-text-primary"><a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/longest-substring-without-repeating-characters/">3. Longest Substring Without Repeating Characters</a><div class="text-body ml-2 inline-flex items-center gap-2 py-1"><div class="inline-flex items-center space-x-2"></div></div></div></div><div class="text-body flex flex-none items-center gap-1 py-1.5 text-text-secondary dark:text-text-secondary">Solved<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 14 14" width="1em" height="1em" fill="currentColor" class="fill-none stroke-current text-message-success dark:text-message-success"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="1.2" d="M12.598 7a5.6 5.6 0 11-3.15-5.037m2.1 1.537l-4.9 4.9-1.4-1.4"></path></svg></div></div>
 *
 * <div class="elfjS" data-track-load="description_content"><p>Given a string <code>s</code>, find the length of the <strong>longest</strong> <span data-keyword="substring-nonempty" class=" cursor-pointer relative text-dark-blue-s text-sm"><button type="button" aria-haspopup="dialog" aria-expanded="false" aria-controls="radix-:rp:" data-state="closed" class=""><strong>substring</strong></button></span> without duplicate characters.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre><strong>Input:</strong> s = "abcabcbb"
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> The answer is "abc", with the length of 3.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre><strong>Input:</strong> s = "bbbbb"
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> The answer is "b", with the length of 1.
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre><strong>Input:</strong> s = "pwwkew"
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>0 &lt;= s.length &lt;= 5 * 10<sup>4</sup></code></li>
 * 	<li><code>s</code> consists of English letters, digits, symbols and spaces.</li>
 * </ul>
 * </div>
 *
 */

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(s.lengthOfLongestSubstring("bbbbb"));
        System.out.println(s.lengthOfLongestSubstring("pwwkew"));
    }


    public int lengthOfLongestSubstring(String s) {
        if(s == "" || s == null) return 0;
        int[] arr = new int[128];
        Arrays.fill(arr, -1);
        int subStrLen = 0;
        int currentLen = 0;
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            currentLen++;
            int currentVal = s.charAt(i);
            if(arr[currentVal] != -1 && arr[currentVal] >= p){
                p = arr[currentVal] + 1;
                currentLen = i - p + 1;
            }
            if(currentLen > subStrLen){
                subStrLen = currentLen;
            }
            arr[currentVal] = i;
        }
        return subStrLen;
    }
}
