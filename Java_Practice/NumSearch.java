

public class NumSearch{
    public static void NumSearch(int sum, String numlist){
        // Split the input string int a array of strings that are single numbers to use Interger.parseInt()
        String[] numberStrings = numlist.split(" ");
        // Initialize an integer Array that is the same length as String array.
        int[] numArr = new int[numberStrings.length]; 
        
        // first, sencond the indexes of the number that sum to sum
        int first = -1;
        int second = -1;
        
        //Parse each int that is held in the string Array.
        for(int i = 0; i < numberStrings.length; i ++){
            numArr[i] = Integer.parseInt(numberStrings[i]);
        }
        
        /*Search for the Two number that sum to sum. j only needs to go from i+1 to the length of number array
          since we have already checked all sums for integers to i. Also by i only going to numArray.length - 1 we
          avoid an out of bounds on the j loop.
        */
        for(int i = 0; i < numArr.length - 1; i++ ){
            for(int j = i + 1; j < numArr.length; j++){
                if(numArr[i] + numArr[j] == sum){
                    first = i;
                    second = j;
                    break;
                }
            }
            if(first != -1){
                break;
            }
            
        }
        // Print Answer
        System.out.printf("Indexes: %d %d ", first, second);
    }
    
    public static void main( String[] args){
        int sum = Integer.parseInt(args[0]);
        String numbers = args[1];
        NumSearch(sum, numbers);
    }
    
    
}