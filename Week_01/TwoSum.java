import java.util.HashMap;
// 两数之和
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        if (nums.length<2)   throw  new IllegalArgumentException("No two sum solution");
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temValue =   target- nums[i];
            if (hashMap.containsKey(temValue)) {
                return  new int[]{nums[i],hashMap.get(temValue)};
            }
            hashMap.put(nums[i],i );
        }
        throw  new IllegalArgumentException("No two sum solution");
    }
}
