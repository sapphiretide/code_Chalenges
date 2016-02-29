import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FileReader{

	public String[] fileToStrArr(String f){
		System.out.println(f);
		File file = new File(f);
		Scanner in = new Scanner(f);
		
		String[] lines = new String[0];
		if(in.hasNextLine()){
			String temp;
			temp = in.nextLine();
			System.out.println(temp); //testing reading lines in the file...
			int numlines = Integer.parseInt(temp.trim());

			lines = new String[numlines];
			for( int i = 0; i < numlines; i++){
				lines[i] = in.nextLine();
			}
		}
		return lines;
	}
}