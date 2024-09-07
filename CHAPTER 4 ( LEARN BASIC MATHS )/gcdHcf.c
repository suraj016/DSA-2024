// BRUTE FORCE APPROACH

 findGcd(int n1, int n2) {
        // Initialize gcd to 1
        int gcd = 1;
       

        // Iterate from 1 up to
        // the minimum of n1 and n2  // Math.min(n1,n2);
        for (int i = 1; i <= (n1, n2); i++) {
            // Check if i is a common
            // factor of both n1 and n2
            if (n1 % i == 0 && n2 % i == 0) {
                // Update gcd to the
                // current common factor i
                gcd = i;
            }
        }

        // Return the greatest
        // common divisor (gcd)
        return gcd;


        // Time Complexity: O(min(N1, N2)) where N1 and N2 is the input number.
    }


    // BETTER APPROACH

    // also knows as EULIDEAN FORMULAE

    findGcd(int a, int b) {
        while(a > 0 && b > 0) {
            // If a is greater than b,
            // subtract b from a and update a
            if(a > b) {
                // Update a to the remainder
                // of a divided by b
                a = a % b;
            }
            // If b is greater than or equal
            // to a, subtract a from b and update b
            else {
                // Update b to the remainder
                // of b divided by a
                b = b % a;
            }
        }
        // Check if a becomes 0,
        // if so, return b as the GCD
        if(a == 0) {
            return b;
        }
        // If a is not 0,
        // return a as the GCD
        return a;


        // Time Complexity: O(min(N1, N2)) where N1 and N2 is the input number
    }

