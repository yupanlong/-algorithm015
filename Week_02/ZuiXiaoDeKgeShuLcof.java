import java.util.Arrays;

public class ZuiXiaoDeKgeShuLcof {

    public int[] getLeastNumbers(int[] arr, int k) {
        if ( arr.length == 0 || k == 0 ) return  new int[0];
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSearch(int[] arr, int lo, int hi, int k) {
        int j =  partition(arr,lo,hi);
        if ( j == k ) {
            return  Arrays.copyOf(arr,j+1);
        }
        return j > k ? quickSearch(arr,lo,j-1,k) : quickSearch(arr,j+1,hi,k);
    }

    private int partition(int[] arr, int lo, int hi) {
        int v = arr[lo];
        int i = lo,j = hi+1;
        while (true) {
            while (++i <= hi && arr[i] < v);
            while (--j >= lo && arr[j] > v);
            if (i > j) break;
            int t = arr [j];
            arr[j]= arr[i];
            arr[i] =t;
        }
        arr[lo] =arr[j];
        arr[j] =v;
        return j;
    }
}
