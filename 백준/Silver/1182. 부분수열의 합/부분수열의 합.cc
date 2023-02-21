#include <iostream>

using namespace std;

int n, s;
int cnt = 0;
int arr[21];

void func(int k, int total) {
	if (k == n) {
		if (total == s) {
			cnt++;
		}
		return;
	}

	func(k + 1, total); //k번째 수 선택하지 않음
	func(k + 1, total + arr[k]); //k번째 수 선택
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);

	cin >> n >> s;

	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}

	func(0, 0);
	if (s == 0) {
		cnt--;
	}

	cout << cnt;

	return 0;
}