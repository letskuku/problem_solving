#include <iostream>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int m; //수행해야 하는 연산의 수
    int s = 0; //공집합 S
    int x;

    string command;

    cin >> m;

    for (int i = 0; i < m; i++) {
        cin >> command;

        if (command == "add") {
            cin >> x;
            s |= (1 << x);
        }
        else if (command == "remove") {
            cin >> x;
            s &= ~(1 << x);
        }
        else if (command == "check") {
            cin >> x;
            if (s & (1 << x)) {
                cout << "1 \n";
            }
            else {
                cout << "0 \n";
            }
        }
        else if (command == "toggle") {
            cin >> x;
            s ^= (1 << x);
        }
        else if (command == "all") {
            s = 0b111111111111111111111;
        }
        else if (command == "empty") {
            s = 0;
        }
    }

    return 0;
}