public class DirectedConnectivity{
    private int V;                  // number of vertices
    private boolean[][] adj;        // adjacency matrix

    public DirectedConnectivity(int V) {
        this.V = V;
        adj = new boolean[V][V];
    }

    // Add directed edge v -> w
    public void addEdge(int v, int w) {
        adj[v][w] = true;
    }

    // Helper to perform DFS from source and mark reachable
    private void dfs(int src, int v, boolean[] visited) {
        visited[v] = true;
        for (int w = 0; w < V; w++) {
            if (adj[v][w] && !visited[w]) {
                dfs(src, w, visited);
            }
        }
    }

    // Compute and print connectivity table
    public void connectivityTable() {
        boolean[][] reachable = new boolean[V][V];

        // For each vertex, run DFS to fill its reachable row
        for (int v = 0; v < V; v++) {
            boolean[] visited = new boolean[V];
            dfs(v, v, visited);
            reachable[v] = visited;
        }

        // Print table header
        System.out.print("    ");
        for (int j = 0; j < V; j++) {
            System.out.printf(" %2d", j);
        }
        System.out.println();
        System.out.println("    " + "---".repeat(V));

        // Print each row
        for (int i = 0; i < V; i++) {
            System.out.printf("%2d |", i);
            for (int j = 0; j < V; j++) {
        System.out.printf("  %d", reachable[i][j] ? 1 : 0);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Example directed graph with 5 vertices
        int V = 5;
        DirectedConnectivity dc = new DirectedConnectivity(V);

        // Add directed edges
        dc.addEdge(0, 1);
        dc.addEdge(0, 2);
        dc.addEdge(1, 2);
        dc.addEdge(2, 0);
        dc.addEdge(2, 3);
        dc.addEdge(3, 3);
        dc.addEdge(3, 4);

        // Display connectivity
        System.out.println("Connectivity table (1 = reachable, 0 = not reachable):");
        dc.connectivityTable();
    }
}