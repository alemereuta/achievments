#include <iostream>
#include <math.h>
using namespace std;

struct Point {
    double x, y;
};

double crossProduct(Point A, Point B) {
    return A.x*B.y-A.y*B.x;
}

bool isOnEdge(Point A, Point B, Point M) {
    double edgeLength = sqrt((B.x - A.x)*(B.x - A.x)+(B.y - A.y)*(B.y - A.y));
    double AM = sqrt((M.x - A.x)*(M.x - A.x)+(M.y - A.y)*(M.y - A.y));
    double MB = sqrt((M.x - B.x)*(M.x - B.x)+(M.y - B.y)*(M.y - B.y));
    return abs(AM + MB - edgeLength)< 1e-9;
}

int locatePoint(Point A, Point B, Point C, Point M) {
    double crossABM = crossProduct(Point{B.x - A.x, B.y - A.y}, Point{M.x - A.x, M.y - A.y});
    double crossBCM = crossProduct(Point{C.x - B.x, C.y - B.y}, Point{M.x - B.x, M.y - B.y});
    double crossCAM = crossProduct(Point{A.x - C.x, A.y - C.y}, Point{M.x - C.x, M.y - C.y});

    if (isOnEdge(A, B, M) || isOnEdge(B, C, M) || isOnEdge(C, A, M)) {
        return 0;
    }

    if ((crossABM > 0 && crossBCM > 0 && crossCAM > 0) || (crossABM < 0 && crossBCM < 0 && crossCAM < 0)) {
        return 1;
    }

    return -1;
}

int main(){
    Point A, B, C, M;

    cout<<"Introduceti coordonatele varfului A (xA yA):";
    cin>>A.x>>A.y;

    cout<<"Introduceti coordonatele varfului B (xB yB):";
    cin>>B.x>>B.y;

    cout<<"Introduceti coordonatele varfului C (xC yC):";
    cin>>C.x>>C.y;

    cout<<"Introduceti coordonatele punctului M (xM yM):";
    cin>>M.x>>M.y;

    int location = locatePoint(A, B, C, M);

    if(location == 0) {
        cout<<"Punctul M este pe frontiera triunghiului ABC."<<endl;
    } else if(location == 1) {
        cout<<"Punctul M este în interiorul triunghiului ABC."<<endl;
    } else {
        cout<<"Punctul M este în exteriorul triunghiului ABC."<<endl;
    }

    return 0;
}
