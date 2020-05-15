import java.util.*;
class medianPQ{
    public static void printMedian( int[] arr ) {
        double median = 0;
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder()); // left hand side elements
        PriorityQueue<Integer> min = new PriorityQueue<>(); // right hand side elements
        for( int i = 0 ; i < arr.length ; i++ ){
            int ele = arr[i];
            if( max.size() == min.size() ){
                if( ele < median ){
                    max.add( ele );     median = max.peek();
                }else{
                    min.add( ele );     median = min.peek();
                }
            }else if( max.size() > min.size() ){
                if( ele < median ){
                    min.add( max.remove() );    max.add( ele );
                }else{
                    min.add( ele );
                }
                median = (1.0 *(max.peek() + min.peek()))/2;
            }else{
                if( ele < median ){
                    max.add( ele );
                }else{
                    max.add( min.remove() );    min.add(ele);
                }
                median = (1.0 *(max.peek() + min.peek()))/2;
            }
            System.out.print(median+"  ");
        }
    }
    public static void main(String[] args) {
        int[] arr = {3,5,4,9,12,6,3,8,7};
        printMedian(arr);
    }
}