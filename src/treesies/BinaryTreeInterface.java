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
public interface BinaryTreeInterface<T> extends TreeInterface<T>, 
                                                TreeIteratorInterface<T> {
    /** Sets this binary tree to a new one-node binary tree.
     * @param rootData  an object that is the data in the new tree's root
     */
    public void setRoot(T rootData);
    
    /**
     * Sets this binary tree to a new binary tree.
     * @param rootData  an object that is the data in the new tree's root
     * @param leftTree  the left subtree of the new tree
     * @param rightTree the right subtree of the new tree
     */
    public void setTree(T rootData, BinaryTreeInterface<T> leftTree,    
                                    BinaryTreeInterface<T> rightTree);
} //end BinaryTreeInterface
