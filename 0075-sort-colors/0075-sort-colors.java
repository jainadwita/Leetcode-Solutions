class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int zeroes = 0; 
        int ones = 0;
        int twos = 0;
        for(int i = 0; i<n; i++){
            if(nums[i]==0){
                zeroes += 1;
            }
            if(nums[i]==1){
                ones += 1;
            }
        }
        twos = n-zeroes-ones;

        for(int i = 0; i<n; i++){
            if(i<zeroes){
                nums[i] = 0;
            } else if(i<zeroes+ones){
                nums[i] = 1;
            } else{
                nums[i] = 2;
            }
        }

        for(int x : nums){
            System.out.print(x);
        }


    }
}