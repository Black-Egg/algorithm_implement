# -*- coding:utf-8 -*-
class ListNode:
    def __init__(self, x, listNode):
        self.val = x
        self.next = listNode

class Solution:
    # 返回从尾部到头部的列表值序列，例如[1,2,3]
    def printListFromTailToHead(self, listNode):
        # write code here
        if listNode is None:
            return []
        else:
            return self.printListFromTailToHead(listNode.next) + [listNode.val]
            

if __name__ == "__main__":
    nodeList = ListNode(0, None)
    for i in range(1,10):
        nodeList = ListNode(i, nodeList)
    sol = Solution()
    print(sol.printListFromTailToHead(nodeList))