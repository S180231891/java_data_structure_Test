package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

//有效的括号
//只包括'('，')'，'{'，'}'，'['，']'
public class zbg_020 {
    public static void main(String[] args) {
        String s = "((()()){}))([]][])";
        System.err.println(ZBG(s));
    }

    public static boolean ZBG(String s ){
        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Stack<Character> stack = new Stack<>();
        char[] res = s.toCharArray();
        for (int i=0;i<res.length;i++){
            if (map.containsKey(res[i])){
                char temp = stack.empty() ? '#':stack.pop();
                if (temp!=map.get(res[i]))
                    return false;
            }else
                stack.push(res[i]);
        }
        return stack.isEmpty();
    }
}