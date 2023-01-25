import java.util.Scanner;

/**
 * @author valar_morghulis on 25/01/23.
 * @project multi-module-gradle
 * @description
 */
class Log
{
    public static void main(String arg[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter a number n :");
        double n=sc.nextDouble();
        System.out.println("enter a base number ");
        double b=sc.nextDouble();
        double c=0;
        while(n>1)
        {
            n=n/b;
            c++;
        }
        c=c+n;
        System.out.println("log value of n approximately equals to: "+(c-1));

    }
}
