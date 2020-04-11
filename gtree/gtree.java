import java.util.*;
class gtree{
    static node root = null;
    
    static class node{
        int data;
        ArrayList<node> child;
        node(int d){
            this.data = d;
            this.child = new ArrayList<>();
        }
    }

    public static void treeConstruct(int[] data){
        ArrayList<node> cplist = new ArrayList<>();
        for( int i = 0 ; i < data.length ; i++){
            if( data[i] == -1 ){
                cplist.remove(cplist.size()-1);
            }else{
                node currNode = new node(data[i]);
                if( root == null){
                    root = currNode;
                }else{
                    node cp = cplist.get(cplist.size()-1);
                    cp.child.add(currNode);
                }
                cplist.add(currNode);
            }
        }
    }



    public static void display(node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ->");
        for(int i=0;i<root.child.size();i++){
            System.out.print(root.child.get(i).data+", ");
        }
        System.out.println(".");
        for(int i=0;i<root.child.size();i++){
            display(root.child.get(i));
        }
    }

    public static int size(node root) {
         if( root == null ){
             return 0;
         }  
        int mysize = 1;
        for( int i = 0;i < root.child.size() ; i++ ){
            mysize += size( root.child.get(i) );
        }
        return mysize;
    }

    public static int height( node root ) {
        if( root == null ){
            return 0;
        }
        int myheight = 0;
        for( int i = 0 ; i < root.child.size() ; i++ ){
            myheight = Math.max( myheight, height( root.child.get(i) ) );
        }
        return myheight + 1;
    }



    public static int max(node root){
        if( root == null ){
            return -1;
        }
        int mymax = root.data;
        for( int i = 0 ; i < root.child.size() ; i++ ){
            int childMax = max( root.child.get(i) );
            if( childMax > mymax ){
                mymax = childMax;
            }
        }
        return mymax;
    }


    public static boolean find( node root , int val ) {
        if( root == null ){
            return false;
        }
        if( root.data == val ){
            return true;
        }

        for( int i = 0; i < root.child.size() ; i++ ){
            boolean ans = find ( root.child.get(i) , val );
            if( ans == true ){
                return true;
            }
        }
        return false;
    }


    public static ArrayList<Integer> n2rpath(node root,int val){
        if( root == null ){
            return null;
        }
        if( root.data == val ){
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(root.data);
            return ans;
        }
        for( int i = 0 ; i < root.child.size() ; i++ ){
            ArrayList<Integer> recAns =  n2rpath( root.child.get(i),val );
            if( recAns != null ){
                recAns.add(root.data);
                return recAns;
            }
        }
        return null;
    }


    public static int LCA( node root, int d1, int d2 ) {
        ArrayList<Integer> n2rPathOfD1 = n2rpath( root, d1 );
        ArrayList<Integer> n2rPathOfD2 = n2rpath( root, d2 );
        int i = n2rPathOfD1.size() -1;
        int j = n2rPathOfD2.size() -1;
        while( i >=0 && j >=0){
            if( n2rPathOfD1.get(i) != n2rPathOfD2.get(j) ){
                break;
            }
            i--;    j--;
        }
        return n2rPathOfD1.get(i+1);
    }
    
    public static  void displayLO( node root ) {
        Queue<node> qu = new LinkedList<>();
        qu.add( root );
        while( qu.size() > 0 ){
            node currNode = qu.remove();
            System.out.print(currNode.data +" ");
            for( int i = 0 ; i < currNode.child.size() ; i++ ){
                qu.add( currNode.child.get(i) );
            }
        }        
    }

    public static void main(String[] args) {
        int[] data = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100};
        treeConstruct(data);
        // display(root);
        // System.out.println(find(root,95));
        // ArrayList<Integer> ans = n2rpath(root,75);
        // System.out.println(ans);
        // System.out.println( LCA( root, 110, 120 ));
        // displayLO(root);
        System.out.println( height(root) );
    }
}
