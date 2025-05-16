public class Hanoi1{
	public static void main(String[] args){
		int n = 3;
		hanoiTower(n, 'A', 'C', 'B'); //for first move
	}
	
	public static void hanoiTower(int n, char from_rod, char to_rod, char helper){
		if(n == 1){
			System.out.println("Disk 1 from " + from_rod + " to " + to_rod);
			return;
		}
		hanoiTower(n - 1, from_rod, helper, to_rod);
		System.out.println("Disk " + n + " from " + from_rod + " to " + to_rod);
		hanoiTower(n - 1, helper, to_rod, from_rod);
	}
}