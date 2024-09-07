          ReverseofaNumber(int n){
            int Reverse = 0;
        while(n>0){
           int  lastDigit = n % 10;
           n = n /10;
           Reverse = (Reverse*10) + lastDigit;
        }
        return Reverse;

        /*
        logic 

         create a reverse and initialize with 0;
         run a loop till n becomes 0
           store last digit   by n modulo 10
           then divide the no by 10 and 
           then update the reverse value by  Reverse = (Reverse*10) + lastDigit;
           and then return reverse

           TIME COMPLEXITY  -  O(log10N + 1) where N is the input number. 
         
        */
         
         
    }