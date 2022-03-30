#include <iostream>
#include <cstdlib>
#include <algorithm>

using namespace std;

int board[51][6];

int digits(int num) {
	int cnt = 0;
	while (num > 0) {
		num /= 10;
		cnt++;
	}
	
	return cnt;
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);

	int r1, c1, r2, c2, maxNum, curX, curY, curD, addX, addY;
	cin >> r1 >> c1 >> r2 >> c2;
	if (r1 < 0) {
		addX = abs(r1);
	}
	else {
		addX = 0 - r1;
	}
	if (c1 < 0) {
		addY = abs(c1);
	}
	else {
		addY = 0 - c1;
	}
	maxNum = max({ abs(r1), abs(c1), abs(r2), abs(c2) });
	curX = curY = 0;
	if (r1 <= 0 && 0 <= r2 && c1 <= 0 && 0 <= c2) {
		board[curX + addX][curY + addY] = 1;
	}
	curY++;
	for (int i = 2; (curX <= maxNum && curY <= maxNum) && maxNum > 0; i++) {
		if (r1 <= curX && curX <= r2 && c1 <= curY && curY <= c2) {
			board[curX + addX][curY + addY] = i;
		}
		if (curX >= 0 && curY > 0 && curX + 1 == curY) {
			curD = 1;
			curX--;
		}
		else if (curX < 0 && curY > 0 && 0 - curX == curY) {
			curY--;
			curD = 4;
		}
		else if (curX < 0 && curY < 0 && curX == curY) {
			curX++;
			curD = 3;
		}
		else if (curX > 0 && curY < 0 && curX == 0 - curY) {
			curY++;
			curD = 2;
		}
		else {
			switch (curD) {
			case 1:
				curX--;
				break;
			case 2:
				curY++;
				break;
			case 3:
				curX++;
				break;
			case 4:
				curY--;
			}
		}
	}

	r1 += addX; c1 += addY; r2 += addX; c2 += addY;
	maxNum = digits(max({ board[r1][c1], board[r1][c2], board[r2][c1], board[r2][c2] }));
	for (int i = r1; i <= r2; i++) {
		for (int j = c1; j <= c2; j++) {
			for (int k = 0; k < maxNum - digits(board[i][j]); k++) {
				cout << ' ';
			}
			if (j != c1) {
				cout << ' ';
			}
			cout << board[i][j];
		}
		cout << "\n";
	}

	return 0;
}
