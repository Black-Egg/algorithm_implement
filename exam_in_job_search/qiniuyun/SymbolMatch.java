import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

class Solution{
    public int isValid(String str){
        char a,b;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<str.length(); i++){
            if(stack.isEmpty()){
                stack.push(str.charAt(i));
                continue;
            }
            else{
                a = stack.peek();
                b = str.charAt(i);
                if((a == '(' && b == ')') || (a == '[' && b == ']') 
                    || (a == '{' && b == '}') || (a == '<' && b == '>')){
                    stack.pop();
                }
                else stack.push(b);
            }
        }
        if(stack.isEmpty()) return 1;
        else return 0;
    }
}

public class SymbolMatch{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Solution sol = new Solution();
        System.out.println(sol.isValid(str));
    }
}