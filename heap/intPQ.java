import java.util.*;
class intPQ{
    static ArrayList<Integer> pq = new ArrayList<>();    
    private static void swap( int i, int j ){
        int temp = pq.get( i );
        pq.set(i, pq.get(j));
        pq.set(j, temp);
    }

    private static void upheapify( int ci ){
        int pi = (ci - 1) / 2;
        if( ci != 0 && pq.get(pi) > pq.get(ci) ){
            swap( pi, ci );
            upheapify( pi );
        }
    }

    private static void downheapify( int pi ){
        int lci = ( 2 * pi ) + 1;
        int rci = ( 2 * pi ) + 2;
        int swapIdx = pi;
        if( lci < pq.size() && pq.get( pi ) > pq.get(lci) ){
            swapIdx = lci;
        }
        if( rci < pq.size() && pq.get( pi ) > pq.get(rci) ){
           if( swapIdx == lci) {
               if(pq.get(lci) > pq.get(rci) ) 
                swapIdx = rci;
            }else{
                swapIdx = rci;
            }
        }
        if( swapIdx != pi ){
            swap( pi, swapIdx );
            downheapify( swapIdx );
        }
    }
    
    //-----------------------------------------------------------

    public static void add( int x ){
        pq.add( x );
        upheapify( pq.size() - 1 );
    }

    public static int peek(){
        if( pq.size() == 0 ){
            System.out.println( "Priority Queue is empty" );
            return Integer.MIN_VALUE;
        }else{
            return pq.get( 0 );
        }
    }

    public static int remove(){
        if( pq.size() == 0 ){
            System.out.println( "Priority Queue is empty" );
            return Integer.MIN_VALUE;
        }else{
            int remVal = pq.get(0);
            swap( 0, pq.size() - 1 );
            pq.remove( pq.size() - 1 );
            downheapify(0);
            return remVal;
        }
    }
    public static int size(){
        return pq.size();
    }
    
    public static void main(String[] args) {
        add( 10 );
        add( 5 );
        System.out.println( peek() );
        add(34);
        add(1);
        add(8);
        System.out.println(remove());        
        System.out.println(remove());
        add(9);
        while( size() > 0 ){
            System.out.println(remove());
        }
    }
}
