import java.util.*;
class clientHM{

    public static void main(String[] args) {
        // hashMap<String, Integer> map = new hashMap<>();

        // map.put( "india", 2000 );
        // map.put( "china", 10000 );
        // map.put( "pakis" , 100000);

        // map.remove( "india" );
        // Set<String> ks = map.keySet();

        // for( String str : ks ){
        //     System.out.println(map.get(str) + " -> "+str);
        // }

        HashSet<Integer> hs = new HashSet<>();

        hs.add( 30 );
        hs.add( 12384 );
        hs.add( 1 );
        hs.add(56);

        for( int val : hs ){
            System.out.println( val );
        }
    }
}