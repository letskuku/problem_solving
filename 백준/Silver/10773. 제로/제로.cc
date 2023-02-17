#include <iostream>
#include <stack>

using namespace std;

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int k, money;
	int sum = 0;

	stack <int> st;

	cin >> k;

	for (int i = 0; i < k; i++)
	{
		cin >> money;

		if (money == 0)
		{
			st.pop();
		}
		else
		{
			st.push(money);
		}
	}

	while (!st.empty())
	{
		sum += st.top();
		st.pop();
	}

	cout << sum;

	return 0;
}