/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treesies;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 *
 * @author nbleier
 */
public class MyBinaryTree<T> implements BinaryTreeInterface<T> {
    private BinaryNodeInterface<T> root;
    
    public MyBinaryTree() {
        root = null;
    }//end constructor
    
    public MyBinaryTree(T rootData) {
        root = new BinaryNode<T>(rootData);
    } //end constructor
    
    public MyBinaryTree(T rootData, MyBinaryTree<T> leftTree, 
                                    MyBinaryTree<T> rightTree) {
        privateSetTree(rootData, leftTree, rightTree);
    } //end constructor
    
    
    @Override
    public void setRoot(T rootData) {
        root = new BinaryNode<T>(rootData);
    }

    @Override
    public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
        privateSetTree(rootData, (MyBinaryTree<T>) leftTree, (MyBinaryTree<T>) rightTree);
    }

    @Override
    public T getRootData() {
        T rootData = null;
        
        if (root != null)
            rootData = root.getData();
        
        return rootData;
    }

    @Override
    public int getHeight() {
        return root.getHeight();
    }

    @Override
    public int getNumberOfNodes() {
        return root.getNumberOfNodes();
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public Iterator<T> getPreorderIterator() {
        return new PreorderIterator();
    }

    @Override
    public Iterator<T> getPostorderIterator() {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public Iterator<T> getInorderIterator() {
        return new InorderIterator();
    }

    @Override
    public Iterator<T> getLevelOrderIterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void inorderTraverse() {
        inorderTraverse(root);
    }
    
    private void inorderTraverse(BinaryNodeInterface<T> node) {
        if (node != null) {
            inorderTraverse(node.getLeftChild());
            System.out.println(node.getData());
            inorderTraverse(node.getRightChild());
        }
    }
    
    private void privateSetTree(T rootData, MyBinaryTree<T> leftTree, MyBinaryTree<T> rightTree) {
        this.root = new BinaryNode<T>(rootData);
        
        //sets the left tree to left tree
        if ( (leftTree != null) && !leftTree.isEmpty() )
            root.setLeftChild(leftTree.root);
        
        //sets the right tree to the right tree, unless the left tree is the same tree as the right tree
        // in which case it sets the right tree to a copy of the left tree
        if ( (rightTree != null) && !rightTree.isEmpty() ) {
            if (rightTree != leftTree)
                root.setRightChild(rightTree.root);
            else
                root.setRightChild(rightTree.root.copy());
        }//end if
        
        //clears the left and right tees passed to the method
        if ( leftTree != null && leftTree != this)
            leftTree.clear();
        if (rightTree != null && rightTree != this)
            rightTree.clear();
        
    }//end privateSetTree
    
    protected void setRootData(T rootData) {
        root.setData(rootData);
    }
    
    protected void setRootNode(BinaryNodeInterface<T> rootNode) {
        root = rootNode;
    }
    
    protected BinaryNodeInterface<T> getRootNode() {
        return root;
    }
    
    private class InorderIterator implements Iterator<T> {
        private Stack<BinaryNodeInterface<T>> nodeStack;
        private BinaryNodeInterface<T> currentNode;
        
        public InorderIterator() {
            nodeStack = new Stack<>();
            currentNode = root;
        }
        
        
        @Override
        public boolean hasNext() {
            return !nodeStack.isEmpty() || (currentNode != null);
        }

        @Override
        public T next() {
            BinaryNodeInterface<T> nextNode = null;
            
            // find the leftmost node with no child
            while (currentNode != null) {
                nodeStack.push(currentNode);
                currentNode = currentNode.getLeftChild();
            } //end while
            
            // get leftmost node, then move to its right subtree
            if ( !nodeStack.isEmpty() ) {
                nextNode = nodeStack.pop();
                assert nextNode != null; // since nodeStack was not empty
                                        // before the pop
                currentNode = nextNode.getRightChild();
            } //end if
            else
                throw new NoSuchElementException();
            
            return nextNode.getData();
            
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }     
    } //end clas InorderIterator
    
    private class PreorderIterator implements Iterator<T> {
        private Stack<BinaryNodeInterface<T>> nodeStack;
        private BinaryNodeInterface<T> currentNode;
        
        public PreorderIterator() {
            nodeStack = new Stack<>();
            currentNode = root;
        }
        
        @Override
        public boolean hasNext() {
            return (currentNode != null || ( !nodeStack.isEmpty() ));
        }

        @Override
        public T next() {
            BinaryNodeInterface<T> nextNode = null;
            
            if (currentNode != null)
                nextNode = currentNode;

            if (currentNode.hasRightChild())
                nodeStack.push(currentNode.getRightChild());

            if (currentNode.hasLeftChild())
                nodeStack.push(currentNode.getLeftChild());
            
            if (!nodeStack.isEmpty())
                currentNode = nodeStack.pop();
            else
                currentNode = null;
            
            return nextNode.getData();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    
    
    
}
