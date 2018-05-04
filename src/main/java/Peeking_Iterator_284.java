import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zhongjianlv on 18-3-14.
 * <p>
 * Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().
 * <p>
 * Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].
 * <p>
 * Call next() gets you 1, the first element in the list.
 * <p>
 * Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
 * <p>
 * You call next() the final time and it returns 3, the last element. Calling hasNext() after that should return false.
 * <p>
 * Follow up: How would you extend your design to be generic and work with all types, not just integer?
 */
public class Peeking_Iterator_284 implements Iterator<Integer>{

    List<Integer> l;
    int i;
    public Peeking_Iterator_284(Iterator<Integer> iterator) {
        l = new ArrayList<>();
        i = -1;
        while (iterator.hasNext()){
            l.add(iterator.next());
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return l.get(i+1);
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        return l.get(++i);
    }

    @Override
    public boolean hasNext() {
        return i + 1 < l.size();
    }
}
