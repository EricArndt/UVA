#include <stdio.h>
#include <iostream>
#include <climits>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	int bins[9];
	
	string hm[3] = {"B", "G", "C"};
	
	while (cin >> bins[0]) {
		for (int i = 1; i < 9; ++i) {
			cin >> bins[i];
		}
		
		int smallest = INT_MAX;		
		vector<string> answers;
		
		for (int i = 0; i < 3; ++i) {
			for (int j = 3; j < 6; ++j) {
				if ((i % 3) == (j % 3)) {
					continue;
				}
				
				for (int k = 6; k < 9; ++k) {
					if ((i % 3) == (k % 3) || (j % 3) == (k % 3)) {
						continue;
					}
					
					int sum = 0;
					
					for (int l = 0; l < 9; ++l) {
						if (l == i || l == j || l == k) {
							continue;
						}
						
						sum += bins[l];
					}	
					
					if (sum < smallest) {
						smallest = sum;
						answers.clear();
						string ans = hm[i % 3] + hm[j % 3] + hm[k % 3];
						answers.push_back(ans);
					}
					else if (sum == smallest) {
						string ans = hm[i % 3] + hm[j % 3] + hm[k % 3];
						answers.push_back(ans);
					}					
				}
			}
		}
		
		sort(answers.begin(), answers.end());
		
		cout << answers[0] << " " << smallest << "\n";
	}
	
	return 0;
}
