import java.util.Scanner;
class lec05{
    public static void input(int[] arr) {
        Scanner scn=new Scanner(System.in);
        for(int i=0;i<arr.length;i++){
            arr[i]=scn.nextInt();
        }
    }
    public static void display(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static int findMax(int[] arr){
        int mymax=arr[0];
        for(int i=1;i<arr.length;i++){
            if(mymax<arr[i]){
                mymax = arr[i];
            }
        }
        return mymax;
    }
    // try it maany times.... important
    public static int binarySearch(int[] arr,int data){
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(arr[mid] == data){
                return mid;
            }else if(arr[mid]<data){
                left=mid+1;
            }else{
                right = mid -1;
            }        }
        return -1;
    }


    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        System.out.println("enter size of array");
        int size=scn.nextInt();
        int[] arr = new int[size];
        System.out.println("enter elements");
        input(arr);
        System.out.println("enter data to find");
        int data = scn.nextInt();
        
        // int max=findMax(arr);
        // System.out.println(max);
        System.out.println(binarySearch(arr,data));
        // display(arr);
    }
}

