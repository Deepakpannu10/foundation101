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


    public static void main(String[] args) {
        PQ<Student> pq = new PQ<>();
        pq.add( new Student( "deepak", 55 ) );
        pq.add( new Student( "abc", 77 ) );
        pq.add( new Student( "xyz", 34 ) );
        pq.add( new Student( "pqr", 69 ) );
        Student lowest = pq.peek();
        System.out.println( lowest.name  + " "+ lowest.marks);
        pq.add( new Student( "dddd", 97 ) );
        pq.add( new Student( "ssss", 14 ) );
        // pq.upheapify( 2 );
        while( pq.size() > 0 ){
            Student stud = pq.remove();
        System.out.println( stud.name  + " "+ stud.marks);
        }
    }
}