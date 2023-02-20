#include <iostream>

using namespace std;

//2^n * 2^n 배열에서 (r, c)를 방문하는 순서를 반환하는 함수
int func(int n, int r, int c) {
	//base condition
	if (n == 0) {
		return 0;
	}

	int half = 1 << (n - 1); //배열 한 변 길이의 절반
	if (r < half && c < half) { //첫번째 사각형
		return func(n - 1, r, c);
	}
	if (r < half && c >= half) { //두번째 사각형
		return half * half + func(n - 1, r, c - half);
	}
	if (r >= half && c < half) { //세번째 사각형
		return 2 * half * half + func(n - 1, r - half, c);
	}
	return 3 * half * half + func(n - 1, r - half, c - half);
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);

	int n, r, c;

	cin >> n >> r >> c;

	cout << func(n, r, c);

	return 0;
}