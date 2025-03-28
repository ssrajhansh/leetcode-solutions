package _8.String_to_Integer_atoi;

/**
 * <div class="flex w-full flex-1 flex-col gap-4 overflow-y-auto px-4 py-5"><div class="flex items-start justify-between gap-4"><div class="flex items-start gap-2"><div class="text-title-large font-semibold text-text-primary dark:text-text-primary"><a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/string-to-integer-atoi/">8. String to Integer (atoi)</a><div class="text-body ml-2 inline-flex items-center gap-2 py-1"><div class="inline-flex items-center space-x-2"></div></div></div></div><div class="text-body flex flex-none items-center gap-1 py-1.5 text-text-secondary dark:text-text-secondary">Solved<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 14 14" width="1em" height="1em" fill="currentColor" class="fill-none stroke-current text-message-success dark:text-message-success"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="1.2" d="M12.598 7a5.6 5.6 0 11-3.15-5.037m2.1 1.537l-4.9 4.9-1.4-1.4"></path></svg></div></div><div class="flex gap-1"><div class="relative inline-flex items-center justify-center text-caption px-2 py-1 gap-1 rounded-full bg-fill-secondary text-difficulty-medium dark:text-difficulty-medium">Medium</div><div class="relative inline-flex items-center justify-center text-caption px-2 py-1 gap-1 rounded-full bg-fill-secondary cursor-pointer transition-colors hover:bg-fill-primary hover:text-text-primary text-sd-secondary-foreground hover:opacity-80"><div class="relative text-[14px] leading-[normal] p-[1px] before:block before:h-3.5 before:w-3.5 h-3.5 w-3.5 fill-none stroke-current"><svg aria-hidden="true" focusable="false" data-prefix="far" data-icon="tag" class="svg-inline--fa fa-tag absolute left-1/2 top-1/2 h-[1em] -translate-x-1/2 -translate-y-1/2 align-[-0.125em]" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512"><path fill="currentColor" d="M197.5 32c17 0 33.3 6.7 45.3 18.7l176 176c25 25 25 65.5 0 90.5L285.3 450.7c-25 25-65.5 25-90.5 0l-176-176C6.7 262.7 0 246.5 0 229.5V80C0 53.5 21.5 32 48 32H197.5zM48 229.5c0 4.2 1.7 8.3 4.7 11.3l176 176c6.2 6.2 16.4 6.2 22.6 0L384.8 283.3c6.2-6.2 6.2-16.4 0-22.6l-176-176c-3-3-7.1-4.7-11.3-4.7H48V229.5zM112 112a32 32 0 1 1 0 64 32 32 0 1 1 0-64z"></path></svg></div>Topics</div><div class="relative inline-flex items-center justify-center text-caption px-2 py-1 gap-1 rounded-full bg-fill-secondary cursor-pointer transition-colors hover:bg-fill-primary hover:text-text-primary text-sd-secondary-foreground hover:opacity-80"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="1em" height="1em" fill="currentColor" class="h-3.5 w-3.5"><path fill-rule="evenodd" d="M7 8v2H6a3 3 0 00-3 3v6a3 3 0 003 3h12a3 3 0 003-3v-6a3 3 0 00-3-3h-1V8A5 5 0 007 8zm8 0v2H9V8a3 3 0 116 0zm-3 6a2 2 0 100 4 2 2 0 000-4z" clip-rule="evenodd"></path></svg>Companies</div></div><div><div class="elfjS" data-track-load="description_content"><p>Implement the <code>myAtoi(string s)</code> function, which converts a string to a 32-bit signed integer.</p>
 *
 * <p>The algorithm for <code>myAtoi(string s)</code> is as follows:</p>
 *
 * <ol>
 * 	<li><strong>Whitespace</strong>: Ignore any leading whitespace (<code>" "</code>).</li>
 * 	<li><strong>Signedness</strong>: Determine the sign by checking if the next character is <code>'-'</code> or <code>'+'</code>, assuming positivity if neither present.</li>
 * 	<li><strong>Conversion</strong>: Read the integer by skipping leading zeros&nbsp;until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.</li>
 * 	<li><strong>Rounding</strong>: If the integer is out of the 32-bit signed integer range <code>[-2<sup>31</sup>, 2<sup>31</sup> - 1]</code>, then round the integer to remain in the range. Specifically, integers less than <code>-2<sup>31</sup></code> should be rounded to <code>-2<sup>31</sup></code>, and integers greater than <code>2<sup>31</sup> - 1</code> should be rounded to <code>2<sup>31</sup> - 1</code>.</li>
 * </ol>
 *
 * <p>Return the integer as the final result.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">s = "42"</span></p>
 *
 * <p><strong>Output:</strong> <span class="example-io">42</span></p>
 *
 * <p><strong>Explanation:</strong></p>
 *
 * <pre>The underlined characters are what is read in and the caret is the current reader position.
 * Step 1: "42" (no characters read because there is no leading whitespace)
 *          ^
 * Step 2: "42" (no characters read because there is neither a '-' nor '+')
 *          ^
 * Step 3: "<u>42</u>" ("42" is read in)
 *            ^
 * </pre>
 * </div>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">s = " -042"</span></p>
 *
 * <p><strong>Output:</strong> <span class="example-io">-42</span></p>
 *
 * <p><strong>Explanation:</strong></p>
 *
 * <pre>Step 1: "<u>   </u>-042" (leading whitespace is read and ignored)
 *             ^
 * Step 2: "   <u>-</u>042" ('-' is read, so the result should be negative)
 *              ^
 * Step 3: "   -<u>042</u>" ("042" is read in, leading zeros ignored in the result)
 *                ^
 * </pre>
 * </div>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">s = "1337c0d3"</span></p>
 *
 * <p><strong>Output:</strong> <span class="example-io">1337</span></p>
 *
 * <p><strong>Explanation:</strong></p>
 *
 * <pre>Step 1: "1337c0d3" (no characters read because there is no leading whitespace)
 *          ^
 * Step 2: "1337c0d3" (no characters read because there is neither a '-' nor '+')
 *          ^
 * Step 3: "<u>1337</u>c0d3" ("1337" is read in; reading stops because the next character is a non-digit)
 *              ^
 * </pre>
 * </div>
 *
 * <p><strong class="example">Example 4:</strong></p>
 *
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">s = "0-1"</span></p>
 *
 * <p><strong>Output:</strong> <span class="example-io">0</span></p>
 *
 * <p><strong>Explanation:</strong></p>
 *
 * <pre>Step 1: "0-1" (no characters read because there is no leading whitespace)
 *          ^
 * Step 2: "0-1" (no characters read because there is neither a '-' nor '+')
 *          ^
 * Step 3: "<u>0</u>-1" ("0" is read in; reading stops because the next character is a non-digit)
 *           ^
 * </pre>
 * </div>
 *
 * <p><strong class="example">Example 5:</strong></p>
 *
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">s = "words and 987"</span></p>
 *
 * <p><strong>Output:</strong> <span class="example-io">0</span></p>
 *
 * <p><strong>Explanation:</strong></p>
 *
 * <p>Reading stops at the first non-digit character 'w'.</p>
 * </div>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>0 &lt;= s.length &lt;= 200</code></li>
 * 	<li><code>s</code> consists of English letters (lower-case and upper-case), digits (<code>0-9</code>), <code>' '</code>, <code>'+'</code>, <code>'-'</code>, and <code>'.'</code>.</li>
 * </ul>
 *
 *
 */

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.myAtoi("1337c0d3"));
    }


    public int myAtoi(String s) {
        final int MAX = Integer.MAX_VALUE;
        boolean isNeg = false;
        boolean visited = false;
        boolean visited1 = false;
        long ans = 0;
        for (char c : s.toCharArray()) {
            if(c == '0') {
                visited = true;
            }
            if(c == ' ' && (visited || visited1)) break;
            if((c == '-' || c == '+') && ans == 0 && !visited) {
                visited = true;
                isNeg = c=='-';
            } else if(!(c >= '0' && c <= '9') && c != ' ') {
                break;
            } else if((c >= '0' && c <= '9')) {
                ans = (ans*10)+(c-'0');
                visited1 = true;
            }

            if(ans > MAX) {
                return (isNeg)? -MAX-1 : MAX;
            }
        }
        return (isNeg)? (int)(-ans):(int)(ans);
    }
}
