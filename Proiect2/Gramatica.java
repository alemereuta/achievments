import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Gramatica {

    List<Productie> P = new ArrayList<Productie>();
    private List<Character> N = new ArrayList<Character>();
    private List<Character> T = new ArrayList<Character>();
    private char start = 'S';
    private HashSet<Productie> productiiDup = new HashSet<Productie>();
    private HashSet<Character> simboluriInutile = new HashSet<Character>();

    public void citesteFisier(String numeFisier) throws Exception {
        BufferedReader buf = new BufferedReader(new FileReader(numeFisier));
        while (true) {
            String linie = buf.readLine();
            if (linie != null) {
                if (!N.contains(linie.charAt(0))) {
                    N.add(linie.charAt(0));
                }
                for (int i = 2; i < linie.length(); i++) {
                    if (!T.contains(linie.charAt(i)) && linie.charAt(i) >= 'a' && linie.charAt(i) <= 'z') {
                        T.add(linie.charAt(i));
                    }

                }

                P.add(new Productie(linie));
            } else {
                break;
            }
        }
    }

    
    public static String genereazaSirUrm(String sir) {
        for (int i = sir.length() - 1; i >= 0; i--) {
            if (sir.charAt(i) == '0') {
                sir = (sir.substring(0, i) + '1' + sir.substring(i + 1));
                return sir;
            } else {
                sir = (sir.substring(0, i) + '0' + sir.substring(i + 1));
            }
        }

        return null;

    }

    
    public static List<Productie> genereazaSiruriCaracteristice(int nrVariabileNulabile, Productie p,List<Character> Nnul) {
        List<Productie> prLema3 = new ArrayList<>();
        String sir = "";
        for (int i = 0; i < nrVariabileNulabile; i++) {
            sir += '0';
        }

        
        
        while (sir != null) {
            System.out.println(sir);
            Productie aux = genereazaProductie(sir, p,Nnul);
            if (!aux.alfa.isEmpty() && !prLema3.contains(aux)) { 
            prLema3.add(aux);
        }
            sir = genereazaSirUrm(sir);
        }
        System.out.println(prLema3);
        return prLema3;
    }


    public static Productie genereazaProductie(String sirC, Productie p,List<Character> Nnul) {
        Productie newP = new Productie(p.sir);
        int k = 0;
        String pr = "";

        for (int i = 0; i < newP.alfa.length(); i++) {
            if(Nnul.contains(newP.alfa.charAt(i)))
            {
                if(k < sirC.length() && sirC.charAt(k) == '1')
                    pr += newP.alfa.charAt(i);
                k++;
            }
            else
                pr+=newP.alfa.charAt(i);
        }
        
        newP.alfa = pr;
        newP.sir = p.sir.substring(0,2) + pr;
        
        return newP;
        
    }
    
    public void adaugaProductieSet(Productie productie) {
        productiiDup.add(productie);
    }

    public HashSet<Productie> getProductiiSet() {
        return productiiDup;
    }
    
    public static Gramatica Lema1(Gramatica G1) {
        Gramatica G2 = new Gramatica();

        
        G2.T = G1.T;
        for (Productie p : G1.P) {
            if (!G2.N.contains(p.A) && p.verificaAlfaTerminale()) {
                G2.N.add(p.A);
                G2.P.add(p);
                p.setParcurs();
                G2.adaugaProductieSet(p);
            }
        }

        G2.P = new ArrayList<>(G2.getProductiiSet());
        
        int it = 1;
        while (it == 1) {
            it = 0;
            for (Productie p : G1.P) {
                int ok = 1;
                if (!p.parcurgere) {
                    for (int i = 0; i < p.alfa.length(); i++) {
                        char s = p.alfa.charAt(i);
                        if (s >= 'A' && s <= 'Z' && !G2.N.contains(s)) {
                            ok = 0;

                            break;
                        }

                    }
                    if (ok == 1) {
                        p.setParcurs();
                        if (!G2.N.contains(p.A)) {
                            G2.N.add(p.A);
                            it = 1;
                        }
                        G2.P.add(p);
                    }
                }
            }
        }
        
        ArrayList<Productie> inutile = new ArrayList<>();
        for(Productie p : G1.P)
            if(!G2.P.contains(p))
                inutile.add(p);
        System.out.println(inutile);
        ArrayList<Character> simboluriInutile = new ArrayList<>();
        
        for(Productie p : inutile)
        {
            if((!G2.N.contains(p.A)) && (!simboluriInutile.contains(p.A)))
                simboluriInutile.add(p.A);
            
            for(int i=0;i<p.alfa.length();i++)
            {
                if((!G2.N.contains(p.alfa.charAt(i))) && (!G2.T.contains(p.alfa.charAt(i))) && (!simboluriInutile.contains(p.alfa.charAt(i))))
                    simboluriInutile.add(p.alfa.charAt(i));
            }
        } 
        
        System.out.println("Lema 1:");
        System.out.println("N1:");
        System.out.println(G2.N);
        System.out.println("T1:");
        System.out.println(G2.T);
        System.out.println("P1:");
        System.out.println(G2.P);
        System.out.println("Simboluri inutile: " + simboluriInutile);
        System.out.println("\n");
       
        G2.start = G1.start;

        return G2;
    }
    
    public void resetParcurs() {
        for (Productie p : P) {
            p.setNeparcurs();
        }
    }

    
    public static Gramatica Lema2(Gramatica G1) {
        Gramatica G2 = new Gramatica();
        G2.N.add(G1.start);
        int ok = 1;
        while (ok == 1) {
            ok = 0;
            for (Productie p : G1.P) {
                if (G2.N.contains(p.A) && !p.parcurgere) {
                    for (int i = 0; i < p.alfa.length(); i++) {
                        char s = p.alfa.charAt(i);
                        if (!G2.T.contains(s) && s >= 'a' && s <= 'z') {
                            G2.T.add(s);
                        } else if (!G2.N.contains(s) && s >= 'A' && s <= 'Z') {
                            G2.N.add(s);
                            ok = 1;
                        }
                    }
                    G2.P.add(p);
                    p.setParcurs();

                }
            }
        }
        
        ArrayList<Productie> inutile = new ArrayList<>();
        for(Productie p : G1.P)
            if(!G2.P.contains(p))
                inutile.add(p);
        System.out.println(inutile);
        ArrayList<Character> simboluriInutile = new ArrayList<>();
        
        for(Productie p : inutile)
        {
            if((!G2.N.contains(p.A)) && (!simboluriInutile.contains(p.A)))
                simboluriInutile.add(p.A);
            
            for(int i=0;i<p.alfa.length();i++)
            {
                if((!G2.N.contains(p.alfa.charAt(i))) && (!G2.T.contains(p.alfa.charAt(i))) && (!simboluriInutile.contains(p.alfa.charAt(i))))
                    simboluriInutile.add(p.alfa.charAt(i));
            }
        } 
        
        System.out.println("Lema 2:");
        System.out.println("N2:");
        System.out.println(G2.N);
        System.out.println("T2:");
        System.out.println(G2.T);
        System.out.println("P2:");
        System.out.println(G2.P);
        System.out.println("Simboluri inutile: " + simboluriInutile);
        System.out.println("\n");
        
        
        return G2;
    }
    
    
    
    static Gramatica Lema3(Gramatica G1) {
        List<Character> Nnul = new ArrayList<>();
        Gramatica G2 = new Gramatica();
        
        for (Productie p : G1.P) {
            if (p.alfa.equals("#")) {
                Nnul.add(p.A);
            }
        }
        int it = 1;
        while (it == 1) {
            it = 0;
            for (Productie p : G1.P) {
                if (!p.parcurgere) {
                    int ok = 1;
                    for (int i = 0; i < p.alfa.length(); i++) {
                        char s = p.alfa.charAt(i);
                        if (s >= 'a' && s <= 'z') {
                            p.setParcurs();
                            ok = 0;
                            break;
                        } else if (!Nnul.contains(s)) {
                            ok = 0;
                            break;
                        }

                    }
                    if (ok == 1) {
                        if (!Nnul.contains(p.A)) {
                            Nnul.add(p.A);
                            it = 1;
                        }
                        
                    }
                }
            }
        }
        System.out.println("Productia care il contine pe (#) lambda:");
        System.out.println(Nnul);
        System.out.println("\n");
        System.out.println("Productiile cu eliminare a caracterelor (#) lambda:");
        
                for(Productie p: G1.P)
        {
            int nr = p.nrVarNulabile(Nnul);
            if(nr > 0)
                G2.P.addAll(genereazaSiruriCaracteristice(nr,p,Nnul));
           
        }
                
        
        return G2;
    }
   
public static void main(String[] args) throws Exception {
        Gramatica G1 = new Gramatica();
        G1.citesteFisier("C:\\lfc\\Gramatica.txt");
        Gramatica G2 = Lema1(G1);
        G2.resetParcurs();
        G2 = Lema2(G2);
        G2.resetParcurs();
        G2 = Lema3(G2);
        System.out.println(G2.P);
        
    }

}

//NETERMINALE = LITERE MARI
//terminale = litere mici
