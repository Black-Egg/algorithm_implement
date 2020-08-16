/**
 * 
 * 单链表翻转
 * 
 * 
 */

import java.util.Stack;

class LinkNode{
    int val;
    LinkNode next;

    public LinkNode(int val){
        this.val = val;
    }

    public static LinkNode createLinkList(int[] nums){
        if(nums.length < 1) return null;

        LinkNode head = new LinkNode(nums[0]);
        LinkNode p = head;

        for(int i = 1; i < nums.length; i ++){
            p.next = new LinkNode(nums[i]);
            p = p.next;
        }
        return head;
    }
    
    public static void printLinkNode(LinkNode list){
        if(list == null)
            return;
        LinkNode p = list;
        while(p != null){
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }
}

class Solution{
    // 方法一：双指针法，时间复杂度O(n) 空间复杂度O(1)
    // 最优方法
    public LinkNode reverse1(LinkNode head){
        if(head == null || head.next == null)
            return head;
        
        LinkNode p = head;
        LinkNode q = p.next;
        LinkNode r;

        head.next = null;
        while(q != null){
            r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        return p;
    }

    // 方法二：递归实现。
    // 在jdk1.8.0_91版本中，当递归的java栈深度大于12000则会出现StackOverFlowError错误
    public LinkNode reverse2(LinkNode head){
        if(head == null || head.next == null)
            return head;
        LinkNode revHead = reverse2(head.next);
        head.next.next = head;
        head.next = null;
        return revHead;
    }

    // 栈实现。
    // 先进后出。使用额外的数据结构
    public LinkNode reverse3(LinkNode head){
        Stack<LinkNode> stack = new Stack<LinkNode>();
        for(LinkNode p = head; p != null; p = p.next){
            stack.push(p);
        }

        LinkNode rev = stack.pop();
        LinkNode cur = rev;
        while(!stack.isEmpty()){
            cur.next = stack.pop();
            cur = cur.next;
            cur.next = null;
        }

        return rev;
    }
}

public class ReverseLinkList{
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7};
        LinkNode list = LinkNode.createLinkList(nums);
        LinkNode.printLinkNode(list);
        Solution sol = new Solution();
        LinkNode list2 = sol.reverse1(list);
        LinkNode.printLinkNode(list2);
        LinkNode list3 = sol.reverse2(list2);
        LinkNode.printLinkNode(list3);
        LinkNode list4 = sol.reverse3(list3);
        LinkNode.printLinkNode(list4);
    }
}