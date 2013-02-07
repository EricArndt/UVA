#include <iostream>
#include <stack>

using namespace std;

int main() {
	int kases;
	
	cin >> kases;
	string line;
	
	getline(cin, line);
	
	while (kases > 0) {
		
		getline(cin, line);
		
		if (line.empty()) {
			cout << "Yes\n";
			--kases;
			continue;
		}
		
		stack<char> st;
		bool valid = true;
		
		for (int i = 0 ; i < line.size(); ++i) {
			if (line[i] == '(' || line[i] == '[') {
				st.push(line[i]);
			}
			else if (line[i] == ')' || line[i] == ']') {
				if (st.size() == 0) {
					valid = false;
					break;
				}
				
				char c = st.top();
				st.pop();
				
				if ((c == '(' && line[i] != ')') || (c == '[' && line[i] != ']')) {
					valid = false;
					break;
				}
			}
		}
		
		if (st.size() > 0) {
			valid = false;
		}
		
		if (valid) {
			cout << "Yes\n";
		}
		else {
			cout << "No\n";
		}
					
		--kases;
	}
}