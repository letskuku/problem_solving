#include <iostream>

using namespace std;

bool arr[10100] = { false }; //셀프 넘버 여부 표시할 배열

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int n; //생성자
    int num; //d(n) 계산 값

    for (int i = 1; i < 10001; i++) {
        num = 0;
        n = i;

        //d(i) 계산
        num += n;
        while (n / 10) {
            num += (n % 10);
            n /= 10;
        }
        num += n;

        arr[num] = true;
    }

    for (int i = 1; i < 10001; i++) {
        if (!arr[i]) {
            cout << i << "\n";
        }
    }

    return 0;
}