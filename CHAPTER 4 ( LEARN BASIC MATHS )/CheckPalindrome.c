         ReverseofaNumber(int n){
            int Reverse = 0;
            int duplicate = n;

        while(n>0){
           int  lastDigit = n % 10;
           n = n /10;
           Reverse = (Reverse*10) + lastDigit;
        }
             if(duplicate == Reverse){
                 printf("yes it is palindrome");
             }else{
                printf("it is not a palindrome number");
             }
         }  

          
          /*
             logic 

             store the value of n into a duplicate variable
             create a reverse and initialize with 0;
             run a loop till n becomes 0
           store last digit   by n modulo 10
           then divide the no by 10 and 
           then update the reverse value by  Reverse = (Reverse*10) + lastDigit;
           rhen if reverse == duplicate no then it's a palindrome

           TIME COMPLEXITY =  O(log10N + 1) where N is the input number.

          */