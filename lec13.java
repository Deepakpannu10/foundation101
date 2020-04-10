class lec13{




    public static void toh(int n,String s,String h,String d){
        if(n==0){
            return;
        }
        toh(n-1,s,d,h);
        System.out.println("move "+n+"th from"+s+" to"+d);
        toh(n-1, h, s, d);
    }



    public static void main(String[] args){
        System.out.println();
        toh(4, "source", "helper", "destination");

    }



}