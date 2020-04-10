import java.util.ArrayList;

class lec16{

    public static ArrayList<String> nkc(String ques,String[] codes){
        if(ques.length()==0){
            ArrayList<String> baseAns = new ArrayList<>();
            baseAns.add("");
            return baseAns;
        }
        ArrayList<String> recAns = nkc(ques.substring(1), codes);
        ArrayList<String> myans = new ArrayList<>();
        int num = ques.charAt(0)-'0';
        String word = codes[num];
        for(int i=0;i<word.length();i++){
            char cch = word.charAt(i);
            for(int j=0;j<recAns.size();j++){
                myans.add(cch + recAns.get(j));
            }
        }
            return myans;
    }

    public static int mazePath(int cr,int cc,int er,int ec,String path){

        if(cc== ec && cr == er){
            System.out.println(path);
            return 1;
        }
        int ans  = 0;
        if(cc+1<=ec){
        // horizontal
            ans +=  mazePath(cr, cc+1, er, ec, path+'h');
        }
        if(cr+1<=er){
        // vertical
            ans += mazePath(cr+1, cc, er, ec, path+'v');
        }
        return ans;
    }


    public static void mazePath1(int sr,int sc,int er,int ec,String path){
        if(sc==ec && sr==er){
            System.out.println(path);
            return;
        }


        for(int i=1;sc+i<=ec;i++){
            mazePath1(sr, sc+i, er, ec, path+'h'+i);
        }

        for(int i=1;sr+i<=er;i++){
            mazePath1(sr+i, sc, er, ec, path+'v'+i);
        }

        for(int i=1;sc+i<=ec && sr+i<=er;i++){
            mazePath1(sr+i, sc+i, er, ec, path+'d'+i);
        }

    }
    

    public static ArrayList<String> mazePath1(int sr,int sc,
    int er,int ec){
        if(sc==ec && sr==er){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> myans = new ArrayList<>();
        for(int i=1;sc+i<=ec;i++){
            ArrayList<String> recans= mazePath1(sr, sc+i, er, ec);
            for(String str:recans){
                myans.add("h"+i+str);
            }
        }
        for(int i=1;sr+i<=er;i++){
            ArrayList<String> recans= mazePath1(sr+i, sc, er, ec);
            for(String str:recans){
                myans.add("v"+i+str);
            }
        }

        for(int i=1;sc+i<=ec && sr+i<=er;i++){
        ArrayList<String> recans= mazePath1(sr+i, sc+i, er, ec);
            for(String str:recans){
                myans.add("d"+i+str);
            }
        }
        return myans;
    }


    public static void stairpath(int n,String path){
        
        if(n==0){
            System.out.println(path);
            return;
        }
        if(n-1>=0)
        stairpath(n-1, path+'1');
        if(n-2>=0)
        stairpath(n-2, path+'2');
        if(n-3>=0)
        stairpath(n-3, path+'3');
    }

    public static void main(String[] args){
        // String[] codes ={"?.",",;","abc","def","ghi","jkl","mno","pqrs","tuvw","xyz"};
        // System.out.println(nkc("234", codes));;
        stairpath(4, "");
        // ArrayList<String> finalAns =mazePath1(0, 0, 2, 2);
        // System.out.println(finalAns+" "+finalAns.size());
    }
}