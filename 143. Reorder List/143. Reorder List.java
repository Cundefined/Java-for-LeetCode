/*
解题思路：线性表+双指针
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }

        List<ListNode> list = new ArrayList<ListNode>();

        //遍历链表，把所有节点加入数组
        ListNode cur = head;
        while(cur != null) {
            list.add(cur);
            cur = cur.next;
        }

        //双指针遍历数组，重新排列链表
        int l = 0;
        int r = list.size() - 1;
        while(l < r) {
            list.get(l).next = list.get(r);
            l++;
            //偶数个节点会出现l==r情况还继续连接，此时应该跳出循环
            if(l == r) {
                break;
            }
            list.get(r).next = list.get(l);
            r--;
        }
        list.get(l).next = null;
    }
}
