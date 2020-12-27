package cn.ouc.jeff.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementSolution {
    public int majorityElement(int[] nums) {

        /*
        Map<Integer, Integer> map = new HashMap<>();
        for (int num:nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        for(int k: map.keySet()){
            if(map.get(k) > nums.length/2)
                return k;
        }
        return -1;

         */
        // 摩尔投票法
        int major=0, cnt = 0;
        for(int x : nums)
        {
            if(cnt == 0)
            {
                major = x;
                cnt++;
            }
            else
            {
                if(major == x)
                    cnt++;
                else
                    cnt--;
            }
        }
        //System.out.println(major);
        int count = 0;
        for(int x: nums){
            if(x == major)
                count++;
        }
        if(count > nums.length/2)
            return major;
        return -1;

    }

    @Test
    public void test(){
        int result = majorityElement(new int[]{2,2,1,1,1,2,2});
        System.out.println(result);
    }
}
