# 是差点运气，可我一直在努力！
**当前进程：**

 - 开始时间：2020.6.27 
 - 结束时间：undefined

***GitHub仓库：https://github.com/Cundefined/Java-for-LeetCode***



## 1、题目要求
[**( LeetCode -- 第143题 )  重排链表**](https://leetcode-cn.com/problems/reorder-list/)
      


## 2、解题思路

```javascript
线性表+双指针
```


### 3、Java Solution

```java
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
```

