#include <iostream>

using namespace std;

int main() {
	string s;
	
	bool openQuote = true;
	while (getline(cin, s)) {
		int len = s.length();
		
		
		for (int i = 0; i < len; ++i) {
			if (s[i] == '"') {
				if (openQuote) {
					cout << "``";
				}
				else {
					cout << "''";
				}
				
				openQuote = !openQuote;
			}
			else {
				cout << s[i];
			}
		}
		
		cout << "\n";
	}
	
	return 0;
}
