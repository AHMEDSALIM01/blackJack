public class Cartes {
    public String coleur;
    public String valeur;
    public Cartes(String valeur,String coleur){
        this.valeur =valeur;
        this.coleur=coleur;
    }

    public String toString(){
       return "("+this.valeur +" "+this.coleur+")";
    }

    public String getValeur(){
        return this.valeur;
    }
}
