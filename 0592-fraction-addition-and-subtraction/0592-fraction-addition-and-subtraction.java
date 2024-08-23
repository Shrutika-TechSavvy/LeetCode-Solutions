class Solution {
    private int gcd(int a,int b)
    {
        while(b!=0)
        {
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    public String fractionAddition(String expression) {
       String[] fractions=expression.split("(?=[+-])");
       int numerator=0,denominator=1;
       for(String frac:fractions)
       {
        String[] parts=frac.split("/");
        int num=Integer.parseInt(parts[0]);
        int denom=Integer.parseInt(parts[1]);
        numerator=numerator*denom+num*denominator;
        denominator*=denom;

        int gcd=gcd(Math.abs(numerator),denominator);

        numerator/=gcd;
        denominator/=gcd;
       }
       return numerator+"/"+denominator;
    }
}