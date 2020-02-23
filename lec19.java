class lec19{
 // sorting algos
    public static void swap(int[] arr,int i,int j){
        int temp =arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void bubbleSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j, j+1);
                }
            }
        }
    }


    public static void selestionSort(int [] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    swap(arr, i, j);
                }
            }
        }
    }


    public static int[] merge2SortedArrays(int[] a,int[] b){
        int[] ans = new int[a.length+b.length];
        int i=0,j=0,k=0;
        while(i<a.length && j<b.length){
            if(a[i]<b[j]){
                ans[k] = a[i] ;         i++;
            }else{
                ans[k] = b[j];   j++;
            }
            k++;
        }
        while(i<a.length){
            ans[k] = a[i] ;   i++; k++;
        }
        while(j<b.length){
            ans[k] = b[j];   j++; k++;
        }
        return ans;
    }

    public static void main(String[] args){
        // int[] arr = {2,8,6,5,3,7,9,4};
        // bubbleSort(arr);
        // selestionSort(arr);
        int[] arr1 = {3,5,17,20,27,30};
        int[] arr2 = {2,4,6,18,20,23,45};
        int[] arr = merge2SortedArrays(arr1,arr2); 

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}