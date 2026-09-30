import java.util.*;

public class BFSInMSTTestDrive{
	private int V;
	private LinkedList<Integer>[] adj;
	
	public BFSInMSTTestDrive(int V){
		this.V = V;
		adj = new LinkedList[V];
		for(int i = 0;i < V;i++){
			adj[i] = new LinkedList<>();
			
		}
		
	}
	public void addEdge(int s , int t){
		adj[s].add(t);
		adj[t].add(s);
	}
	public void bfsMST(int s){
		boolean[] visited = new boolean[V];
		int[] parent  = new int[V];
		Arrays.fill(parent,-1);
		
		Queue<Integer> queue = new LinkedList<>();
		visited[s] = true;
		queue.offer(s);
		
		while(!queue.isEmpty()){
			int u = queue.poll();
			for(int v : adj[u]){
				if(!visited[v]){
					visited[v] = true;
					parent[v] = u;
					queue.offer(v);
					
				}
				
			}
			
		}
		
		System.out.println("Minimum Spanning Tree (using BFS): ");
		for(int i = 0;i < V;i++){
			if(parent[i] != -1){
				System.out.println(parent[i]+" - "+i);
			}
		}
		
	}
	public static void main(String args[]){
		BFSInMSTTestDrive graph = new BFSInMSTTestDrive(9);
		graph.addEdge(0,1);
		graph.addEdge(0,3);
		graph.addEdge(1,2);
		graph.addEdge(1,4);
		graph.addEdge(2,5);
		graph.addEdge(3,4);
		graph.addEdge(3,6);
		graph.addEdge(4,5);
		graph.addEdge(4,7);
		graph.addEdge(5,8);
		graph.addEdge(6,7);
		graph.addEdge(7,8);
	graph.bfsMST(0);
		
	}
}
	