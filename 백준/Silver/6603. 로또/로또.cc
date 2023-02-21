#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int k;
int s[15];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);

	while (1) {
		cin >> k;
		if (k == 0) {
			break;
		}

		for (int i = 0; i < k; i++) {
			cin >> s[i];
		}

		vector<int> v(6);
		for (int i = 0; i < k - 6; i++) {
			v.emplace_back(1);
		}

		do {
			for (int i = 0; i < v.size(); i++) {
				if (v[i] == 0) {
					cout << s[i] << ' ';
				}
			}
			cout << '\n';
		} while (next_permutation(v.begin(), v.end()));

		cout << '\n';
	}

	return 0;
}