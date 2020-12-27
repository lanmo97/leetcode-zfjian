package cn.ouc.jeff.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsNearbyDuplicateSolution {

    public boolean containsNearbyDuplicate(int[] nums, int k){

        /*
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.get(nums[i]) == null){
                map.put(nums[i], i);
            }else{
                if(i-map.get(nums[i]) > k)
                    return false;
                else
                    map.put(nums[i], i);
            }
        }*/

        /**
         * 存在一个就需要返回 true
         * 维护一个 k 大小的滑动窗口
         * 在这里面有和它相等的，即满足条件 <=k.
         * 返回true；
         * 遍历完一圈，若没有返回 true，返回结果 false。
         * 【运行超时】
         */
        /*
        for(int i=0; i<nums.length; i++){
            for(int j=Math.max(i-k,0);j<i;++j){
                if(nums[i] == nums[j]) return true;
            }
        }*/

        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);
            if(set.size()>k)
                set.remove(nums[i-k]);
        }
        return false;
    }

    @Test
    public void test(){

        boolean result = containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2);
        System.out.println(result);
    }
}
