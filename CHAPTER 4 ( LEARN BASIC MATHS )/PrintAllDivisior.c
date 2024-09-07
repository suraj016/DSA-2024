
    // BRUTEFORCE APPROACH
    
      PrintAllDivisor(int n){
           for(int i = 1; i <= n; i++){
            if( n % i == 0){
                printf(i);
            }
           }
         }  



   /*
       logic

       Step 1:Initialise an array to store the divisors.

Step 2:Iterate from 1 to n using a loop variable ‘i’. For each value of ‘i’:

Check if ‘i’ is a divisor of ‘n’ by checking if ‘n’ is divisible by ‘i’ without a remainder (‘n’%i == 0).
If i is a divisor, store it in the array of divisors and increment the count of divisors. 

TIME COMPLEXITY = O(n);
   
   */    


  // OPTIMIZED APPROACH

//    PrintAllDivisor(int n){
//     ArrayList<Integer> divisors = new ArrayList<>();
//     int sqrtN = (int) Math.sqrt(n);
//     for(int i =1; i <= sqrtN; n++){
//         if( n % i == 0){
//           divisors.add(i);
//             if((n%i)!= i){
//                divisors.add(n/i);
//             }
//         }
//     }
//    }




/*
   LOGIC
   run a loop for 1 to n till sqare root of n
   if n divides by any no put that into the list and also check if 
    if((n%i)!= i) then also put into the list and at last return the list

    Time Complexity: O(sqrt(N)) where N is the input number




*/