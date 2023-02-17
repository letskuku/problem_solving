#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

struct student {
    string name;
    int kor, eng, math;
} s[100001];

bool compare(student a, student b) {
    if ((a.kor == b.kor) && (a.eng == b.eng) && (a.math == b.math)) {
        return a.name < b.name;
    }
    else if ((a.kor == b.kor) && (a.eng == b.eng)) {
        return a.math > b.math;
    }
    else if (a.kor == b.kor) {
        return a.eng < b.eng;
    }
    else {
        return a.kor > b.kor;
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int n; //학생 수

    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> s[i].name >> s[i].kor >> s[i].eng >> s[i].math;
    }

    sort(s, s + n, compare);

    for (int i = 0; i < n; i++) {
        cout << s[i].name << '\n';
    }

    return 0;
}