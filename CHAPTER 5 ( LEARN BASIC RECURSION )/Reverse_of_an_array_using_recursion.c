// Example 1:


// Input: N = 5, arr[] = {5,4,3,2,1}
// Output: {1,2,3,4,5}

// Example 2:
// Input: N=6 arr[] = {10,20,30,40}
// Output: {40,30,20,10}

//---------------------------------------------------------------------------------------------------------//

// Solution 1: Using an extra array.

// Approach: Declare an array,ans[] of the same size as the input array.
//  Iterate from the back of the input array while storing the elements in ans[]  in opposite direction.

// public class Main {
//    Function to print array
//    static void printArray(int ans[], int n) {
//       System.out.print("Reversed array is:- \n");
//       for (int i = 0; i < n; i++) {
//          System.out.print(ans[i] + " ");
//       }
//    }
//    //Function to reverse array using an auxiliary array
//    static void reverseArray(int arr[], int n) {
//       int[] ans = new int[n];
//       for (int i = n - 1; i >= 0; i--) {
//          ans[n - i - 1] = arr[i];
//       }
//       printArray(ans, n);
//    }
//    public static void main(String[] args) {
//       int n = 5;
//       int arr[] = { 5, 4, 3, 2, 1};
//       reverseArray(arr, n);
//    }
// }

  // T.C -> O(n);
  // s.c -> O(n);

//-------------------------------------------------------------------------------------------//

/*
  2nd method

    public class Main {
   //Function to print array
   static void printArray(int arr[], int n) {
      System.out.print("Reversed array is:- \n");
      for (int i = 0; i < n; i++) {
         System.out.print(arr[i] + " ");
      }
   }
   //Function to reverse array 
   static void reverseArray(int arr[], int n) {
      int p1 = 0, p2 = n - 1;
      while (p1 < p2) {
         int tmp = arr[p1];
         arr[p1] = arr[p2];
         arr[p2] = tmp;
         p1++;
         p2--;
      }
      printArray(arr, n);
   }
   public static void main(String[] args) {
      int n = 5;
      int arr[] = { 5, 4, 3, 2, 1};
      reverseArray(arr, n);

   }
}  

   t.c -> O(n);
// one make

*/

 // Recursive method

 // 