class lec06{

    public static void display(int[] arr) {
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }



    public static void swap(int[] arr,int left,int right) {
        int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++; right--;
    }
    public static void reverse(int[] arr,int left , int right){
           while(left<right){
                swap(arr,left,right);
           }
    }

    public static void pattern(int[] arr){
        int max=-1;
        for(int i=0;i<arr.length;i++){
            if(max<arr[i]){
                max=arr[i];
            }
        }
        for(int cr = max ; cr > 0 ; cr--){
            for(int cc=0 ; cc<arr.length;cc++){
                if(arr[cc]>=max){
                    System.out.print("*\t");
                }else{
                    System.out.print("\t");
                }
            }
            System.out.println();
            max--;
        }


    }

    private static void rotate(int[] arr,int r){
        reverse(arr,arr.length-r,arr.length-1);
        reverse(arr,0,arr.length-r-1);
        reverse(arr,0,arr.length-1);
    }


    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9};

        // display(arr);
        // rotate(arr,6);
        // display(arr);
        pattern(arr);
    }


}