class StackX{
	private final int size = 20;
	private int[] st;
	private int top;
	
	public StackX(){
		st = new int[size];
		top = -1;
		
	}
	public void push(int j){
	  st[++top] = j;
	}
	public int pop(){
		return st[top--];
	}
	public int peek(){
		return st[top];
	}
	public boolean isEmpty(){
		return (top == -1);
	}
	
}
//this is a part of a graph that we are a called Vertex is represent a city.
class Vertex{
	public char label;
	public boolean wasVisited;
	
	public Vertex(char lab){
		label = lab;
		wasVisited = false;
	}
}
class Graph{
	private final int MAX_VERIS = 20;
	private Vertex vertedList[];
	private int adjMat[][] ;
	private int nVerts;
	private StackX theStack;
	
	public Graph(){
		vertedList = new Vertex[MAX_VERIS];
		adjMat = new int[MAX_VERIS][MAX_VERIS];
		nVerts = 0;
		for(int j=0;j<MAX_VERIS;j++){
			for(int i = 0; i < MAX_VERIS;i++){
				adjMat[j][i] = 0;
			}
		}
		theStack = new StackX();
		
	}
	public void addVertex(char lab){
		vertedList[nVerts++] = new Vertex(lab);
	}
	public void addEdge(int start, int end){
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
		
	}
	public void displayVertex(int v){
		System.out.print(vertedList[v].label);
	}
	public void dfs(){
		vertedList[0].wasVisited = true;
		displayVertex(0);
		theStack.push(0);
		while(!theStack.isEmpty()){
			int v = getAdjUnvisitedVertex(theStack.peek());
			if( v == -1){
				theStack.pop();
			}else{
				vertedList[v].wasVisited = true;
				displayVertex(v);
				theStack.push(v);
				
			}
			
		}
		for(int j = 0; j < nVerts;j++){
			vertedList[j].wasVisited = false;
		}
		
	}
	public int getAdjUnvisitedVertex(int v){
		for(int j=0;j <nVerts;j++){
			if(adjMat[v][j] == 1 && vertedList[j].wasVisited == false){
				return j;
			}
		}
		return -1;
	}
}
public class GraphTestDrive{
public static void main(String args[]){
Graph theGraph = new Graph();
theGraph.addVertex('A');//0
theGraph.addVertex('B');//1
theGraph.addVertex('C');//2
theGraph.addVertex('D');//3
theGraph.addVertex('E');//4
theGraph.addVertex('F');//5
theGraph.addVertex('G');//6
theGraph.addVertex('H');//7
theGraph.addVertex('I');//8

theGraph.addEdge(0,1);
theGraph.addEdge(1,5);
theGraph.addEdge(5,7);
theGraph.addEdge(0,2);
theGraph.addEdge(0,3);
theGraph.addEdge(3,6);
theGraph.addEdge(6,8);
theGraph.addEdge(0,4);
System.out.print("Visits: ");
theGraph.dfs();
System.out.println();

}
}