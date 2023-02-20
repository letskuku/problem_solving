#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

int n, m, day;
int board[1001][1001];
int dist[1001][1001];
int dx[4] = { 0, 0, -1, 1 };
int dy[4] = { -1, 1, 0, 0 };
queue<pair<int, int>> q;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);

	cin >> m >> n;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> board[i][j];
			if (board[i][j] == 1) {
				q.push({ i, j });
			}
			
			if (board[i][j] == 0) {
				dist[i][j] = -1;
			}			
		}
	}

	while (!q.empty()) {
		pair<int, int> cur = q.front();
		q.pop();

		for (int i = 0; i < 4; i++) {
			int nx = cur.first + dx[i];
			int ny = cur.second + dy[i];

			if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
				continue;
			}

			if (dist[nx][ny] >= 0 || board[nx][ny] == -1) {
				continue;
			}

			dist[nx][ny] = dist[cur.first][cur.second] + 1;
			q.push({ nx, ny });
		}
	}

	day = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (dist[i][j] == -1) {
				cout << -1 << '\n';
				return 0;
			}

			day = max(day, dist[i][j]);
		}
	}

	cout << day << '\n';

	return 0;
}