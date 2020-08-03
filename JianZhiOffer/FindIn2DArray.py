# -*- coding:utf-8 -*-
class Solution:
    # array 二维列表
    def Find(self, target, array):
        # write code here
        for col in array:
            high = len(col) - 1
            low = 0
            while low <= high:
                mid = int((high + low) / 2)
                if target == col[mid]:
                    return True
                elif target < col[mid]:
                    high = mid-1
                else:
                    low = mid+1

if __name__ == "__main__":
    target = 7
    array = [[1,2,3],[4,5,6],[6,7,9]]
    a = Solution()
    print(a.Find(target, array))
