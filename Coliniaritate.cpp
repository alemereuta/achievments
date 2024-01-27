#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Point{
    int x, y;
};

struct ColinearPoints{
    Point a, b, c;
    Point a_point,b_point, c_point;
};


int main(){
int n, i, j, k, a[10], b[10], c[10], d[10], e[10], aux1, aux2, aux3;
cout<<"Introdu numarul de puncte: ";
cin>>n;
vector<Point> A(n), B(n), C(n);

cout<<"Introduceti coordonatele pentru multimea A: "<<endl;
for(i=0; i<n; i++){
    cin>>A[i].x>>A[i].y;
}

cout<<"Introduceti coordonatele pentru multimea B: "<<endl;
for(j=0; j<n; j++){
    cin>>B[j].x>>B[j].y;//eventual folosesc un i, nu neparat j
}

cout<<"Introduceti coordonatele pentru multimea C: "<<endl;
for(k=0; k<n; k++){
    cin>>C[k].x>>C[k].y;
}

vector<ColinearPoints> colinearPoints;

sort(B.begin(), B.end(), [](Point p1, Point p2){
        return p1.x<p2.x;
});

sort(C.begin(), C.end(), [](Point p1, Point p2){
        return p1.x<p2.x;
});


vector<Point> D;

for(j=0; j<n; j++){
    D.push_back({2*B[j].x, 2*B[j].y});
}

vector<Point> E;

for(i=0; i<n; i++){
    for(k=0; k<n; k++){
        E.push_back({A[i].x+C[k].x, A[i].y+C[i].y});
    }
}


while(j<=n && k<=n){
    if(D[j].x==E[k].x && D[j].y==E[k].y){
            colinearPoints.push_back({A[i], B[j], C[k]});
            break;
    }
    if(D[j].x<E[k].x){
        j++;
    }
    if(D[j].x<E[k].x){
        k++;
    }
}

if(!colinearPoints.empty()){
    cout<<"Punctele coliniare exista in lista si sunt: "<<endl;
    for(i=0; i<colinearPoints.size(); i++){
        cout<<"A("<<colinearPoints[i].a_point.x<<","<<colinearPoints[i].a_point.y<<")"<<endl;
        cout<<"B("<<colinearPoints[i].b_point.x<<","<<colinearPoints[i].b_point.y<<")"<<endl;
        cout<<"c("<<colinearPoints[i].c_point.x<<","<<colinearPoints[i].c_point.y<<")"<<endl;
    }
}
else {
    cout<<"In lista nu exista puncte coliniare."<<endl;
}

return 0;

}
