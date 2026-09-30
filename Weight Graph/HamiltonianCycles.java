public class HamiltonianCycles{
	private int V;
	private int[][] adjMatrix;
	private boolean[] visited;
	private int[] path;
	private int cycleCount = 0;
	
	public HamiltonianCycles(int[][] matrix){
		this.V = matrix.length;
		this.adjMatrix = matrix;
		visited = new boolean[V];
		path = new int[V+1];
		
	}
	public void findAllCycles(){
		//Start at vertex 0;
		visited[0] = true;
		path[0] = 0;
		backtrack(1,0);
		System.out.println("Total Hamiltonian Cycles found: "+cycleCount);
		
	}
	private void backtrack(int pos , int currentCost){
		if(pos == V){
			int last = path[pos-1];
			if(adjMatrix[last][0] > 0){
				path[pos] = 0;
				int totalCost = currentCost+adjMatrix[last][0];
				printCycle(totalCost);
				cycleCount++;
				
			}
			return;
		}
		for(int v = 1;v < V;v++){
			if(!visited[v] && adjMatrix[path[pos-1]][v] > 0){
				visited[v] = true;
				path[pos] = v;
				backtrack(pos+1,currentCost+adjMatrix[path[pos-1]][v]);
				visited[v] = false;
			}
			
		}
	}
	private void printCycle(int totalCost){
		System.out.print("Cycles "+(cycleCount+1)+": ");
		for(int i = 0;i <= V;i++){
			System.out.print(path[i]);
			if(i < V){
				System.out.print(" - ");
			}
			
		}
		System.out.println(" | Total weight = "+totalCost);
	}
	public static void main(String args[]){
		int[][] matrix = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };
		HamiltonianCycles hc = new HamiltonianCycles(matrix);
		hc.findAllCycles();
	}
}