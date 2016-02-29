/* Given int X and string of ints L
	L is delimited by spaces: "3 6 7 9"
	find the two numbers in L that sum to L
	and print indexes of numbers in L that sum to X:
	"Indexes: a b" where a < b 
	Assumptions:
	There are always exactly two numbers in L that sum to X
*/

public class NumSearch_v2{
	public static void heapify(int[] l, int p, int q){
		int lc = p*2+1;
		int rc = p*2+2;

		if(lc < q && rc <= q){
			int move = -1;
			if(l[p] < l[lc] || l[p] < l[rc]){		
				if(l[lc] > l[rc]){
					move = lc;
				}
				else{move = rc;}
				int temp = l[p];
				l[p] = l[move];
				l[move] = temp;
			}
			if(move != -1){
				heapify(l, move, q);
			}
		}
		// for this case we know that if l[p] is moved it will be at the end of the array so
		// we don't need to call heapify again
		else if(lc <= q){
			if(l[p] < l[lc]){
				int temp = l[p];
				l[p] = l[lc];
				l[lc] = temp;
			}
		}
		//in case of the base case we are done heapifying and can just fall out
	}

	public static int extractMax(int[] l, int q){
		int retVal = l[0];
		l[0] = l[q];
		heapify(l, 0, q-1);
		return retVal;
	}

	public static void buildHeap(int[] l){
		for(int i = l.length/2; i >= 0; i--){
			heapify(l, i, l.length - 1);
		}
	}

	public static void heapSort(int[] l){
		buildHeap(l);
		for(int q = l.length - 1; q >= 0; q--){
			l[q] = extractMax(l, q);
		}
	}
	public static int binarySearch( int s,int[] l, int p, int q){
		int mid = (p + q) / 2;
		if(s == l[mid]){
			return mid;
		}
		else if(p == q){
			return -1;
		}
		else if( s < l[mid] && mid != p){
			return binarySearch(s, l, p, mid - 1);
		}
		else if (mid != q){
			return binarySearch(s, l, mid + 1, q);
		}
		else{
			return -1;
		}
	}

	public static void NumSearch(int sum, String numlist){
        // Split the input string int a array of strings that are single numbers to use Interger.parseInt()
        String[] numberStrings = numlist.split(" ");
        // Initialize an integer Array that is the same length as String array.
        int[] numArr = new int[numberStrings.length]; 
        int[] orgNumArr = new int[numberStrings.length];
        
        // first, sencond the indexes of the number that sum to sum
        int a = -1;
        int b = -1;
        
        //Parse each int that is held in the string Array.
        for(int i = 0; i < numberStrings.length; i ++){
            numArr[i] = Integer.parseInt(numberStrings[i]);
            orgNumArr[i] = Integer.parseInt(numberStrings[i]);
        }
        heapSort(numArr);
        for(int i = 0; i < numArr.length - 2; i++ ){
        	a = i;
        	int s = sum - numArr[i];
        	b = binarySearch(s, numArr, a + 1 , numArr.length - 1);
        	if(b != -1){
        		break;
        	}
            
        }
        // Print Answer
        int orga = -1;
        int orgb = -1;
        for(int i = 0; i < numArr.length; i++){
        	if(orgNumArr[i] == numArr[a] && orga == -1){
        		orga = i;
        	}
        	else if(orgNumArr[i] == numArr[b]){
        		orgb = i;
        	}
        }
        if(orgb < orga){	
        	int temp = orga;
        	orga = orgb;
        	orgb = temp;
        }
        System.out.printf("Indexes: %d %d ", orga, orgb);
    }



	public static void main(String[] args) {
		int sum = Integer.parseInt(args[0]);
        String numbers = args[1];
        NumSearch(sum, numbers);
	}



}