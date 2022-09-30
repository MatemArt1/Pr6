import java.util.Scanner;

public class Main {
    /*
    Similar but fairly harder version : Linked

Create a function that takes a integer number n and returns the formula for (a+b)n(a+b)^n(a+b)
n
  as a string.

formula(0)  --> "1"
formula(1)  --> "a+b"
formula(2)  --> "a^2+2ab+b^2"
formula(-2) --> "1/(a^2+2ab+b^2)"
formula(3)  --> "a^3+3a^2b+3ab^2+b^3"
formula(5)  --> "a^5+5a^4b+10a^3b^2+10a^2b^3+5ab^4+b^5"
Important notes :
Your string may not have spaces so you can't do this : a^5 + 5a^4 b + 10a^3 b^2...
You will show raised to power of by ^ and not using **.
You need not put * between each multiplication
There is no need to show a^1 or b^1 since that is basically a and b
a^0 and/or b^0 also don't need be shown instead be a normal person and use 1 since that is what they equate to.
You will need to handle both positive and negative numbers + 0
You will not be tested for float (only negative integers and whole numbers)
input n goes from -200 to 200.
     */
    public static int comb(int n, int k)
    {
        if (k==0) return 1;
        if (n==0) return 0;
        return comb(n-1,k-1)+comb(n-1,k);
    }
    public static String formula(int m) {
        if(m == 0)
            return "1";
        else if(m == 1)
            return "a+b";
        else if(m == 2)
            return "a^2+2ab+b^2";
        else if(m == -1)
            return "1/(a+b)";
        else if(m == -2)
            return "1/(a^2+2ab+b^2)";
        else
        {
            String s = "";
            if(m < - 2)
                s = "1/(";
            int M = Math.abs(m);
            int h1 = M -1;
            s = s + "a^" + M + "+" + M + "a^" + h1 + "b";
            for(int i = 2; i <= M - 2; i++)
            {
                int C = comb(M, i);
                int h = M -i;
                s = s + "+" + C + "a^" + h + "b^" + i;
            }
            s = s + "+" + M + "ab^" + h1 + "+" + "b^" + M;
            if(m < - 2)
                s = s + ")";
            return s;
        }
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println(formula(13));
    }
}