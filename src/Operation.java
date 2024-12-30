import java.util.Scanner;

public class Operation {

    //objects
    Scanner scanner=new Scanner(System.in);
    //CompteCourant compte = new CompteCourant();

    //constructors

    //déclaration des méthodes
    // Méthode pour calculer le solde actuel
    public  double calculerSoldeActuel(Compte compte) {
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

    // Méthode pour effectuer un virement
    public static void EffectuerVirement(Compte compteEnvoye, Compte compteReçu, double montant){
        if (montant>compteEnvoye.getSoldeActuelle()){
            compteEnvoye.setSoldeActuelle(compteEnvoye.getSoldeActuelle()-montant);
            System.out.println("vous avez effectuer un virement de "+montant+" dr votre solde actuelle est "+compteEnvoye.getSoldeActuelle()+" dr");
            compteReçu.setSoldeActuelle(compteReçu.getSoldeActuelle()+montant);
            System.out.println("vous avez reçu un virement de "+montant+" dr votre solde actuelle est "+compteReçu.getSoldeActuelle()+" dr");
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
                     // Ajout d'un dépôt à un compte
                      System.out.println("Entrer le montant à déposer : ");
                      double montantDepot = scanner.nextDouble();
                      scanner.nextLine();
                      System.out.println("entrer le numero de compte: ");
                      long numeroCompte=scanner.nextLong();
                      scanner.nextLine();
                      Compte compte= Compte.RechercheCompteNumero(numeroCompte);
                      if (compte != null){
                      Operation.effectuerDepot(compte, montantDepot);
                      }else {
                        System.out.println("compte n'existe pas!!");
                     }

                    break;
                case 2:
                    //effectuer un virement
                    System.out.println("entrer le numero de compte pour l'envoi: ");
                    long numeroCompteEnvoi = scanner.nextLong();
                    scanner.nextLine();
                    Compte compteEnvoi=Compte.RechercheCompteNumero(numeroCompteEnvoi);
                    if (compteEnvoi!=null){
                        System.out.println("entrer le numero de compte distinataire: ");
                        long numeroCompteReçu = scanner.nextLong();
                        scanner.nextLine();
                        Compte compteReçu = Compte.RechercheCompteNumero(numeroCompteReçu);
                        if (compteReçu != null){
                            System.out.println("entrer le mantant à envoyée : ");
                            double montantEnvoye = scanner.nextDouble();
                            scanner.nextLine();
                            EffectuerVirement(compteEnvoi,compteReçu,montantEnvoye);
                        }else {
                            System.out.println("compte distinataire n'existe pas!!");
                        }
                    }else {
                        System.out.println("compte émetteur n'existe pas!! ");
                    }
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
