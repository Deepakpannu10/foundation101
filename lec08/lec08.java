class lec08{
    public static void display(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }System.out.println();
        }
        System.out.println("---------------------");
    }

    // this requires update... so think about it and try it.
    public static void spiralPrint(int[][] arr){
        int minr=0, minc = 0 , maxr=arr.length-1, maxc = arr[0].length-1;
        int tne = arr.length*arr[0].length;
        while(tne>0){
            // left wall
            for(int i = minr; i<=maxr;i++){
                System.out.print(arr[i][minc]+" ");
                tne--;
            }
            minc++;
            // bottom wall
            for(int i = minc ; i<=maxc ; i++){
                System.out.print(arr[maxr][i]+" ");
                tne--;
            }
            maxr--;
            // right wall
            for(int i= maxr;i>=minr;i-- ){
                System.out.print(arr[i][maxc]+" ");
                tne--;
            }
            maxc--;
            // top wall
            for(int i=maxc;i>=minc;i--){
                System.out.print(arr[minr][i]+" ");
                tne--;
            }
            minr++;
        }
    }


    public static void transpose(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr[0].length;j++){
                    int temp = arr[i][j];
                    arr[i][j] = arr[j][i];  arr[j][i] = temp;
            }
        }
    }
    public static void rotate(int[][] arr){
        transpose(arr);
        for(int i=0;i<arr.length/2;i++){
            for(int j=0;j<arr[0].length;j++){
                int temp = arr[i][j];
                arr[i][j] = arr[arr.length-1-i][j];     arr[arr.length-1-i][j] = temp;
            }
        }
    }


    // important algorithm...
    public static void kadane(int[] arr){
        int cs=0,os=0,ce=0,oe=0,cmax=0,omax=0;
        while(ce<arr.length){
            if(cmax>0){ cmax +=arr[ce];
            }else{ cs=ce;
                cmax = arr[ce]; }
            if(omax<cmax){
                omax=cmax;
                os=cs;  oe=ce;
            }
            ce++;
        }
        for(int i=os;i<=oe;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("maximum sum of subarray= "+omax);

    }

    public static void main(String[] args) {
        // int[][] arr={{ 1, 2, 3, 4, 5,34,44,45},
        //              { 6, 7, 8, 9, 0,56,57,58},
        //              {11,12,13,14,15,67,68,69},
        //              {16,17,18,19,20,27,28,29},
        //              {21,22,23,24,25,61,62,63}};
        // spiralPrint(arr);
    
        ints[][] arr={{1,2,3},
                     {4,5,6},
                     {7,8,9}};

                     display(arr);
                     rotate(arr);
                     display(arr);
        int[] arr={3,5,-1,-7,8,4,2,-6,10};
        kadane(arr);
    
    }


}