package com.pk.algorithms.stacks;
import java.util.Stack;

/**
 *
 * @author parveenkumar
 */
public class DecodeString {
    public String decodeString(String s){
        //Create a stack (counts) for how many times character to be reapeated
        Stack<Integer> counts = new Stack<>();
        //Create a stack (result)
        Stack<String> result = new Stack<>();
        String res = "";
        int index = 0;
        while(index < s.length()){
            if(Character.isDigit(s.charAt(index))){
                int count = 0;
                while(Character.isDigit(s.charAt(index))){
                    count = 10 * (s.charAt(index) - '0');
                    index++;
                }
                counts.push(count);
            }else if(s.charAt(index) == '['){
                result.push(res);
                res ="";
                index++;
            }else if (s.charAt(index)== ']'){
                StringBuilder sb = new StringBuilder(result.pop());
                int count = counts.pop();
                for(int i = 0; i < count; i++){
                    sb.append(res);
                }
                res = sb.toString();
                index++;
            }else{
                res += s.charAt(index);
                index++;
            }
        }
        return res;
    }
}
