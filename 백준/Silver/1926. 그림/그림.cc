#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

int board[501][501];
bool visit[501][501] = {false};
int dx[4] = {0, 0, -1, 1};
int dy[4] = {1, -1, 0, 0};
int n, m;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int picNum, maxPic;

    cin >> n >> m;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> board[i][j];
        }
    }

    picNum = 0; maxPic = 0;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (visit[i][j] || !board[i][j]) {
                continue; //그림 시작점 찾기
            }

            picNum++;
            queue<pair<int, int>> q;
            int size = 0;

            visit[i][j] = true;
            q.push({ i, j });
            while (!q.empty()) {
                pair<int, int> cur = q.front();
                q.pop();
                size++;

                for (int k = 0; k < 4; k++) {
                    int nx = cur.first + dx[k];
                    int ny = cur.second + dy[k];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                        continue;
                    }

                    if (visit[nx][ny] || !board[nx][ny]) {
                        continue;
                    }

                    visit[nx][ny] = true;
                    q.push({ nx, ny });
                }
            }

            if (size > maxPic) {
                maxPic = size;
            }
        }
    }

    cout << picNum << '\n' << maxPic << '\n';

    return 0;
}