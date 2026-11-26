class Solution {
    public boolean canAliceWin(int n) {

        if(n<10){
            return false;
        }

        int stones = 10;
        int turn = 0;

        int k = 10;

        while(n>=stones){
            n = n - stones;
            stones--;

            turn++;
        }

        return turn%2 == 1;
    }
}