# -*- coding:utf-8 -*-
class Solution:
    def Fibonacci(self, n):
        # write code here
        if n == 0:
            return 0
        elif n == 1:
            return 1
        else:
            return self.Fibonacci(n-1) + self.Fibonacci(n-2)


if __name__ == "__main__":
    sol = Solution()
    print(sol.Fibonacci(39))