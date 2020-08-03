import java.util.Scanner;

class Solution{
    public boolean isRepeatUser(String user){
        if(user.equals("zhangsan") || user.equals("lisi"))
            return true;
        else
            return false;
    }
    
    public boolean isWrongFormatPasswd(String passwd){
        if(passwd.length() < 8 || passwd.length() > 16)
            return true;
        for(int i=0; i<passwd.length(); i++){
            if(!Character.isLetterOrDigit(passwd.charAt(i)))
                return true;
        }
            return false;
    }

    public boolean isWrongFormatPhone(String phone){
        if(phone.length() != 11 && phone.charAt(0) != '1')
            return true;
        for(int i=1; i<phone.length(); i++){
            if(!Character.isDigit(phone.charAt(i)))
                return true;
        }
        return false;
    }
}

public class CheckLogin{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String user = sc.nextLine();
        String passwd = sc.nextLine();
        String phone = sc.nextLine();
        sc.close();

        if(user == null || user.equals("") || user.equals(" ")) 
            return;
        
        Solution sol = new Solution();
        if(sol.isRepeatUser(user)){
            System.out.println("该用户名已存在");
            return;
        }
        if(sol.isWrongFormatPasswd(passwd)){
            System.out.println("密码格式错误");
            return;
        }
        if(sol.isWrongFormatPhone(phone)){
            System.out.println("请输入正确的手机号码");
            return;
        }
        System.out.println("注册成功");
    }
}