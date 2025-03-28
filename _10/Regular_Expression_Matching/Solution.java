package _10.Regular_Expression_Matching;

/**
 * <div class="flex w-full flex-1 flex-col gap-4 overflow-y-auto px-4 py-5"><div class="flex items-start justify-between gap-4"><div class="flex items-start gap-2"><div class="text-title-large font-semibold text-text-primary dark:text-text-primary"><a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/regular-expression-matching/">10. Regular Expression Matching</a><div class="text-body ml-2 inline-flex items-center gap-2 py-1"><div class="inline-flex items-center space-x-2"></div></div></div></div><div class="text-body flex flex-none items-center gap-1 py-1.5 text-text-secondary dark:text-text-secondary">Solved<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 14 14" width="1em" height="1em" fill="currentColor" class="fill-none stroke-current text-message-success dark:text-message-success"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="1.2" d="M12.598 7a5.6 5.6 0 11-3.15-5.037m2.1 1.537l-4.9 4.9-1.4-1.4"></path></svg></div></div><div class="flex gap-1"><div class="relative inline-flex items-center justify-center text-caption px-2 py-1 gap-1 rounded-full bg-fill-secondary text-difficulty-hard dark:text-difficulty-hard">Hard</div><div class="relative inline-flex items-center justify-center text-caption px-2 py-1 gap-1 rounded-full bg-fill-secondary cursor-pointer transition-colors hover:bg-fill-primary hover:text-text-primary text-sd-secondary-foreground hover:opacity-80"><div class="relative text-[14px] leading-[normal] p-[1px] before:block before:h-3.5 before:w-3.5 h-3.5 w-3.5 fill-none stroke-current"><svg aria-hidden="true" focusable="false" data-prefix="far" data-icon="tag" class="svg-inline--fa fa-tag absolute left-1/2 top-1/2 h-[1em] -translate-x-1/2 -translate-y-1/2 align-[-0.125em]" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512"><path fill="currentColor" d="M197.5 32c17 0 33.3 6.7 45.3 18.7l176 176c25 25 25 65.5 0 90.5L285.3 450.7c-25 25-65.5 25-90.5 0l-176-176C6.7 262.7 0 246.5 0 229.5V80C0 53.5 21.5 32 48 32H197.5zM48 229.5c0 4.2 1.7 8.3 4.7 11.3l176 176c6.2 6.2 16.4 6.2 22.6 0L384.8 283.3c6.2-6.2 6.2-16.4 0-22.6l-176-176c-3-3-7.1-4.7-11.3-4.7H48V229.5zM112 112a32 32 0 1 1 0 64 32 32 0 1 1 0-64z"></path></svg></div>Topics</div><div class="relative inline-flex items-center justify-center text-caption px-2 py-1 gap-1 rounded-full bg-fill-secondary cursor-pointer transition-colors hover:bg-fill-primary hover:text-text-primary text-sd-secondary-foreground hover:opacity-80"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="1em" height="1em" fill="currentColor" class="h-3.5 w-3.5"><path fill-rule="evenodd" d="M7 8v2H6a3 3 0 00-3 3v6a3 3 0 003 3h12a3 3 0 003-3v-6a3 3 0 00-3-3h-1V8A5 5 0 007 8zm8 0v2H9V8a3 3 0 116 0zm-3 6a2 2 0 100 4 2 2 0 000-4z" clip-rule="evenodd"></path></svg>Companies</div></div><div><div class="elfjS" data-track-load="description_content"><p>Given an input string <code>s</code>&nbsp;and a pattern <code>p</code>, implement regular expression matching with support for <code>'.'</code> and <code>'*'</code> where:</p>
 *
 * <ul>
 * 	<li><code>'.'</code> Matches any single character.​​​​</li>
 * 	<li><code>'*'</code> Matches zero or more of the preceding element.</li>
 * </ul>
 *
 * <p>The matching should cover the <strong>entire</strong> input string (not partial).</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "aa", p = "a"
 * <strong>Output:</strong> false
 * <strong>Explanation:</strong> "a" does not match the entire string "aa".
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "aa", p = "a*"
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "ab", p = ".*"
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> ".*" means "zero or more (*) of any character (.)".
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= s.length&nbsp;&lt;= 20</code></li>
 * 	<li><code>1 &lt;= p.length&nbsp;&lt;= 20</code></li>
 * 	<li><code>s</code> contains only lowercase English letters.</li>
 * 	<li><code>p</code> contains only lowercase English letters, <code>'.'</code>, and&nbsp;<code>'*'</code>.</li>
 * 	<li>It is guaranteed for each appearance of the character <code>'*'</code>, there will be a previous valid character to match.</li>
 * </ul>
 */

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isMatch("a", "b")); // false
        System.out.println(s.isMatch("a", "a")); // true
        System.out.println(s.isMatch("aa", "a")); // false
        System.out.println(s.isMatch("aa", "a*")); // true
        System.out.println(s.isMatch("aa", ".*")); // true
        System.out.println(s.isMatch("ab", ".*")); // true
        System.out.println(s.isMatch("aaaabbc", "aaaabbcc")); // false
        System.out.println(s.isMatch("aaaabbc", "aaaabbc")); // true
        System.out.println(s.isMatch("aaaabbc", "a*b*c")); // true
        System.out.println(s.isMatch("aaaabbc", "a*b*cc")); // false
        System.out.println(s.isMatch("aaaabbbbbbb", "a*b*")); // true

    }


    public boolean isMatch_old(String s, String p) {
        if (s.length() == 1) {
            return p.equals(".") || p.equals(s) || p.equals(".*");
        }

        boolean result = true;
        char pPrevious = 0;
        int i = 0, j = 0;
        while (i < p.length() && j < s.length()) {
            char pCurrent = p.charAt(i);
            char sCurrent = s.charAt(j);

            if(pCurrent == sCurrent || pCurrent == '.'){
                pPrevious = pCurrent;
                i++; j++;
            } else if (pCurrent == '*') {
                if(pPrevious == '.') return true;
                if(pPrevious == sCurrent) {
                    j++;
                } else {
                    if(i+1 == s.length()) return true;
                    i++;
                    pPrevious = pCurrent;
                }
            } else {
                return false;
            }
        }

        if(i == p.length() && j == s.length()) return true;
        if(i == p.length() && j < s.length()) return false;
        if(i < p.length() && j == s.length()) return false;

        return result;
    }

    public boolean isMatch(String text, String pattern){
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--) {
            for (int j = pattern.length() - 1; j >= 0; j--) {
                boolean first_match =
                        (i < text.length() &&
                                (pattern.charAt(j) == text.charAt(i) ||
                                        pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || (first_match && dp[i + 1][j]);
                } else {
                    dp[i][j] = first_match && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }
}
