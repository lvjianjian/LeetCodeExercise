/**
 * Created by zhongjianlv on 18-4-12.
 * <p>
 * Given an undirected graph, return true if and only if it is bipartite.
 * <p>
 * Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B.
 * <p>
 * The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.  Each node is an integer between 0 and graph.length - 1.  There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.
 * <p>
 * Example 1:
 * Input: [[1,3], [0,2], [1,3], [0,2]]
 * Output: true
 * Explanation:
 * The graph looks like this:
 * 0----1
 * |    |
 * |    |
 * 3----2
 * We can divide the vertices into two groups: {0, 2} and {1, 3}.
 * Example 2:
 * Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
 * Output: false
 * Explanation:
 * The graph looks like this:
 * 0----1
 * | \  |
 * |  \ |
 * 3----2
 * We cannot find a way to divide the set of nodes into two independent subsets.
 * <p>
 * <p>
 * Note:
 * <p>
 * graph will have length in range [1, 100].
 * graph[i] will contain integers in range [0, graph.length - 1].
 * graph[i] will not contain i or duplicate values.
 * The graph is undirected: if any element j is in graph[i], then i will be in graph[j].
 */
public class Is_Graph_Bipartite_785 {
    public boolean isBipartite(int[][] graph) {
        int[] group = new int[graph.length];
        return helper(group, graph, 0, 0);
    }

    private boolean helper(int[] group, int[][] graph, int node_id, int col_index) {
        if (node_id == graph.length) return true;
        if (col_index == graph[node_id].length) return helper(group, graph, node_id + 1, 0);
        int adjacent_id = graph[node_id][col_index];
        if (group[node_id] == 0 && group[adjacent_id] == 0) {
            group[node_id] = 1;
            group[adjacent_id] = -1;
            if (helper(group, graph, node_id, col_index + 1)) return true;
            group[node_id] = -1;
            group[adjacent_id] = 1;
            return helper(group, graph, node_id, col_index + 1);
        } else if (group[node_id] == group[adjacent_id]) {
            return false;
        } else {
            boolean res = true;
            if (group[node_id] == 0) {
                group[node_id] = -group[adjacent_id];
                res = helper(group, graph, node_id, col_index + 1);
                group[node_id] = 0;
            } else if (group[adjacent_id] == 0) {
                group[adjacent_id] = -group[node_id];
                res = helper(group, graph, node_id, col_index + 1);
                group[adjacent_id] = 0;
            } else {
                res = helper(group, graph, node_id, col_index + 1);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Is_Graph_Bipartite_785 is_graph_bipartite_785 = new Is_Graph_Bipartite_785();
        System.out.println(is_graph_bipartite_785.isBipartite(new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}}));
    }
}
