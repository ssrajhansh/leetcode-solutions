package _12.Integer_to_Roman;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <div class="flex w-full flex-1 flex-col gap-4 overflow-y-auto px-4 py-5"><div class="flex items-start justify-between gap-4"><div class="flex items-start gap-2"><div class="text-title-large font-semibold text-text-primary dark:text-text-primary"><a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/integer-to-roman/">12. Integer to Roman</a><div class="text-body ml-2 inline-flex items-center gap-2 py-1"><div class="inline-flex items-center space-x-2"></div></div></div></div></div><div class="flex gap-1"><div class="relative inline-flex items-center justify-center text-caption px-2 py-1 gap-1 rounded-full bg-fill-secondary text-difficulty-medium dark:text-difficulty-medium">Medium</div><div class="relative inline-flex items-center justify-center text-caption px-2 py-1 gap-1 rounded-full bg-fill-secondary cursor-pointer transition-colors hover:bg-fill-primary hover:text-text-primary text-sd-secondary-foreground hover:opacity-80"><div class="relative text-[14px] leading-[normal] p-[1px] before:block before:h-3.5 before:w-3.5 h-3.5 w-3.5 fill-none stroke-current"><svg aria-hidden="true" focusable="false" data-prefix="far" data-icon="tag" class="svg-inline--fa fa-tag absolute left-1/2 top-1/2 h-[1em] -translate-x-1/2 -translate-y-1/2 align-[-0.125em]" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512"><path fill="currentColor" d="M197.5 32c17 0 33.3 6.7 45.3 18.7l176 176c25 25 25 65.5 0 90.5L285.3 450.7c-25 25-65.5 25-90.5 0l-176-176C6.7 262.7 0 246.5 0 229.5V80C0 53.5 21.5 32 48 32H197.5zM48 229.5c0 4.2 1.7 8.3 4.7 11.3l176 176c6.2 6.2 16.4 6.2 22.6 0L384.8 283.3c6.2-6.2 6.2-16.4 0-22.6l-176-176c-3-3-7.1-4.7-11.3-4.7H48V229.5zM112 112a32 32 0 1 1 0 64 32 32 0 1 1 0-64z"></path></svg></div>Topics</div><div class="relative inline-flex items-center justify-center text-caption px-2 py-1 gap-1 rounded-full bg-fill-secondary cursor-pointer transition-colors hover:bg-fill-primary hover:text-text-primary text-sd-secondary-foreground hover:opacity-80"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="1em" height="1em" fill="currentColor" class="h-3.5 w-3.5"><path fill-rule="evenodd" d="M7 8v2H6a3 3 0 00-3 3v6a3 3 0 003 3h12a3 3 0 003-3v-6a3 3 0 00-3-3h-1V8A5 5 0 007 8zm8 0v2H9V8a3 3 0 116 0zm-3 6a2 2 0 100 4 2 2 0 000-4z" clip-rule="evenodd"></path></svg>Companies</div></div><div><div class="elfjS" data-track-load="description_content"><p>Seven different symbols represent Roman numerals with the following values:</p>
 *
 * <table><thead><tr><th>Symbol</th><th>Value</th></tr></thead><tbody><tr><td>I</td><td>1</td></tr><tr><td>V</td><td>5</td></tr><tr><td>X</td><td>10</td></tr><tr><td>L</td><td>50</td></tr><tr><td>C</td><td>100</td></tr><tr><td>D</td><td>500</td></tr><tr><td>M</td><td>1000</td></tr></tbody></table>
 *
 * <p>Roman numerals are formed by appending&nbsp;the conversions of&nbsp;decimal place values&nbsp;from highest to lowest. Converting a decimal place value into a Roman numeral has the following rules:</p>
 *
 * <ul>
 * 	<li>If the value does not start with 4 or&nbsp;9, select the symbol of the maximal value that can be subtracted from the input, append that symbol to the result, subtract its value, and convert the remainder to a Roman numeral.</li>
 * 	<li>If the value starts with 4 or 9 use the&nbsp;<strong>subtractive form</strong>&nbsp;representing&nbsp;one symbol subtracted from the following symbol, for example,&nbsp;4 is 1 (<code>I</code>) less than 5 (<code>V</code>): <code>IV</code>&nbsp;and 9 is 1 (<code>I</code>) less than 10 (<code>X</code>): <code>IX</code>.&nbsp;Only the following subtractive forms are used: 4 (<code>IV</code>), 9 (<code>IX</code>),&nbsp;40 (<code>XL</code>), 90 (<code>XC</code>), 400 (<code>CD</code>) and 900 (<code>CM</code>).</li>
 * 	<li>Only powers of 10 (<code>I</code>, <code>X</code>, <code>C</code>, <code>M</code>) can be appended consecutively at most 3 times to represent multiples of 10. You cannot append 5&nbsp;(<code>V</code>), 50 (<code>L</code>), or 500 (<code>D</code>) multiple times. If you need to append a symbol&nbsp;4 times&nbsp;use the <strong>subtractive form</strong>.</li>
 * </ul>
 *
 * <p>Given an integer, convert it to a Roman numeral.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">num = 3749</span></p>
 *
 * <p><strong>Output:</strong> <span class="example-io">"MMMDCCXLIX"</span></p>
 *
 * <p><strong>Explanation:</strong></p>
 *
 * <pre>3000 = MMM as 1000 (M) + 1000 (M) + 1000 (M)
 *  700 = DCC as 500 (D) + 100 (C) + 100 (C)
 *   40 = XL as 10 (X) less of 50 (L)
 *    9 = IX as 1 (I) less of 10 (X)
 * Note: 49 is not 1 (I) less of 50 (L) because the conversion is based on decimal places
 * </pre>
 * </div>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">num = 58</span></p>
 *
 * <p><strong>Output:</strong> <span class="example-io">"LVIII"</span></p>
 *
 * <p><strong>Explanation:</strong></p>
 *
 * <pre>50 = L
 *  8 = VIII
 * </pre>
 * </div>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">num = 1994</span></p>
 *
 * <p><strong>Output:</strong> <span class="example-io">"MCMXCIV"</span></p>
 *
 * <p><strong>Explanation:</strong></p>
 *
 * <pre>1000 = M
 *  900 = CM
 *   90 = XC
 *    4 = IV
 * </pre>
 * </div>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= num &lt;= 3999</code></li>
 * </ul>
 */

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] inputs = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 33, 35, 39, 49, 85, 1994, 1042, 3749, 3738, 3008, 58, 3999};

        Arrays.stream(inputs).forEach(x -> System.out.println(x + ": " + s.intToRoman(x)));
    }


    public String intToRoman_7ms(int num) {
        String result = "";
        Map<Integer, String> dict = new HashMap<>();
        dict.put(1, "I");
        dict.put(5, "V");
        dict.put(10, "X");
        dict.put(50, "L");
        dict.put(100, "C");
        dict.put(500, "D");
        dict.put(1000, "M");


        for (int i = 0, input = num; input > 0; i++, input /= 10) {
            int digit = input % 10;
            int tenPow = (int) Math.pow(10, i);

            String digitRoman = "";

            if (digit == 0) {
                continue;
            } else if (digit == 4 || digit == 9) {
                digitRoman = dict.get(tenPow).concat(dict.get((digit + 1) * tenPow));
            } else {
                if (digit == 5) {
                    int checkNum = digit * tenPow;
                    if (dict.containsKey(checkNum)) {
                        digitRoman = dict.get(checkNum);
                    }
                } else {
                    if (5 - digit < 0) {
                        digit = (-1) * (5 - digit);
                        digitRoman = dict.get(5 * tenPow);
                    }
                    while (digit-- > 0) {
                        digitRoman = digitRoman.concat(dict.get(tenPow));
                    }
                }
            }

            result = digitRoman.concat(result);
        }

        return result;
    }

    public String intToRoman_5ms(int num) {
        String result = "";

        String[] powTen = {"I", "X", "C", "M"};
        String[] powTenMulFive = {"V", "L", "D"};

        for (int i = 0, input = num; input > 0; i++, input /= 10) {
            int digit = input % 10;

            String digitRoman = "";

            if (digit == 0) {
                continue;
            } else if (digit == 4) {
                digitRoman = powTen[i] + powTenMulFive[i];
            } else if (digit == 9) {
                digitRoman = powTen[i] + powTen[i + 1];
            } else {
                if (digit == 5) {
                    digitRoman = powTenMulFive[i];
                } else {
                    if (5 - digit < 0) {
                        digit = (-1) * (5 - digit);
                        digitRoman = powTenMulFive[i];
                    }
                    while (digit-- > 0) {
                        digitRoman = digitRoman.concat(powTen[i]);
                    }
                }
            }

            result = digitRoman.concat(result);
        }

        return result;
    }

    public String intToRoman(int num) {
        String[] M = {"", "M", "MM", "MMM"};
        String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return M[num / 1000]
                .concat(C[(num % 1000) / 100]
                        .concat(X[(num % 100) / 10]
                                .concat(I[num % 10])));
    }
}
