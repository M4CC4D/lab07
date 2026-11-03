package it.unibo.inner.impl;

import java.util.Iterator;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T> {
 
    private final T array[];
    private Predicate<T> predicate;

    public IterableWithPolicyImpl(T array[]) {
        this(array, x -> true);
    } 

    public IterableWithPolicyImpl(T array[], Predicate<T> predicate) {
        this.array = array;
        this.predicate = predicate;
    }

    @Override
    public Iterator<T> iterator() {
        return (Iterator<T>) new IteratorGasante();
    }

    @Override
    public void setIterationPolicy(Predicate<T> filter) {
        predicate = filter;
    }
   
    private class IteratorGasante implements Iterator<T> {
        private int i = 0;
        private final int length = array.length;
        @Override
        public boolean hasNext() {
            try {
                hasNextPredicate();
                return true;
            } catch (IllegalAccessError e) {
                return false;
            }
        }

        @Override
        public T next() {
            try {
                int i = hasNextPredicate();
                T n = array[i];
                i++;
                return n;
            } catch (IllegalAccessError e) {
                throw e;
            }
        }

        private int hasNextPredicate() throws IllegalAccessError{
            for(int i = this.i; i < length; i++) {
                if(predicate.test(array[i])) {
                    return i;
                }
            }
            throw new IllegalAccessError("Non è stato possibile trovare un elemento che rispetta il predicato.");
        }
    }
}
