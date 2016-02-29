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

	public static void sort(int[] l){
		buildHeap(l);
		for(int q = l.length - 1; q > 0; q--){
			l[q] = extractMax(l, q - 1);
		}
	}
	public static void main(String[] args) {
		int[] l = {1,6,2,4,9,2,5,3};
		sort(l);
		for(int i = 0; i < l.length; i++){
			System.out.println(l[i]);
		}
	}



}