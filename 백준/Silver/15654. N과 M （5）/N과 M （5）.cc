#include <iostream>
#include <algorithm>

using namespace std;

int n, m;
int answer[10];
int arr[10];
bool isused[10];

void solve(int level)
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

	for (int i = 0; i < n; i++)
	{
		if (isused[i])
		{
			continue;
		}

		answer[level] = arr[i];
		isused[i] = true;

		solve(level + 1);

		isused[i] = false;
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

	solve(0);

	return 0;
}