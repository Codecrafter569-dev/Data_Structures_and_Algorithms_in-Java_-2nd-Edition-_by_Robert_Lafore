public class BubbleSortWithObjectTestDrive{
public static void main(String args[]){
	
ArrayInOb arr = new ArrayInOb(10); // create the array
arr.insert("Evans", "Patty", 15);
arr.insert("Smith", "Doc", 14);
arr.insert("Smith", "Lorraine", 16);
arr.insert("Smith", "Paul", 16);
arr.insert("Yee", "Tom", 20);
arr.insert("Hashimoto", "Sato", 13);
arr.insert("Stimson", "Henry", 19);
arr.insert("Velasquez", "Jose", 24);
arr.insert("Vang", "Minh", 21);
arr.insert("Creswell", "Lucinda", 23);
System.out.println("Before sorting:");
arr.display(); // display items
arr.bubbleSort(); // insertion-sort them
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
	
	public void bubbleSort(){
		int out,in;
		for(out = nElems-1;out>1;out--){
			for(in=0;in<out;in++){
				if(a[in].getAge() >= a[in+1].getAge()){
					Person temp = a[in];
		                 a[in] = a[in+1];
		                 a[in+1] = temp;
				}
			}
			
		}
		
	}
	
}