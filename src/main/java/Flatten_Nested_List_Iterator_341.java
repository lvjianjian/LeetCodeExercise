import java.util.Iterator;
import java.util.List;

/**
 * Created by zhongjianlv on 2018/5/7
 * <p>
 * Given a nested list of integers, implement an iterator to flatten it.
 * <p>
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * <p>
 * Example 1:
 * Given the list [[1,1],2,[1,1]],
 * <p>
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
 * <p>
 * Example 2:
 * Given the list [1,[4,[6]]],
 * <p>
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
 */
public class Flatten_Nested_List_Iterator_341 implements Iterator<Integer> {

    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    private List<NestedInteger> list;
    private int index = 0;
    private int n = 0;
    private Flatten_Nested_List_Iterator_341 next;

    public Flatten_Nested_List_Iterator_341(List<NestedInteger> nestedList) {
        this.list = nestedList;
        this.n = this.list.size();
    }

    @Override
    public Integer next() {
        if (this.next != null)
            return this.next.next();
        return list.get(index++).getInteger();
    }

    @Override
    public boolean hasNext() {
        if (this.next != null && this.next.hasNext()) return true;
        this.next = null;
        if (this.index >= this.n) return false;
        if (!this.list.get(index).isInteger()) {
            Flatten_Nested_List_Iterator_341 flatten_nested_list_iterator_341 = new Flatten_Nested_List_Iterator_341(this.list.get(index).getList());
            this.next = flatten_nested_list_iterator_341;
            ++this.index;
        } else return true;
        return hasNext();
    }

}
