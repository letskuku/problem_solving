#include <iostream>

using namespace std;

int dp[1000002];
int path[1000002];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);

	int n;
	
	cin >> n;

	dp[1] = 0; path[1] = 0;
	for (int i = 2; i <= n; i++) {
		dp[i] = dp[i - 1] + 1;
		path[i] = i - 1;

		if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
			dp[i] = dp[i / 2] + 1;
			path[i] = i / 2;
		}

		if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
			dp[i] = dp[i / 3] + 1;
			path[i] = i / 3;
		}
	}

	cout << dp[n] << '\n';
	cout << n << ' ';
	while (path[n]) {
		cout << path[n] << ' ';
		n = path[n];
	}

	return 0;
}