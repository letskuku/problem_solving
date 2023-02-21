#include <iostream>

using namespace std;

int n;
int cnt = 0;

bool isused1[15]; //열 검사
bool isused2[30]; //우상향 검사
bool isused3[30]; //좌상향 검사

void solve(int level)
{
	if (level == n)
	{
		cnt++;

		return;
	}

	for (int i = 0; i < n; i++)
	{
		if (isused1[i] || isused2[level + i] || isused3[level - i + n - 1])
		{
			continue;
		}

		isused1[i] = true;
		isused2[level + i] = true;
		isused3[level - i + n - 1] = true;

		solve(level + 1);

		isused1[i] = false;
		isused2[level + i] = false;
		isused3[level - i + n - 1] = false;
	}
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);

	cin >> n;

	solve(0);

	cout << cnt << "\n";

	return 0;
}