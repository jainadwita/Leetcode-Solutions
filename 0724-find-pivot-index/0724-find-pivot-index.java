class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;

        int pivot = 0;
        
        while(pivot<n){
            int leftSum = 0;
            int rightSum = 0;
            if(pivot == 0) {
                leftSum = 0;
            } else{
                for(int i = pivot-1; i>=0; i--){
                    leftSum += nums[i];
                }
            }
            if(pivot == n-1) {
                rightSum = 0;
            } else{
                for(int i = pivot+1; i<n; i++){
                    rightSum += nums[i];
                }
            }
            if(leftSum == rightSum){
                return pivot;
            }
            pivot++;
        }
        return -1;
    }
}

