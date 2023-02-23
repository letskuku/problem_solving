#include <iostream>
#include <algorithm>

using namespace std;

int dp[305][3]; //j개 계단 연속으로 밟아 i층 도착했을 때의 최대 점수
int score[305];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);

	int n;

	cin >> n;
	
	for (int i = 1; i <= n; i++) {
		cin >> score[i];
	}

	dp[1][1] = score[1];
	dp[2][1] = score[2]; dp[2][2] = dp[1][1] + score[2];
	for (int i = 3; i <= n; i++) {
		dp[i][1] = max(dp[i - 2][1], dp[i - 2][2]) + score[i];
		dp[i][2] = dp[i - 1][1] + score[i];
	}

	cout << max(dp[n][1], dp[n][2]);

	return 0;
}