#include <iostream>

using namespace std;

int board[2700][2700]; //종이
int ans[3]; //-1, 0, 1로만 채워진 종이의 개수

/*
N * N 종이의 -1, 0, 1 종이 수 구하는 함수
종이의 왼쪽 최상단 좌표는 (r, c)
*/
void func(int n, int r, int c) {
	//base condition
	if (n == 1) {
		ans[board[r][c] + 1]++;
		return;
	}

	int val = board[r][c];
	bool check = true;
	
	//종이가 모두 같은 수로 되어있는지 확인
	for (int i = r; i < r + n; i++) {
		for (int j = c; j < c + n; j++) {
			if (val != board[i][j]) {
				check = false;
				i = r + n;
				break;
			}
		}
	}

	if (check) {
		ans[val + 1]++;
	}
	else {
		int len = n / 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				func(len, r + (i * len), c + (j * len));
			}
		}
	}
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);

	int n;

	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> board[i][j];
		}
	}

	func(n, 0, 0);

	cout << ans[0] << '\n' << ans[1] << '\n' << ans[2] << '\n';

	return 0;
}