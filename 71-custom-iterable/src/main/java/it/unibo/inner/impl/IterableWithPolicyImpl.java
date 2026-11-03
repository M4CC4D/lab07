package it.unibo.inner.impl;

import java.util.Iterator;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T> {
 
    private final T array[];

    public IterableWithPolicyImpl(T array[]){
        this.array = array;
    } 

    @Override
    public Iterator<T> iterator() {
        return (Iterator<T>) new IteratorGasante();
    }

    @Override
    public void setIterationPolicy(Predicate<T> filter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setIterationPolicy'");
    }
   
    private class IteratorGasante implements Iterator<T> {
        private int i = 0;
        private final int lenghth = array.length;
        @Override
        public boolean hasNext() {
            return i < lenghth;
        }

        @Override
        public T next() {
            if(!hasNext()) {
                throw new IllegalAccessError();
            }
            i++;
            return (T)array[i - 1];
        }
    }
}
