import java.util.HashSet;
//import java.util.Arrays;
public class containsDuplicate{
    public boolean containsDuplicate1(int[] nums) {
        // Arrays.sort(nums);
        // for(int i = 0; i < nums.length-1; i++){
        //     if(nums[i] == nums[i+1]){
        //         return true;
        //     }
        // }
        // return false;

        // approach 2

        //  HashSet<Integer> set = new HashSet<>();
        // for (int i = 0; i < nums.length; i++) {
        //         if (set.contains(nums[i])) {
        //             return true;
        //         }
        //         set.add(nums[i]);
        // }
        // return false;


        HashSet<Integer> newSet = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(newSet.contains(nums[i])){
                return true;
            }
            newSet.add(nums[i]);
        }
        return false;



    }
}