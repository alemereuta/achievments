#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

struct Point {
    double x, y;
};

double crossProduct(Point A, Point B) {
    return A.x * B.y - A.y * B.x;
}

bool isOnEdge(Point A, Point B, Point M) {
    return abs(crossProduct(Point{B.x - A.x, B.y - A.y}, Point{M.x - A.x, M.y - A.y})) < 1e-9 &&
    (M.x >= min(A.x, B.x) && M.x <= max(A.x, B.x) && M.y >= min(A.y, B.y) && M.y <= max(A.y, B.y));
}

int locatePoint(const vector<Point>& polygon, Point M) {
    int n = polygon.size();
    int crossings = 0;

    for (int i = 0; i < n; i++) {
        int j = (i + 1) % n;
        if(isOnEdge(polygon[i], polygon[j], M)) {
            return 0;
        }
        if(polygon[i].y < M.y && polygon[j].y >= M.y || polygon[j].y < M.y && polygon[i].y >= M.y) {
            if (polygon[i].x + (M.y - polygon[i].y) / (polygon[j].y - polygon[i].y) * (polygon[j].x - polygon[i].x) < M.x) {
                crossings++;
            }
        }
    }

    return (crossings % 2 == 1) ? 1 : -1;
}

int main() {
    int numVertices;
    cout<<"Introduceti numarul de varfuri ale poligonului: ";
    cin>>numVertices;

    vector<Point> polygon;
    for (int i = 0; i < numVertices; i++) {
        double x, y;
        cout<<"Introduceti coordonatele varfului A"<<i + 1<<" (x y):";
        cin>>x>>y;
        polygon.push_back({x, y});
    }

    Point M;
    cout<<"Introduceti coordonatele punctului M(x y):";
    cin>>M.x>>M.y;

    int location = locatePoint(polygon, M);

    if(location == 0) {
        cout<<"Punctul M este pe frontiera poligonului."<<endl;
    } else if(location == 1) {
        cout<<"Punctul M este in interiorul poligonului."<<endl;
    } else {
        cout<<"Punctul M este in exteriorul poligonului."<<endl;
    }

    return 0;
}
