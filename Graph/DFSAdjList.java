class Link{
	public int vertex;
	public Link next;
	
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
	public void insert(int v){
		Link newLink = new Link(v);
		newLink.next = first;
		first = newLink;
		
	}
	public int findUnvisited(boolean[] visisted){
		Link current = first;
		while(current != null){
			if(!visisted[current.vertex]){
				return current.vertex;
			}
			current = current.next;
		}
		return -1;
	}
	public Iterable<Integer> getNeighbors(){
		java.util.List<Integer> list  = new java.util.ArrayList<>();
		Link current = first;
		while(current != null){
			list.add(current.vertex);
			current = current.next;
			
		}
		return list;
	}
	
}
class Graph {
	private final int V;
	private LinkList[] adjLists;
	
	public Graph(int V){
		this.V = V;
		adjLists = new LinkList[V];
		for(int i = 0; i < V;i++){
			adjLists[i] = new LinkList();
		}
	}
	public void addEdge(int v,int w){
		adjLists[v].insert(w);
		adjLists[w].insert(v);
		
	}
	public LinkList getAdjList(int v){
		return adjLists[v];
	}
	public int V(){
		return V;
	}
	
}


public class DFSAdjList{
	private boolean[] visisted;
	private Graph graph;
	
	private DFSAdjList(Graph g){
		this.graph = g;
		visisted = new boolean[g.V()];
		
	}
	public void dfs(int startVertex){
		java.util.Stack<Integer> stack = new java.util.Stack<>();
		visisted[startVertex] = true;
		stack.push(startVertex);
		
		System.out.print("DFS order: ");
		while(!stack.isEmpty()){
			int v = stack.peek();
			int w = graph.getAdjList(v).findUnvisited(visisted);
			if(w == -1){
				stack.pop();
			}else{
				visisted[w] = true;
				stack.push(w);
				System.out.print(w+" ");
				
			}
			
		}
		System.out.println();
	}
	public static void main(String args[]){
		Graph g = new Graph(8);
		g.addEdge(0,1);
		g.addEdge(0,2);
		g.addEdge(0,2);
		g.addEdge(1,4);
		g.addEdge(1,5);
		g.addEdge(2,6);
		g.addEdge(3,7);
		
		DFSAdjList dfs = new DFSAdjList(g);
		System.out.print("Starting at vertex 0. ");
		dfs.dfs(0);
		
	}
	
}