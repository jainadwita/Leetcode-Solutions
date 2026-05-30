class Solution {
    public boolean isPalindrome(String s) {
        String lower = s.toLowerCase();
        String result = lower.replaceAll("[^a-z0-9]", "");
        int j = result.length()-1;
    
        for(int i = 0; i<result.length()/2; i++){
            if(result.charAt(i) != result.charAt(j)){
                return false;
            }
            j--;
        }
        return true;
    }
}