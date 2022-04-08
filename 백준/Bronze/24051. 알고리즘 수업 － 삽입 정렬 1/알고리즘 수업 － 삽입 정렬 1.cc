#include <iostream>

using namespace std;

int list[10001];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);

	int n, k, cnt, key, tmp, ans;

	cin >> n >> k;
	for (int i = 0; i < n; i++) {
		cin >> list[i];
	}

	cnt = 0; ans = -1;
	for (int i = 1; i < n; i++) {
		key = list[i];
		tmp = i - 1;
		
		while (tmp >= 0 && list[tmp] > key) {
			list[tmp + 1] = list[tmp];
			if (++cnt == k) {
				ans = list[tmp];
			}
			tmp--;
		}
		if (tmp + 1 != i) {
			list[tmp + 1] = key;
			if (++cnt == k) {
				ans = key;
			}
		}
	}

	cout << ans << '\n';

	return 0;
}