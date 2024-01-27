//C:/Users/alexa/OneDrive/Documents/GC/DCEL.txt

#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>

using namespace std;

struct HalfEdge {
    int edgeID;
    int vertexFrom;
    int vertexTo;
    int faceLeft;
    int faceRight;
    int prevClockwise;
    int prevCounterclockwise;
};

struct Vertex {
    double x;
    double y;
};

struct Face {
    vector<int> boundaryEdges;
    bool isOuter;
};

struct PSLG {
    vector<Vertex> V;
    vector<HalfEdge> E;
    vector<Face> F;
};

void printSet(const vector<int>& s) {
    cout << "{";
    for (int elem : s) {
        cout << elem << " ";
    }
    cout << "}" << endl;
}

PSLG readPSLGFromFile(const string& filename) {
    PSLG myPSLG;
    ifstream file(filename);

    if (!file.is_open()) {
        cerr << "Unable to open file: " << filename << endl;
        // Handle error accordingly
    }

    double x, y;
    while (file >> x >> y) {
        myPSLG.V.push_back({x, y});
    }

    file.clear();
    file.seekg(0, ios::beg); // Repositionare la începutul fișierului

    int edgeID, vertexFrom, vertexTo, faceLeft, faceRight, prevClockwise, prevCounterclockwise;
    while (file >> edgeID >> vertexFrom >> vertexTo >> faceLeft >> faceRight >> prevClockwise >> prevCounterclockwise) {
        myPSLG.E.push_back({edgeID, vertexFrom, vertexTo, faceLeft, faceRight, prevClockwise, prevCounterclockwise});
    }

    int boundaryEdgeCount, edgeIDInFace;
    bool isOuter;
    while (file >> boundaryEdgeCount >> isOuter) {
        Face face;
        for (int i = 0; i < boundaryEdgeCount; ++i) {
            file >> edgeIDInFace;
            face.boundaryEdges.push_back(edgeIDInFace);
        }
        face.isOuter = isOuter;
        myPSLG.F.push_back(face);
    }

    file.close();
    return myPSLG;
}

int binarySearch(const vector<double>& sortedArray, double target) {
    int low = 0;
    int high = sortedArray.size() - 1;

    while (low <= high) {
        int mid = low + (high - low) / 2;

        if (sortedArray[mid] == target) {
            return mid;
        } else if (sortedArray[mid] < target) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }

    return high; // Returnează indicele marginii superioare a lespedei
}

int findFaceIndex(const PSLG& pslg, double targetX, double targetY) {
    for (size_t i = 0; i < pslg.F.size(); ++i) {
        const Face& face = pslg.F[i];
        if (!face.isOuter) {
            bool isInside = true;
            for (int edgeID : face.boundaryEdges) {
                const HalfEdge& edge = pslg.E[edgeID - 1];
                const Vertex& vertexFrom = pslg.V[edge.vertexFrom - 1];
                const Vertex& vertexTo = pslg.V[edge.vertexTo - 1];

                if ((vertexFrom.y > targetY && vertexTo.y > targetY) || (vertexFrom.y < targetY && vertexTo.y < targetY)) {
                    // Latura este deasupra sau sub punctul M, deci nu contribuie la verificarea interiorului
                    continue;
                }

                double edgeX = vertexFrom.x + (targetY - vertexFrom.y) * (vertexTo.x - vertexFrom.x) / (vertexTo.y - vertexFrom.y);
                if (edgeX > targetX) {
                    isInside = !isInside;
                }
            }

            if (isInside) {
                return i;
            }
        }
    }

    return -1; // Punctul M nu este în interiorul niciunei fețe
}

int main() {
    // Exemplu de citire a PSLG din fișier
    PSLG myPSLG = readPSLGFromFile("C:/Users/alexa/OneDrive/Documents/GC/DCEL.txt");

    // Localizarea punctului M
    double targetX = 0.5, targetY = 0.5;  // Exemplu de coordonate pentru punctul M
    int faceIndex = findFaceIndex(myPSLG, targetX, targetY);

    if (faceIndex != -1) {
        cout << "Punctul M se afla in fata " << faceIndex + 2 << endl; // Adăugăm 2 pentru a reflecta numerotarea de la 2 în sus
        cout << "Laturile din fata:" << endl;
        printSet(myPSLG.F[faceIndex].boundaryEdges);
    } else {
        cout << "Punctul M nu este in interiorul niciunei fete." << endl;
    }

    return 0;
}
