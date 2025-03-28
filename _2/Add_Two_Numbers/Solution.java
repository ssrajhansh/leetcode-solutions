package _2.Add_Two_Numbers;

/**
 * <div class="flex items-start justify-between gap-4"><div class="flex items-start gap-2"><div class="text-title-large font-semibold text-text-primary dark:text-text-primary"><a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/add-two-numbers/">2. Add Two Numbers</a><div class="text-body ml-2 inline-flex items-center gap-2 py-1"><div class="inline-flex items-center space-x-2"></div></div></div></div><div class="text-body flex flex-none items-center gap-1 py-1.5 text-text-secondary dark:text-text-secondary">Solved<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 14 14" width="1em" height="1em" fill="currentColor" class="fill-none stroke-current text-message-success dark:text-message-success"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="1.2" d="M12.598 7a5.6 5.6 0 11-3.15-5.037m2.1 1.537l-4.9 4.9-1.4-1.4"></path></svg></div></div>
 *
 * <div><div class="elfjS" data-track-load="description_content"><p>You are given two <strong>non-empty</strong> linked lists representing two non-negative integers. The digits are stored in <strong>reverse order</strong>, and each of their nodes contains a single digit. Add the two numbers and return the sum&nbsp;as a linked list.</p>
 *
 * <p>You may assume the two numbers do not contain any leading zero, except the number 0 itself.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/10/02/addtwonumber1.jpg" style="width: 483px; height: 342px;">
 * <pre><strong>Input:</strong> l1 = [2,4,3], l2 = [5,6,4]
 * <strong>Output:</strong> [7,0,8]
 * <strong>Explanation:</strong> 342 + 465 = 807.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre><strong>Input:</strong> l1 = [0], l2 = [0]
 * <strong>Output:</strong> [0]
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre><strong>Input:</strong> l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * <strong>Output:</strong> [8,9,9,9,0,0,0,1]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li>The number of nodes in each linked list is in the range <code>[1, 100]</code>.</li>
 * 	<li><code>0 &lt;= Node.val &lt;= 9</code></li>
 * 	<li>It is guaranteed that the list represents a number that does not have leading zeros.</li>
 * </ul>
 * </div></div>
 */

public class Solution {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "" + val;
        }
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        ListNode l1 = new ListNode(
                9, new ListNode(
                9, new ListNode(
                9, new ListNode(
                9, new ListNode(
                9, new ListNode(
                9, new ListNode(9)
        ))))));
        ListNode l2 = new ListNode(
                9, new ListNode(
                9, new ListNode(
                9, new ListNode(9)
        )));
        ListNode result = s.addTwoNumbers(l1, l2);
        ListNode itr = result;
        while(itr != null){
            System.out.print(itr + ", ");
            itr = itr.next;
        }

    }

    ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode current = dummyHead;
        int carry = 0;

        while (p1 != null || p2 != null) {
            int x = (p1 != null) ? p1.val : 0;
            int y = (p2 != null) ? p2.val : 0;
            int sum = x + y + carry;

            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;

            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }
        }

        if (carry > 0) {
            current.next = new ListNode(1);
        }

        return dummyHead.next;
    }

}
