class Solution {
    public boolean isPalindrome(String s) {

      int start = 0;
      int end = s.length()-1;


      while(start<end)
      {
         char i = s.charAt(start);
         char j = s.charAt(end);

         if(!((i>='a' && i<='z')||(i>='A' && i<='Z')||(i>='0' && i<='9'))){
            start++;
            continue;
         }
          if (!((j >= 'a' && j <= 'z') ||
                  (j >= 'A' && j <= 'Z') ||
                  (j >= '0' && j <= '9'))) {
                end--;
                continue;
            } 
            if (i >= 'A' && i <= 'Z') i = (char)(i + 32);
             if (j >= 'A' && j <= 'Z') j = (char)(j + 32);

              if(i!=j)
              return false;

              start ++;
              end --; 
      }

      return true;   
    }
}