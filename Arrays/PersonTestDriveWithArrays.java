public class PersonTestDriveWithArrays{
public static void main(String args[]){
int maxSize = 100;
ClassDateArray arr = new ClassDateArray(maxSize);
arr.insert("Evans", "Patty", 24);
arr.insert("Smith", "Lorraine", 37);
arr.insert("Yee", "Tom", 43);
arr.insert("Adams", "Henry", 63);
arr.insert("Hashimoto", "Sato", 21);
arr.insert("Stimson", "Henry", 29);
arr.insert("Velasquez", "Jose", 72);
arr.insert("Lamarque", "Henry", 54);
arr.insert("Vang", "Minh", 22);
arr.insert("Creswell", "Lucinda", 18);
arr.displayA();
String searchName = "Stimson65";
Person found;
found = arr.find(searchName);
if(found != null){
	found.displayPerson();
}else{
System.out.println("Can't find " + searchName);
System.out.println("Deleting Smith, Yee, and Creswell");
arr.delete("Smith"); // delete 3 items
arr.delete("Yee");
arr.delete("Creswell");
arr.displayA(); // 	
}

}
}
class Person{
	private String lastName;
	private String firstName;
	private int age;
	
	public Person(String lastName,String firstName,int age){
		this.lastName =lastName;
		this.firstName = firstName;
		this.age = age;
	}
	public void displayPerson(){
		System.out.print(" Last Name:"+lastName);
		System.out.print(" First Name:"+firstName);
		System.out.println(",Age : "+age);
	}
	public String getLast(){
		return lastName;
	}
	
}
class ClassDateArray{
private Person[] a;
private int nElems;

public ClassDateArray(int max){
a = new Person[max];
nElems = 0;
}	
public Person find(String searchName){
int j ;
for(j = 0; j < nElems; j++){
	if(a[j].getLast().equals(searchName)){
		break;
	}
}
if(j == nElems){
	return null;
}else{
	return a[j];
}
}
public void insert(String lastName , String firstName , int age){
a[nElems] = new Person(lastName,firstName,age);
nElems++;
}	
public boolean delete(String searchName){
	int j;
	for(j=0; j<nElems; j++) {// look for it
        if( a[j].getLast().equals(searchName) ){
         break;
        }
	}
	if(j==nElems){
		return false;
	}else{
		for(int k=j; k < nElems; k++){
			a[k] = a[k+1];
		}
		nElems--;
		return true;
	}
}
public void displayA(){
	for(int j=0;j<nElems;j++){
		a[j].displayPerson();
	}
}
}