#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int dist[105][105];
queue<pair<int, int>> q;
int dx[4] = {0, 0, -1, 1};
int dy[4] = {-1, 1, 0, 0};

int solution(vector<vector<int> > maps)
{
    int answer = 0;
    
    int n, m;
    
    n = maps.size();
    m = maps[0].size();
    
    q.push({0, 0});
    dist[0][0] = 1;
    while(!q.empty()) {
        pair<int, int> cur = q.front();
        q.pop();
        
        for (int i = 0; i < 4; i++) {
            int nx = cur.first + dx[i];
            int ny = cur.second + dy[i];
            
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue;
            }
            
            if (maps[nx][ny] == 0 || dist[nx][ny] > 0) {
                continue;
            }
            
            dist[nx][ny] = dist[cur.first][cur.second] + 1;
            q.push({nx, ny});
            
            if (nx == n - 1 && ny == m - 1) {
                answer = dist[nx][ny];
                return answer;
            }
        }
    }
    
    if (dist[n - 1][m - 1] == 0) {
        answer = -1;
    }
    
    return answer;
}