class lec21{
    public static void swap(int[]arr,int i,int j) {
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]= temp;
    }
    public static int partition(int[] arr,int lo,int hi) {
        int i=lo,j=lo;
        int val = arr[hi];
        while(j<=hi){
            if(arr[j]<=val){
                swap(arr, i, j);      i++;
            }
            j++;
        }
        return i-1;
    }


    public static void quicksort(int[] arr,int lo,int hi){
        if(lo>=hi){
            return;
        }
        int pi = partition(arr, lo, hi);
        quicksort(arr, lo, pi-1);
        quicksort(arr, pi+1, hi);
    }
    //----------------------------------------------------------------

    public static int fibo(int n,int[] dp){
        if(n==0 || n==1)
            return n;
        if(dp[n] != 0)
            return dp[n];
        int n1f = fibo(n-1,dp);   int n2f = fibo(n-2,dp);
        int ans = n1f+n2f;   dp[n] = ans;
        return ans;
    }

    public static int fiboTabu(int n){
        int[] dp = new int[n+1];   dp[0] = 0; dp[1] = 1;
        for(int i = 2;i<=n;i++){  dp[i] = dp[i-1] + dp[i-2];    }
        return dp[n];
    }

    public static void main(String[] args) {
        // int[] arr = {25,27,15,7,29,3,45,1,6,15};
        // // partition(arr);
        // quicksort(arr, 0, arr.length-1);
        // for(int i=0;i<arr.length;i++)
        //     System.out.print(arr[i]+" ");
        int[] dp = new int[47];
        System.out.println(fibo(46,dp));
    }
}