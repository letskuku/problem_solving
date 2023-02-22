#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

string str[51];

bool cmp(string a, string b) {
	if (a.size() != b.size()) {
		return a.size() < b.size();
	}

	int aa = 0, bb = 0;
	for (int i = 0; i < a.size(); i++) {
		if (a[i] - '0' <= 9) {
			aa += a[i] - '0';
		}

		if (b[i] - '0' <= 9) {
			bb += b[i] - '0';
		}
	}
	if (aa != bb) {
		return aa < bb;
	}

	return a < b;
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);

	int n;

	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> str[i];
	}

	sort(str, str + n, cmp);
	for (int i = 0; i < n; i++) {
		cout << str[i] << '\n';
	}

	return 0;
}