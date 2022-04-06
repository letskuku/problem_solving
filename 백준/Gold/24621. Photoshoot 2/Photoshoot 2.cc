#include <iostream>

using namespace std;

int priority[100001];
int init[100001];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);

	int n, tmp, ans;

	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> init[i];
	}
	for (int i = 1; i <= n; i++) {
		cin >> tmp;
		priority[tmp] = i;
	}

	ans = tmp = 0;
	for (int i = 1; i <= n; i++) {
		if (tmp < priority[init[i]]) {
			tmp = priority[init[i]];
		}
		else {
			ans++;
		}
	}

	cout << ans << '\n';

	return 0;
}