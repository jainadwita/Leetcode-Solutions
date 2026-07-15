class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = solve(nums,target,true);
        if(first==-1){
            return new int[]{-1,-1}; // inline 
        }
        int last = solve(nums,target, false);
        return new int[]{first,last};

    }

    public int solve(int nums[], int target, boolean bool){
        int left = 0, right = nums.length - 1;
        int result = -1;

        while(left<=right){   

            int mid = left + (right-left)/2;

            if(nums[mid]==target){
                result = mid;
                if(bool){
                    right = mid - 1;
                } else{
                    left = mid+1;
                }
            } else if(nums[mid]<target){
                left = mid+1;
            } else{
                right = mid-1;
            }
        }
        return result;
    }
}