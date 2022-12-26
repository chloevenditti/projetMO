package projet;
import java.util.ArrayList;

class Personne {
    public int id_personne;
    public String adressemail;
    public Compte comptePersonne;
    public ArrayList<Etablissements> lEtablissements = new ArrayList<Etablissements>();

    Personne(int id_personne,String adressemail, Compte comptePersonne){
        this.id_personne = id_personne;
        this.adressemail = adressemail;
        this.comptePersonne = comptePersonne;
    }
    public ArrayList<Etablissements> getlEtablissements() {
        return lEtablissements;
    }
    /* Boucle for each 'etablissements ' dans la liste d'établissement 'lEtablissements'.
    pour afficher les informations des établissements */

    public void afficherListeEtablissement() {
        int i = 1;
        for (Etablissements etablissements : lEtablissements) {
            System.out.println(i+" - "+etablissements.toString());
            i++;
        }
    }
    public void setlEtablissements(ArrayList<Etablissements> lEtablissements) {
        this.lEtablissements = lEtablissements;
    }
    
    Personne(int id_personne,String adressemail, Compte comptePersonne, ArrayList<Etablissements> lEtablissements ){
        this.id_personne = id_personne;
        this.adressemail = adressemail;
        this.comptePersonne = comptePersonne;
        this.lEtablissements = lEtablissements;
    }
    public String getAdressemail() {
        return adressemail;
    }
    public Compte getComptePersonne() {
        return comptePersonne;
    }
    public int getId_personne() {
        return id_personne;
    }
    public void setAdressemail(String adressemail) {
        this.adressemail = adressemail;
    }
    public void setComptePersonne(Compte comptePersonne) {
        this.comptePersonne = comptePersonne;
    }
    public void setId_personne(int id_personne) {
        this.id_personne = id_personne;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
