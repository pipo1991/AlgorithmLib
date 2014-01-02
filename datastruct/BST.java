class BST{

    private BST right;
    private BST left;
    int data;
    
    
    BST(int x){
        data=x;
        right=null;
        left=null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BST getLeft() {
        return left;
    }

    public void setLeft(BST left) {
        this.left = left;
    }

    public BST getRight() {
        return right;
    }

    public void setRight(BST right) {
        this.right = right;
    }
    
    //Using Recursion
    static void insertNode(BST root, int x){
        if(root.getData()==x)
            return;
        if(x<root.getData()){
            if(root.getLeft()==null)
                root.setLeft(new BST(x));
            else
              insertNode(root.getLeft(),x);
        }
        else{
            if(root.getRight()==null)
                root.setRight(new BST(x));
            else
              insertNode(root.getRight(),x);
        }    
    }
    
    static int deleteNode(BST root, int x){
        BST parent=root;
        BST temp=root;
       while(temp!=null && temp.getData()!=x){
           parent=temp;
           if(x<temp.getData()){
               temp=temp.getLeft();
           }else{
               temp=temp.getRight();
           }
       }
       if(temp==null){
           //Not Found
           return -1;
       }
       while(true){
           if(temp.getLeft()==null && temp.getRight()==null){
               if(parent.getLeft()!=null && parent.getLeft().getData()==temp.getData()){
                   parent.setLeft(null);
               }else{
                   parent.setRight(null);
               }
               break;
           }
           else if(temp.getLeft()!=null){
               temp.setData(temp.getLeft().getData());
               BST child=temp.getLeft();
               if(child.getLeft()==null && child.getLeft()==null){
                   temp.setLeft(null);
                   break;
               }
               temp=child;
           }
           else if(temp.getRight()!=null){
               temp.setData(temp.getRight().getData());
               BST child=temp.getRight();
               if(child.getLeft()==null && child.getLeft()==null){
                   temp.setRight(null);
                   break;
               }
               temp=child;
           }
       }
       //Deleted
       return 1;
    }
    
    static int search(BST root, int x){
        if(root== null)
            return 0;
        if(root.getData()==x){
            return 1;
        }
        if(x<root.getData()){
            return search(root.getLeft(), x);
        }
        return search(root.getRight(), x);
    }
    
    static int getMaxDepth(BST bst){
        if(bst.getRight()==null && bst.getLeft()==null)
            return 1;
        return Math.max(getMaxDepth(bst.getLeft()),getMaxDepth(bst.getRight()))+1;
    }
}
