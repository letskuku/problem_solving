#include <iostream>
#include <algorithm>
#include <queue>
#include <string>

using namespace std;

int r, c;
string board[1001];
int distF[1001][1001];
int distJ[1001][1001];
int dx[4] = { 0, 0, -1, 1 };
int dy[4] = { -1, 1, 0, 0 };

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);

	cin >> r >> c;

	for (int i = 0; i < r; i++) {
		cin >> board[i];

		fill(distF[i], distF[i] + c, -1);
		fill(distJ[i], distJ[i] + c, -1);
	}

	queue <pair<int, int>> q1;
	queue<pair<int, int>> q2;
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			if (board[i][j] == 'F') {
				distF[i][j] = 0;
				q1.push({ i, j });
			}

			if (board[i][j] == 'J') {
				q2.push({ i, j });
				distJ[i][j] = 0;
			}
		}
	}

	while (!q1.empty()) {
		pair<int, int> fire = q1.front();
		q1.pop();

		for (int i = 0; i < 4; i++) {
			int nx = fire.first + dx[i];
			int ny = fire.second + dy[i];

			if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
				continue;
			}

			if (board[nx][ny] == '#' || distF[nx][ny] >= 0) {
				continue;
			}

			distF[nx][ny] = distF[fire.first][fire.second] + 1;
			q1.push({ nx, ny });
		}
	}

	while (!q2.empty()) {
		pair<int, int> jihoon = q2.front();
		q2.pop();

		for (int i = 0; i < 4; i++) {
			int nx = jihoon.first + dx[i];
			int ny = jihoon.second + dy[i];

			if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
				cout << distJ[jihoon.first][jihoon.second] + 1 << '\n';
				return 0;
			}

			if (board[nx][ny] == '#' || distJ[nx][ny] >= 0 ) {
				continue;
			}

			if ((distJ[jihoon.first][jihoon.second] + 1) >= distF[nx][ny] && distF[nx][ny] != -1) {
				continue;
			}

			distJ[nx][ny] = distJ[jihoon.first][jihoon.second] + 1;
			q2.push({ nx, ny });
		}
	}

	cout << "IMPOSSIBLE \n";

	return 0;
}