package cn.ouc.jeff.leetcode;

import cn.ouc.jeff.designpattern.builder.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SummaryRangesSolution {

    public List<String> summaryRanges(int[] nums){
        List<String> list = new ArrayList<>();
/*
        int start = 0;
        int end =0;

        if(nums.length == 1){
            list.add(String.valueOf(nums[0]));
        }

        for(int i=1; i<nums.length; i++){
            if(nums[i] - nums[i-1] != 1){
                if(start == end){
                    list.add(String.valueOf(nums[i-1]));
                }else
                    list.add(nums[start]+"->"+nums[end]);
                start = i;
                end = i;

            }else{
                end = i;
            }

            if(start == end && end  == nums.length-1){
                list.add(String.valueOf(nums[nums.length-1]));
            }else if(end == nums.length-1){
                list.add(nums[start]+"->"+nums[end]);
            }

        }*/

        for(int i=0,j=0; j<nums.length; j++){
            if(j+1 < nums.length && (nums[j+1]==nums[j]+1))
                continue;

            if(i == j)
                list.add(nums[j]+"");
            else
                list.add(nums[i]+"->"+nums[j]);

            i = j+1;
        }
        return list;
    }

    @Test
    public void test(){

        List<String > list = summaryRanges(new int[]{-1});
        System.out.println(list.toString());
    }
}
