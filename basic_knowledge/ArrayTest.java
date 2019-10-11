import java.util.Arrays;

public class ArrayTest{
    public static void main(String[] args){
        int[] array1 = new int[]{1,2,3,4,5,6,7,8,9};
        for(int i : array1){
            System.out.print(i + " ");  // 输出 1 2 3 4 5 6 7 8 9
        }
        System.out.println();

        // // array1指向新数组。
        // array1 = new int[array1.length+1];
        // for(int i : array1){
        //     System.out.print(i + " ");  // 输出 0 0 0 0 0 0 0 0 0 0
        // }
        // System.out.println();

        // 数组扩容(将长度扩展为12)
        // 数组扩容方法1
        int[] array2 = new int[12];
        for(int i=0; i<array1.length; i++){
            array2[i] = array1[i];
        }
        for(int i : array2){
            System.out.print(i + " ");  // 输出 1 2 3 4 5 6 7 8 9 0 0 0 
        }
        System.out.println();

        // 数组扩容方法2
        int[] array3 = Arrays.copyOf(array1, 12);
        for(int i : array3){
            System.out.print(i + " ");  // 输出 1 2 3 4 5 6 7 8 9 0 0 0 
        }
        System.out.println();

        // 数组扩容方法3
        int[] array4 = new int[12];
        System.arraycopy(array1, 0, array4, 0, array1.length);
        for(int i : array4){
            System.out.print(i + " ");  // 输出 1 2 3 4 5 6 7 8 9 0 0 0 
        }
        System.out.println();


        // 判断两个数组是否相同的函数
        // 可用于比较byte[], short[], int[], long[], char[], float[], double[], boolean[], String[]
        Arrays.equals(array2, array4);
        
        // 可用于排序可用于比较byte[], short[], int[], long[], char[], float[], double[], String[]
        Arrays.sort(array2);

        String[] arr1 = {"abcf", "fghl", "eljk", "zxy", "zzz"};
        String[] arr2 = {"abcf", "fghl", "eljk", "zxy", "zzz"};
        System.out.println(Arrays.equals(arr1, arr2));
        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));

    }
}