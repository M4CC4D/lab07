package it.unibo.inner;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.impl.IterableWithPolicyImpl;

import java.util.List;

import static it.unibo.inner.test.Assertions.assertContentEqualsInOrder;

public class TestIterablePlain {

    private TestIterablePlain() {}

    public static void main() {
        final String[] test1 = { "pippo", "pluto", "paperino" };
        final IterableWithPolicy<String> evenIterable = new IterableWithPolicyImpl<>(test1);
        assertContentEqualsInOrder(List.of("pippo", "pluto", "paperino"), evenIterable);
        final String[] test2 = {};
        final IterableWithPolicy<String> emptyIterable = new IterableWithPolicyImpl<>(test2);
        assertContentEqualsInOrder(List.of(), emptyIterable);
        String[] test3 = { "foo" };
        final IterableWithPolicy<String> oneIterable = new IterableWithPolicyImpl<>(test3);
        assertContentEqualsInOrder(List.of("foo"), oneIterable);
    }
}
