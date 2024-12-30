import java.util.ArrayList;
import java.util.Scanner;

public class CompteEpargne extends Compte {
    //declaration des variable
   private double tauxInteret;
   static ArrayList<CompteEpargne>compteEpargnes=new ArrayList<>();

   //getter and setter
    public double getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    //constractors
    public CompteEpargne (){}
    public CompteEpargne(long numeroCompte, double soldeInitiale, Client client){
        super(numeroCompte,soldeInitiale,client);
    }

    //objects
    Operation operation=new Operation();
     Scanner scanner = new Scanner(System.in);

    //implementation des methodes
    @Override
    public void CreerCompte() {
        System.out.println("entrer id du client: ");
        int idClient = scanner.nextInt();
        scanner.nextLine();
        Client client = RechercheClientIdExiste(idClient);
        if(client != null){
            System.out.println("entrer le numéro du compte: ");
            long numeroCompte = scanner.nextLong();
            scanner.nextLine();
            System.out.println("entrer le solde initiale: ");
            double soldeInitiale = scanner.nextDouble();
            scanner.nextLine();
            CompteEpargne compteEpargne = new CompteEpargne(numeroCompte,soldeInitiale,client);
            double soldeActuelle = operation.calculerSoldeActuel(compteEpargne);
            compteEpargne.setSoldeActuelle(soldeActuelle);
            compteEpargnes.add(compteEpargne);
        }else {
            System.out.println("client introuvable . veuillez ajouter un client!!");
        }
//        System.out.println("un Taux d'interet de 3% par année");
//        System.out.println("combien d'annéés de blockage: ");
//        int nombreAnnee=scanner.nextInt();
//        scanner.nextLine();
//        double mantantActuelle= getSoldeActuelle();
//        double tauxInteret = (nombreAnnee*mantantActuelle*3)/100;
//        double soldeActuelle = operation.CalculeSoldeActuelle(compteEpargne)+operation.CalculeTauxInteret();
    }


    public static void AfficherCompteEpargne() {
        if(compteEpargnes.isEmpty()){
            System.out.println("aucun compte courant à afficher!!");
        }else {
            for (CompteEpargne compteEpargne : compteEpargnes){
                System.out.println(compteEpargne);
            }
        }

    }


    //fonction Menu de gestion des comptes
    public void MenuGestionCompteCourant(){

        int choix;
        do {
            System.out.println("------- Menu gestion de compte --------");
            System.out.println("1: Creer  un compte");
            System.out.println("2: Afficher un compte");
            System.out.println("3: break!");
            System.out.println("entre votre choix: ");
            choix=scanner.nextInt();
            scanner.nextLine();
            switch (choix){
                case 1:
                    int choixCompte;
                    do {
                        System.out.println("1: pour la creation d'un compte courant ");
                        System.out.println("2: pour la creation d'un compte épargne ");
                        System.out.println("3: break!!");
                        System.out.println("entrer votre choix: ");
                        choixCompte=scanner.nextInt();
                        scanner.nextLine();
                        switch (choixCompte){
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                        }
                    }while (choixCompte!= 3);
                    break;
                case 2:
                    System.out.println("afficher un compte");
                    break;
                case 3:
                    break;
                default:
                    System.out.println("choisir en nombre existe dans le menu!!");
            }

        }while(choix!=3);

    }

}
