import java.util.*;
public class GraphReferenceImplements{
	private Map<String, Vertex> vertces = new LinkedHashMap<>();
	private static final double INF = Double.POSITIVE_INFINITY;
	private static class Edge{
		Vertex target;
		double weight;
		Edge(Vertex target , double weight){
			this.target = target;
			this.weight = weight;
		}
		
		
	}
	private static class Vertex{
		String name;
		List<Edge> edges = new ArrayList<>();
		Vertex(String name){
			this.name = name;
		}
		void addEdge(Vertex to , double weight){
			edges.add(new Edge(to , weight));
		}
		
		
	}
	public void addVertex(String name){
		if(vertces.containsKey(name)){
			throw new IllegalArgumentException("Vertex already exisis : "+name);
			
		}
		vertces.put(name, new Vertex(name));
		
	}
	public void addEdge(String a ,String b , double weight){
		Vertex va = vertces.get(a);
		Vertex vb = vertces.get(b);
		if(va == null || vb == null){
			throw new IllegalArgumentException("Vertex not found : "+a+" or "+b);
		}
		va.addEdge(vb,weight);
		vb.addEdge(va,weight);
		
	}
	public void displayConnectivity(){
		List<Vertex> list = new ArrayList<>(vertces.values());
		int n = list.size();
		
		System.out.print("\t");
		for(Vertex v : list){
			System.out.print(v.name+"\t");
			
		}
		System.out.println();
		
		for(Vertex row : list){
			System.out.print(row.name+"\t");
			for(Vertex col : list){
				double w  = (row == col ? 0.0 : findWeight(row,col));
				if(Double.isInfinite(w)){
				System.out.print("INF\t");
			    }else{
				System.out.print(w+"\t");
			    }
			}
			System.out.println();
		}
		
		
	}
	private double findWeight(Vertex u , Vertex v){
		for(Edge e : u.edges){
			if(e.target == v){
				return e.weight;
			}
			
		}
		return INF;	
	}
	public static void main(String args[]){
		GraphReferenceImplements graph = new GraphReferenceImplements();
		
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		
		graph.addEdge("A", "B", 3);
        graph.addEdge("A", "D", 7);
        graph.addEdge("B", "C", 1);
        graph.addEdge("B", "E", 5);
        graph.addEdge("C", "D", 2);
        graph.addEdge("C", "E", 4);
        graph.addEdge("D", "E", 6);
		
		System.out.println("Connectivity table (edge weights of INF): ");
		graph.displayConnectivity();
	}
}