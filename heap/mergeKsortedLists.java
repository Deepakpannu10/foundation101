import java.util.*;
class mergeKsortedLists{
    static class pair implements Comparable<pair>{
        int idx;
        ArrayList<Integer> arr;
        pair( int i, ArrayList<Integer> list ){
            idx = i; arr = list;
        }
        public int compareTo( pair other ){
            return this.arr.get(this.idx) - other.arr.get( other.idx );
        }
    }
    public static ArrayList<Integer> merge( ArrayList<ArrayList<Integer>> al ) {
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<pair> pq = new PriorityQueue<>();
        for( int i = 0 ; i < al.size() ; i++ ){
            pq.add( new pair( 0, al.get(i) ));
        }
        while( pq.size() > 0 ){
            pair cp = pq.remove();
            ans.add( cp.arr.get(cp.idx) );
            cp.idx++;
            if( cp.idx < cp.arr.size() ){
                pq.add( cp );
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> al =  new ArrayList<>();
        for( int i = 0; i < 3 ; i++ ){
            al.add( new ArrayList<Integer>());
            for( int j = 0 ; j < 5 ; j++ ){
                al.get( i ).add(scn.nextInt());
            }
        }
       ArrayList<Integer> ans = merge( al );
        System.out.println(ans);
    }
}