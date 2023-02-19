#include <iostream>
#include <queue>
#include <algorithm>
#include <string>

using namespace std;

string board[101];
int dist[101][101];
int dx[4] = {0, 0, -1, 1};
int dy[4] = {1, -1, 0, 0};
int n, m;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    queue<pair<int, int>> q;

    cin >> n >> m;

    for (int i = 0; i < n; i++) {
        cin >> board[i];
    }

    for (int i = 0; i < n; i++) {
        fill(dist[i], dist[i] + m, -1); //거리 초기화
    }

    dist[0][0] = 0;
    q.push({ 0,0 });
    while (!q.empty()) {
        pair<int, int> cur = q.front();
        q.pop();

        for (int i = 0; i < 4; i++) {
            int nx = cur.first + dx[i];
            int ny = cur.second + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue;
            }

            if (board[nx][ny] == '0' || dist[nx][ny] >= 0) {
                continue;
            }

            dist[nx][ny] = dist[cur.first][cur.second] + 1;
            q.push({ nx, ny });
        }
    }

    cout << dist[n - 1][m - 1] + 1 << '\n';

    return 0;
}