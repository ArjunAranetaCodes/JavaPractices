public class Palindrome {
	public static void main(String[] args){
		String test1 = "car";
		System.out.println(recursive(test1));
	}
	
	public static String recursive(String word){
		if(word.length() < 2){
			return word;
		}
		
		return recursive(word.substring(1)) + word.charAt(0);
	}
}