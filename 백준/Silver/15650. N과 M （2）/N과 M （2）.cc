#include <iostream>

using namespace std;

int n, m;
int answer[10];

void solve(int level, int num)
{
	if (level == m)
	{
		for (int i = 0; i < m; i++)
		{
			cout << answer[i] << " ";
		}

		cout << "\n";
		return;
	}

	for (int i = num + 1; i <= n; i++)
	{
		answer[level] = i;
		solve(level + 1, i);
	}
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);

	cin >> n >> m;
	solve(0, 0);

	return 0;
}