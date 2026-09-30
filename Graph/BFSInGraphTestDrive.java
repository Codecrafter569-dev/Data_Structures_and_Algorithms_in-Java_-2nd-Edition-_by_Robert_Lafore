class QueueB{
	private final int SIZE = 20;
	private int[] queArray;
	private int front;
	private int rear;
	
	     public QueueB(){
		    queArray = new int[SIZE];
		    front = 0;
		    rear = -1;
	    }
	        public void insert(int j){
		     if(rear == SIZE-1){
			   rear = -1;
		      }
		       queArray[++rear] = j;
	        }

		public int remove(){
			int temp = queArray[front++];
			if(front == SIZE){
				front = 0;
			}
			return temp;
		}
		public boolean isEmpty(){
			return (rear+1 == front || (front+SIZE-1 == rear));
		}	
}
class Vertex{
	public char label;
	public boolean wasVisited;
	
	public Vertex(char lab){
		label = lab;
		wasVisited = false;
	}
	
	
}
class BFSInGraph{
	private final int MAX_VERTS = 20;
	private Vertex vertedList[];
	private int adjMat[][];
	private int nVerts;
	private QueueB theQueues;
	
	public BFSInGraph(){
		vertedList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for(int j=0;j<MAX_VERTS;j++){
			for(int i = 0;i < MAX_VERTS;i++){
				adjMat[j][i] = 0;
			}
		}
		theQueues = new QueueB();
		
	}
	public void addVertex(char lab){
		vertedList[nVerts++] = new Vertex(lab);
	}
	public void addEdge(int start,int end){
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}
	public void displayVertex(int v){
		System.out.print(vertedList[v].label);
	}
	public void bfs(){
		vertedList[0].wasVisited = true;
		displayVertex(0);
		theQueues.insert(0);
		int v2;
		while(!theQueues.isEmpty()){
			int v1 = theQueues.remove();
			while((v2 = getAdjUnvisitedVertex(v1)) != -1){
				vertedList[v2].wasVisited = true;
				displayVertex(v2);
				theQueues.insert(v2);
				
			}
		}
		for(int j=0; j<nVerts;j++){
			vertedList[j].wasVisited = false;
		}
		
		
	}
	public int getAdjUnvisitedVertex(int v){
		for(int j = 0;j<nVerts;j++){
			if(adjMat[v][j] == 1 && vertedList[j].wasVisited == false){
				return j;
			}
		}
		return -1;
	}
}
public class BFSInGraphTestDrive{
public static void main(String args[]){
BFSInGraph theGraph = new BFSInGraph();
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
theGraph.bfs();
System.out.println();
}
}