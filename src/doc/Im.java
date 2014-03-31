package doc;

/**
 * Im implements the ImList<E> abstract datatype.
 */
public class Im {
    // datatype definition:
    //    ImList = Empty 
    //             + Cons(e:E, rest:ImList)    

    public interface ImList<E> {
        /**
         * @return a list with e as its first element, 
         * followed by this list as its remaining elements.
         */
        public ImList<E> cons(E e);
        
        /**
         * @return the first element of this list.  
         * Requires this list to be nonempty.
         */
        public E first();
        
        /**
         * @return the rest of this list after removing the first element.  
         * Requires this list to be nonempty.
         */
        public ImList<E> rest();
        
        /**
         * @return 
         */
        public boolean isEmpty();
    }
    
    /**
     * Implements the empty() operation for ImList<E>
     */
    public static <E> ImList<E> empty() {
        return new Empty<E>();
    }

    private static class Empty<E> implements ImList<E> {
        public Empty() { }
        public ImList<E> cons(E e) { return new Cons<E>(e, this); }
        public E first() { throw new UnsupportedOperationException(); }
        public ImList<E> rest() { throw new UnsupportedOperationException(); }
        public boolean isEmpty() { return true; }
    }

    private static class Cons<E> implements ImList<E> {
        private final E e;
        private final ImList<E> rest;

        public Cons(E e, ImList<E> rest) { this.e = e; this.rest = rest; }
        public ImList<E> cons(E e) { return new Cons<E> (e, this); }
        public E first() { return e; }
        public ImList<E> rest() { return rest; }
        public boolean isEmpty() { return false; }
    }   
    
}
