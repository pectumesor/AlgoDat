package GeneralAlgorithms;

class TreeNode {
    public int key;
    public int size;
    public TreeNode parent;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int key) {
        this.key = key;
        this.parent = null;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {
    TreeNode root;

    BinaryTree() {
        this.root = null;
    }

    // Inserts a node with the given key in the binary tree rooted at BinaryTree.root.
    public void insert(int key) {
        if (root == null) {
            root = new TreeNode(key);
            root.size = 1;
        } else {
            insert(root, key);
        }
    }

    //Increases the size of each subtree
    public void sizeAdd(TreeNode node){

        node.size++;
        if (node.parent != null){
            sizeAdd(node.parent);
        }
    }

    //Decreases the size of each subtree
    public void sizeSub(TreeNode node){

        node.size--;
        if(node.parent!=null){
            sizeSub(node.parent);
        }
    }


    // Inserts a node with the given key in the binary tree rooted at node.
    public void insert(TreeNode node, int key) {
        if (key < node.key) { // insert in left subtree
            if (node.left != null) {
                insert(node.left, key);
            } else {
                node.left = new TreeNode(key);
                node.left.parent = node;
                sizeAdd(node.left);
            }
        } else { // insert in right subtree
            if (node.right != null) {
                insert(node.right, key);
            } else {
                node.right = new TreeNode(key);
                node.right.parent = node;
                sizeAdd(node.right);
            }
        }
    }

    // Deletes a node with the given key from the binary tree rooted at BinaryTree.root.
    public void delete(int key) {
        TreeNode node = search(key); // find the node to be deleted

        if (node == null) {
            return;
        }

        if (node.left == null) { // no left child
            if (node.right == null) { // no children
                if (node == root) {
                    root = null;
                } else {
                    if (node.parent.left == node) {
                        node.parent.left = null;
                        sizeSub(node.parent);
                    } else {
                        node.parent.right = null;
                        sizeSub(node.parent);
                    }
                }
            } else { // only right child
                if (node == root) {
                    root = node.right;
                    root.parent = null;
                    sizeSub(root);
                } else {
                    if (node.parent.left == node){
                        node.parent.left = node.right;
                        node.right.parent = node.parent;
                        sizeSub(node.parent);
                    } else {
                        node.parent.right = node.right;
                        node.right.parent = node.parent;
                        sizeSub(node.parent);
                    }
                }
            }
        } else {
            if (node.right == null) { // only left child
                if (node == root) {
                    root = node.left;
                    root.parent = null;
                    sizeSub(root);
                } else {
                    if (node.parent.left == node){
                        node.parent.left = node.left;
                        node.left.parent = node.parent;
                        sizeSub(node.parent);
                    } else {
                        node.parent.right = node.left;
                        node.left.parent = node.parent;
                        sizeSub(node.parent);
                    }
                }
            } else { // two children
                TreeNode swapNode = node.left;
                while (swapNode.right != null) { // swapNode is the rightmost descendant of node.left
                    swapNode = swapNode.right;
                }

                node.key = swapNode.key; // replace node by swapNode

                // clean up the tree
                if (swapNode.left != null) { // swapNode has left child
                    if (swapNode.parent.left == swapNode) {
                        swapNode.parent.left = swapNode.left;
                        swapNode.left.parent = swapNode.parent;
                        sizeSub(swapNode.parent);
                    } else {
                        swapNode.parent.right = swapNode.left;
                        swapNode.left.parent = swapNode.parent;
                        sizeSub(swapNode.parent);
                    }
                } else { // swapNode has no child
                    if (swapNode.parent.left == swapNode) {
                        swapNode.parent.left = null;
                        sizeSub(swapNode.parent);
                    } else {
                        swapNode.parent.right = null;
                        sizeSub(swapNode.parent);
                    }
                }
            }
        }
    }

    // Returns a node with the given key in the binary tree rooted at BinaryTree.root.
    public TreeNode search(int key) {
        if (root == null) {
            return null;
        } else {
            return search(root, key);
        }
    }

    // Returns a node with the given key in the binary tree rooted at node.
    public TreeNode search(TreeNode node, int key) {
        if (node == null) {
            return null;
        } else if (key == node.key) {
            return node;
        } else {
            if (key < node.key) {
                return search(node.left, key);
            } else {
                return search(node.right, key);
            }
        }
    }

    public int searchSmallerEquals(TreeNode node, int val){

        int res = 0;

        if (node == null){
            return 0;
        } else if (node.key<=val){
            if (node.right!=null && node.left != null){
                res = 1 + node.left.size + searchSmallerEquals(node.right,val);
            } else if (node.right!=null && node.left == null){
                res = 1 + searchSmallerEquals(node.right,val);
            } else {
                res = node.size;
            }
        } else {
            res = searchSmallerEquals(node.left,val);
        }
        return res;
    }

    // Returns the number of keys with value less than or equal to val in the binary tree rooted at BinaryTree.root.
    public int query(int val) {
        // TODO: implement
        return searchSmallerEquals(root,val);
    }
}