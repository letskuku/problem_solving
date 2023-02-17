#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

bool compare(pair<int, int> a, pair<int, int> b) {
    if (a.first == b.first) {
        return a.second < b.second;
    }

    return a.first < b.first;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int n; //점의 개수
    int x, y; //좌표
    vector<pair<int, int>> v; //좌표 저장

    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> x >> y;
        v.emplace_back(make_pair(x, y));
    }

    sort(v.begin(), v.end(), compare); //정렬

    for (int i = 0; i < v.size(); i++) {
        cout << v[i].first << ' ' << v[i].second << '\n';
    }

    return 0;
}