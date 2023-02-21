#include <iostream>
#include <algorithm>

using namespace std;

int n, m;
int answer[10];
int arr[10];

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

	for (int i = num; i < n; i++)
	{
		answer[level] = arr[i];
		solve(level + 1, i + 1);
	}
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);

	cin >> n >> m;
	
	for (int i = 0; i < n; i++)
	{
		cin >> arr[i];
	}

	sort(arr, arr + n);

	solve(0, 0);

	return 0;
}