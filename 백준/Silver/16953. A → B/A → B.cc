#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

long long a, b, cnt;
queue<pair<long long, long long>> q;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    
    cin >> a >> b;

    cnt = -2;
    q.push({ a, 0 });
    while (!q.empty()) {
        pair<long long, long long> cur = q.front();
        q.pop();

        long long mult = cur.first * 2;
        long long add = cur.first * 10 + 1;

        if (mult == b || add == b) {
            cnt = cur.second + 1;
            break;
        }

        if (mult < b) {
            q.push({ mult, cur.second + 1 });
        }

        if (add < b) {
            q.push({ add, cur.second + 1 });
        }
    }

    cout << cnt + 1 << '\n';

    return 0;
}