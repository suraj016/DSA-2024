/*
WHAT IS RECURSION
-> when a fuction call itself 
   until a specified condition is meet.


   void f(){
    printf(1);
    f();
}

int main()
{
    f();
   
}


*/ 



// output will be 1111....
// it is an infinite recursion - stack overflow





 

// recursion code when you want to return till base condition

    static int cnt = 0;
    static void print(){
        
         // Base Condition.
         if(cnt == 3 ) return;
         System.out.println(cnt);

         // Count incremented.
         cnt = cnt+1;
         print();

    }
    public static void main(String[] args) {
        print();
    }



