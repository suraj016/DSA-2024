
          countDigits(int n){
        int count = 0;
        while( n > 0){
            n = n/10;
            count++;
        }
        return count;
    }

         countDigitss(int n){
                           // Math.log10(n)
            int cnt = (int) (log10(n) + 1);
            return cnt;
         }
                                         
      


    // logic 1
     
     /*
           run a loop till n becomes zero
           till then divide the n by 10 
           and incremenent the counter 
           and u will get the no of digit

           Time Complexity: O(log10N + 1) where N is the input number.

     */

    // logic 2 

    /*
    
    Step 1: Initialise a variable to store the count of digits of the number.

Step 2: The count of digits can be calculated using log10 N + 1.

log10 N operation gives the logarithmic base 10 of which returns the power to which 10 must be raised to, to be equal to N.
We add 1 to the result which accounts for the possibility that N itself is a power of 10.
Financially cast the result to an integer to ensure that it is rounded down to the nearest whole number.

Step 3: Return the value of count which represents the count of digits in the input integer N

Time Complexity: O(1)as simple arithmetic operations in constant time are computed on integers.


    
    */