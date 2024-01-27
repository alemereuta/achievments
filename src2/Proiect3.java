import java.util.ArrayList;

public class Proiect3 {

    static public ArrayList<Character> ProdCeDerivaA(Gramatica G, char a) {
        ArrayList<Character> productiiGasite = new ArrayList<>();

        for (Productie p : G.P) {
            if (p.simboluri.length() == 1 && p.simboluri.charAt(0) == a) {
                productiiGasite.add(p.A);
            }
        }
        return productiiGasite;
    }

    static void problema(Gramatica G, String input) {
        int n = input.length();
        ArrayList<ArrayList<ArrayList<Character>>> m = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            m.add(new ArrayList<ArrayList<Character>>());
            for (int j = 0; j <= n - i + 1; j++) {
                m.get(i).add(new ArrayList<Character>());
            }
        }

        for (int j = 1; j <= n; j++) {
            m.get(1).get(j).addAll(ProdCeDerivaA(G, input.charAt(j - 1)));
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                m.get(i).get(j).clear();
                for (int k = 1; k <= i - 1; k++) {
                    for (Productie p : G.P) {
                        if (p.simboluri.length() == 2) {

                            char B = p.simboluri.charAt(0);
                            char C = p.simboluri.charAt(1);
                            ArrayList<Character> V1 = m.get(k).get(j);
                            ArrayList<Character> V2 = m.get(i - k).get(j + k);

                            if (V1.contains(B) && V2.contains(C)) {
                                if (!m.get(i).get(j).contains(p.A)) {
                                    m.get(i).get(j).add(p.A);
                                }
                            }
                        }
                    }
                }
            }
        }

        for (ArrayList<ArrayList<Character>> linie : m) {
            System.out.println(linie);
        }
    }

    public static void main(String[] args) throws Exception {
        Gramatica G1 = new Gramatica();
        G1.citesteFisier("C:\\lfc\\Gramatica.txt");
        System.out.println(G1.P);
        problema(G1, "baaba");
    }
}