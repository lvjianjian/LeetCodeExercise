/**
 * Created by zhongjian on 2017/4/1.
 *
 * leetcode algorithm 2
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class Add_Two_Numbers_2 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int jinwei = 0;
        ListNode r = l1;
        ListNode pre1 = null;
        while (l1 != null && l2 != null){
            l1.val += l2.val + jinwei;
            jinwei = l1.val / 10;
            l1.val %= 10;
            pre1 = l1;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null){
            l1.val += jinwei;
            jinwei = l1.val / 10;
            l1.val %= 10;
            pre1 = l1;
            l1 = l1.next;
        }

        while (l2 != null){
            l2.val += jinwei;
            jinwei = l2.val / 10;
            l2.val %= 10;
            pre1.next = l2;
            l2 = l2.next;
            pre1 = pre1.next;
        }

        while (jinwei != 0){
            pre1.next = new ListNode(jinwei % 10);
            jinwei /= 10;
            pre1 = pre1.next;
        }

        return r;
    }

    public ListNode generate(int[] numbers){
        ListNode r = new ListNode(numbers[0]);
        ListNode c = r;
        for (int i = 1; i < numbers.length; i++) {
            c.next = new ListNode(numbers[i]);
            c = c.next;
        }
        return r;

    }

    public static void main(String[] args) {
//        AddTwoNumbers2 addTwoNumbers2 = new AddTwoNumbers2();
//        ListNode l1 = addTwoNumbers2.generate(new int[]{2,4,3,1});
//        ListNode l2 = addTwoNumbers2.generate(new int[]{5,6,4,9,1,1});
//        System.out.println(l1);
//        System.out.println(l2);
//        System.out.println(addTwoNumbers2.addTwoNumbers(l1,l2));

    }
}
