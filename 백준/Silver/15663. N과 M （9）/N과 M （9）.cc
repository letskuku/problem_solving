#include <iostream>
#include <algorithm>

using namespace std;

int n, m;
int num[10]; //n개의 자연수
int arr[10]; //수열 저장
bool isused[10]; //방문 여부

void func(int k) {
	//숫자 m개 선택 완료
	if (k == m) {
		for (int i = 0; i < m; i++) {
			cout << arr[i] << ' ';
		}
		cout << '\n';
	
		return;
	}

	int last = 0; //중복 방지
	for (int i = 1; i <= n; i++) {
		if (!isused[i] && num[i] != last) {
			arr[k] = num[i];
			last = num[i];
			isused[i] = true;
			func(k + 1);
			isused[i] = false;
		}
	}
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);

	cin >> n >> m;
	for (int i = 1; i <= n; i++) {
		cin >> num[i];
	}

	sort(num, num + n + 1);
	func(0);

	return 0;
}