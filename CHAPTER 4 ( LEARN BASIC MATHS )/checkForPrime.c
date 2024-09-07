// WHAT IS A PRIME NO ?
 // a no which has exctly 2 factors ( 1 and the number itself)

      checkforPrime(int n){
        int counter = 0;
        for(int i = 1; i <=n; i++){
            if(n % i == 0){
                counter++;
            }
            if(counter == 2){
                printf("yes its a prime number");
            }else{
                printf("not a prime number");
            }
        }
      } 

          /*
            tc = o(n)
          
          
          */


    //    checkforPrime(int n){
    //     int count = 0;
    //      for(int i =1; i <= sqrtN; n++){
    //     if( n % i == 0){
    //       count++;
    //         if((n%i)!= i){
    //           count++;
    //         }
    //     }
    //     if(count == 2){
    //         printf("yes its a prime no");
    //     }else{
    //         printf("not a prime no");
    //     }
    // }
    //   }


      
          /*
            T.C = O(sqrt(N))
          
          
          */
