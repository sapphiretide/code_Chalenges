import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SumOfDigits{
	
	public static String[] readfile(String f){
		String[] lines = new String[0];
		try{
			File in = new File(f);
			Scanner scan = new Scanner(in);
			
			if(scan.hasNextLine()){
				String temp;
				temp = scan.nextLine();
				int numlines = Integer.parseInt(temp.trim());
				lines = new String[numlines];
				for( int i = 0; i < numlines; i++){
					lines[i] = scan.nextLine();
				}
			}
		}catch(FileNotFoundException fnfex){
			System.out.println("File Not Found");
		}
		return lines;
	}


	public static void main(String[] args) {

		String[] lines = readfile(args[0]);
		
		for(int i = 0; i < lines.length; i++){
			int problemi = Integer.parseInt(lines[i].trim());
			int solutioni = 0;
			while(problemi > 0){
				solutioni += problemi % 10;
				problemi /= 10;
			}
			System.out.printf("Solution %d: %d \n", i + 1, solutioni);
		}		
	}

}