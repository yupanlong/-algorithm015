// 旋转数组
public class RotateArray {
    // 第一种暴力解法
    public void rotate(int[] nums, int k) {
        while (k>0){
            int tem = nums [nums.length-1];
            for (int i = nums.length-1; i > 0; i--) {
                nums [i]  = nums[i-1];
            }
            nums[0] =tem;
            k--;
        }
    }
    // 使用环状替换
    public  void rotate1(int[] nums,int k){
        k = k % nums.length; // 取k 的余数 ， 因为当 k % n = 0  时， 数组相当于没有变化；
        int count = 0; // 因为n 个元素 需要 移动n 次， 记录移动的次数

        for (int start = 0; count < nums.length; start++) {  // 当 n % k = 0 时 ，会出现元素 当前操作的指针回到开始的位置（并且还有元素没有移动）, 所以当前操作的指数回到开始的位置时，起始指针+1 ，继续移动。

             int current = start; // 记录起始指针；
             int prev = nums[start];
             do {
                 int next = (current + k) % nums.length; // 计算当前操作指针需要移动的最终位置

                 int tem = nums[next];
                 nums[next] = prev;
                 prev = tem;
                 current = next;    // 更新当前操作指针
                 count++;
             }while (start != current);
        }
    }

    // 使用反转
    /*
      原始数组                  : 1 2 3 4 5 6 7
     反转所有数字后             : 7 6 5 4 3 2 1
     反转前 k 个数字后          : 5 6 7 4 3 2 1
     反转后 n-k 个数字后        : 5 6 7 1 2 3 4 --> 结果
     */

    public void rotate2(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        reverse(nums,0,length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,length-1);
    }

    public void reverse(int[] nums,int start, int end) {
        while (start<end){
            int tem = nums[start];
            nums[start] = nums[end];
            nums[end] = tem;
            start++;
            end-- ;
        }
    }

}
