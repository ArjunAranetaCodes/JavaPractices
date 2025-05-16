import java.util.Arrays;
 
public class Bubble1{
 
   public static void main(String args[]) {
        bubbleSort(new int[] { 20, 12, 45, 19, 91, 55 });
        bubbleSort(new int[] { -1, 0, 1 });
        bubbleSort(new int[] { -3, -9, -2, -1 });

    }
	
	public static void bubbleSort(int[] array){
		for(int i = 0; i < array.length; i++){
			for(int j = array.length - 1; j > i; j--){
				if(array[j] < array[j-1]){
					swap(array, j, j - 1);
				}
			}
		}
		System.out.println(Arrays.toString(array));
	}
	
	public static void swap(int[] array, int from, int to){
		int temp = array[from];
		array[from] = array[to];
		array[to] = temp;
	}
 
}