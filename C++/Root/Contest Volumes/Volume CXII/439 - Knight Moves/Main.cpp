#include <stdio.h>
#include <iostream>
#include <vector>
#include <climits>

using namespace std;

vector< vector<int> > floyd(vector< vector<int> > matrix) {
	
	const int I = INT_MAX;
	
	int n = matrix.size();
	
	for (int k = 0; k < n; ++k) {
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (matrix[i][k] != I && matrix[k][j] != I && matrix[i][k] + matrix[k][j] < matrix[i][j]) {
					matrix[i][j] = matrix[i][k] + matrix[k][j];
				}
			}
		}
	}
	
	return matrix;
}

int main() {
	
	vector< vector<int> > board (64, vector <int> (64, INT_MAX));	

	int UR = 17;
	int UL = 15;
	int LU = 6;
	int LD = -10;
	int DL = -17;
	int DR = -15;
	int RU = 10;
	int RD = -6;
	
	for (int x = 0; x < 64; ++x) {
		board[x][x] = 0;
		
		int xLoc = x % 8;
		int yLoc = x / 8;
		
		if (xLoc + 1 < 8 && yLoc + 2 < 8) {
				board[x][x + UR] = 1;
		}

		if (xLoc - 1 >= 0 && yLoc + 2 < 8) {
			board[x][x + UL] = 1;
		}

		if (xLoc - 2 >= 0 && yLoc + 1 < 8) {
			board[x][x + LU] = 1;
		}

		if (xLoc - 2 >= 0 && yLoc - 1 >= 0) {
			board[x][x + LD] = 1;
		}

		if (xLoc - 1 >= 0 && yLoc - 2 >= 0) {
			board[x][x + DL] = 1;
		}

		if (xLoc + 1 < 8 && yLoc - 2 >= 0) {
			board[x][x + DR] = 1;
		}

		if (xLoc + 2 < 8 && yLoc + 1 < 8) {
			board[x][x + RU] = 1;
		}

		if (xLoc + 2 < 8 && yLoc - 1 >= 0) {
			board[x][x + RD] = 1;
		}
	}
	
	vector< vector<int> > lookup = floyd(board);
	
	string from;
	string to;
	
	while (cin >> from >> to) {
		int fx = from[0] - 'a';
		int fy = from[1] - '1';
		int tx = to[0] - 'a';
		int ty = to[1] - '1';
		
		int start = fx + 8 * fy;
		int finish = tx + 8 * ty;
		
		cout << "To get from " << from << " to " << to << " takes " << lookup[start][finish] << " knight moves.\n";
	}
	
	return 0;
}
