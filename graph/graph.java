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

    static int mincost = Integer.MAX_VALUE;
    static int maxcost = Integer.MIN_VALUE;
    static String minpath = "";
    static String maxpath = "";


    public static void longestAndShortestPaths( ArrayList<ArrayList<edge>> graph,int s,int d,boolean[] visited,String psf,int csf ){

        if( s == d ){
            psf = psf+d;
            if( csf < mincost ){
                mincost = csf;
                minpath = psf;
            }
            if(csf > maxcost){
                maxcost = csf;
                maxpath = psf;
            }
            return;
        }
        visited[s] = true;
        for( int e = 0 ; e < graph.get(s).size() ; e++ ){
            edge ce = graph.get(s).get(e);
            if( visited[ce.nbr] == false ){
                longestAndShortestPaths( graph,ce.nbr,d,visited,psf+s+" -> ",csf+ce.wt );
            }
        }
        visited[s] = false;
    }

    static int cCost = Integer.MAX_VALUE;
    static int fCost = Integer.MIN_VALUE;
    static String cPath = "";
    static String fPath = "";
    public static void cAndFPaths( ArrayList<ArrayList<edge>> graph,int s,int d,boolean[] visited,String psf,
                                    int csf ,int factor){
        if( s == d ){
            psf = psf+d;
            if( csf > factor ){
                if( cCost > csf ){
                    cCost = csf;
                    cPath = psf;
                }
            }
            if( csf < factor ){
                if( csf > fCost ){
                    fCost = csf;
                    fPath = psf;
                }
            }
            return;
        }
        visited[s] = true;
        for( int e = 0 ; e < graph.get(s).size() ; e++ ){
            edge ce = graph.get(s).get(e);
            if( visited[ce.nbr] == false ){
                cAndFPaths( graph,ce.nbr,d,visited,psf+s+" -> ",csf+ce.wt , factor);
            }
        }
        visited[s] = false;
    }


    public static void kthLargestPath(ArrayList<ArrayList<edge>> graph,int s,int d,int k){
        // fCost = Integer.MIN_VALUE;
        int factor = Integer.MAX_VALUE;
        boolean[] visited = new boolean[graph.size()];
        for( int i = 0; i < k ; i++ ){
            fCost = Integer.MIN_VALUE;
            cAndFPaths(graph,s,d,visited,"",0,factor);
            factor = fCost;
        }
        System.out.println( fPath +" @ " + fCost );
    }


    public static void hamiltonianPathAndCycle( ArrayList<ArrayList<edge>> graph,int s, ArrayList<Integer> psf,
                                                boolean[] visited, int os ) {
        if( psf.size() == graph.size() - 1 ){
            psf.add( s );
            for( int i = 0 ; i < psf.size() ; i++ ){
                System.out.print(psf.get(i)+" ");
            }
            boolean isCycle = false;
            for( int e = 0 ; e < graph.get(s).size() ; e++ ){
                edge ce = graph.get(s).get(e);
                if( ce.nbr == os ){
                    isCycle = true;
                    break;
                }
            }
            if( isCycle ){
                System.out.println(".");
            }
            System.out.println();
            psf.remove(psf.size()-1);
            return;
        }

        visited[s] = true;
        psf.add(s); // why arraylist?
        for( int e = 0 ; e < graph.get(s).size() ; e++ ){
            edge ce = graph.get(s).get(e);
            if( visited[ce.nbr] == false ){
                hamiltonianPathAndCycle(graph,ce.nbr,psf,visited,os);
            }
        }
        psf.remove(psf.size() -1);
        visited[s] = false;
    }

    public static void getComponent(ArrayList<ArrayList<edge>> graph,ArrayList<Integer> comp,boolean[] visited, int s){
        visited[s] = true;
        comp.add(s);
        for( int e = 0 ; e < graph.get(s).size() ; e++ ){
            edge ce = graph.get(s).get(e);
            if( visited[ce.nbr] == false ){
                getComponent(graph,comp,visited,ce.nbr);
            }
        }
    }

    public static int connectedComponents(  ArrayList<ArrayList<edge>> graph ){
        boolean[] visited = new boolean[graph.size()];
        int count = 0;
        // ArrayList<ArrayList<Integer>> allComps = new ArrayList<>();
         for( int v = 0 ; v < graph.size() ; v++ ){
            if( visited[v] == false ){
                count++;
                ArrayList<Integer> singleComp = new ArrayList<>();
                getComponent( graph, singleComp, visited, v );
                System.out.println(singleComp);
                // allComps.add(singleComp);
            }
        }
        return count;
    }

    static class bfsHelper implements Comparable<bfsHelper>{
        int vtx;
        String path;
        int cost;
        bfsHelper( int v, String p, int c ){
            this.vtx = v; this.path = p; this.cost = c;
        }
        public int compareTo( bfsHelper other ){
                return this.cost - other.cost;
        }
    }

    public static void bfsTraversal(ArrayList<ArrayList<edge>> graph, int s){
        Queue<bfsHelper> qu = new LinkedList<>();
        boolean[] visited = new boolean[graph.size()];
        qu.add( new bfsHelper(s, ""+s+" -> ",0) );
        visited[0] = true;
        while( qu.size() > 0 ){
            // remove
            bfsHelper cv = qu.remove();
            // mark
            // if( visited[cv.vtx] ){
            //     continue;
            // }else{
            //     visited[cv.vtx] = true;
            // }
            // work
            System.out.println( cv.path +" @ "+cv.cost );
            // add nbrs
            for( int e =  0 ; e < graph.get(cv.vtx).size() ; e++ ){
                edge ce = graph.get(cv.vtx).get(e);
                if( visited[ce.nbr] == false ){
                    visited[ce.nbr] = true;
                    qu.add( new bfsHelper( ce.nbr, cv.path + ce.nbr+" -> ",cv.cost+ce.wt) );
                }
            }
        }
    }

    public static void dijkstra(ArrayList<ArrayList<edge>> graph,int s){
        PriorityQueue<bfsHelper> pq = new PriorityQueue<>();
        //PriorityQueue<bfsHelper> pq = new PriorityQueue<>(Collections.reverseOrder());  max priorityQueue
        boolean[] visited = new boolean[graph.size()];
        bfsHelper root = new bfsHelper( s, ""+s,0 );
        pq.add( root );
        while( pq.size() > 0 ){
            // remove
            bfsHelper cv = pq.remove();
            // mark
            if( visited[cv.vtx] == true ){
                continue;
            }else{
                visited[cv.vtx] = true;
            }
            // work
            System.out.println( cv.path + " @ " + cv.cost );
            for( int i = 0; i <graph.get( cv.vtx ).size() ; i++ ){
                edge ce = graph.get( cv.vtx ).get(i);
                if( visited[ ce.nbr ] == false ){
                    bfsHelper newvtx = new bfsHelper( ce.nbr, cv.path +"->" +ce.nbr , cv.cost + ce.wt );
                    pq.add( newvtx );
                }
            }
        }
    }

    static class primsHelper implements Comparable<primsHelper>{
        int vtx;
        int par;
        int wt;
        primsHelper( int v, int p, int dis ){
            vtx = v; par = p; wt = dis;
        }
        public int compareTo( primsHelper other){
            return this.wt - other.wt;
        }
    }
    public static void primsMST(ArrayList<ArrayList<edge>> graph){
        ArrayList<ArrayList<edge>> mst = new ArrayList<>();
        for( int i = 0 ; i < graph.size() ; i++ ){
            mst.add( new ArrayList<edge>() );
        }
        PriorityQueue<primsHelper> pq = new PriorityQueue<>();
        primsHelper rootNode = new primsHelper(2, -1 , 0  );
        pq.add( rootNode );
        boolean[] visited = new boolean[graph.size()];
        while( pq.size() > 0 ){
            primsHelper cv = pq.remove();
            // mark
            if( visited[cv.vtx] == true ){
                continue;
            }else{
                visited[cv.vtx] = true;
            }
            // work
            if( cv.par != -1 ){
                   addEdge( mst, cv.vtx, cv.par, cv.wt  );
            }
            // add nbrs
            for( int i = 0; i <graph.get( cv.vtx ).size() ; i++ ){
                edge ce = graph.get( cv.vtx ).get(i);
                if( visited[ ce.nbr ] == false ){
                    primsHelper newvtx = new primsHelper(ce.nbr, cv.vtx, ce.wt );
                    pq.add( newvtx );
                }
            }
        }
        display( mst );
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
        addEdge(graph,2,5,5);   // for hamiltonian cycle. 
        addEdge(graph,3,4,2);
        addEdge(graph,4,5,3);
        addEdge(graph,5,6,3);
        addEdge(graph,4,6,8);
        addEdge(graph,0,6,30);
        // display(graph);
        boolean[] visited =  new boolean[graph.size()];
        // System.out.println( hasPath(graph,0,6,visited) );
        // printAllPaths(graph,0,6,visited,"");
        // longestAndShortestPaths(graph,0,6,visited,"",0);
        // System.out.println( minpath +" @ " + mincost );
        // System.out.println( maxpath +" @ " + maxcost );

        // cAndFPaths(graph,0,6,visited,"",0,48);
        // System.out.println( cPath +" @ " + cCost );
        // System.out.println( fPath +" @ " + fCost );

        // kthLargestPath(graph,0,6,1);
        // hamiltonianPathAndCycle( graph,0,new ArrayList<Integer>(),visited,0 );
        // int comps = connectedComponents( graph );
        // System.out.println(comps);
        // bfsTraversal(graph, 0);
        // dijkstra( graph,0 );
        primsMST(graph);
    }
}