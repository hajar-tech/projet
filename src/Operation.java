import java.util.Scanner;

public class Operation {

    //objects
    Scanner scanner=new Scanner(System.in);
    //CompteCourant compte = new CompteCourant();

    //constructors

    //déclaration des méthodes

    // Méthode pour calculer le solde actuel
    public static double calculerSoldeActuel(Compte compte) {
        double soldeActuelle = compte.getSoldeInicile() + compte.getSoldeActuelle();
        return soldeActuelle;
    }

    // Méthode pour effectuer un dépôt sur le compte
    public static void effectuerDepot(Compte compte, double montant) {
        if (montant > 0) {
            double soldeActuel = compte.getSoldeActuelle();
            compte.setSoldeActuelle(soldeActuel + montant);
            System.out.println("Dépôt de " + montant + "dh a été effectué. Votre nouveau solde est : " + compte.getSoldeActuelle() + "dh.");
        } else {
            System.out.println("Montant invalide pour le dépôt.");
        }
    }


    // methode gestion du menu des opérations
    public void GectionMenuOperation(){
        CompteCourant compteCourant = new CompteCourant();
        CompteEpargne compteEpargne = new CompteEpargne();
        int choix;
        do{
            System.out.println("-------menu gestion des opérations-------------");
            System.out.println("1: effectuer un dépot");
            System.out.println("2: effectuer un viremment");
            System.out.println("3: quitter!!");
            System.out.println("entrer votre choix: ");
            choix=scanner.nextInt();
            switch (choix){
                case 1:
                    int choixOperation;
                    do {
                        System.out.println("1: effectuer un dépôt pour un compte courant");
                        System.out.println("2: effectuer un dépôt pour un compte épargne");
                        System.out.println("3: quitter!!");
                        System.out.println("entrer votre choix: ");
                        choixOperation = scanner.nextInt();
                        switch (choixOperation){
                            case 1:
                                // Ajout d'un dépôt sur le compte courant
                                System.out.println("Entrer le montant à déposer : ");
                                double montantDepot = scanner.nextDouble();
                                Operation.effectuerDepot(compteCourant, montantDepot);
                                break;

                            case 2:
                                // Ajout d'un dépôt sur le compte épargne
                                System.out.println("Entrer le montant à déposer : ");
                                double montantAjouter = scanner.nextDouble();
                                Operation.effectuerDepot(compteCourant, montantAjouter);
                                break;

                            case 3:
                                break;
                        }
                    }while (choixOperation != 3);

                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
        }while (choix!=3);
    }





//    public double CalculeTauxInteret (){
//        System.out.println("un Taux d'interet de 3% par année");
//        System.out.println("combien d'annéés de blockage: ");
//        int nombreAnnee=scanner.nextInt();
//        scanner.nextLine();
//        double mantantActuelle= compte.getSoldeActuelle();
//        double tauxInteret = (nombreAnnee*mantantActuelle*3)/100;
//        return tauxInteret;
//    }

}
