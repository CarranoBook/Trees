/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treesies;

import java.util.Iterator;

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
        ExpressionTree a = new ExpressionTree("+");
        ExpressionTree b = new ExpressionTree("1");
        ExpressionTree c = new ExpressionTree("2");
        a.setTree(a.getRootData(), b, c);
        System.out.println(a.evaluate());
       
        
    }
    
    public MyBinaryTree<Integer> makeTree() {
        MyBinaryTree<Integer> a = new MyBinaryTree<>(1);
        MyBinaryTree<Integer> b = new MyBinaryTree<>(2);
        MyBinaryTree<Integer> c = new MyBinaryTree<>(4);
        MyBinaryTree<Integer> d = new MyBinaryTree<>(5);
        MyBinaryTree<Integer> e = new MyBinaryTree<>(3);
        MyBinaryTree<Integer> f = new MyBinaryTree<>(6);
        MyBinaryTree<Integer> g = new MyBinaryTree<>(7);
        b.setTree(b.getRootData(), c, d);
        e.setTree(e.getRootData(), f, g);
        a.setTree(a.getRootData(), b, e);
        return a;
    }
    
}
