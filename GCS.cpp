/* Yue Wang
find the greatest common subsequence of two strings, characters
do not have to be consecutive.
*/

#include <iostream>
#include <cstring>
#include <cmath>
#include <cstdlib>
#include <algorithm>
using namespace std;
typedef pair<int, int> pi;

string a;
string b;
int dp[1000][1000];
pi decision[1000][1000];

int len(int i, int j){
	if(i<0 || j<0) return 0;
	if(dp[i][j] !=-1)
		return dp[i][j];
	pi pp;
	if(a[i] == b[j]){
		decision[i][j] = make_pair(i-1, j-1);
		return dp[i][j] = 1+len(i-1, j-1);
	}
	else if (len(i-1, j)> len(i, j-1)){
		decision[i][j] = make_pair(i-1, j);
		return dp[i][j] = len(i-1, j);
	}
	else{
		decision[i][j] =  make_pair(i, j-1);
		return dp[i][j] = len(i, j-1);
	}

}

void printPath(int i, int j){
	if(i<0 || j<0) return;
	pi temp = decision[i][j];
	// cout << temp.first << endl;
	// cout << temp.second << endl;
	printPath(temp.first, temp.second);

	if (temp.first == i-1 && temp.second == j-1){
		cout << a[i];
	}
		
}

int main(){
	memset(dp, -1, sizeof(dp));
	printf("\nEnter string A: ");
	cin >> a;
	printf("\nEnter string B: ");
	cin >> b;
	cout << a.size() << endl;
	cout << b.size() << endl;
	cout << len(a.size()-1,b.size()-1) << endl;

    printPath(a.size()-1, b.size()-1);
    cout << endl;
	return 0;
}

