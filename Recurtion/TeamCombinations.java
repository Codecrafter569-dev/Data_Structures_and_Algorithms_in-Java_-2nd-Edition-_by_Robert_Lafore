import java.util.Scanner;
public class TeamCombinations {

public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
System.out.println("Enter the size of the group (n) : ");
int n = sc.nextInt();
System.out.print("Enter the team size (k) : ");
int k = sc.nextInt();

if( k > n || n <= 0 || k<= 0){
	System.out.println("Invalid values : team size must be <= group size and both must be positive.");
	sc.close();
	return;
}
int[] group = new int[n];
for(int i = 0;i < n;i++){
	group[i] = i+1;
}
int[] team = new int[n];
System.out.println("AllPermission possible team of size "+k+" From a group of "+n+":");
showTeams(group,k,0,team,0);
sc.close();
}
public static void showTeams(int[] group  , int teamSize , int start , int[] team , int teamIndex){
	if(teamIndex == teamSize){
		for(int i=0;i< teamSize;i++){
			System.out.println(team[i]+ " ");
		}
		System.out.println();
		return;
	}
	for(int i = start; i < group.length;i++){
		if(group.length-i < teamSize - teamIndex){
			break;
		}
		team[teamIndex] = group[i];
		showTeams(group,teamSize,i+1,team,teamIndex+1);
	}
}
}