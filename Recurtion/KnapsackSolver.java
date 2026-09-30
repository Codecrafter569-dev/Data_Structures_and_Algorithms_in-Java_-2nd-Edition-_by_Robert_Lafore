public class KnapsackSolver{

      public static void main(String args[]){
	  int capacity = 10;
	  int[] weights = {10,20,30,40,15,51,60};
	  int bestWeight = knapsack(capacity,0,weights);
	  
	  System.out.println("Knapsack capacity: "+capacity);
	  System.out.print("Available weights: ");
	  
	  for(int w : weights){
		  System.out.print(w+ " ");
	  }
	  System.out.println();
	  System.out.println("Maximum weights that can be packed: "+bestWeight);
	  }
	  public static int knapsack(int target,int index,int[] weights){
		  if(target == 0 || index >= weights.length){
			  return 0;
		  }
		  int weightwithout  = knapsack(target,index+1,weights);
		  int weightwith = 0;
		  if(weights[index] <= target){
			  weightwith = weights[index]+knapsack(target-weights[index],index+1,weights);
		  }
		  return Math.max(weightwith,weightwithout);
	  }
}