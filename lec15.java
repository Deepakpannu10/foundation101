import java.util.ArrayList;

class lec15{

    public static void subSeq(String ques,String ans){
        if(ques.length()==0){
            System.out.println(ans);
            return;
        }
        char ch = ques.charAt(0);
        String roq = ques.substring(1);
        subSeq(roq, ans + ch);
        subSeq(roq, ans);
    }

    public static ArrayList<String> subSeq(String ques){
        if(ques.length()==0){
            ArrayList<String> baseAns = new ArrayList<>();
            baseAns.add("");  return baseAns;
        }
        String roq = ques.substring(1);
        ArrayList<String> recAns = subSeq(roq);
        ArrayList<String> myans = new ArrayList<>();
        for(int i=0;i<recAns.size();i++){
            myans.add(ques.charAt(0)+recAns.get(i));
        }
        for(int i=0;i<recAns.size();i++){ myans.add(recAns.get(i));
        }
        return myans;
    }


public static void nokiaKey(String ques,String ans,String[] codes){
        if(ques.length()==0){
            System.out.print(ans+" ");
            return;
        }
        char ch= ques.charAt(0);
        int num = ch-'0';
        String word = codes[num];
        for(int i=0;i<word.length();i++){
            char ch1 = word.charAt(i);
            nokiaKey(ques.substring(1), ans+ch1, codes);
        }
    }
    public static void main(String[] args){
        String[] codes ={"?.",",;","abc","def","ghi","jkl","mno","pqrs","tuvw","xyz"};
     
        // subSeq("abc",".");
        System.out.println(subSeq("abc"));
        nokiaKey("234", "", codes);
    }
}