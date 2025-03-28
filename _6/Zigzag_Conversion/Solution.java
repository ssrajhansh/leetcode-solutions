package _6.Zigzag_Conversion;

/**
 * <div class="flex w-full flex-1 flex-col gap-4 overflow-y-auto px-4 py-5"><div class="flex items-start justify-between gap-4"><div class="flex items-start gap-2"><div class="text-title-large font-semibold text-text-primary dark:text-text-primary"><a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/zigzag-conversion/">6. Zigzag Conversion</a><div class="text-body ml-2 inline-flex items-center gap-2 py-1"><div class="inline-flex items-center space-x-2"></div></div></div></div><div class="text-body flex flex-none items-center gap-1 py-1.5 text-text-secondary dark:text-text-secondary">Solved<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 14 14" width="1em" height="1em" fill="currentColor" class="fill-none stroke-current text-message-success dark:text-message-success"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="1.2" d="M12.598 7a5.6 5.6 0 11-3.15-5.037m2.1 1.537l-4.9 4.9-1.4-1.4"></path></svg></div></div><div class="flex gap-1"><div class="relative inline-flex items-center justify-center text-caption px-2 py-1 gap-1 rounded-full bg-fill-secondary text-difficulty-medium dark:text-difficulty-medium">Medium</div><div class="relative inline-flex items-center justify-center text-caption px-2 py-1 gap-1 rounded-full bg-fill-secondary cursor-pointer transition-colors hover:bg-fill-primary hover:text-text-primary text-sd-secondary-foreground hover:opacity-80"><div class="relative text-[14px] leading-[normal] p-[1px] before:block before:h-3.5 before:w-3.5 h-3.5 w-3.5 fill-none stroke-current"><svg aria-hidden="true" focusable="false" data-prefix="far" data-icon="tag" class="svg-inline--fa fa-tag absolute left-1/2 top-1/2 h-[1em] -translate-x-1/2 -translate-y-1/2 align-[-0.125em]" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512"><path fill="currentColor" d="M197.5 32c17 0 33.3 6.7 45.3 18.7l176 176c25 25 25 65.5 0 90.5L285.3 450.7c-25 25-65.5 25-90.5 0l-176-176C6.7 262.7 0 246.5 0 229.5V80C0 53.5 21.5 32 48 32H197.5zM48 229.5c0 4.2 1.7 8.3 4.7 11.3l176 176c6.2 6.2 16.4 6.2 22.6 0L384.8 283.3c6.2-6.2 6.2-16.4 0-22.6l-176-176c-3-3-7.1-4.7-11.3-4.7H48V229.5zM112 112a32 32 0 1 1 0 64 32 32 0 1 1 0-64z"></path></svg></div>Topics</div><div class="relative inline-flex items-center justify-center text-caption px-2 py-1 gap-1 rounded-full bg-fill-secondary cursor-pointer transition-colors hover:bg-fill-primary hover:text-text-primary text-sd-secondary-foreground hover:opacity-80"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="1em" height="1em" fill="currentColor" class="h-3.5 w-3.5"><path fill-rule="evenodd" d="M7 8v2H6a3 3 0 00-3 3v6a3 3 0 003 3h12a3 3 0 003-3v-6a3 3 0 00-3-3h-1V8A5 5 0 007 8zm8 0v2H9V8a3 3 0 116 0zm-3 6a2 2 0 100 4 2 2 0 000-4z" clip-rule="evenodd"></path></svg>Companies</div></div><div><div class="elfjS" data-track-load="description_content"><p>The string <code>"PAYPALISHIRING"</code> is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)</p>
 *
 * <pre>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * </pre>
 *
 * <p>And then read line by line: <code>"PAHNAPLSIIGYIR"</code></p>
 *
 * <p>Write the code that will take a string and make this conversion given a number of rows:</p>
 *
 * <pre>string convert(string s, int numRows);
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre><strong>Input:</strong> s = "PAYPALISHIRING", numRows = 3
 * <strong>Output:</strong> "PAHNAPLSIIGYIR"
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre><strong>Input:</strong> s = "PAYPALISHIRING", numRows = 4
 * <strong>Output:</strong> "PINALSIGYAHRPI"
 * <strong>Explanation:</strong>
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre><strong>Input:</strong> s = "A", numRows = 1
 * <strong>Output:</strong> "A"
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= s.length &lt;= 1000</code></li>
 * 	<li><code>s</code> consists of English letters (lower-case and upper-case), <code>','</code> and <code>'.'</code>.</li>
 * 	<li><code>1 &lt;= numRows &lt;= 1000</code></li>
 * </ul>
 */

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.convert("PAYPALISHIRING", 3));
        System.out.println(s.convert("PAYPALISHIRING", 4));
        System.out.println(s.convert("PAYPALISHIRING", 8));

    }

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        char[] ans = new char[s.length()];
        int diff = ((2 * numRows) - 2);
        int index = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += diff) {
                ans[index++] += s.charAt(j);
                if (i > 0 && i < numRows - 1 && j + diff - 2 * i < s.length()) {
                    ans[index++] += s.charAt(j + diff - 2 * i);
                }
            }
        }
        return new String(ans);
    }
}
