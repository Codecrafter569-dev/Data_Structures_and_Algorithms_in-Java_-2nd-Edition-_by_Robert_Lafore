public class TowerOfHanoi{
public static void main(String args[]){
int n = 3;
doTower(3,'A','B','C');
}
public static void doTower(int n,char source ,char imtermadate,char destinie){
	if(n == 1){
		System.out.println("Disk 1 from "+source+" to "+destinie);
	}else{

		doTower(n-1,source,destinie,imtermadate);
		System.out.println("Disk "+n+" from "+source+" to "+destinie);
		doTower(n-1,imtermadate,source,destinie);
	}
}
}