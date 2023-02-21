#include <iostream>
#include <algorithm>
#include <queue>
#include <string>

using namespace std;

bool mask[25];
string board[5];
int cnt = 0;
int dx[4] = { 0, 0, -1, 1 };
int dy[4] = { -1, 1, 0, 0 };

int main()
{
	for (int i = 0; i < 5; i++) {
		cin >> board[i];
	}

	fill(mask + 7, mask + 25, true);

	do {
		int dasom = 0, adj = 0;
		queue<pair<int, int>> q;
		bool check[5][5] = { false };
		bool visit[5][5] = { false };

		for (int i = 0; i < 25; i++) {
			if (!mask[i]) {
				int x = i / 5; int y = i % 5;
				check[x][y] = true;
				if (q.empty()) {
					q.push({ x, y });
					visit[x][y] = true;
				}
			}
		}

		while (!q.empty()) {
			pair<int, int> cur = q.front();
			q.pop();
			adj++;
			dasom += board[cur.first][cur.second] == 'S';

			for (int i = 0; i < 4; i++) {
				int nx = cur.first + dx[i];
				int ny = cur.second + dy[i];

				if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || visit[nx][ny] || !check[nx][ny]) {
					continue;
				}

				q.push({ nx, ny });
				visit[nx][ny] = true;
			}
		}

		if (dasom > 3 && adj == 7) {
			cnt++;
		}
	} while (next_permutation(mask, mask + 25));

	cout << cnt;

	return 0;
}