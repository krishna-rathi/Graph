import java.util.LinkedList;
//0 -> 1, 0 -> 2, 1 -> 2, 2 -> 0, 2 -> 3, 3 -> 3
public class Graph {
    int vertices;

    LinkedList<Integer> adjList[];
    boolean vis[];

    Graph(int v) {
        vertices = v;
        adjList = new LinkedList[v];
        vis = new boolean[v];
        for(int i = 0; i < v; i++) {
            adjList[i] = new LinkedList();
            vis[i] = false;
        }
    }

    void addEdge(int v, int u) {
        adjList[v].add(u);
    }

    void dfs(int v) {
        vis[v] = true;
        System.out.println(v);
        for(int i = 0; i < adjList[v].size(); i++) {
            if(vis[adjList[v].get(i)] == false)
                dfs(adjList[v].get(i));
        }
    }

    public static void main(String args[]) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.dfs(2);
    }
}
