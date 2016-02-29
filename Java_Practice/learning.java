public class learning{

	public static void main(String[] args) {
		System.out.print("Hello"); //prints without adding a line terminator on the end
		System.out.println(" world"); // prints and appends a line terminator to the end

		for(int i = 1; i <16; i++){
			if(i % 15 == 0){
				System.out.println("FIZZBUZZ");
			}
			else if(i % 3 == 0){
				System.out.println("FIZZ");
			}
			else if(i % 5 == 0){
				System.out.println("BUZZ");
			}
			else{System.out.println(i);}
		}
		String s = "1 2 3 4";
		String[] s2 = s.split(" ");
		for(int i = 0; i < s2.length; i++){
			System.out.println(s2[i]);
		}
	}
}