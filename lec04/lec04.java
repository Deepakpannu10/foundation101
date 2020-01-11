class lec04{


    public static int deciToBin(int n){
        int ans=0;
        int pow=1;
        while(n!=0){
            int rem=n%2;
            n=n/2;
            ans=rem*pow+ans;
            pow=pow*10;
        }
        return ans;
    }


    public static int deciToAnyBase(int n,int db){
        int ans=0;
        int pow=1;
        while(n!=0){
            int rem=n%db;
            n=n/db;
            ans=rem*pow+ans;
            pow=pow*10;
        }
        return ans;
    }

    public static void main(String[] args){
        int n=560;

        int ans=deciToBin(n);
        System.out.println(ans);
        System.out.println(deciToBin(320));
        System.out.println(deciToBin(189));



    }

}