import java.util.*;

class largerofthree{

	public static void main(String[] args){
		Scanner scn=new Scanner(System.in);  
        System.out.println("enter 1st number");
        int a = scn.nextInt();

        System.out.println("enter 2nd number");
        int b=scn.nextInt();
        System.out.println("enter 3rd number");
        int c=scn.nextInt();
        if(a > b  && a > c ){
            System.out.println( " larger is = " + a);
        }else if(b > a && b > c ){
            System.out.println("larger is =" + b);
        }else{
            System.out.println("larger is=" + c );
        }

	
	
	}

}