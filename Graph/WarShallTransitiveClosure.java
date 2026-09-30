
import java.util.*;
public class WarShallTransitiveClosure{
	private final int V;
	private final boolean[][] reach;
	public WarShallTransitiveClosure(int V){
		this.V = V;
		reach = new boolean[V][V];
	}
	public void addEdge(int v, int w){
		if(v < 0 || v >= V  || w < 0 || w >= V){
			throw new IllegalArgumentException("Vertex out of range");
		}
		reach[v][w] = true;
		
	}
	private void displayMatirx(String title){
		System.out.println(title);
		System.out.print("    ");
		for(int j = 0;j < V; j++){
			System.out.printf(" %2d",j);
		}
		System.out.println();
		System.out.print("    ");
		for(int j = 0;j < V;j++){
			System.out.print("---");
		}
		System.out.println();
		for(int i = 0;i < V;i++){
			System.out.printf("%2d |",i);
			for(int j = 0;j < V;j++){
				System.out.printf(" %d",reach[i][j] ? 1 : 0);
			}
			System.out.println();
		}
		System.out.println();
	}
	public void computeTransitiveClosure(){
		displayMatirx("Initial adjancency matrix: ");
		
		for(int k = 0;k < V;k++){
			for(int i = 0;i < V;i++){
				for(int j = 0; j< V;j++){
					reach[i][j]  = reach[i][j] || (reach[i][k] && reach[k][j]);
					
				}
			}
			displayMatirx("After including vertex "+k+":");
		}
		
	}
public static void main(String args[]){
	int V = 5;
	WarShallTransitiveClosure wtc = new WarShallTransitiveClosure(V);
	wtc.addEdge(0,1);
	wtc.addEdge(0,2);
	wtc.addEdge(1,2);
	wtc.addEdge(2,0);
	wtc.addEdge(2,3);
	wtc.addEdge(3,3);
	wtc.addEdge(3,4);
	
	wtc.computeTransitiveClosure();
}
}