#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdlib>

using namespace std;

int n, m;
int board[52][52];
int dist[101];
vector<pair<int, int>> chicken;
vector<pair<int, int>> house;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);

	cin >> n >> m;

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			cin >> board[i][j];

			if (board[i][j] == 2) {
				chicken.emplace_back(make_pair(i, j));
				continue;
			}

			if (board[i][j] == 1) {
				house.emplace_back(make_pair(i, j));
			}
		}
	}

	int ans = 987654321;
	vector<int> per(m);
	for (int i = 0; i < chicken.size() - m; i++) {
		per.emplace_back(1);
	}

	do {
		fill(dist, dist + house.size(), 100);

		for (int i = 0; i < per.size(); i++) {
			if (per[i] == 0) {
				for (int j = 0; j < house.size(); j++) {
					dist[j] = min(dist[j], abs(house[j].first - chicken[i].first) + abs(house[j].second - chicken[i].second));
				}
			}
		}

		int val = 0;
		for (int i = 0; i < house.size(); i++) {
			val += dist[i];
		}

		ans = min(ans, val);
	} while (next_permutation(per.begin(), per.end()));

	cout << ans;

	return 0;
}