import java.util.*;
class hm{
    public static char mostFreqChar(String str) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for( int i = 0 ; i < str.length() ; i++ ){
            char ch = str.charAt(i);
            if( hm.containsKey(ch) ){
                int freq = hm.get( ch );
                hm.put( ch, freq + 1 );
            }else{
                hm.put( ch, 1 );
            }
        }
        char ans = str.charAt(0);
        int freq = 1;
        for( char ch : hm.keySet() ){
            int cfreq = hm.get( ch );
            if( cfreq > freq ){
                ans = ch;
                freq = cfreq;
            }
        }
        return ans;
    }

    public static void printCommonElements1( int[] a, int[] b ){
        HashMap<Integer,Integer> hm = new HashMap<>();
        for( int i = 0 ; i < a.length ; i++ ){
            if( hm.containsKey(a[i]) ){
                hm.put( a[i], hm.get(a[i]) + 1 );
            }else{
                hm.put( a[i] , 1 );
            }
        }
        for( int i = 0 ; i < b.length ; i++ ){
            if( hm.containsKey( b[i] ) ){
                System.out.println( b[i] );
            }
        }
    }

    public static void printCommonElements2(int[] a, int[] b) {
       HashMap<Integer,Integer> map = new HashMap<>();
       for( int i = 0 ; i < a.length ; i++ ){
            if(map.containsKey(a[i]) ){
                map.put( a[i], map.get(a[i]) + 1 );
            }else{
                map.put( a[i] , 1 );
            }
       }
       for( int i = 0 ; i < b.length ; i++ ){
            if( map.containsKey( b[i] ) ){
                System.out.print( b[i] +" " );
                int freq = map.get( b[i] );
                freq--;
                if( freq > 0 ){
                    map.put( b[i] , freq );
                }else{
                    map.remove( b[i] );
                }
            }
       }
    }
    public static void main(String[] args) {
        int[] a = {1,5,3,1,5,8,7,2,7,2,92};
        int[] b = {20,1,2,25,7,7,2,2,7,7,80,25};
        printCommonElements2( a , b);
        // String str = "aaaeeaaaabbbaaaeeeeettteeeettttjjjjeeeejj";
        // char ch = mostFreqChar(str);
        // System.out.println(ch);
    
    }
}