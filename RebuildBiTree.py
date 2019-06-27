# -*- coding:utf-8 -*-
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
class Solution:
    # 返回构造的TreeNode根节点
    def reConstructBinaryTree(self, pre, tin):
        # write code here
        if not pre or not tin:
            return None
        root = TreeNode(pre.pop(0))
        index = tin.index(root.val)
        root.left = self.reConstructBinaryTree(pre, tin[ :index])
        root.right = self.reConstructBinaryTree(pre, tin[index+1: ])
        return root

def PrintBiTree(bi_tree):
    if not bi_tree:
        return
    print(bi_tree.val)
    PrintBiTree(bi_tree.left)
    PrintBiTree(bi_tree.right)

if __name__ == "__main__":
    pre = [1,2,3,4,5]
    tin = [2,3,1,4,5]
    sol = Solution()
    bi_tree = sol.reConstructBinaryTree(pre, tin)
    PrintBiTree(bi_tree)
            