package cn.ouc.jeff.leetcode.backspaceCompare;

import java.util.Stack;

public class SolutionBC {
    public static boolean backspaceCompare(String S, String T){
        Stack sStack = new Stack();
        Stack tStack = new Stack();
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i) == '#'){
                if(sStack.size() > 0)
                    sStack.pop();
            }else {
                sStack.push(S.charAt(i));
            }
        }
        for(int j=0; j<T.length(); j++){
            if(T.charAt(j) == '#'){
                if(tStack.size()>0)
                    tStack.pop();
            }else {
                tStack.push(T.charAt(j));
            }
        }

        Object[] resS = sStack.toArray();
        Object[] resT = tStack.toArray();
        if(resS.length != resT.length)
            return false;
        for(int k=0; k<resS.length; k++){
            if(!resS[k].toString().equals(resT[k].toString()))
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        /**
        Stack stack = new Stack();
        String s = "abc#";
        for(int i=0; i<s.length(); i++)
           stack.push(s.charAt(i));
        Object[] res = stack.toArray();
        System.out.println(res[0].toString().equals("a"));
         */
        String S = "ab##";
        String T = "c#d#";
        Boolean flag = backspaceCompare(S, T);
        System.out.println(flag);
    }
}
