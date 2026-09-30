import java.util.*;
class Link{
	int vertex;
	Link next;
	
	public Link(int v){
		vertex = v;
		next = null;
	}
	
}
class LinkList{
	private Link first;
	
	public LinkList(){
		first = null;
	}
	public void insertFirst(int v){
		Link newLink = new Link(v);
		newLink.next = first;
		first = newLink;
		
	}
	public int find(boolean[] visited){
		Link current = first;
		while(current != null){
			if(!visited[current.vertex]){
				return current.vertex;
			}
			current = current.next;
				
			
		}
		return -1;
		
	}
	
}
class Graph {
	private int nVerts;
	private LinkList[] adj;
	private boolean[] visited;
	
	public Graph(int n){
		nVerts = n;
		visited = new boolean[nVerts];
		adj = new LinkList[nVerts];
		for(int i = 0;i < nVerts;i++){
			adj[i] = new LinkList();
		}
		
	}
	public void addEdge(int strat, int end){
		adj[strat].insertFirst(end);
		adj[end].insertFirst(strat);
	}
	public int getAdjUnvisitedVertex(int v){
		return adj[v].find(visited);
	}
	public void dfs(){
		Stack<Integer> stack = new Stack<>();
		visited[0] = true;
		System.out.print(0+ " ");
		stack.push(0);
		
		while(!stack.isEmpty()){
			int currentVertex = stack.peek();
			int adjVertex = getAdjUnvisitedVertex(currentVertex);
			if(adjVertex == -1){
				stack.pop();
			}else{
				visited[adjVertex] = true;
				System.out.print(adjVertex+ " ");
				stack.push(adjVertex);
			}
			
		}
		System.out.println();
		
	}
}

public class DFSAdjacencyList{
	public static void main(String args[]){
		Graph graph = new Graph(7);
		
		graph.addEdge(0,1);
		graph.addEdge(0,2);
		graph.addEdge(1,3);
		graph.addEdge(1,4);
		graph.addEdge(2,5);
		graph.addEdge(2,6);
		graph.addEdge(4,5);
		
		
		
		System.out.println("Depth-First Search starting from Vertex 0: ");
		graph.dfs();
	}
}