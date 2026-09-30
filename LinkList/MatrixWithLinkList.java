public class MatrixWithLinkList{
public static void main(String args[]){
Matrix m = new Matrix(2,3);
m.display();

m.insert(1,1,24);
m.insert(1,2,45);
m.insert(1,3,66);
m.insert(2,1,56);
m.insert(2,2,67);
m.insert(2,3,89);
m.display();
}

}
class Node{
	int data;
	Node fLink;
	Node bLink;
	
	public Node(int data){
		this.data = data;
		this.fLink = this.bLink = null;
	}
	
}
class Row {
	private int col;
	private Node start;
	
	public Row(int col){
		this.col = col;
		generateRow();
	}
	private void generateRow(){
		Node newNode = new Node(-1);
		start = newNode;
		Node p = start;
		
		while(col > 1){
			Node newN = new Node(-1);
			p.fLink  = newN;
			p = newN;
			col--;
		}
		
	}
	public Node getStart(){
		return start;
	}
	
}
class Matrix{
	private int n;
	private int m;
	private Row[] r;
	private Node start;
	
	public Matrix(int n, int m){
		this.n = n;
		this.m = m;
		start = null;
		r = new Row[n];
		
		check();
		generateMatrix();
	}
	
	private void check(){
		if(n <= 0 || m <=0){
			System.out.println("value of 'n' & 'm' must be greater than 0");
			System.exit(0);
		}
	}
	public void generateMatrix(){
		for(int i=0; i<n;i++){
			r[i] = new Row(m);
		}
		start = r[0].getStart();
		
		for(int i = 0;i <n-1;i++){
			Node p1  = r[i].getStart();
			Node p2 = r[i+1].getStart();
			
			for(int j = 0;j<m;j++){
				p1.bLink = p2;
				p1 = p1.fLink;
				p2 = p2.fLink;
			}
		}
	}
	public void insert(int x, int y,int data){
		Node cell = start;
		int col = y;
		
		if(x > n || y > m || x <=0 || y <=0){
			System.out.println("(x,y) such that 0 < x < "+ n + " and 0 < y < " + m + ".");
			return;
		}
		for(int row=1;row<x;row++){
			cell = cell.bLink;
		}
		while(col>1){
			cell = cell.fLink;
			col--;
		}
		cell.data = data;
		
	}
	public void display(){
		Node row = start;
		
		while(row != null){
			Node cell = row;
			
			while(cell != null){
				System.out.print(cell.data+" ");
				cell = cell.fLink;
			}
			System.out.println();
			row = row.bLink;
			
		}
		System.out.println();
		
		
	}
}