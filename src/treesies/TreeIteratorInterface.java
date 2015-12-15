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
public interface TreeIteratorInterface<T> {
    public Iterator<T> getPreorderIterator();
    public Iterator<T> getPostorderIterator();
    public Iterator<T> getInorderIterator();
    public Iterator<T> getLevelOrderIterator();
}
