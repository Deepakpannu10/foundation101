import java.util.*;
class clientHM{

    public static void main(String[] args) {
        hashMap<String, Integer> map = new hashMap<>();

        map.put( "india", 2000 );
        map.put( "china", 10000 );
        map.put( "pakis" , 100000);

        map.remove( "india" );
        Set<String> ks = map.keySet();

        for( String str : ks ){
            System.out.println(map.get(str) + " -> "+str);
        }
    }
}