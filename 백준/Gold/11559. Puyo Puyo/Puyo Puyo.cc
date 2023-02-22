#include <iostream>
#include <algorithm>
#include <queue>
#include <string>
#include <vector>

using namespace std;

int cnt = 0;
string board[13];
bool visit[13][7];
bool erase[7];
int dx[4] = { 0, 0, -1, 1 };
int dy[4] = { -1, 1, 0, 0 };

//터짐 발생하는지 알려주는 함수
bool func() {
	bool check = false;
	for (int i = 0; i < 12; i++) {
		for (int j = 0; j < 6; j++) {
			if (board[i][j] != '.' && !visit[i][j]) {
				queue<pair<int, int>> q1;
				vector<pair<int, int>> v;

				q1.push({ i, j });
				visit[i][j] = true;

				int connected = 0;
				while (!q1.empty()) {
					pair<int, int> cur = q1.front();
					q1.pop();
					v.emplace_back(cur);
					connected++;

					for (int k = 0; k < 4; k++) {
						int nx = cur.first + dx[k];
						int ny = cur.second + dy[k];

						if (nx < 0 || nx >= 12 || ny < 0 || ny >= 6) {
							continue;
						}

						if (board[cur.first][cur.second] != board[nx][ny] || visit[nx][ny]) {
							continue;
						}

						visit[nx][ny] = true;
						q1.push({ nx, ny });
					}
				}

				if (connected >= 4) {
					check = true;
					for (int k = 0; k < v.size(); k++) {
						board[v[k].first][v[k].second] = '.';
						erase[v[k].second] = true;
					}
				}
			}
		}
	}

	for (int i = 0; i < 7; i++) {
		if (erase[i]) {
			for (int j = 0; j < 11; j++) {
				if (board[j][i] == '.') {
					for (int k = j + 1; k < 12; k++) {
						if (board[k][i] != '.') {
							board[j][i] = board[k][i];
							board[k][i] = '.';
							break;
						}
					}
				}
			}
		}
	}

	return check;
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);

	for (int i = 11; i >= 0; i--) {
		cin >> board[i];
	}

	while (1) {
		if (!func()) {
			break;
		}
		cnt++;

		for (int i = 0; i < 12; i++) {
			fill(visit[i], visit[i] + 7, false);
		}
		fill(erase, erase + 7, false);
	}

	cout << cnt;

	return 0;
}