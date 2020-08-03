public class StringBufferTest{
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append(1);
        
        sb.append("23");
        System.out.println(sb.toString());
        sb.delete(0, 2);
        System.out.println(sb.toString());

        sb.delete(0, sb.length());
        System.out.println(sb.toString());

        int i, x;

        for(;;x+=i){
            System.out.println(x);
        }
    }
}