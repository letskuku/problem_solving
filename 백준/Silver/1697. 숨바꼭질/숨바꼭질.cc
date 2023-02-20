#include <iostream>
#include <queue>

using namespace std;

int n, k;
int dist[100002];
queue<int> q;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);

	cin >> n >> k;

	fill(dist, dist + 100001, -1);

	dist[n] = 0;
	q.push(n);
	while (dist[k] == -1) {
		int cur = q.front();
		q.pop();

		int nx[3] = { cur - 1, cur + 1, cur * 2 };
		for (int i = 0; i < 3; i++) {
			if (nx[i] < 0 || nx[i] > 100000) {
				continue;
			}

			if (dist[nx[i]] >= 0) {
				continue;
			}

			q.push(nx[i]);
			dist[nx[i]] = dist[cur] + 1;
		}
	}

	cout << dist[k] << '\n';

	return 0;
}