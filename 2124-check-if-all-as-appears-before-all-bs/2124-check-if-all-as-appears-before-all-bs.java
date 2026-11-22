class Solution {
    public boolean checkString(String s) {
        char charArray [] = s.toCharArray();
        int acount = 0 , bcount = 0;
        for(char x : charArray){
            if(x == 'a'){
                acount+=1;
            } else{
                bcount+=1;
            }
        }
        for(int i = 0; i<acount; i++){
            if(charArray[i]!='a'){
                return false;
            }
        }

        for(int i = acount; i<charArray.length; i++){
            if(charArray[i]!='b'){
                return false;
            }
        }

        return true;
    }
}