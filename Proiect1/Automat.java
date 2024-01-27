import java.io.*;
import java.util.*;
public class Automat {
    private String st_init = "q0";
    private String stare_finala = "q2";
    private ArrayList<String> lista_StFinala = new ArrayList<String>();
    private ListaTranzitii lista = new ListaTranzitii();
    private ArrayList<String> q = new ArrayList<String>();
    private ArrayList<Character> d = new ArrayList<Character>();
    private String sirAsociat = "";
    private ArrayList<String> stariTrecute = new ArrayList<String>();
    private Set<Character> alfabet;
    private String er_stare_init = "q[0-9]*";
    private String er_stare_finala = "((q[1-9][0-9]*|q0) )*q[1-9][0-9]*"; //q([1-9][0-9]*| )*
    private String er_tranzitie = "((q[1-9][0-9]*|q0) )*([a-zA-z]* )*((q[1-9][0-9]*|q0))*";
    
    
    
    public Automat(String Automat) throws Exception{
        BufferedReader buf = new BufferedReader(new FileReader(Automat));
        this.st_init = buf.readLine();
        this.stare_finala = buf.readLine();
        
        if(!st_init.matches(er_stare_init)){
            throw new Exception("Starea initiala nu este valida.");
        } else {
            System.out.println("Starea initiala este valida.");
        }
        
        
        if(!stare_finala.matches(er_stare_finala)){
            throw new Exception("Starile finale nu sunt valide.");
        } else {
            System.out.println("Starile finale sunt valide.");
        }
        
        
        String stf = buf.readLine();
        String tab[] = stf.split(" ");
        for(int i=0; i<tab.length; i++){
            lista_StFinala.add(tab[i]);
        }
        while(true){
            String linie = buf.readLine();
            if(linie!=null){
                if(linie.matches(er_tranzitie)){
                String elems[] = linie.split(" ");
                if(!q.contains(elems[0]))
                    q.add(elems[0]);
                if(!q.contains(elems[1]))
                    q.add(elems[1]);
                if(!q.contains(elems[2]))
                    q.add(elems[2]);
              
                if (!d.contains('a')) {
                    d.add('a');
                }
                if (!d.contains('b')) {
                    d.add('b');
                }
                Tranzitie tr = new Tranzitie(elems[0], elems[1].charAt(0), elems[2], "");
                if(elems.length > 3)
                    tr.setSirAsociat(elems[3]);
                this.lista.adaugaTranzitie(tr);
                System.out.println("Tranzitie valida: "+ linie);
            } else {
                throw new Exception("Tranzitie invalida: " + linie);
            }

            }
            else break;
        }
    
        
        /*for(Tranzitie tr: lista.lista){
            String stInceput = tr.spuneStInceput();
            char simbol = tr.spuneSimbol();
            String stSf = tr.spuneStSf();
            
            if(!stInceput.matches(er_stare_init) || !stSf.matches(er_stare_init) || !Character.isLetter(simbol)){
            throw new Exception("Tranzitiile nu sunt valide.");
            } else {
                System.out.println("Tranzitiile sunt valide.");
            }
        }*/
        
        Alfabet();
    }
    
    
    public ArrayList<String> getQ(){
        return q;
    }
    
    public ArrayList<Character> getD(){
        return d;
    }
    
    public ArrayList<String> getF(){
        return lista_StFinala;
    }
    
    private void Alfabet(){
        alfabet = new HashSet<>();
        for(Tranzitie tr: lista.lista){
            alfabet.add(tr.spuneSimbol());
        }
    }
    
    public Set<Character> getAlfabet(){
        return alfabet;
    }
    
    public boolean analizeazaCuvant(String cuvant){
            String stareCurenta = st_init;
                   
            for(int i=0; i<cuvant.length(); i++){
                char simbol = cuvant.charAt(i);
                Tranzitie tranzitie = lista.gasesteTranzitie(stareCurenta, simbol);
                
                if(tranzitie != null){
                    stareCurenta = tranzitie.spuneStSf();
                    if(!stariTrecute.contains(tranzitie.spuneStSf()))
                        stariTrecute.add(tranzitie.spuneStSf());
                        sirAsociat += tranzitie.spuneSirAsociat();
                        q.add(tranzitie.spuneStSf());
                } else {                 
                    return false;
                }
            }
            for(int i=0; i<stariTrecute.size(); i++){
                System.out.println(stariTrecute.get(i));
            }
            return lista_StFinala.contains(stareCurenta);
        }
    
    public void afiseazaStariNetrecute(){
        StringBuilder mesaj = new StringBuilder("St netrecute: {"); // creez un sir de carac pentru a construi mesajul rezultat
        //.removeAll(stariTrecute);
        boolean ok = false;
        //for(int i=0; i<q.size(); i++){
        for(String st : q) { //iterez prin lista de stari posibile
            //if(!stariTrecute.contains(q.get(i))){
            if(!stariTrecute.contains(st) && !st.equals("a") && !st.equals("b")){ // verific daca starea din lista q nu a fost vizitata
                //mesaj += (q.get(i) + ",");
                mesaj.append(st).append(",");
                //adaug starea la sirul mesaj + ,
                ok = true;
            }
        }
            if(ok){
                
                System.out.println(mesaj.substring(0, mesaj.length()-1) + "}");
            } else {
                System.out.println(mesaj.append("}"));
            }
                
        
    }
    
    public void afiseazaSirAsociat(){
        System.out.println(sirAsociat);
    }

    public boolean isDeterminist() {
        Set<String> stari = new HashSet<>(); 
        Set<Character> simboluri = new HashSet<>(); //am creat 2 set uri pt a tine evidenta starilor si simbolurilor automatului

    for (Tranzitie tr : lista.lista) { // parcurg fiecare tranzitie din lista, iar fiecare iteratie tr devine o referinta la tranzitia curenta din lista. adica codul din interiorul buclei se executa pentru fiecare tranzitie din lista
        String stareInit = tr.spuneStInceput(); // obtin:
        char simbol = tr.spuneSimbol(); // obtin:

        //if (stari.contains(stareInit) && simboluri.contains(simbol)) {
        if(stari.contains(stareInit+simbol)){ //verific daca o pereche stare simbol, in cazul asta starea de inceput si simbolul, a mai fost intalnita
            return false; //daca da, automatul este considerat nedeterminist si returnez fals
        }

        //stari.add(stareInit);
        stari.add(stareInit+simbol); // adaug perechea in seturile coresp pt urm verificari
    }
    
    return true; // daca in final nu am gasit nicio pereche stare simbol identica, atunci automatul este determinist
    }

    public boolean isNedeterminist() {
        return !isDeterminist();
    }

}

