// 移除数组重复元素
public class RemoveDuplicates {

    public int removeDuplicatesWhile(int[] nums) {
        int i = 0 ;
        int j = 1 ;
        while ( j < nums.length){
            if (nums [i] != nums [j] ) {
                nums [++i] = nums [j] ;
            }
            j++;
        }
        return  i+1;
    }

}
