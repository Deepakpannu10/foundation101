import java.util.*;

class btree{

    static node root = null;

    static class node{
        int data;
        node left;
        node right;

        node(int d){
            this.data = d;
            this.left = this.right = null;
        }
    }

    public static void constuct(int[] data){
        ArrayList<node> cplist = new ArrayList<>();
        for( int i = 0; i < data.length ; i++){
            if( data[i] == -1){
                cplist.remove(cplist.size()-1);
            }else{
                node currNode = new node(data[i]);
                if( root == null ){
                    root = currNode;
                }else{
                    node cp =  cplist.get(cplist.size()-1);
                    if( cp.left == null ){
                        cp.left =currNode;
                    }else{
                        cp.right = currNode;
                    }
                }
                cplist.add(currNode);
            }
        }
    }

    public static void display(node root){
        if( root == null ){
            return ;
        }
        if( root.left != null ){
            System.out.print(root.left.data + " -> ");
        }
        System.out.print(root.data + " ");
        if(root.right != null){
            System.out.print( " <- " +root.right.data );            
        }
        System.out.println(".");
        if(root.left != null){
            display( root.left );
        }
        if(root.right != null){
            display( root.right );
        }
    }



    public static int size( node root ){
        if( root == null ){
            return 0;
        }
        int mysize = 1;
        if( root.left != null ){
            mysize += size( root.left );
        }
        if( root.right != null ){
            mysize += size( root.right );
        }
        return mysize;
    }

    public static int height( node root ){
        if( root == null){
            return 0;
        }
        int myheight = 0;
        if( root.left != null ){
            myheight = height( root.left );
        }
        if( root.right != null ){
            myheight = Math.max( myheight , height( root.right ) );
        }
        return myheight + 1;
    }

    public static int max( node root ) {
        if( root == null ){
            return -1;
        }
        int mymax = root.data;
        if( root.left != null ){
            mymax = Math.max( mymax , max( root.left ) );
        }
        if( root.right != null ){
            mymax = Math.max( mymax , max( root.right ) );
        }
        return mymax;
    }

    public static void preOrder( node root ){
        if( root == null ){
            return;
        }
        System.out.print( root.data+", ");
        if( root.left != null){
            preOrder( root.left );
        }
        if(root.right != null ){
            preOrder(root.right);
        }
    }
    public static void inOrder( node root ){
        if( root == null ){
            return;
        }
        if( root.left != null){
            inOrder( root.left );
        }
        System.out.print( root.data+", ");
        if(root.right != null ){
            inOrder(root.right);
        }
    }
    public static void postOrder( node root ){
        if( root == null ){
            return;
        }
        if( root.left != null){
            postOrder( root.left );
        }
        if(root.right != null ){
            postOrder(root.right);
        }
        System.out.print( root.data+", ");
    }

    public static node preInConst( int[] pre , int[] in , int ps , int pe , int is , int ie ) {
        if( is == ie || ps == pe ){
            node baseNode = new node(pre[ps]);
            return baseNode;
        }        
        node croot = new node(pre[ ps ]);
        int i = is;
        int count = 0;
        while( pre[ps] != in[i] ){
            i++;
            count++;
        }
        croot.left = preInConst( pre , in , ps+1, ps+count, is , i - 1  );
        croot.right = preInConst( pre, in, ps+count+1, pe, i+1, ie  );
        return croot;
    }
    

    // Post and Inoder construct...homework

    public static void preOrderIterative( node root ) {
        ArrayList<node> stack = new ArrayList<>();
        stack.add(root);
        while(stack.size() > 0){
            node currNode = stack.remove( stack.size() - 1 );
            System.out.print(currNode.data+" ");
            if(currNode.right != null){
                stack.add(currNode.right);
            }
            if(currNode.left != null){
                stack.add(currNode.left);
            }
        }
    }


    static class diaHelper{
        int d = 0 ;     // diameter
        int h = 0;      // height
    }

    public static diaHelper diameterDP( node root ) {
        if(root == null){
            diaHelper baseAns = new diaHelper();
            return baseAns;
        }
        diaHelper left = diameterDP(root.left);
        diaHelper right = diameterDP(root.right);
        diaHelper myans = new diaHelper();
        myans.d = Math.max( left.h + right.h + 1, Math.max(left.d, right.d) );
        myans.h = Math.max( left.h, right.h ) + 1;
        return myans;
    }


    static class balHelper{
        int h = 0;
        boolean b = true;
    }


    public static balHelper isBalancedDP(node root){
        if(root == null){
            balHelper baseAns = new balHelper();
            return baseAns;
        }

        balHelper left = isBalancedDP(root.left);
        balHelper right = isBalancedDP(root.right);
        balHelper myans = new balHelper();

        myans.b = left.b && right.b && ( left.h - right.h >= -1 && left.h - right.h <= 1 );
        myans.h = Math.max( left.h, right.h ) + 1;
        return myans;
    }






    public static void main(String[] args) {
        int[] data = {10,20,30,80,-1,-1,40,-1,-1,50,70,-1,60};
        constuct(data);
        // display( root );
        // System.out.println( " size = " +size( root ));
        // System.out.println(" height = " +height( root ));
        // System.out.println(" max = " + max( root ));

        // System.out.println("preOrder :");
        // preOrder(root);
        // System.out.println();
        // System.out.println("inOrder :");
        // inOrder(root);
        // System.out.println();
        // System.out.println("postOrder :");
        // postOrder(root);
        // int[] pre = {10,20,30,4,5,40,1,80,50,60,2,90,70,100,3};
        // int[] in = {4,30,5,20,1,40,80,10,2,60,90,50,100,70,3};
        // node root1 = preInConst(pre, in , 0 , pre.length -1 , 0 , in.length - 1 );
        // display( root1 );
        // preOrderIterative(root);
        // diaHelper ans = diameterDP(root);
        // System.out.println(ans.d);
        balHelper ans = isBalancedDP(root);
        System.out.println(ans.b);
    }
}