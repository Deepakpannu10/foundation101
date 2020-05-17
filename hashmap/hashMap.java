import java.util.*;
import java.util.LinkedList;

public class hashMap< K , V >{ // user will tell the type of key and value

    // a single hashMap node will contain key and value
    private class hashmapNode{
        K key;
        V value;
        hashmapNode( K key, V value ){
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    private LinkedList<hashmapNode>[] buckets;

    // constructor for hashMap
    hashMap(){
        this.size = 0;
        buckets = new LinkedList[4];
        for( int i = 0 ; i < 4 ; i++ ){
            buckets[i] = new LinkedList<hashmapNode>();
        }
    }

    private int hashFunction( K key ){
        int hashcode = key.hashCode();
        int bi = hashcode % buckets.length;
        return bi;
    }

    private void reHash(){
        LinkedList<hashmapNode>[] oldbuckets = buckets;
        buckets = new LinkedList[2 * oldbuckets.length];
        for( int i = 0 ; i < buckets.length ; i++ ){
            buckets[i] = new LinkedList<hashmapNode>();
        }
        for( int i = 0 ; i < oldbuckets.length ; i++ ){
            for( hashmapNode currNode : oldbuckets[i] ){
                put( currNode.key, currNode.value );
            }
        }
    }

    private int findInBucket( int bi, K key ){
        int i = 0;
        for( hashmapNode currNode : buckets[bi] ){
            if( currNode.key == key ){
                return i;
            }
            i++;
        }
        return -1;
    }

    public void put(K key, V value) {
        //
        int bi = hashFunction( key );   // bucket index;
        int di = findInBucket( bi, key );   // data index
        if( di != -1 ){
            
            hashmapNode oldNode = buckets[bi].get(di);
            oldNode.value = value;
        }else{
            hashmapNode nn = new hashmapNode(key, value );
            buckets[bi].addLast(nn);
            this.size++;
        }
        if(  ( 1.0 * this.size / buckets.length) > 2.0 ){
            reHash();
        }
    }

    public V remove( K key ) {
        int bi = hashFunction( key );
        int di = findInBucket( bi, key );

        if( di == -1 ){
            return null;
        }else{
            hashmapNode delNode = buckets[bi].remove(di);
            this.size--;
            return delNode.value;
        }
    }

    public int size(){
        return this.size;
    }

    public V get(K key) {
       int bi = hashFunction( key );
       int di = findInBucket( bi, key );
       if( di == -1 ){
           return null;
       }else{
           return buckets[bi].get(di).value;
       }
    }

    public boolean containsKey( K key ) {
        int bi = hashFunction( key );
        int di = findInBucket( bi, key );
        if( di == -1 ){
            return false;
        }else{
            return true;
        }
    }

    public Set<K> keySet(){
        Set<K> ks = new HashSet<>();

        for( int i = 0 ; i < buckets.length ; i++ ){
            for( hashmapNode currNode : buckets[i] ){
                ks.add( currNode.key );
            }
        }
        return ks;
    }

}
