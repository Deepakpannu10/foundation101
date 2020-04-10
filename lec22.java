
class lec22{

    public static int stairsPathMemo(int n,int[] dp){
        if(n==0){
            return 1;
        }
        // else if(n<0){
        //     return 0;
        // }
        if(dp[n] != 0){
            return dp[n];
        }
        int ans = 0;
        if(n-1>=0)
        ans +=stairsPathMemo(n-1, dp);
        if(n-2>=0)
        ans += stairsPathMemo(n-2, dp);
        if(n-3>=0)
        ans += stairsPathMemo(n-3, dp);
        dp[n] = ans;
        return ans;
    }

    public static int stairsPathTabu(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1;i<dp.length;i++){
            if(i-1>=0) dp[i] += dp[i-1];
            if(i-2>=0) dp[i] += dp[i-2];
            if(i-3>=0) dp[i] += dp[i-3];
        }
        return dp[n];
    }


    public static int minJumps(int[] arr){
        int[] dp = new int[arr.length];
        dp[dp.length-1] = 0;
        for(int i = dp.length-2;i>=0;i-- ){
            if(arr[i] ==0 ){
                dp[i] = Integer.MAX_VALUE;
            }else{
                int minjump = Integer.MAX_VALUE;
                for(int jump = 1 ; jump<=arr[i] && i+jump<arr.length ;jump++ ){
                    minjump = Math.min(minjump, dp[i+jump]);
                }      
                dp[i] = minjump != Integer.MAX_VALUE?minjump+1:Integer.MAX_VALUE;
            }
        }
        return dp[0];
    }


    public static int minCost(int[][] arr){
        int[][] dp = new int[arr.length][arr[0].length];
        for(int i=dp.length-1;i>=0;i--){
            for(int j=dp[0].length-1;j>=0;j--){
                if(i==dp.length-1 && j == dp[0].length-1){
                    dp[i][j] = arr[i][j];
                }else if(i==dp.length-1){
                    dp[i][j] = arr[i][j] + dp[i][j+1];
                }else if(j==dp[0].length-1){
                    dp[i][j] = arr[i][j] + dp[i+1][j];
                }else{
                    dp[i][j] = arr[i][j] + (dp[i][j+1]<dp[i+1][j]?dp[i][j+1]:dp[i+1][j]);
                }
            }
        }
        printPath(0,0,"",dp);
        return dp[0][0];
    }

    public static void printPath(int i,int j,String path,int[][] dp){
        if(i==dp.length-1 && j == dp[0].length-1){
            System.out.println(path);
            return; 
        }else if(i==dp.length-1){
            printPath(i, j+1, path+'h', dp);
        }else if(j==dp[0].length-1){
            printPath(i+1, j, path+'v', dp);
        }else{
            int min = (dp[i][j+1]<dp[i+1][j]?dp[i][j+1]:dp[i+1][j]);
            if(min == dp[i][j+1]){
                printPath(i, j+1, path+'h', dp);
            }
            if(min == dp[i+1][j]){
                printPath(i+1, j, path+'v', dp);
            }
        }
    }

    public static void main(String[] args) {
        // int n = 35;
        // int[] dp = new int[n+1];
        // System.out.println(stairsPathMemo(n, dp)+"  "+stairsPathTabu(n));
        // int[] arr = {4,5,1,0,2,2,3,1,2,0,1};
        // System.out.println(minJumps(arr));
        // int[][] arr = {{5,7,8,3,27},{9,11,11,21,25},{28,14,20,22,30},
        //                 {18,31,15,4,2},{9,17,6,5,10}};
        int[][] arr = {{1,1,1},{1,1,1},{1,1,1}};
        System.out.println(minCost(arr));
    }
}