package projet;
import java.util.ArrayList;
import java.util.*;
 import javax.print.attribute.standard.PresentationDirection;

class PersonnePhysique extends Personne {
    protected String nom;
    protected String prenom;

    public PersonnePhysique(int id_personne, String nom, String prenom, String adressemail, Compte comptePersonne){
        super(id_personne, adressemail, comptePersonne);
        this.nom=nom;
        this.prenom=prenom;

    }
        // Polymorphisme puisqu'une personne morale peut comme ne peut pas posséder d'établissements.

    public PersonnePhysique(int id_personne, String nom, String prenom, String adressemail, Compte comptePersonne, ArrayList<Etablissements> lEtablissements){
        super(id_personne, adressemail, comptePersonne, lEtablissements);
        this.nom=nom;
        this.prenom=prenom;

    }
    @Override
    public String toString() {
            return "Id : "+this.id_personne+" Nom: "+this.nom+" Prenom: "+this.prenom+" AdresseMail: "+this.adressemail+" Compte: "+this.comptePersonne.toString();        
    }

  }
  