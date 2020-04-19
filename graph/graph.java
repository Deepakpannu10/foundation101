import java.util.*;
class graph{
    static class edge{
        int src;  // src
        int nbr;  // nbr
        int wt; // weight
        edge(int v1,int v2,int wt){
            this.src= v1;
            this.nbr=v2;
            this.wt = wt;
        }
    }
    public static void addEdge( ArrayList<ArrayList<edge>> graph, int src,int nbr, int wt ) {
        graph.get( src ).add(new edge(src,nbr,wt));
        graph.get( nbr ).add(new edge(nbr,src,wt));
    }
    
    public static void display(ArrayList<ArrayList<edge>> graph){
        for( int i = 0 ; i < graph.size() ; i++ ){
            System.out.print( i +" -> " );
            for( int j = 0 ; j < graph.get(i).size() ; j++ ){
                edge ce = graph.get(i).get(j);
                System.out.print("["+ ce.nbr +" @ " + ce.wt + "], ");
            }
            System.out.println();
        }
    }

    public static boolean hasPath(ArrayList<ArrayList<edge>> graph, int s ,int d,boolean[] visited){
        if( s == d ){
            return true;
        }
        visited[ s ] = true;
        for( int e = 0 ; e < graph.get(s).size() ; e++ ){
            edge ce = graph.get(s).get(e);
            if( visited[ce.nbr] == false ){
                boolean recAns = hasPath( graph, ce.nbr, d, visited );
                if( recAns ) return true;
            }
        }
        return false;
    }


    public static void printAllPaths( ArrayList<ArrayList<edge>> graph, int s ,int d,boolean[] visited, String psf  ) {
        
        if( s == d ){
            psf = psf + d;
            System.out.println(psf);
            return;
        }
        visited[s] = true;
        for( int e = 0 ; e < graph.get(s).size() ; e++ ){
            edge ce = graph.get(s).get(e);
            if( visited[ce.nbr] == false ){
                printAllPaths( graph , ce.nbr,d,visited,psf+s+" -> " );
            }
        }
        visited[s] = false;
    }


    public static void main(String[] args) {   
        ArrayList<ArrayList<edge>> graph = new ArrayList<>();
        for( int i = 0 ; i <= 6 ; i++ ){
            graph.add(new ArrayList<edge>());
        }
        addEdge(graph,0,1,10);
        addEdge(graph,0,3,40);
        addEdge(graph,1,2,10);
        addEdge(graph,2,3,10);
        addEdge(graph,3,4,2);
        addEdge(graph,4,5,3);
        addEdge(graph,5,6,3);
        addEdge(graph,4,6,8);
        // display(graph);
        boolean[] visited =  new boolean[graph.size()];
        // System.out.println( hasPath(graph,0,6,visited) );
        printAllPaths(graph,0,6,visited,"");
    }
}