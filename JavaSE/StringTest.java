import java.util.Arrays;

public class StringTest{
    public static void main(String[] args){
        String str1 = "        ";
        String str2 = "  SA A B  C";
        String newStr1 = Arrays.toString(str1.split(" "));
        System.out.println(newStr1);  // 输出[]


        System.out.println(str1.replaceAll(" ", "").equals(""));  //输出true
        System.out.println(str1.replaceAll(" ", "") == "");  //输出false


        String a = "J2";
        final String b = "J";
        String d = "J";
        String e = b + 2;
        String f = d + 2;
        System.out.println(a == e);  // 输出[]
        System.out.println(a == f);  // 输出
    
    }
}