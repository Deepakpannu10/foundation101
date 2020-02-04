class lec12{


    public static void printDec(int n){
        if(n==0){
            return;
        }
        System.out.println(n);

        printDec(n-1);

    }


    public static void printinc(int n){
       if(n==0){
            return;
        }
        int a = 25;   
        printinc(n-1);
        System.out.println(n);
        n=n+20;

    }

    public static void printDecInc(int n){
        if(n==3){
            System.out.println(n);
            return;
        }
        System.out.println(n);
        printDecInc(n-1);
        System.out.println(n);
    }

    public static int facto(int n){
        if(n==1){
            return 1;
        }
        int nm1fact = facto(n-1);
        int myfact = n*nm1fact;
        return myfact;
    }

    public static int printzzz(int n){
        if(n==0){
            return 1;
        }
        int myans = 0;
        System.out.println(n);
        myans += printzzz(n-1);
        System.out.println(n);
        myans += printzzz(n-1);
        System.out.println(n);
        return myans;
    }

    public static void toh(int n,String s,String h,String d){
        if(n==0){
            return;
        }
        toh(n-1,s,d,h);
        System.out.println("move "+n+"th disk from "+s+" to "+d);
        toh(n-1,h,s,d);

    }


    public static void main(String[] args){
        // printDecInc(5);
    // int ans = facto(5);
    // System.out.println(ans);
    toh(3,"source","helper","destination");
    }
}