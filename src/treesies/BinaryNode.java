/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treesies;

/**
 *
 * @author nbleier
 */
public class BinaryNode<T> implements BinaryNodeInterface<T> {
    private T data;
    private BinaryNode<T> left;
    private BinaryNode<T> right;

    public BinaryNode() {
        this(null);
    }//end constructor
    
    public BinaryNode(T dataPortion) {
        this(dataPortion, null, null);
    }//end constructor
    
    public BinaryNode(T dataPortion, BinaryNode<T> leftChild,
                                     BinaryNode<T> rightChild) {
        data = dataPortion;
        left = leftChild;
        right = rightChild;
    } //end constructor
    
    @Override
    public T getData() {
        return data;
    }

    @Override
    public void setData(T newData) {
        this.data = newData;
    }

    @Override
    public BinaryNodeInterface<T> getLeftChild() {
        return left;
    }

    @Override
    public BinaryNodeInterface<T> getRightChild() {
        return right; }

    @Override
    public void setLeftChild(BinaryNodeInterface<T> leftChild) {
        left = (BinaryNode<T>) leftChild;
    }

    @Override
    public void setRightChild(BinaryNodeInterface<T> rightChild) {
        right = (BinaryNode<T>) rightChild;
    }

    @Override
    public boolean hasLeftChild() {
        return left != null;
    }

    @Override
    public boolean hasRightChild() {
        return right != null;
    }

    @Override
    public boolean isLeaf() {
        return (left == null) && (right == null);
    }

    @Override
    public int getNumberOfNodes() {
        int counter = 1;
        if (left != null)
            counter += left.getNumberOfNodes();
        
        if (right != null) 
            counter += right.getNumberOfNodes();
        
        return counter;
    }

    @Override
    public int getHeight() {
        return getHeight(this);
    }

    @Override
    public BinaryNodeInterface<T> copy() {
        BinaryNode<T> newRoot = new BinaryNode<T>(data);
        
        if (left != null)
            newRoot.left = (BinaryNode<T>) left.copy();
        
        if (right != null)
            newRoot.right = (BinaryNode<T>) right.copy();
        
        return newRoot;
    } //end copy

    private int getHeight(BinaryNode<T> node) {
        int height = 0;
         if (node != null)
            height = 1 + Math.max(getHeight(node.left),
                    getHeight(node.right));
        
        return height;
    }
    
    
}
