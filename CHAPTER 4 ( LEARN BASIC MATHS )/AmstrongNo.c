               AmstrongNo(int n){
            int Reverse = 0;
            int duplicate = n;
            int sum = 0;

        while(n>0){
           int  lastDigit = n % 10;
           sum = sum + (lastDigit*lastDigit*lastDigit);
           n = n /10;
           Reverse = (Reverse*10) + lastDigit;
        }
             if(duplicate == sum){
                 printf("yes it is Armstrong no");
             }else{
                printf("it is not a amstrong number");
             }
         }  
      


         
          /*
             logic 

             store the value of n into a duplicate variable
             create a variable sum and initialize with 0
             create a reverse and initialize with 0;
             run a loop till n becomes 0
           store last digit   by n modulo 10
           and then sum = sum + (lastDigit*lastDigit*lastDigit);
           then divide the no by 10 and 
           then update the reverse value by  Reverse = (Reverse*10) + lastDigit;
           rhen if sum == duplicate no then it's a armstrong no

           TIME COMPLEXITY =  O(log10N + 1) where N is the input number.

          */