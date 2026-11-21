class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int mid = 1;
        while(mid<n){
        for(int i = 0; i<mid; i++){
            if(nums[mid]<nums[i]){
                int temp = nums[i];
                nums[i] = nums[mid];
                nums[mid] = temp;
            }
        }
        mid++;
        }

        for(int x : nums){
            System.out.print(x);
        }


    }
}