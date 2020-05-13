import java.util.*;  

public class PQ <Type extends Comparable<Type>>{
    ArrayList<Type> pq ;        
    PQ(){
        pq = new ArrayList<Type>();
    }
    
    private void swap( int i, int j ){
        Type temp = pq.get( i );
        pq.set(i, pq.get(j));
        pq.set(j, temp);
    }

    private void upheapify( int ci ){
        int pi = (ci - 1) / 2;
        if( ci != 0 && willSwap( pi, ci ) == true ){
            swap( pi, ci );
            upheapify( pi );
        }
    }

    private void downheapify( int pi ){
        int lci = ( 2 * pi ) + 1;
        int rci = ( 2 * pi ) + 2;
        int swapIdx = pi;
        if( lci < pq.size() && willSwap( pi, lci ) ){
            swapIdx = lci;
        }
        if( rci < pq.size() && willSwap( pi, rci ) ){
           if( swapIdx == lci) {
               if( willSwap( lci, rci ) ) 
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

    private boolean willSwap( int i, int j ){
        Type ith = pq.get( i );
        Type jth = pq.get( j );

        if( ith.compareTo( jth ) > 0 ){
            return true;
        }else{
            return false;
        }
    }
    
    //-----------------------------------------------------------

    public void add( Type x ){
        pq.add( x );
        upheapify( pq.size() - 1 );
    }

    public Type peek(){
        if( pq.size() == 0 ){
            System.out.println( "Priority Queue is empty" );
            return null;
        }else{
            return pq.get( 0 );
        }
    }

    public Type remove(){
        if( pq.size() == 0 ){
            System.out.println( "Priority Queue is empty" );
            return null;
        }else{
            Type remVal = pq.get(0);
            swap( 0, pq.size() - 1 );
            pq.remove( pq.size() - 1 );
            downheapify(0);
            return remVal;
        }
    }
    
    public int size(){
        return pq.size();
    }
    
    
}