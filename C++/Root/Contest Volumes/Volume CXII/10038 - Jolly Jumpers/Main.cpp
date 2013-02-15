#include <iostream>
#include <vector>
#include <cstdlib>

using namespace std;

int main() {
    int n;
    int t;
    while (cin >> n) {
        vector<int> nums;
        
        for (int i = 0; i < n; ++i) {
            cin >> t;
            nums.push_back(t);
        }
        
        if (n == 1) {
            cout << "Jolly" << endl;
            continue;
        }
        
        vector<bool> jolly;
        
        for (int i = 0; i < n; ++i) {
            jolly.push_back(false);
        }
        
        for (int i = 0; i < n - 1; ++i) {
            int diff = abs(nums[i] - nums[i + 1]);
            
            if (diff < 1 || diff >= n) {
                break;
            }
            
            jolly[diff] = true;
        }
        
        bool j = true;
        
        for (int i = 1; i < n; ++i) {
            if (!jolly[i]) {
                j = false;
                break;
            }
        }
        
        if (j) {
            cout << "Jolly" << endl;
        }
        else {
            cout << "Not jolly" << endl;
        }
    }
}