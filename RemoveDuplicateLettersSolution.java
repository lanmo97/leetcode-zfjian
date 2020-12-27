package cn.ouc.jeff.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 316. 去除重复字母
 *
 * 既要保证字符不重复/不漏（1）
 * 还要保证字典序：即从a-z 的顺序（2）
 * 再同时还要保证字符的相对顺序 在字符串中出现的顺序（3）
 *
 * 所以当一个字符A是最后一次出现时，不管他后面的字符字典序在他前还是他后，字符A都要保留。保证（1）
 *
 * 为什么当一个字符在栈里存在时，后面再出现，直接略过。
 * 因为如果这个字符在前面已经被存储并保留在了栈里，说明按字典序它小于等于当前栈顶。为了保证字典序，所以再出现就不要它了。（2）优于（3）
 */
public class RemoveDuplicateLettersSolution {

    public String removeDuplicateLetters(String s) {

        Map<Character, Integer> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.get(c)-1);

            if(stack.search(c) < 0){ // 代表存在
                while(stack.size() > 0 && stack.peek() > c){
                    if(map.get(stack.peek()) == 0) break;
                    else{
                        stack.pop();
                    }
                }
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<stack.size(); i++)
            sb.append(stack.get(i));
        return sb.toString();
    }

    @Test
    public void test(){
        Stack<Character> s = new Stack<>();
        s.push('i');
        s.push('o');
        System.out.println(s.search('i'));
        System.out.println(s.search('k'));
        System.out.println(s.search('o'));
        System.out.println(s.peek() > 'z');

        StringBuilder sb = new StringBuilder();
        sb.append('i');
        sb.append('a');
        System.out.println(sb.toString());

        System.out.println(removeDuplicateLetters("bcabc"));
    }
}
