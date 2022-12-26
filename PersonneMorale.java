package projet;
import java.util.ArrayList;
class PersonneMorale extends Personne {
    protected String raison_sociale;
    protected String forme_juridique;
    protected int num_siret;
    //private Compte compte;

    public PersonneMorale(int id_personne, String raison_sociale, String forme_juridique,int num_siret, String adressemail, Compte comptePersonne){
        super(id_personne, adressemail, comptePersonne);
        this.raison_sociale = raison_sociale;
        this.forme_juridique = forme_juridique;
        this.num_siret = num_siret;

    }
    // Polymorphisme puisqu'une personne morale peut comme ne peut pas posséder d'établissements.
    public PersonneMorale(int id_personne, String raison_sociale, String forme_juridique,int num_siret, String adressemail, Compte comptePersonne, ArrayList<Etablissements> lEtablissements){
        super(id_personne, adressemail, comptePersonne, lEtablissements);
        this.raison_sociale = raison_sociale;
        this.forme_juridique = forme_juridique;
        this.num_siret = num_siret;

    }
    @Override
    public String toString() {
            return "Id : "+this.id_personne+" Raison Sociale: "+this.raison_sociale+" Forme Juridique: "+this.forme_juridique+" Num SIRET: "+this.num_siret+" Adresse: "+this.adressemail+" Compte: "+this.comptePersonne.toString();        
    }
  }
