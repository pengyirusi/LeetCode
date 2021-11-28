package cn.peng;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Create by weiyupeng on 2021/10/5 14:17
 */
class S284 implements Iterator<Integer> {

    private int size = 0;
    private int cur = -1;
    private List<Integer> list;

    public S284(Iterator<Integer> iterator) {
        // initialize any member here.
        list = new ArrayList<>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        size = list.size();
        cur = 0;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return list.get(cur);
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer ret = list.get(cur);
        cur++;
        return ret;
    }

    @Override
    public boolean hasNext() {
        return cur != -1 && cur < size;
    }
}
