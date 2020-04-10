import java.util.ArrayList;
class lec11{

    public static void substrings(String str){
        for(int i=0;i<str.length() ;i++ ){
            for(int j=i+1;j<=str.length();j++){
                System.out.println(str.substring(i,j));
            }
        }

    }

    public static String toogle(String str){
        String ans = "";
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch>='a' && ch <= 'z'){
                ch =(char) (ch - 'a' +'A');
            }else{
                ch =(char) (ch - 'A' + 'a');
            }
            ans= ans + ch;
        }
        return ans;
    }

    public static String diffOfAscii(String str){
        String ans = "";
        for(int i=0;i<str.length()-1;i++){
            ans += str.charAt(i);
            ans+= str.charAt(i+1) - str.charAt(i);
        }
        ans += str.charAt(str.length()-1);
        return ans;
    }

    public static void main(String[] args){
        // String str="abacd"; 
        // System.out.println(diffOfAscii(str));
        ArrayList<Integer> arr = new ArrayList<>();
        arr.remove(arr.size()-1);
        for(int i=0;i<arr.size();i++){
            System.out.println(arr.get(i));
        }
    }
}