package cn.ouc.jeff.leetcode;

import org.junit.Test;

/**
 * 最长子字符串
 */
import java.util.*;

public class LengthOfLongestSubstringSolution {

    public int lengthOfLongestSubstring(String s){
        int length = 0;

        int i=0;
        Queue<Character> queue = new LinkedList<>();

        for(int j=0; j<s.length(); j++){

            if(queue.contains(s.charAt(j))){ // 若包含
                queue.offer(s.charAt(j));
                int k=0;
                /*
                do{
                    if(k==0 && queue.peek().equals(s.charAt(j))){
                        queue.poll();
                        k++;
                        break;
                    }else{
                        queue.poll();
                        k++;
                    }
                }while (!queue.peek().equals(s.charAt(j)));
                 */
                while (!queue.peek().equals(s.charAt(j))){
                    queue.poll();
                    k++;
                }
                queue.poll();
                k++;

                i = i+k; // i移动
            }else{ // 不包含，直接放队尾
                queue.offer(s.charAt(j));
            }
            if(queue.size() > length)
                length = queue.size();
        }
        return length;
    }

    @Test
    public void test(){

        Queue<Character> queue = new LinkedList<>();
        queue.offer('a');
        queue.offer('b');

        System.out.println(queue.peek());
        System.out.println(queue.contains('a'));
        System.out.println(queue.poll().equals('a'));
        System.out.println(queue.contains('a'));
        System.out.println(queue.contains('!'));


        int result = lengthOfLongestSubstring("");
        System.out.println(result);

    }
}
