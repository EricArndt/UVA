#include <iostream>
#include <cmath>

using namespace std;

int main() {
    while (true) {
        int n1;
        int n2;
        
        cin >> n1;
        cin >> n2;
        
        if (n1 == 0 && n2 == 0) {
            break;
        }
        
        int num1[10];
        int num2[10];
        
        for (int i = 0; i < 10; ++i) {
            int div = (int)pow(10.0, 10 - i - 1);
            
            num1[i] = n1 / div;
            num2[i] = n2 / div;
            
            n1 %= div;
            n2 %= div;
        }
        
        int carries = 0;
        int carry = 0;
        
        for (int i = 9; i >= 0; --i) {
            if (num1[i] + num2[i] + carry > 9) {
                ++carries;
            }
            
            carry = (num1[i] + num2[i] + carry) / 10;
        }
        
        if (carries == 0) {
            cout << "No carry operation." << endl;
        }
        else if (carries == 1) {
            cout << "1 carry operation." << endl;
        }
        else {
            cout << carries <<" carry operations." << endl;
        }
    }
}