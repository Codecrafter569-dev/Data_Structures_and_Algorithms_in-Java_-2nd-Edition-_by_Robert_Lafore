public class OrderedArrayTest{
public static void main(String args[]){
int maxSize = 100; 
		OrderedArray arr = new OrderedArray(maxSize);

		arr.insert(77); 
		arr.insert(99); 
		arr.insert(44); 
		arr.insert(55); 
		arr.insert(22); 
		arr.insert(88); 
		arr.insert(11); 
		arr.insert(12); 
		arr.insert(00); 
		arr.insert(66); 
		arr.insert(33); 

		arr.display();

		//ELEMENT TO BE SEARCHED
		int searchKey = 11;

		if( arr.find(searchKey) != arr.size())
			System.out.println("Found " + searchKey); 
		else
			System.out.println("Can’t find " + searchKey);

		arr.display();

		//ELEMENT TO BE DELETED
		arr.delete(00); 
		arr.delete(55); 
		arr.delete(99);


		OrderedArray arr2 = new OrderedArray(maxSize);

		arr2.insert(34); 
		arr2.insert(54); 
		arr2.insert(23); 
		arr2.insert(54); 
		arr2.insert(76); 
		arr2.insert(87); 
		arr2.insert(63); 
		arr2.insert(82); 
		arr2.insert(45); 
		arr2.insert(73); 
		arr2.insert(78); 

		arr2.display();

		//MERGE TWO ARRAY 
		OrderedArray arr3 = OrderedArray.merge(arr, arr2, maxSize);

		arr3.display();
}
}
class OrderedArray{
	private int[] a;
	private int nElems;
	
	public OrderedArray(int max){
		a = new int[max];
	}
	public int size(){
		return nElems;
	}
	public int getElementFromPos(int index){
		return a[index];
	}
	public void setElementAtPos(int index,int value){
		a[index] = value;
	}
	public int find(int searchKey){
		int lowerBound = 0;
		int upperBound = nElems-1;
		int curIn;
		
		while(true){
			curIn = (lowerBound + upperBound)/2;
			if(a[curIn] == searchKey){
				return curIn;
			}else if(lowerBound > upperBound){
				return nElems;
			}else{
				if(a[curIn]<searchKey){
					lowerBound = curIn+1;
				}else{
					upperBound = curIn-1;
				}
				
			}
			
			
		}
		
	}
	public void insert(int value){
		int lowerBound = 0;
		int upperBound = nElems-1;
		int j = 0;
		
		while(true){
			if(lowerBound > upperBound){
				break;
			}
			j = (lowerBound+upperBound)/2;
			
			if(value > a[j]){
				lowerBound = j+1;
				j++;
			}else{
				upperBound = j-1;
			}
			
		}
		for(int k=nElems;k>j;k--){
			a[k] = a[k-1];
		}
		a[j] = value;
		nElems++;
		
	}
	public boolean delete(int value){
		int j = find(value);
		if(j == nElems){
			return false;
		}else{
			for(int k = j; k<nElems;k++){
				a[k] = a[k+1];
		    }
				nElems--;
				return true;
			
		}
		
	}
	public void display(){
		for(int j=0;j<nElems;j++){
			System.out.print(a[j]+" ");
		}
		System.out.println();
		
	}
	public static OrderedArray merge(OrderedArray a, OrderedArray b, int size) {

		OrderedArray c = new OrderedArray(size);
		
		int j = 0, k = 0;

		while(j < a.size() && k < b.size()) {

			if(a.getElementFromPos(j) <= b.getElementFromPos(k)) {
				c.setElementAtPos(c.nElems, a.getElementFromPos(j));
				j++;
			}
			else {
				c.setElementAtPos(c.nElems, b.getElementFromPos(k));
				k++;
			}

			c.nElems++;
		}

		while(j < a.size())
		{
			c.setElementAtPos(c.nElems, a.getElementFromPos(j));
			c.nElems++;
			j++;
		}
		
		while(k < b.size())
		{
			c.setElementAtPos(c.nElems, b.getElementFromPos(k));
			c.nElems++;
			k++;
		}
		return c;

	}
}