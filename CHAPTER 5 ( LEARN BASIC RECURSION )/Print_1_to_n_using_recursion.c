// PRINT 1 TO N USING RECURSION  WHERE N = 4,   O/P = 1234

void func( i, n )
{
   if(i>n) return;
 print(i);
   f( i+1,n );
}
main()
{
  int n;
  input(n);
  f(1,n);
}


// Alternate Approach for printing integers from 1 to N (using Backtracking)

void func( i, n )
{
   if(i<1) return;
 f( i-1,n );
print(i);

}
main()
{
  int n;
  input(n);
  f(n,n);
}