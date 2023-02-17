#include <iostream>
#include <queue>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int n, x;
    priority_queue<int, vector<int>, greater<int>> pq;

    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> x;

        if (x) {
            pq.push(x);
        }
        else {
            if (pq.empty()) {
                cout << "0 \n";
            }
            else {
                cout << pq.top() << '\n';
                pq.pop();
            }
        }
    }

    return 0;
}