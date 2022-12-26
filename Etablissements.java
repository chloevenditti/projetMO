package projet;
import java.util.*;

class Etablissements {

    double zone;
    String nomEtab;
    Terrasse terrasse = null;
    HashMap<Terrasse,String> listeTerrasse = new HashMap<Terrasse,String>();
    ArrayList<Terrasse> lTerrasses = new ArrayList<Terrasse>();
    public Etablissements(double zoneE, String nomEtab, Terrasse terrasse, String dateFin) {
        this.zone = zoneE;
        this.nomEtab = nomEtab;
        this.terrasse = terrasse;
        this.listeTerrasse.put(terrasse,dateFin);
        this.lTerrasses.add(terrasse);
    }

    public void ajouterTerrasse(Terrasse t, String dateFin){
        this.listeTerrasse.put(t,dateFin);
        this.lTerrasses.add(t);

    }
    public Etablissements() {
    }
    public ArrayList<Terrasse> getlTerrasses() {
        return lTerrasses;
    }
    public String getNomEtab() {
        return nomEtab;
    }
    public Terrasse getTerrasse() {
        return terrasse;
    }
    public double getZone() {
        return zone;
    }

public HashMap<Terrasse, String> getListeTerrasse() {
    return listeTerrasse;
}
public void setListeTerrasse(HashMap<Terrasse, String> listeTerrasse) {
    this.listeTerrasse = listeTerrasse;
}
    public void setNomEtab(String nomEtab) {
        this.nomEtab = nomEtab;
    }
    public void setTerrasse(Terrasse terrasse) {
        this.terrasse = terrasse;
    }
    public void setdouble(double zone) {
        this.zone = zone;
    }
    @Override
    public String toString() {
        
        return "Nom :"+nomEtab+" Zone: "+zone+" Type: "+terrasse.getTypeTerrasse();
    }

}
