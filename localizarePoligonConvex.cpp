#include <iostream>
#include <cmath>
#include <algorithm>
#include <vector>

using namespace std;

struct Point {
    double x, y;
};

Point calculeazaCG(const vector<Point>& points);
vector<Point> translateToOrigin(const vector<Point>& points, const Point& centruDeGreutate);
bool isOnBoundary(const vector<Point>& polygon, const Point& point);
bool isOnLineSegment(const Point& a, const Point& b, const Point& point);
string locatePointInConvexPolygon(const vector<Point>& polygon, const Point& point);
vector<Point> sortPoints(const vector<Point>& points);
bool inversTrigonometric(const Point& a, const Point& b, const Point& point);

int main() {
    vector<Point> polygon = {{0, 0}, {0, 1}, {1, 1}, {1, 0}};
    //Point point = {0.3, 0.3}; // interior
    //Point point = {1.2, 0.8}; // exterior
    Point point = {0.5, 0.5}; // pe frontiera


    string result = locatePointInConvexPolygon(polygon, point);
    cout << result << endl;

    return 0;
}


Point calculeazaCG(const vector<Point>& points) {
    int n = points.size();
    double sumX = 0, sumY = 0;

    for (int i = 0; i < n; i++) {
        sumX += points[i].x;
        sumY += points[i].y;
    }

    return {sumX / n, sumY / n};
}

vector<Point> translateToOrigin(const vector<Point>& points, const Point& centruDeGreutate) {
    int n = points.size();
    vector<Point> newPoints(n);

    for (int i = 0; i < n; i++) {
        newPoints[i].x = points[i].x - centruDeGreutate.x;
        newPoints[i].y = points[i].y - centruDeGreutate.y;
    }

    return newPoints;
}

bool isOnBoundary(const vector<Point>& polygon, const Point& point) {
    int n = polygon.size();

    for (int i = 0; i < n; i++) {
        Point a = polygon[i];
        Point b = polygon[(i + 1) % n];
        if (isOnLineSegment(a, b, point)) {
            return true;
        }
    }

    return false;
}

bool isOnLineSegment(const Point& a, const Point& b, const Point& point) {
    double det = (point.y - a.y) * (b.x - a.x) - (point.x - a.x) * (b.y - a.y);

    if (fabs(det) > 1e-10) {
        return false;
    }

    double det2 = (point.x - a.x) * (b.x - a.x) + (point.y - a.y) * (b.y - a.y);

    if (det2 < 0) {
        return false;
    }

    double lengthSquaredAB = pow(b.x - a.x, 2) + pow(b.y - a.y, 2);

    return det2 <= lengthSquaredAB;
}

string locatePointInConvexPolygon(const vector<Point>& polygon, const Point& point) {
    Point centruDeGreutate = calculeazaCG(polygon);

    vector<Point> translatedPoints = translateToOrigin(polygon, centruDeGreutate);

    vector<Point> sortedPoints = sortPoints(translatedPoints);

    int n = polygon.size();
    int left = 0;
    int right = n - 1;
    bool onBoundary = false;
    bool inInterior = false;

    while (right - left > 1) {
        int mid = (left + right) / 2;
        if (inversTrigonometric(sortedPoints[0], sortedPoints[mid], point)) {
            right = mid;
        } else {
            left = mid;
        }
    }

    if (isOnLineSegment(sortedPoints[left], sortedPoints[right], point)) {
        onBoundary = true;
        inInterior = false;
    } else if (inversTrigonometric(sortedPoints[right], sortedPoints[left], point)) {
        inInterior = true;
    }

    if (onBoundary) {
        return "Punctul M(0.5, 0.5) se afla pe frontiera.";
    } else if (inInterior) {
        return "Punctul M(0.3, 0.3) se afla in interior.";
    } else {
        return "Punctul M(1.2, 0.8) se afla in exterior.";
    }
}

vector<Point> sortPoints(const vector<Point>& points) {
    vector<Point> sortedPoints = points;
    sort(sortedPoints.begin(), sortedPoints.end(), [](const Point& a, const Point& b) {
        return atan2(a.y, a.x) < atan2(b.y, b.x);
    });
    return sortedPoints;
}

bool inversTrigonometric(const Point& a, const Point& b, const Point& point) {
    return (b.x - a.x) * (point.y - a.y) - (point.x - a.x) * (b.y - a.y) < 0;
}
