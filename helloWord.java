package projet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
// il faut ouvrir toutes les classes avant d'éxecuter le programme main
public class helloWord {

    static ArrayList<PersonnePhysique> listePP = new ArrayList<PersonnePhysique>();
    static ArrayList<PersonneMorale> listePM = new ArrayList<PersonneMorale>();
    static int choice = 0;
    static ArrayList<Etablissements> lEtab = new ArrayList<Etablissements>();

    static String P_dateFin="31/12/2005";
    static String SP_dateFin="31/10/2005";
    static String ETE_dateFin="15/09/2005";



  static double  P_A=126.50;
  static double  P_B=106.36;
  static double  P_C=74.74;

  static double  SP_A=74.16;
  static double  SP_B=62.36;
  static double  SP_C=43.82;

  static double  ETE_A=42.97;
  static double  ETE_B=36.14;
  static double  ETE_C=25.39;

    public static PersonnePhysique authentificationP(ArrayList<PersonnePhysique> listePP) {
        System.out.println("Veuillez saisir votre identifiant");
        Scanner scanUser = new Scanner(System.in);
        String username = scanUser.nextLine();  // Read user input


        System.out.println("Veuillez saisir votre mot de passe");
        Scanner scanPwd = new Scanner(System.in);
        int mdp = scanPwd.nextInt();  // Read user input
            for (PersonnePhysique personnePhysique: listePP) {

                if (personnePhysique.getComptePersonne().getLogin().equals(username) && personnePhysique.getComptePersonne().getPassword() == mdp ) {
            
                    return personnePhysique;
                }

            }
            return null;
    }
    public static PersonneMorale authentificationM(ArrayList<PersonneMorale> listePM) {
        System.out.println("Veuillez saisir votre identifiant");
        Scanner scanUser = new Scanner(System.in);
        String username = scanUser.nextLine();  // Read user input


        System.out.println("Veuillez saisir votre mot de passe");
        Scanner scanPwd = new Scanner(System.in);
        int mdp = scanPwd.nextInt();  // Read user input
        for (PersonneMorale personneMorale: listePM) {

            if (personneMorale.getComptePersonne().getLogin().equals(username) && personneMorale.getComptePersonne().getPassword() == mdp ) {
        
                return personneMorale;
            }

        }
        return null;
}
    public static void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush(); 
    }
        /*  on a la methode générique afficherListeEtablissement qui prend en paramètre <T> P 
         *  car on ne sait pas à l'avance si l'utilisateur est une personne Physique ou Morale 
         * (Pareil pour supprimer un établissement de la liste des établissements qu'une personne possède.) */
    public static <T> void afficherListeEtablissement(T p) {
        System.out.println(p.getClass().toString());

        if (p.getClass().toString().equals("class projet.PersonneMorale") ) {
            PersonneMorale pm =(PersonneMorale) p;
            pm.afficherListeEtablissement();
        }
        else if(p.getClass().toString().equals("class projet.PersonnePhysique")) {

            PersonnePhysique pp = (PersonnePhysique) p;
            pp.afficherListeEtablissement();
        }


    }
    /*supprimer un établissement de la liste des établissements qu'une personne de type T (Physique/Morale) possède.) */
    public static <T> void supprimerElmlisteEtablissement(T p){
        Scanner sscan = new Scanner(System.in);
        int choixEtab;
        if (p.getClass().toString().equals("class projet.PersonneMorale") ) {
            PersonneMorale pm =(PersonneMorale) p;
            pm.afficherListeEtablissement();
            System.out.println("Choisissez le numéro d'établissement que vous souhaitez supprimer");
            choixEtab = sscan.nextInt();
            pm.getlEtablissements().remove(choixEtab-1);
            clear();
            pm.afficherListeEtablissement();
        }
        else if(p.getClass().toString().equals("class projet.PersonnePhysique")) {
            PersonnePhysique pp = (PersonnePhysique) p;
            pp.afficherListeEtablissement();
            System.out.println("Choisissez le numéro d'établissement que vous souhaitez supprimer");
            choixEtab = sscan.nextInt();
            pp.getlEtablissements().remove(choixEtab-1);
            clear();
            pp.afficherListeEtablissement();
        }
        
    }

    public static <T> double calculFacture(T p) throws ParseException{
            double prixfinal=0;
            int choixEtab;
            double nbJour = 0;
            Etablissements etab = new Etablissements();
            Scanner sscan = new Scanner(System.in);
            if (p.getClass().toString().equals("class projet.PersonneMorale") ) {
                PersonneMorale pm =(PersonneMorale) p;
                pm.afficherListeEtablissement();
                System.out.println("Choisissez le numéro d'établissement que vous souhaitez calculer");
                choixEtab = sscan.nextInt();
                etab = pm.getlEtablissements().get(choixEtab-1);
            }
            else if(p.getClass().toString().equals("class projet.PersonnePhysique")) {
                PersonnePhysique pp = (PersonnePhysique) p;
                pp.afficherListeEtablissement();
                System.out.println("Choisissez l'établissement possedant la terrasse dont vous voulez la facture");
                choixEtab = sscan.nextInt();
                etab = pp.getlEtablissements().get(choixEtab-1);
            }
            for (Terrasse terrasse : etab.getlTerrasses()) {
                nbJour = nbJour + terrasse.calculDateUtilisation(etab.getListeTerrasse().get(terrasse));
                prixfinal = prixfinal + (etab.getZone()*terrasse.calculDateUtilisation(etab.getListeTerrasse().get(terrasse))*terrasse.getSurface())/365;
           
         }

            System.out.println("--------------------------------------------------");
            System.out.println("Periode occupée : "+nbJour+" jours.");
            System.out.println("Facture à payer: "+prixfinal+" euros.");
            return prixfinal; 
    }

    public static <T> void menu(T P) throws InterruptedException, ParseException {
            System.out.println(P.toString());
            System.out.println("1 - Afficher les listes des établissements de l'utilisateur");
            System.out.println("2 - Supprimer un établissement à l'utilisateur");
            System.out.println("3 - Demander une facture de terrasse");
            System.out.println("0 - Appuyer sur 0 pour quitter");
            Scanner scanf = new Scanner(System.in);
            choice = scanf.nextInt();
            if (choice == 1) {
                afficherListeEtablissement(P);
                Thread.sleep(50000);
                clear();
            } else if(choice == 2) {
                supprimerElmlisteEtablissement(P);
            } else if(choice == 3) {
                calculFacture(P);
            } else if ( choice== 0 ){
                System.out.println("Quitting");
                System.exit(choice);
            }
            
            

    }



    public static void afficherListePP(ArrayList<PersonnePhysique> listePP) {
        for (PersonnePhysique personnePhysique : listePP) {
            System.out.println(personnePhysique.toString());
        }
	}
    public static void afficherListePM(ArrayList<PersonneMorale> listePM) {
        for (PersonneMorale personneMorale : listePM) {
            System.out.println(personneMorale.toString());
        }
	}
    public static void main(String[] args) throws InterruptedException, ParseException {
        Terrasse tTerrasse = new Terrasse(552, "Permanente", 4, "01/01/2005");
      //  Terrasse tTerrasse2 = new Terrasse(552, "ETE", 4, "15/05/2005");
        Etablissements ziz = new Etablissements( P_A, "Café La Gare", tTerrasse,P_dateFin);
      //  Etablissements ziz2 = new Etablissements( SP_A, "zone type 1", new Terrasse(553, "Permanente", choice, "01/01/2005"),SP_dateFin);


        lEtab.add(ziz);


        PersonnePhysique pp1 = new PersonnePhysique(1, "Zerban", "Yassine", "yassine@pm.me", new Compte("user1", 1234), lEtab);
        PersonnePhysique pp2 = new PersonnePhysique(2, "zerb", "zerban", "zerb@pm.me", new Compte("user2", 1234));
        PersonnePhysique pp3 = new PersonnePhysique(3, "adam", "zerban", "adam@pm.me", new Compte("user3", 1234));
        PersonnePhysique pp4 = new PersonnePhysique(4, "chloe", "zerban", "chloe@pm.me", new Compte("user4", 1234));

        PersonneMorale pm1 = new PersonneMorale(1, "SAARL", "SS", 1234, "apple@icloud.com", new Compte("a", 1234), lEtab);
        PersonneMorale pm2 = new PersonneMorale(2, "SAAAARL", "SS", 1234, "apple@icloud.com", new Compte("apple2", 1234));
        PersonneMorale pm3 = new PersonneMorale(3, "SAAARL", "SS", 1234, "apple@icloud.com", new Compte("apple3", 1234));
        PersonneMorale pm4 = new PersonneMorale(4, "SARL", "SS", 1234, "apple@icloud.com", new Compte("apple4", 1234));

            listePP.add(pp1);
            listePP.add(pp2);
            listePP.add(pp3);
            listePP.add(pp4);

            listePM.add(pm1);
            listePM.add(pm2);
            listePM.add(pm3);
            listePM.add(pm4);


       
            System.out.println("Bonjour, bienvenue à notre application");
            
           
            Thread.sleep(2000);
            clear();

            System.out.println("Veuillez choisir si vous êtes une personne Morale/Physique");
            System.out.println("1: Morale,\n2: Physique");
            Scanner scanP = new Scanner(System.in);
            choice = scanP.nextInt();



            if (choice == 1) {
                PersonneMorale v = authentificationM(listePM);
                if ( v == null) {
                    System.out.println("Erreur de connexion ! Vérifiez le nom d'utilisateur ou le mot de passe...");
                } else {
                
                    System.out.println("Vous êtes bien connecté !");
                    menu(v);
    
                }
            } else if (choice == 2 ) {
                PersonnePhysique p = authentificationP(listePP);
                if ( p == null) {
                    System.out.println("Erreur de connexion ! Vérifiez le nom d'utilisateur ou le mot de passe...");
                } else {
                   
                    System.out.println("Vous êtes bien connecté !");
                    menu(p);

                }
                

            } else if ( choice== 0 ){
                System.out.println("Quitting...");
                System.exit(choice);
            }


           
           


        
    }
}
