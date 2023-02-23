#include <iostream>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

int n;
string str;
vector<long long> v;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);

	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> str;
		reverse(str.begin(), str.end());
		v.emplace_back(stoll(str));
	}

	sort(v.begin(), v.end());
	for (int i = 0; i < n; i++) {
		cout << v[i] << '\n';
	}

	return 0;
}