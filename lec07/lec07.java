import java.util.Scanner;
class lec07{
    
    static Scanner scn = new Scanner(System.in);


    public static void input(int[][] arr){
        int count=1;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j] = scn.nextInt();
                // count++;
            }
        }
    }
    public static void display(int[][] arr){
        int count=1;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");    
            }
            System.out.println();
        }
    }

    public static void multiply(int[][] arr1,int[][] arr2){
        int[][] ans = new int[arr1.length][arr1.length];
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr1[0].length;j++){
                for(int k=0;k<arr1[0].length;k++){
                    ans[i][j] += arr1[i][k] * arr2[k][j]; 
                }
            }
            
        }

        display(ans);
    }


    public static void wave(int[][] arr){
        for(int j=0;j<arr[0].length;j++){
            if(j%2==0){
                for(int i=0;i<arr.length;i++){
                    System.out.print(arr[i][j]+" ");
                }
            }else{
                for(int i = arr.length-1;i>=0 ; i--){
                    System.out.print(arr[i][j]+" ");
                }
            }
        }
    }


    public static void exitPoint(int[][] arr){
        int i=0;
        int j=0;
        int dir=0;
        while(true){
            dir += arr[i][j];
            dir %=4;
            if(dir==0){
                j++;
            }else if(dir==1){
                i++;
            }else if(dir==2){
                j--;
            }else if(dir == 3){
                i--;
            }
            if(i<0 || i==arr.length || j<0 || j==arr[0].length ){
                break;
            }
        }
        if(i<0){
            i++;
        }
        if(i==arr.length){
            i--;
        }
        if(j<0){
            j++;
        }
        if(j==arr[0].length){
            j--;
        }
        System.out.println("exit point is:" +i+", "+j);
    }

    public static void main(String[] args){
        // int rows=4;
        // int cols=4;
        // int[][] arr = new int[rows][cols];
        // input(arr);
        // display(arr);

        // int[][] arr1={{2,3,4},
        //               {5,6,7},
        //               {4,1,7}};
        

        // int[][] arr2={{4,1,2},
        //               {7,5,6},
        //               {2,3,4}};
        
        //               multiply(arr1,arr2);
        
        // int[][] arr={{1,2,3,4,5},
        //              {6,7,8,9,0},
        //              {11,22,33,44,55}};
        //              wave(arr);
        
        int[][] arr={{0,0,1,0},
                     {1,0,0,0},
                     {0,0,0,0},
                     {1,0,0,0}};
        exitPoint(arr);
    }

}