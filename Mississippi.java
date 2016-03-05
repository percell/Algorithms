/*	Yue Wang
 Print all permutations of the word MISSISSIPPI
*/
import java.util.ArrayList;

public class Mississippi {
	static pair m = new pair('M', 1);
	static pair i = new pair('I', 4);
	static pair s = new pair('S', 4);
	static pair p = new pair('P', 2);
	static pair[] option = {m, i, s, p};
	static ArrayList<pair> buffer = new ArrayList<pair>();
	static int count = 1;
	
	public static void main(String[] args){
		Miss(11, 3);
		
	}
	
	static void Miss(int height, int width){
		if(height == 0){
			System.out.println();
			System.out.print(count++);
			for(int c = 0; c<buffer.size(); c++){
				System.out.print(buffer.get(c).name);
			}
		}
		else {
			for(int i=0; i<=width; i++){
				buffer.add(option[i]);
				option[i].count--;
				if(option[i].count==0){
					swap(i, width);
					Miss(height-1, width-1);
					swap(i, width);
	
				}
				else {
				//	System.out.println(height + " "+ width);
					Miss(height-1, width);
				}
				buffer.remove(11-height);
				option[i].count++;
			//	width = 3;
			}
		}
		
	} // end Miss
	
	static void swap(int a, int b){
		pair temp = option[a];
		option[a] = option[b];
		option[b] = temp;
	}
}

class pair {
	char name;
	int count;
	
	pair(char d, int c){
		name = d;
		count = c;
	}
}