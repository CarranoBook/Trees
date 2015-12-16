/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package treesies;

/**
 *
 * @author NB <nb@fs.org>
 */
public interface ExpressionTreeInterface extends BinaryTreeInterface<String>{
    /**
     * Computes the value of the expression in this tree
     * @return the value of the expression
     */
    public double evaluate();
}
