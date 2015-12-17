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
public class ExpressionTree extends MyBinaryTree<String>
                            implements ExpressionTreeInterface
{
    
    public ExpressionTree() {}
    
    public ExpressionTree(String b) {
        super(b);
    }
    
    @Override
    public double evaluate() {
        return evaluate(getRootNode());
    }

    private double evaluate(BinaryNodeInterface<String> rootNode) {
        double result;
        if (rootNode == null)
            result = 0;
        else if (rootNode.isLeaf()) {
            String variable = rootNode.getData();
            result = getValueOf(variable);
        }
        else
        {
           double firstOperand = evaluate(rootNode.getLeftChild());
           double secondOperand = evaluate(rootNode.getRightChild());
           String operator = rootNode.getData();
           result = compute(operator, firstOperand, secondOperand);
        }
        
        return result;
    }

    private double getValueOf(String v) {
        return Double.parseDouble(v);
    }

    private double compute(String operator, double firstOperand, double secondOperand) {
        if (operator.equals("+"))
            return firstOperand + secondOperand;
        
        if (operator.equals("-"))
            return firstOperand - secondOperand;
        
        if (operator.equals("*"))
            return firstOperand - secondOperand;
        
        return firstOperand / secondOperand;
    }
 
    
}
