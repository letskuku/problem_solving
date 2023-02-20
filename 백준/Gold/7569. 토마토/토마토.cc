#include <iostream>
#include <algorithm>
#include <queue>
#include <tuple>

using namespace std;

int n, m, h, day;
int board[101][101][101];
int dist[101][101][101];
int dx[6] = { 0, 0, -1, 1, 0, 0 };
int dy[6] = { -1, 1, 0, 0, 0, 0 };
int dz[6] = { 0, 0, 0, 0, -1, 1 };
queue<tuple<int, int, int>> q;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);

	cin >> m >> n >> h;

	for (int i = 0; i < h; i++) {
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < m; k++) {
				cin >> board[i][j][k];

				if (board[i][j][k] == 1) {
					q.push({ i, j ,k });
				}

				if (board[i][j][k] == 0) {
					dist[i][j][k] = -1;
				}
			}
		}
	}

	while (!q.empty()) {
		tuple<int, int, int> cur = q.front();
		q.pop();

		for (int i = 0; i < 6; i++) {
			int nz = get<0>(cur) + dz[i];
			int nx = get<1>(cur) + dx[i];
			int ny = get<2>(cur) + dy[i];

			if (nz < 0 || nz >= h || nx < 0 || nx >= n || ny < 0 || ny >= m) {
				continue;
			}

			if (dist[nz][nx][ny] >= 0) {
				continue;
			}

			dist[nz][nx][ny] = dist[get<0>(cur)][get<1>(cur)][get<2>(cur)] + 1;
			q.push({ nz, nx, ny });
		}
	}

	day = 0;
	for (int i = 0; i < h; i++) {
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < m; k++) {
				if (dist[i][j][k] == -1) {
					cout << -1 << '\n';
					return 0;
				}

				day = max(day, dist[i][j][k]);
			}
		}
	}

	cout << day << '\n';

	return 0;
}