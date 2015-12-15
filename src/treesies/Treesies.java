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
public class Treesies {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyBinaryTree<Integer> a = new MyBinaryTree<>(5);
        MyBinaryTree<Integer> b = new MyBinaryTree<>(3);
        MyBinaryTree<Integer> c = new MyBinaryTree<>(2);
        a.setTree(a.getRootData(), b, c);
        System.out.println(a.getNumberOfNodes());
        
    }
    
}
