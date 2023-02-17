#include <iostream>
#include <string>
#include <stack>

using namespace std;

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int t;
	bool confirm;

	string s;

	cin >> t;

	for (int i = 0; i < t; i++)
	{
		cin >> s;
		stack <char> st;
		confirm = true;

		for (int j = 0; j < s.size(); j++)
		{
			if (s[j] == '(')
			{
				st.push('(');
			}
			else if (s[j] == ')')
			{
				if (!st.empty() && st.top() == '(')
				{
					st.pop();
				}
				else
				{
					confirm = false;
					break;
				}
			}
		}

		if (st.empty() && confirm)
		{
			cout << "YES\n";
		}
		else
		{
			cout << "NO\n";
		}
	}

	return 0;
}