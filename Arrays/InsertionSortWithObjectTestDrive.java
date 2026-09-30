public class InsertionSortWithObjectTestDrive{
public static void main(String args[]){
	
ArrayInOb arr = new ArrayInOb(10); // create the array
arr.insert("Evans", "Patty", 24);
arr.insert("Smith", "Doc", 59);
arr.insert("Smith", "Lorraine", 37);
arr.insert("Smith", "Paul", 37);
arr.insert("Yee", "Tom", 43);
arr.insert("Hashimoto", "Sato", 21);
arr.insert("Stimson", "Henry", 29);
arr.insert("Velasquez", "Jose", 72);
arr.insert("Vang", "Minh", 22);
arr.insert("Creswell", "Lucinda", 18);
System.out.println("Before sorting:");
arr.display(); // display items
arr.insertionSort(); // insertion-sort them
System.out.println("After sorting:");
arr.display(); // display them ag
}
}
class Person{
	private String lastName;
	private String firstName;
	private int age;
	
	public Person(String lastName,String firstName,int age){
		this.lastName = lastName;
		this.firstName = firstName;
		this.age = age;
	}
	public void displayPerson(){
        System.out.print(" Last name: " + lastName);
        System.out.print(", First name: " + firstName);
        System.out.println(", Age: " + age);
}
public String getLast(){
	return lastName;
}
public int getAge(){
	return age;
}
}
class ArrayInOb{
	private Person[] a;
	private int nElems;
	
	public ArrayInOb(int max){
		a = new Person[max];
		nElems = 0;
	}
	public void insert(String last , String first , int ag){
		a[nElems] = new Person(last,first,ag);
		nElems++;
	}
	
    public void display(){
       for(int j=0; j<nElems; j++){ // for each element,
            a[j].displayPerson(); 
	    } // display it
         System.out.println("");
    }
	
	public void insertionSort(){
		int in, out;
		for(out = 1; out < nElems;out++){
			Person temp = a[out];
			in = out;
			while(in>0 && a[in-1].getLast().compareTo(temp.getLast())>0){
                a[in] = a[in-1]; // shift item to the right
                --in; // go left one position
             }
             a[in] = temp; // insert marked item
        } // end for
		
	}
}