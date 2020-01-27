class lec09{

    public static int firstOcc(int[] arr,int data){
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid] == data){
                if(mid-1>=0 && arr[mid-1] == data){
                    right = mid-1;               
                 }else{
                       return mid;
                 }
            }else if(arr[mid]>data){
                    right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }
    public static int lastOcc(int[] arr,int data){
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid] == data){
                if(mid+1 < arr.length && arr[mid+1] == data){
                    left = mid+1;               
                 }else{
                       return mid;
                 }
            }else if(arr[mid]>data){
                    right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }


    public static int iIntoArrOfI(int[] arr) {
        int sum = 0;
        int rot = 0;
        for(int i=0;i<arr.length;i++){
            sum = sum + arr[i];
            rot += (i*arr[i]);
        }
        int mymax = rot;
        for(int i=1;i<arr.length;i++){
             rot = rot - (sum - arr.length*arr[i-1]);
            if(rot>mymax){
                mymax = rot;
            }
        }
        return mymax;
    }


    public static void subsets(int[] arr){
        int pow = 1;
        for(int i=0;i<arr.length;i++){
            pow = pow * 2;
        }
        int count = 0 ;
        while(count<pow){
            int length = 0;  int cc = count ;
            while(cc != 0){
                int rem = cc % 2; cc = cc/2;
                if(rem == 1){
                    System.out.print(arr[length]+" ");
                }
                length++;
            }
            System.out.println();
            count++;
        }
    }


    public static void main(String[] args){
        // int[] arr= {1,1,1,4,4,4,5,5,5,5,6,6,6,6,6,6,6,6,6,6,6};
        // int[] arr={3,5,1,8,2};
        int[] arr = {1,2,3};
        // System.out.println(iIntoArrOfI(arr));
        subsets(arr);  
    }


}