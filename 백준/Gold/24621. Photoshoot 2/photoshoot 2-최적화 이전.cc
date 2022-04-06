/*
최적화 이전 놓친 부분
=> 정렬 결과를 출력하는 것이 아니므로 일일이 정렬할 필요 없음
  => 벡터, 이진탐색 부분 필요 없음
    => 이미 정렬한 것들 중 우선순위가 가장 높은 값을 저장하고 우선순위만 비교하여 우선순위 최댓값, ans 업데이트하면 됨
*/
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
