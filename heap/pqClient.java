import java.util.*;
class pqClient{
    static class Student implements Comparable<Student> {
        String name;
        int marks;

        Student( String n, int m ){
            this.name  = n;     this.marks = m;
        }
        public int compareTo(Student other){
            return this.marks - other.marks;
        }
    }


    public static void kLargest(int[] arr, int k) {
        // time - O ( nlogk )-- worst case updated after video stopped....
        // space = O( k )
        PQ<Integer> pq = new PQ<Integer>();
        int i = 0;
        while( i < arr.length && pq.size() < k ){
            pq.add( arr[i] );
            i++;
        }

        while( i < arr.length ){
            if( pq.peek() < arr[i] ){
                pq.remove();    pq.add( arr[i] );
            }
            i++;
        }

        while( pq.size() > 0 ){
            System.out.println( pq.remove() );
        }
    }



    public static void main(String[] args) {
        // PQ<Student> pq = new PQ<>();
        // pq.add( new Student( "deepak", 55 ) );
        // pq.add( new Student( "abc", 53 ) );
        // pq.add( new Student( "xyz", 34 ) );
        // pq.add( new Student( "pqr", 69 ) );
        // // Student lowest = pq.peek();
        // // System.out.println( lowest.name  + " "+ lowest.marks);
        // pq.add( new Student( "dddd", 97 ) );
        // pq.add( new Student( "ssss", 14 ) );
        // pq.add( new Student( "fffff", 89 ) );
        
        // // pq.upheapify( 2 );
        // while( pq.size() > 0 ){
        //     Student stud = pq.remove();
        // System.out.println( stud.name  + " "+ stud.marks);
        // }

        int[] data ={ 2,10,20,5,17,6,4,3,8,9,22 };
        kLargest( data, 4 );
    }
}