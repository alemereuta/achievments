import java.util.List;
import java.util.Objects;
import java.util.*;

public class Productie {

    public String sir;
    public String alfa; 
    public String simboluri;
    public boolean parcurgere;
    public char A;
   
    
    public Productie(String sir)
    {
        this.sir = sir;
        this.alfa = sir.substring(2);
        this.parcurgere = false;
        this.A = sir.charAt(0);
        this.simboluri = sir.substring(2);
        
    }

    public char getA()
    {
        return A;
    }

    public String getAlfa()
    {
        return alfa;
    }
    
    public String getSimboluri()
    {
        return simboluri;
    }
    
    public void setParcurs()
    {
        parcurgere = true;
    }

    public void setNeparcurs()
    {
        parcurgere = false;
    }

    public static void main(String[] args) {

        Productie p = new Productie("A abc");
        System.out.println(p.getA());
        System.out.println(p.getAlfa());

    }

    public boolean verificaAlfaTerminale()
    {
       return (alfa.toLowerCase().equals(alfa));
    }
    
    //compara sirul original alfa cu versiunea sa convertita la litere mici. 
    //daca aceste doua siruri sunt identice,
    //inseamna ca toate caracterele din alfa sunt terminale (litere mici)

    public int nrVarNulabile(List<Character> Nnul)
    {
        int nr = 0; //numarul de variabile nulabile gasite in partea dreapta a productiei curente
        for(int i=0;i<alfa.length();i++)
        {
            char s = alfa.charAt(i);
            if(s >= 'A' && s <= 'Z' && Nnul.contains(s)) //verific daca este o variabila nulabila si daca se afla in lista variabilelor nulabile
                nr++;
        }
        return nr;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.alfa);
        hash = 37 * hash + this.A;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Productie other = (Productie) obj;
        if (this.A != other.A) {
            return false;
        }
        return Objects.equals(this.alfa, other.alfa);
    }

    public String toString() {
        return sir;
    }
}