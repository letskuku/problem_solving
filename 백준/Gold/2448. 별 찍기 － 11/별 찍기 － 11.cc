#include <iostream>
#include <algorithm>

using namespace std;

int board[3100][6200];

/*
별 찍는 보드 채우는 함수
(r, c)부터 시작
*/
void func(int n, int r, int c) {
	//base condition
	if (n == 3) {
		board[r][c] = 1; //1층
		board[r + 1][c - 1] = 1; board[r + 1][c + 1] = 1; //2층
		fill(board[r + 2] + c - 2, board[r + 2] + c + 3, 1); //3층
		
		return;
	}

	int val = n / 2;
	func(val, r, c);
	func(val, r + val, c - val);
	func(val, r + val, c + val);
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);

	int n;

	cin >> n;
	func(n, 0, n - 1);

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < 2 * n; j++) {
			if (board[i][j] == 1) {
				cout << '*';
			}
			else {
				cout << ' ';
			}
		}
		cout << '\n';
	}

	return 0;
}