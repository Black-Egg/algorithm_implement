/**
 * 功能：根据输入的子网掩码，判断输入的两个ipv4地址是否属于同一个子网。
 * 方法：子网掩码是用来判断任意两个ipv4地址是否属于同一个子网的根据。
 *      子网掩码与ipv4地址的结构相同，是32位二进制数。其中，网络号部分全为“1”，主机号部分全为“0”。
 *      若两个ipv4地址分别与子网掩码相“与”后的结果相同，则说明他们同属一个子网。
 */

import java.util.Scanner;

class Solution{
    public boolean isSame(String a, String b, String m){

        int[] ip1 = parseAddress(a);
        int[] ip2 = parseAddress(b);
        int[] mask = parseAddress(m);

        // ip 或 子网掩码非法
        if(!isLegalIp(ip1) || !isLegalIp(ip2) || !isLegalMask(mask))
            return false;

        for(int i=0; i<4; i++){
            if((ip1[i] & mask[i]) != (ip2[i] & mask[i]))
                return false;
        }
        return true;
    }

    // 从字符串中解析ip地址
    public int[] parseAddress(String str){
        String[] ipStrs = str.split("\\.");
        int[] address = new int[ipStrs.length];
        for(int i=0; i<ipStrs.length; i++){
            address[i] = Integer.parseInt(ipStrs[i]);
        }
        return address;
    }

    // 判断ip地址是否合法
    public boolean isLegalIp(int[] ip){
        if(ip.length != 4) return false;
        for(int i : ip){
            if(i<0 || i>255)
                return false;
        }
        return true;
    }

    // 判断子网掩码是否合法
    public boolean isLegalMask(int[] mask){
        if(mask.length != 4) return false;
        StringBuffer sb = new StringBuffer(); 
        for(int i : mask){
            String b = Integer.toBinaryString(i);
            while(b.length() != 8){
                b = "0" + b;
            }
            sb.append(b);
        }
        if(sb.indexOf("0") < sb.indexOf("1"))
            return false;
        return true;
    }

    // 根据子网掩码位数获取子网掩码
    public String parseMask(int maskNum){
        StringBuffer maskStrBuf = new StringBuffer();
        for(int i=0; i<4; i++){
            if(maskNum >= 8){
                maskStrBuf.append("255");
            }
            else if(maskNum <= 0){
                maskStrBuf.append("0");
            }
            else{
                maskStrBuf.append((int)Math.pow(2, maskNum) - 1);
            }
            maskNum = maskNum - 8;

            if(i != 3)
                maskStrBuf.append(".");
            System.out.println(maskStrBuf.toString());
        }
        System.out.println(maskStrBuf.toString());
        return maskStrBuf.toString();
    }
}



public class IsSameSubnet {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ip1 = in.next();
        String ip2 = in.next();
        Solution sol = new Solution();

        String mask = sol.parseMask(in.nextInt());
        System.out.println(sol.isSame(ip1, ip2, mask));
            
    }
}