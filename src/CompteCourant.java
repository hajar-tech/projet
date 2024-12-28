import java.util.ArrayList;
import java.util.Scanner;

public class CompteCourant extends Compte {

      //declaration des varible
    static ArrayList<CompteCourant>compteCourants=new ArrayList<CompteCourant>();
    static double fraisBancaires;

      //objects
    Scanner scanner = new Scanner(System.in);
    Operation operation = new Operation();

      //constractos
    public CompteCourant(){};
    public CompteCourant(long numeroCompte, double soldeActuelle ,Client client){
        super(numeroCompte,soldeActuelle,client);

    }

     //declaration des methodes

      //implémentation des methodes
    @Override
    public void CreerCompte() {
        System.out.println("entrer id du client: ");
        int idClient = scanner.nextInt();
        scanner.nextLine();
        Client client = RechercheClientIdExiste(idClient);
         if(client != null) {
             System.out.println("entrer le numéro du compte: ");
             long numeroCompte = scanner.nextLong();
             scanner.nextLine();
             System.out.println("entrer le solde initiale: ");
             double soldeInitiale = scanner.nextDouble();
             scanner.nextLine();
            CompteCourant compteCourant = new CompteCourant(numeroCompte, getSoldeActuelle(), client);
             double soldeActuelle = operation.calculerSoldeActuel(compteCourant);
             compteCourant.setSoldeActuelle(soldeActuelle);
             compteCourants.add(compteCourant);
         }else {
             System.out.println("client introuvable . veuillez ajouter un client!!");
         }

    }

    //implimentation du fonction Afficher


    public static void AfficherCompteCourant(){
        if(compteCourants.isEmpty()){
            System.out.println("aucun compte courant à afficher!!");
        }else {
            for (CompteCourant compteCourant : compteCourants){
                System.out.println(compteCourant);
            }
        }

    }


    }


