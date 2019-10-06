/**
 * 给定两个数组，编写一个函数来计算它们的交集。

示例 1:

输入: nums1 = [1,2,2,1], nums2 = [2,2]
输出: [2]

示例 2:

输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出: [9,4]

说明:

    输出结果中的每个元素一定是唯一的。
    我们可以不考虑输出结果的顺序。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 */

import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List <Integer> list = new ArrayList<> ();
        for(int i=0; i<nums1.length; i++){
            for(int j=0; j<nums2.length; j++){
                if(nums1[i] == nums2[j])
                    list.add(nums1[i]);
            }
        }
        int[] res = new int[list.size()];
        for (int i=0; i<list.size(); i++)
            res[i] = list.get(i);
        return res;
    }
}