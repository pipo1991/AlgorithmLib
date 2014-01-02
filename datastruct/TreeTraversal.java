class TreeTraversal{
    static void preOrderTraversal(BST bst,StringBuilder out){
        if(out.length()>0)
            out.append(",");
        out.append(bst.data);
        if(bst.getLeft()!=null)
             preOrderTraversal(bst.getLeft(), out);
        if(bst.getRight()!=null)
             preOrderTraversal(bst.getRight(), out);
    }
    
     static void inOrderTraversal(BST bst,StringBuilder out){
        if(bst.getLeft()!=null)
             inOrderTraversal(bst.getLeft(), out);
        if(out.length()>0)
            out.append(",");
        out.append(bst.data);
        if(bst.getRight()!=null)
             inOrderTraversal(bst.getRight(), out);
    }
     
      static void postOrderTraversal(BST bst,StringBuilder out){
        if(bst.getLeft()!=null)
             postOrderTraversal(bst.getLeft(), out);
        if(bst.getRight()!=null)
             postOrderTraversal(bst.getRight(), out);
        if(out.length()>0)
            out.append(",");
        out.append(bst.data);
    }
}
