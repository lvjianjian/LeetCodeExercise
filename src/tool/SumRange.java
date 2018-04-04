package tool;

/**
 * Created by zhongjianlv on 18-4-4.
 */

class RangeNode {
    public int left;
    public int right;
    public int val;
    public int delta;

    public RangeNode() {
    }

    RangeNode(int l, int r, int v) {
        left = l;
        right = r;
        val = v;
    }

    public RangeNode(int left, int right) {
        this.left = left;
        this.right = right;
    }
}

/**
 * sum线段树,区间从0开始计数
 */
public class SumRange {
    private RangeNode[] nodes;
    private final int startPos = 1;

    public SumRange(int[] vals) {
        built(vals);
    }

    private void built(int[] vals) {//建树操作
        nodes = new RangeNode[vals.length * 4]; // 最差情况4n空间复杂度
        if (nodes.length == 0) return;
        builtHelper(0, vals.length - 1, startPos, vals);
    }

    private void builtHelper(int l, int r, int pos, int[] vals) {
        if (l == r) {
            nodes[pos] = new RangeNode(l, r, vals[l]);
            return;
        }
        if (r < l) return;
        int mid = l + ((r - l) >> 1);//注意括号，运算优先级 +- 高于 移位
        int newpos = pos << 1; // pos * 2
        builtHelper(l, mid, newpos, vals);
        builtHelper(mid + 1, r, newpos + 1, vals);
        nodes[pos] = new RangeNode(l, r, nodes[newpos].val + nodes[newpos + 1].val);
    }

    /**
     * 区间求值
     *
     * @param l 区间左值
     * @param r 区间右值
     * @return
     */
    public int query(int l, int r) {
        if (r < l || nodes.length == 0) return 0;
        return queryHelper(l, r, startPos);
    }

    private int queryHelper(int l, int r, int pos) {
        RangeNode node = nodes[pos];
        if (node.left == l && node.right == r) return node.val;
        int mid = node.left + ((node.right - node.left) >> 1);
        int newpos = pos << 1;
        if (mid >= r) {
            return queryHelper(l, r, newpos);
        } else if (l >= mid + 1)
            return queryHelper(l, r, newpos + 1);
        else
            return queryHelper(l, mid, newpos) + queryHelper(mid + 1, r, newpos + 1);
    }

    /**
     * 单点修改
     *
     * @param index  修改位置
     * @param newval 修改新值
     */
    public void modify(int index, int newval) {
        if (nodes.length == 0) return;
        modifyHelper(index, newval, startPos);
    }

    private void modifyHelper(int index, int newval, int pos) {
        RangeNode node = nodes[pos];
        if (node.left == index && node.right == index) {
            node.val = newval;
            return;
        }
        int mid = node.left + ((node.right - node.left) >> 1);
        int newpos = pos << 1;
        if (mid >= index) {
            modifyHelper(index, newval, newpos);
        } else
            modifyHelper(index, newval, newpos + 1);
        node.val = nodes[newpos].val + nodes[newpos + 1].val;
    }
}



