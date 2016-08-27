import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by wjma on 8/25/16.
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 */
class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}

public class Clone_Graph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<Integer, Integer> map = new HashMap<>();

    }
}