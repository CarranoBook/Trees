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
public interface BinaryNodeInterface<T> {
    
    /**
     * Returns the data element of the node
     * @return the data element of the node
     */
    public T getData();
    /**
     * Mutator for the data element
     * @param newData sets the data element to this parameter
     */
    public void setData(T newData);
    public BinaryNodeInterface<T> getLeftChild();
    public BinaryNodeInterface<T> getRightChild();
    public void setLeftChild(BinaryNodeInterface<T> leftChild);
    public void setRightChild(BinaryNodeInterface<T> rightChild);
    public boolean hasLeftChild();
    public boolean hasRightChild();
    /**
     * Returns true if the node is a "leaf" or exterior node.
     * @return True if both the left and right children are null
     */
    public boolean isLeaf();
    /**
     * Counts the nodes in the subtree rooted at this node
     * @return the number of nodes in the subtree rooted at this node
     */
    public int getNumberOfNodes();
    public int getHeight();
    public BinaryNodeInterface<T> copy();
    
}
