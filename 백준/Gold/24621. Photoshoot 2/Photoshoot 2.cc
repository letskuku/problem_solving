#include <iostream>
#include <vector>

using namespace std;

int priority[100001];
int init[100001];
vector<int> v;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);

	int n, tmp, left, right, mid, ans;

	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> init[i];
	}
	for (int i = 1; i <= n; i++) {
		cin >> tmp;
		priority[tmp] = i;
	}

	ans = 0;
	v.emplace_back(init[1]);
	for (int i = 2; i <= n; i++) {
		if (priority[init[i]] > priority[v.back()]) {
			v.emplace_back(init[i]);
			continue;
		}
		
		left = 0; right = i - 2; tmp = priority[init[i]];
		while (left < right) {
			mid = (left + right) >> 1;
			if (priority[v[mid]] > tmp) {
				right = mid;
			}
			else {
				left = mid + 1;
			}
		}
		v.insert(v.begin()+left, init[i]);
		ans++;
	}

	cout << ans << '\n';

	return 0;
}