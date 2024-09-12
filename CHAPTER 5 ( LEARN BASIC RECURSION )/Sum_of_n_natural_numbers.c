// SUM OF FIRST N NATURAL NUMBERS
// 1. PARAMETERIZED WAY
// 2. FUNCTIONAL WAY


// Example 1:
// Input: N=5
// Output: 15
// Explanation: 1+2+3+4+5=15

// Example 2:
// Input: N=6
// Output: 21
// Explanation: 1+2+3+4+5+6=15

/*
GENERIC WAY 1 


    import java.util.*;

  public class tuf {

  public static void main(String[] args) {

    solve(5);
    solve(6);
  }
  public static void solve(int n) {
    int sum = 0;
    for (int i = 1; i <= n; i++) {
      sum += i;
    }
    System.out.println("The sum of the first " + n + " numbers is: " + sum);
  }
}

GENERIC WAY 2

     public class tuf {

  public static void main(String[] args) {

    solve(5);
    solve(6);
  }
  public static void solve(int N) {
    int sum = N * (N + 1) / 2;
    System.out.println("The sum of the first " + N + " numbers is: " + sum);
  }
}






*/

//GENERIC WAY 3 (PARAMETER)

void func(i,sum)
{
   if(i<1)
   {
     print(sum);
     return;
   }

func(i-1,sum+i);

}

main()
{
    int n; // as a input
   input(n);
   func(n,0);

}



// FUNCTIONAL WAY

int func(n)
{
   if(n == 0)
   {
     return 0;
   }

  // return n + func(n-1);

}

main()
{
    int n;
   input(n);
   func(n);

}
