//Manipulate class for BST
class BSTree {

    private BST tree;

    public BSTree() {
        tree = null;
    }

    void add(int x) {
        if (tree == null) {
            tree = new BST(x);
        } else {
            BST.insertNode(tree, x);
        }
    }

    void delete(int x) {
        if (tree != null) {
            boolean flag = tree.isOnlyRoot();
            int returnVal = BST.deleteNode(tree, x);
            if (flag && returnVal == 1) {
                tree = null;
            }
        } else {
            System.out.println("Warning !! Deleting from an empty tree.");
        }
    }

    int search(int x) {
        return BST.search(tree, x);
    }

    int getMax() {
        return BST.getMax(tree);
    }

    int getMin() {
        return BST.getMin(tree);
    }

    int getDepth() {
        return BST.getMaxDepth(tree);
    }
}
// simple implemantation for simple unbalnced BST
class BST {

    private BST parent;
    private BST right;
    private BST left;
    int data;

    BST(int x) {
        data = x;
        right = null;
        left = null;
        parent = null;
    }

    BST(int x, BST p) {
        data = x;
        right = null;
        left = null;
        parent = p;
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

    public BST getParent() {
        return parent;
    }

    public void setParent(BST parent) {
        this.parent = parent;
    }

    //Using Recursion
    static void insertNode(BST root, int x) {
        if (root.getData() == x) {
            return;
        }
        if (x < root.getData()) {
            if (root.getLeft() == null) {
                root.setLeft(new BST(x, root));
            } else {
                insertNode(root.getLeft(), x);
            }
        } else {
            if (root.getRight() == null) {
                root.setRight(new BST(x, root));
            } else {
                insertNode(root.getRight(), x);
            }
        }
    }

    static int deleteNode(BST root, int x) {
        BST parentTemp = null;
        BST temp = root;
        while (temp != null && temp.getData() != x) {
            parentTemp = temp;
            if (x < temp.getData()) {
                temp = temp.getLeft();
            } else {
                temp = temp.getRight();
            }
        }
        if (temp == null) {
            //Not Found
            return -1;
        }
        if (temp.getRight() == null && temp.getLeft() == null) {
            if(parentTemp !=null){
                if (parentTemp.getRight() != null && parentTemp.getRight().getData() == temp.getData()) {
                    parentTemp.setRight(null);
                } else {
                    parentTemp.setLeft(null);
                }
            }
        } else if (temp.getLeft() == null) {
            if(parentTemp !=null){
                if (parentTemp.getRight() != null && parentTemp.getRight().getData() == temp.getData()) {
                    parentTemp.setRight(temp.getRight());
                } else {
                    parentTemp.setLeft(temp.getRight());
                }
            }else{
               temp.setData(temp.getRight().getData());
               temp.setRight(null);
            }
        } else if (temp.getRight() == null) {
            if(parentTemp !=null){
                if (parentTemp.getRight().getData() == temp.getData()) {
                    parentTemp.setRight(temp.getLeft());
                } else {
                    parentTemp.setLeft(temp.getLeft());
                }
            }else{
               temp.setData(temp.getLeft().getData());
               temp.setLeft(null);
            }
        } else {
            int data = deleteMin(temp.getRight());
            temp.setData(data);
        }
        //Deleted
        return 1;
    }

    public boolean isOnlyRoot() {
        return this.left == null && this.right == null;
    }

    static int search(BST root, int x) {
        if (root == null) {
            return 0;
        }
        if (root.getData() == x) {
            return 1;
        }
        if (x < root.getData()) {
            return search(root.getLeft(), x);
        }
        return search(root.getRight(), x);
    }

    static int getMaxDepth(BST bst) {
        if (bst == null) {
            return 0;
        }
        return Math.max(getMaxDepth(bst.getLeft()), getMaxDepth(bst.getRight())) + 1;
    }

    static int getMin(BST bst) {
        BST temp = bst;
        while (temp.getLeft() != null) {
            temp = temp.getLeft();
        }
        return temp.getData();
    }

    static int getMax(BST bst) {
        BST temp = bst;
        while (temp.getRight() != null) {
            temp = temp.getRight();
        }
        return temp.getData();
    }

    static int deleteMax(BST bst) {
        BST temp = bst;
        while (temp.getRight() != null) {
            temp = temp.getRight();
        }
        temp = temp.getParent();
        int data = temp.getData();
        if (temp.getLeft().getData() == data) {
            temp.setLeft(null);
        } else {
            temp.setRight(null);
        }
        return data;
    }

    static int deleteMin(BST bst) {
        BST temp = bst;
        while (temp.getLeft() != null) {
            temp = temp.getLeft();
        }
        int data = temp.getData();
        temp = temp.getParent();
        if (temp.getLeft().getData() == data) {
            temp.setLeft(null);
        } else {
            temp.setRight(null);
        }
        return data;
    }
}
