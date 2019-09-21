class Sort{
    public int[] QuickSort(int[] array, int low, int high){
        if(array.length<1 || low<0 || high>=array.length || low > high)
            return null;
        int smallIndex = partition(array, low, high);
        if(smallIndex > low)
            QuickSort(array, low, smallIndex-1);
        if(smallIndex < high)
            QuickSort(array, smallIndex+1, high);
        return array;
    }

    public static int partition(int[] array, int low, int high){
        int piovt = array[low];
        while(low < high){
            while(low < high && array[high] >= piovt){
                high--;
            }
            while(low < high && array[high] <= piovt){
                low++;
            }
            int tmp = array[high];
            array[high] = array[low];
            array[low] = tmp;
        }
        array[low] = piovt;
        return low;
    }
}

public class QuickSort{
    public static void main(String[] args){
        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        Sort sort = new Sort();
        int[] sortedArray = sort.QuickSort(arr, 0, arr.length-1);
        for (int i = 0; i < sortedArray.length; i++) {
            System.out.println(sortedArray[i]);
        }
    }
}