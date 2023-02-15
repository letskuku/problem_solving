#include <iostream>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int m; //수행해야 하는 연산의 수
    int s[21] = { 0 }; //공집합 S
    int x;

    string command;

    cin >> m;

    for (int i = 0; i < m; i++) {
        cin >> command;

        if (command == "add") {
            cin >> x;
            s[x] = 1;
        }
        else if (command == "remove") {
            cin >> x;
            s[x] = 0;
        }
        else if (command == "check") {
            cin >> x;
            cout << s[x] << "\n";
        }
        else if (command == "toggle") {
            cin >> x;
            s[x] ^= 1;
        }
        else if (command == "all") {
            for (int j = 1; j < 21; j++) {
                s[j] = 1;
            }
        }
        else if (command == "empty") {
            for (int j = 1; j < 21; j++) {
                s[j] = 0;
            }
        }
    }

    return 0;
}