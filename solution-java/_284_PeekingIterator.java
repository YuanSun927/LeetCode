public class _284_PeekingIterator implements Iterator<Integer> {
    
    private Iterator<Integer> iter;
    private boolean hasNext;
    private Integer nextE;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        if (iterator == null)
            throw new NullPointerException();
        iter = iterator;
        hasNext = iterator.hasNext();
        nextE = hasNext ? iterator.next() : null;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return nextE;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int res = nextE;
        if ((hasNext = iter.hasNext()) == true)
            nextE = iter.next();
        else
            nextE = null;
        return res;
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }
}