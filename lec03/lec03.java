import java.util.*;
class lec03{



    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);

        int n=scn.nextInt();

        // for(int cr=1;cr<=n;cr++){
        //     for(int cc=1;cc<=n;cc++){
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }


        // int st=n;
        // int sp=0;
        // for(int cr=1;cr<=n;cr++){
        //     for(int cp=1;cp<=sp;cp++){
        //         System.out.print(" ");
        //     }
        //     for(int cs=1;cs<=st;cs++){
        //         System.out.print("*");
        //     }
        //     sp++;
        //     st--;
        //     System.out.println();
        // }
 
            // int count=1;

            // for(int cr=1;cr<=n;cr++){
            //     for(int cc=1;cc<=cr;cc++){
            //         System.out.print(count+" ");
            //         count++;
            //     }
            //     System.out.println();

            // }


            for(int cr=0;cr<=n;cr++){
                int ncr=1;
                for(int cc=0;cc<=cr;cc++){
                    System.out.print(ncr+" ");
                    int ncrpo=ncr*(cr-cc)/(cc+1);
                    ncr=ncrpo;
                }System.out.println();
            }



    }



}