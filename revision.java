
class revision{

    public static int[] merge2SortedArray(int[] a,int[] b){
        int[] ans = new int[a.length+b.length];

        int i=0;
        int j=0;
        int k=0;

        while(i<a.length&&j<b.length){
            if(a[i]<b[j]){
                ans[k] = a[i]; i++;
            }else{
                ans[k] = b[j]; j++;
            }
            k++;
        }

        while(i<a.length){
            ans[k] = a[i]; i++; k++;
        }

        while(j<b.length){
            ans[k] = b[j]; j++; k++;
        }
        return ans;
    }

    public static int[] mergeSort(int[] arr,int lo,int hi) {
        if(lo==hi){
            int[] base = new int[1];
            base[0] = arr[lo];
            return base;
        }

        int mid = (lo+hi)/2;
        int[] left = mergeSort(arr, lo, mid);
        int[] right = mergeSort(arr, mid+1, hi);
        int[] ans = merge2SortedArray(left,right);

        return ans;
    }


    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] =  temp;
    }

    public static void sort01(int[] arr){
        int i=0, j=0;

        while(j<arr.length){
            if(arr[j] == 0){
                swap(arr,i,j);
                i++;
            }
            j++;
        }
    }

    public static void sort012(int[] arr){
        int i=0,j=0,k=0;
        while(j<arr.length){
            if(arr[j]==0){
                swap(arr, k, j);    
                swap(arr, i, k);    i++; k++;
            }else if(arr[j]==1){
                swap(arr, k, j);    k++;
            }
            j++;
        }
    }
//----------------------------------------------------------------------sat.......


    public static int parition(int[] arr,int lo,int hi){
        int pivot = arr[hi];
        int i=0, j=0;
        while(j<=hi){
            if(arr[j] <= pivot){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
             }
                j++;
        }
        return i-1;
    }

    public static void quickSort(int[] arr,int lo,int hi){
        if(lo>=hi){
            return;
        }
        int pivotIndex = parition(arr,lo,hi);        
        quickSort(arr, lo, pivotIndex-1);
        quickSort(arr, pivotIndex+1, hi);
    }


    public static long fibo(int n,int[] dp){
        if(n==1||n==0){
            return n;
        }
        // if(dp[n] != 0){
        //     return dp[n];
        // }
        long nm1 = fibo(n-1,dp);
        long nm2 = fibo(n-2,dp);
        // dp[n] = nm1+nm2;
        return nm1+nm2;
    }

    public static long fiboT(int n){
        long[] dp = new long[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            long nm1 = dp[i-1];
            long nm2 = dp[i-2];
            dp[i] = nm1+nm2;
        }
        return dp[n];
    }



    public static void main(String[] args) {
        // int[] arr = {3,10,12,9,2,12,13,6,5,15,20,10};
        //  quickSort(arr,0,arr.length-1);
        // for(int i=0;i<arr.length;i++) System.out.print(arr[i]+" ");
        int n=48;
        int[] dp = new int[n+1];
        System.out.println(fibo(n,dp)+" "+fiboT(n));
    }
}