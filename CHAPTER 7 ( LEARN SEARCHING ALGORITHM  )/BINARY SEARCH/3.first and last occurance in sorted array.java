LEETCODE 34 

int[] arr = {1, 2, 3, 3, 3, 3, 6, 7, 8, 9};

int target = 3,  target = 5

expected output = [2,5] , [-1,-1]

class Solution {
    public int[] searchRange(int[] nums, int x) {
        
        int [] result = new int[2];
        res[0] = first(nums,x);
        if(res[0]==-1) return new int [] {-1,-1};
        res[1]= last(nums,x);
        return res;
    }
    public int first(int [] nums, int x){

        int low=0, high=nums.length-1,start=-1;

        while(low<=high){

            int mid = low+(high-low)/2;

            if(nums[mid]==x){
                start= mid;
                high=mid-1;
            }
            else if(nums[mid]<x) low = mid+1;
            else high = mid-1;
        }
        return start;
    }
    public int last(int [] nums, int x){

        int low=0, high=nums.length-1,last=-1;

        while(low<=high){

            int mid = low+(high-low)/2;

            if(nums[mid]==x){
                last= mid;
                low=mid+1;
            }
            else if(nums[mid]<x) low = mid+1;
            else high = mid-1;
        }
        return last;
    }
}