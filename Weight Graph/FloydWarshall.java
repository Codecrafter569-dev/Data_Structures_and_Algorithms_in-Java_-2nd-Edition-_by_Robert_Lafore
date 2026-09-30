import java.util.Arrays;

public class FloydWarshall{
	private static final double INF = Double.POSITIVE_INFINITY;
	public static void floyWarshall(double[][] dist){
		int n= dist.length;
		for(int  k = 0;k < n; k++){
			for(int i = 0;i < n;i++){
				for( int j = 0; j< n;j++){
					double viaK = dist[i][k] + dist[k][j];
					if(viaK < dist[i][j]){
						dist[i][j] = viaK;
					}
				}
				
			}
			
		}
		
	}
	public static void printMatrix(double[][] matrix){
		int n = matrix.length;
		for(int i = 0; i <n;i++){
			for(int j = 0; j< n;j++){
				if(matrix[i][j] == INF){
						System.out.print("INF\t");
				}else{
					System.out.print(matrix[i][j]+"\t");
				}	
			}
			System.out.println();
		}
		
		
	}
	public static void main(String args[]){
		double[][] dist = {
            {  0,   3, INF,   7, INF },
            {  3,   0,   1, INF,   5 },
            {INF,   1,   0,   2,   4 },
            {  7, INF,   2,   0,   6 },
            {INF,   5,   4,   6,   0 }
        };
        System.out.println("Initial distance matrix:");
          printMatrix(dist);
		  
		  floyWarshall(dist);
		  
		        System.out.println("\nAll-pairs shortest paths (Floyd-Warshall result):");
				printMatrix(dist);


	}
}