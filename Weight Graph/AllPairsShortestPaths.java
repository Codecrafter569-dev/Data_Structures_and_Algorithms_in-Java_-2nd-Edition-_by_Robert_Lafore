import java.util.Arrays;
import java.util.PriorityQueue;

public class AllPairsShortestPaths{
	private static final double INF = Double.POSITIVE_INFINITY;
	private final int n;
	private final double[][] graph;
	
	public AllPairsShortestPaths(double[][] graph){
		this.n = graph.length;
		this.graph = graph;
		
	}
	private double[] dijkstra(int s){
		double[] dist = new double[n];
		boolean[] seen = new boolean[n];
		Arrays.fill(dist,INF);
		dist[s] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>(
		   (a,b) -> Double.compare(a[0],b[0])
		);
		pq.add(new int[]{0,s});
		
		while(!pq.isEmpty()){
			int[] top = pq.poll();
			double d = top[0];
			int u = top[1];
			if(seen[u]){
				continue;
			}
			seen[u] = true;
			
			for(int v = 0; v<n;v++){
				double w = graph[u][v];
				
				if(w < INF && !seen[v]){
					double nd = d+w;
					if(nd < dist[v]){
						dist[v] = nd;
						pq.add(new int[]{(int)nd, v});
					}
					
				}
				
			}
			
		}
		return dist;
	}
	public double[][] computeAllPairs(){
		double[][] all = new double[n][n];
		for(int s = 0; s < n;s++){
			all[s] = dijkstra(s);
		}
		return all;
	}
	private static void printCostTable(double[][] cost){
		int n = cost.length;
		System.out.print("\t");
		for(int j = 0; j<n;j++){
			System.out.print((char)('A'+j)+"\t");
		}
		System.out.println();
		for(int i = 0;i < n;i++){
			System.out.print((char)('A'+i)+"\t");
			for(int j = 0;j < n;j++){
				double d= cost[i][j];
				System.out.print(Double.isInfinite(d) ? "INF\t" :((int)d)+"\t");
			}
			System.out.println();
			
		}
		
		
	}
	public static void main(String args[]){
		
		double INF = Double.POSITIVE_INFINITY;
		double[][] matrix = {
            //A    B    C    D    E
            {  0,   3, INF,   7, INF }, // A
            {  3,   0,   1, INF,   5 }, // B
            {INF,   1,   0,   2,   4 }, // C
            {  7, INF,   2,   0,   6 }, // D
            {INF,   5,   4,   6,   0 }  // E
        };
		AllPairsShortestPaths apsp = new AllPairsShortestPaths(matrix);
		double[][] costs = apsp.computeAllPairs();
		
		System.out.println("Minimun-cost table (rows = source , cols = target):");
		printCostTable(costs);
	}
	
}