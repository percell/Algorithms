// Yue Wang

public class MatrixMult {
	
	static int[] d = {20, 100, 10, 20, 100, 5};
	// d[i] is the number of rows in ith matrix. d[i+1] is number of columns in ith matrix.
	static int[][] look = new int [5][5];
	public static void main(String[] args){
		mult();
		for(int i=0; i<5; i++){
			for(int j=0; j<(5-i); j++){
				System.out.print(" "+look[i][j]);
			}
			System.out.println();
		}
	}
	
	// stone age dynamic programming
	// fills the table Look[i][j] with number of operations needed to multiply
	// ith matrix by jth matrix
	static void mult(){
		for(int i=1; i<5; i++){
			for(int j=0; j<5-i; j++){
				if(i==1){
					look[i][j] = d[j]*d[j+1]*d[j+2];
				}
				else{
					int min = (int) 1e9;
					for (int c=0; c<i; c++){
						int count = look[i-1-c][j+c+1] + d[j]*d[j+c+1]*d[j+i+1] + look[c][j]; 
						if(count<min) min = count;
					}
					
					look[i][j] = min;
				}
			}
		}
	}
}
