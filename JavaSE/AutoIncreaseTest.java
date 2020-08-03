public class AutoIncreaseTest{
    public static void main(String[] args){
        int i=0;
        for( ; i<10; i++){
            System.out.print(i + " ");           //输出: 0 1 2 3 4 5 6 7 8 9 

        }
        System.out.println();
        System.out.println("After For: " + i);   //输出: After For: 10
       
        int j=0;
        for( ; j<10; ++j){
            System.out.print(j + " ");           //输出: 0 1 2 3 4 5 6 7 8 9 

        }
        System.out.println();
        System.out.println("After For: " + j);   //输出: After For: 10

        int a = 0;
        a = a ++;
        System.out.println("a = " + a);         //输出: a = 0

        int b = 0;
        b = ++ b;                               //IDE提示: The assignment to variable f has no effect
        System.out.println("b = " + b);         //输出: b = 1

        int c = 0;
        int d = 0;
        int e = 0;
        for (int k = 0; k < 99; k++) {
            c = c ++;
            e = d ++;
        }
        System.out.println("c = " + c);         //输出: c = 0
        System.out.println("d = " + d);         //输出: d = 99
        System.out.println("e = " + e);         //输出: e = 98

        int f = 0;
        int g = 0;
        int h = 0;
        for (int k = 0; k < 99; k++) {
            f = ++ f;                           //IDE提示: The assignment to variable f has no effect
            h = ++ g;
        }
        System.out.println("f = " + f);         //输出: f = 99
        System.out.println("g = " + g);         //输出: g = 99
        System.out.println("h = " + h);         //输出: h = 99
    }
}