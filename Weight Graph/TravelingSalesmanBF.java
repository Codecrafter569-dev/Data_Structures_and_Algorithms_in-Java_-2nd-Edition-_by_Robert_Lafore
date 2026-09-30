import java.util.Arrays;

public class TravelingSalesmanBF{
	private final int N;
	private final double[][] dist;
	private final int[] route;
	
	public TravelingSalesmanBF(double[][] dist){
		this.N = dist.length;
		this.dist = dist;
		this.route = new int[N];
		
		for(int i = 0;i < N;i++){
			route[i] = i;
		}
		
	}
	private double tourCost(){
		double cost = 0.0;
		for(int i = 0; i < N-1;i++){
			cost += dist[route[i]][route[i+1]];
		}
		cost += dist[route[N-1]][route[0]];
		
		return cost;
	}
	private void printRoute(double cost){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i< N;i++){
			sb.append((char)('A'+route[i]));
			if(i < N-1){
				sb.append(" - ");
			}
		}
		sb.append(" - ").append((char)('A'+route[0]));
		sb.append("  |  cost = ");
		if(Double.isInfinite(cost)){
			sb.append("Inf");
		}else{
			sb.append(cost);
		}
		System.out.println(sb);
	}
	private void permute(int k){
		if(k == N){
			double cost = tourCost();
			printRoute(cost);
			return;
			
		}
		for(int i = k;i < N;i++){
			swap(k,i);
			permute(k+1);
			swap(k,i);
		}
		
	}
	private void swap(int i , int j){
		int tmp  = route[i];
		route[i] = route[j];
		route[j] = tmp;
		
	}
	public void solve(){
		
		System.out.println("All possible tours and their cost: \n");
		permute(0);
	}
	public static void main(String args[]){
		double INF = Double.POSITIVE_INFINITY;
		double[][] matrix =  {
            {  0,  10,  15,  20, INF },
            { 10,   0,  35,  25,  17  },
            { 15,  35,   0,  30, INF },
            { 20,  25,  30,   0,  28  },
            {INF,  17, INF,  28,   0  }
        };
		TravelingSalesmanBF tsp = new TravelingSalesmanBF(matrix);
		tsp.solve();
		
	}
}