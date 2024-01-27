public class Tranzitie {
    private String st_inceput;
    private char simbol;
    private String st_sf;
    char spuneSimbol;
    private String sir_asociat = "";
    
    Tranzitie(String st_inceput, char simbol, String st_sf){
        this.st_inceput = st_inceput;
        this.simbol = simbol;
        this.st_sf = st_sf;
    }
    Tranzitie(String st_inceput, char simbol, String st_sf, String sir_asociat){
        this.st_inceput = st_inceput;
        this.simbol = simbol;
        this.st_sf = st_sf;
        this.sir_asociat = sir_asociat;
    }
    String spuneStInceput(){return this.st_inceput;}
    char spuneSimbol(){return this.simbol;}
    String spuneStSf(){return this.st_sf;}
    String spuneSirAsociat(){return this.sir_asociat;}
    void setSirAsociat(String s){
        this.sir_asociat = s;
    }
}
