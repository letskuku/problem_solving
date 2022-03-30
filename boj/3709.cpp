#include <iostream>
#include <cstring>

using namespace std;

int board[51][51];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);

	int t, n, r, tmpX, tmpY, lzX, lzY, curD;
	cin >> t;
	for (int i = 0; i < t; i++) {
		memset(board, 0, sizeof(board));
		cin >> n >> r;
		for (int j = 0; j < r; j++) {
			cin >> tmpX >> tmpY;
			board[tmpX][tmpY] = 1;
		}

		cin >> lzX >> lzY;
		if (lzX == 0) {
			lzX++;
			curD = 3;
		}
		else if (lzX == n + 1) {
			lzX--;
			curD = 1;
		}
		else if (lzY == 0) {
			lzY++;
			curD = 2;
		}
		else {
			lzY--;
			curD = 4;
		}

		while (lzX != 0 && lzX != n + 1 && lzY != 0 && lzY != n + 1) {
			if (!board[lzX][lzY]) {
				switch (curD) {
				case 1:
					lzX--;
					break;
				case 2:
					lzY++;
					break;
				case 3:
					lzX++;
					break;
				case 4:
					lzY--;
				}
			}
			else {
				switch (curD) {
				case 1:
					lzY++;
					curD = 2;
					break;
				case 2:
					lzX++;
					curD = 3;
					break;
				case 3:
					lzY--;
					curD = 4;
					break;
				case 4:
					lzX--;
					curD = 1;
				}
			}
		}
		cout << lzX << ' ' << lzY << "\n";
	}

	return 0;
}
