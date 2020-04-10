class lec14{

    public static void print(int[] arr,int idx){
        if(idx==arr.length){
            return;
        }
        System.out.println(arr[idx]);
        print(arr, idx+1);
    }
    public static void printrev(int[] arr,int idx){
        if(idx==arr.length){
            return;
        }
        printrev(arr, idx+1);
        System.out.println(arr[idx]);
    }

    public static int ffo(int[] arr,int data,int i){
        if(i==arr.length){
            return -1;
        }

        int ans = ffo(arr, data, i+1);
        if(arr[i]==data){
            return i;
        }
    return ans;
    }

    public static int locc(int[] arr,int data,int i){
        if(i==arr.length){
            return -1;
        }
        int ans = locc(arr, data, i+1);
        if(ans == -1 && arr[i] == data){
            return i;
        }
        return ans;
    }


    public static int[] allOcc(int[] arr,int i,int data,int c) {
     if(i==arr.length){
         int[] ans= new int[c];
         return ans;
     }
        int count=0;
        if(arr[i]==data){
            c++;
        }
        int[] ans= allOcc(arr, i+1, data, c);
        if(arr[i]==data){
            ans[c-1]=i;
        }

        return ans;
    }



    public static void main(String[] args){
        int[] arr={3,1,3,0,1,0,3,2};
        // locc(arr, 1, 0);
        int[] ans = allOcc(arr, 0, 3, 0);

        print(ans, 0);

        
    }
}