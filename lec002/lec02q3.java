class lec02q3{

// rotate question...

    public static void main(String[] args){
        int n=12345; // number
        int r=3; // rotation

        int n1=n;   // copy of n to find length

        int length=0;

        while(n1!=0){
            n1=n1/10;
            length++;
        }

        r = r % length; // range concept( eg. 1002 % 5)
        if(r<0){
            r=r+length; // handle negative r;
        }

        int post=0;
        int pow=1;
        int r1=r;
        while(r>0){
            int rem=n%10;`
            n=n/10;
            post=rem*pow+post;
            pow=pow*10;
            r--;
        }

        length = length - r1;
        
        while(length > 0){
            post=post*10;
            length--;
        }
        post=post+n;
        
        System.out.print(post);
    }

}