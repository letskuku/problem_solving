#include <iostream>
#include <algorithm>

using namespace std;

int dp[100002]; //i를 표현하는 제곱수 항의 최소 개수

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);

	int n;
	
	cin >> n;

	for (int i = 1; i <= n; i++) {
		dp[i] = i; //최악의 경우
		for (int j = 1; j * j <= i; j++) {
			dp[i] = min(dp[i], dp[i - j * j] + 1);
		}
	}

	cout << dp[n];

	return 0;
}