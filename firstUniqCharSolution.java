package cn.ouc.jeff.leetcode;

import org.junit.Test;

import java.util.*;

public class firstUniqCharSolution {

    public int firstUniqChar(String s) {

        /* 自解 可以通过
        Set<Character> dupSet = new HashSet<>(); // 已出现重复的字符
        Set<Character> uniqSet = new HashSet<>(); // 未出现重复的字符
        List<Character> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            if(dupSet.contains(s.charAt(i)))
                continue;
            if(uniqSet.contains(s.charAt(i))){
                dupSet.add(s.charAt(i));
                list.remove(list.indexOf(s.charAt(i)));
                uniqSet.remove(s.charAt(i));
            }else {
                uniqSet.add(s.charAt(i));
                list.add(s.charAt(i));
                map.put(s.charAt(i), i);
            }
        }

        if(list.size() > 0)
            return map.get(list.get(0));
        return -1;
         */

        /* 错误方法
        if(s.length() <= 0)
            return -1;

        Set<Character> uniqChar = new HashSet<>();
        Set<Character> end = new HashSet<>();
        int index = -1;
        char c = s.charAt(s.length()-1);
        end.add(c);
        for(int i=s.length()-1; i>=0; i--){
            if(uniqChar.contains(s.charAt(i))){
                if(c == s.charAt(i)){
                    index = -1;
                }
            }else {
                index = i;
                c = s.charAt(i);
                uniqChar.add(s.charAt(i));
            }
        }
        return index;

         */
        // 官方解答
        // 首次遍历，将 key-value 对放在map中，key字符，value 表示出现的下标；重复的字符 value 置为-1。
        // 再次遍历上述map，比较value 最小的，则为最早出现的。如果没有满足的value，则表示无单个字符，返回-1
        Map<Character, Integer> position = new HashMap<>();
        for(int i=0; i<s.length()-1; i++){
            char c = s.charAt(i);
            if(position.containsKey(c)){
                position.put(c, -1);
            }else {
                position.put(c, i);
            }
        }

        int first = s.length();
        for(Map.Entry<Character, Integer> entry : position.entrySet()){
            if(entry.getValue() != -1 && entry.getValue() < first){
                first = entry.getValue();
            }
        }

        if(first < s.length())
            return first;
        else
            return -1;
    }

    @Test
    public void test(){
        //System.out.println(firstUniqChar("ababab"));
        //System.out.println(firstUniqChar("loveleetcode"));
        //System.out.println(firstUniqChar("dddccdbba"));
        System.out.println(firstUniqChar("z"));
    }
}
