# -*- coding:utf-8 -*-
class Solution:
    def __init__(self):
        self.stackA = []
        self.stackB = []
    def push(self, node):
        # write code here
        self.stackA.append(node)
        
    def pop(self):
        # return xx
        if self.stackB:
            return self.stackB.pop()
        elif not self.stackA:
            return None
        else:
            while self.stackA:
                self.stackB.append(self.stackA.pop())
            return self.stackB.pop()

if __name__ == "__main__":
    queue = Solution()
    queue.push(1)
    queue.push(2)
    queue.push(3)
    print(queue.pop())
    print(queue.pop())
    queue.push(4)
    print(queue.pop())
    queue.push(5)
    print(queue.pop())
    print(queue.pop())    