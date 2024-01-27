import java.util.*;
class ListaTranzitii {
    ArrayList<Tranzitie> lista;
        ListaTranzitii(){this.lista=new ArrayList<Tranzitie>();}
    void adaugaTranzitie(Tranzitie tr){
        this.lista.add(tr);
    }
    Tranzitie gasesteTranzitie(String stare, char simbol){
        for(int i=0; i<this.lista.size(); i++){
            Tranzitie tr = this.lista.get(i);
            String stInceput = tr.spuneStInceput();
            if(stInceput != null){
                if(stInceput.equals(stare) && tr.spuneSimbol() == simbol){
                    return tr;
                }
            }
        }
        return null;
    }
}
