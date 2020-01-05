import java.util.*;

class lec02{
    // getting started again.
    public static void main(String[] args){
        
        Scanner scn=new Scanner(System.in);

        System.out.println("enter 1st number");
        int a=scn.nextInt();
        System.out.println("enter 2nd number");
        int b=scn.nextInt();

        int res=a+b;
        System.out.println("your res is="+res);


        // if else conditions

        int marks=scn.nextInt();

        if(marks>90){
            System.out.println("I will take science");
        }else{
            System.out.println("I will not study");
        }

        // loop (print till given value)

        int value=scn.nextInt();

        for(int i=0;i<=value;i++)
        {
            System.out.print(i+" ");
        }



    }
}