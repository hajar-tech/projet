import java.util.ArrayList;
import java.util.Scanner;

public class CompteEpargne extends Compte {
    //declaration des variable
   private double tauxInteret;

   //getter and setter
    public double getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    //constractors
    public CompteEpargne (){}

    //objects
    Operation operation=new Operation();
     Scanner scanner = new Scanner(System.in);

    //daclaration des methodes
    @Override
    public void CreerCompte() {
        System.out.println("entrer le numéro du compte: ");
        long numeroCompte = scanner.nextLong();
        scanner.nextLine();
        System.out.println("entrer le solde initiale: ");
        double soldeInitiale = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("un Taux d'interet de 3% par année");
        System.out.println("combien d'annéés de blockage: ");
        int nombreAnnee=scanner.nextInt();
        scanner.nextLine();
        double mantantActuelle= getSoldeActuelle();
        double tauxInteret = (nombreAnnee*mantantActuelle*3)/100;
        double soldeActuelle = operation.CalculeSoldeActuelle()+operation.CalculeTauxInteret();
    }
}
