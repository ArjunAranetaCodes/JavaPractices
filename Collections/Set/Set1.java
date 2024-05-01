import java.util.*;

public class Set1 {
	public static void main(String[] args){
		Set<Integer> set1 = new HashSet<Integer>();
		
		set1.add(5);
		set1.add(4);
		set1.add(3);
		set1.add(5);
		
		System.out.println(set1);
		
		for(Integer num : set1){
			System.out.println(num);
		}
		
		Iterator<Integer> iterSet = set1.iterator();
		
		while(iterSet.hasNext()){
			System.out.println(iterSet.next());
		}
	}
}