package cn.ouc.jeff.leetcode;
/**
 * leetcode 805
 */

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class UniqueMorseRepresentationsSolution {

    public int uniqueMorseRepresentations(String[] words) {

        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.",
                "---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Map<String,String> map = new HashMap<>();

        for(int i=0; i<words.length; i++){
            StringBuffer sb = new StringBuffer();
            System.out.println(words[i]);
            String value = words[i];

            for(int j=0; j<value.length(); j++){

                char ch = value.charAt(j);
                System.out.println(ch);
                System.out.println(Integer.valueOf(ch) - 97);
                System.out.println(ch - 'a');
                sb.append(morse[Integer.valueOf(ch)-97]);
            }
            map.put(sb.toString(),sb.toString());
        }

        System.out.println(map.size());
        return map.size();

    }

    @Test
    public void Test(){

        String[] words = {"gin", "zen", "gig", "msg"};
        int result = uniqueMorseRepresentations(words);
        System.out.println(result);
    }
}
