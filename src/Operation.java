import java.util.Scanner;

public class Operation {
    Scanner scanner=new Scanner(System.in);
    CompteCourant compte = new CompteCourant();
    public double CalculeSoldeActuelle (){
        double depot=0 ;
        double soldeInitiale = compte.getSoldeInicile();
        double soldeActuelle = soldeInitiale+depot;
        return soldeActuelle;
    }

    public double CalculeTauxInteret (){
        System.out.println("un Taux d'interet de 3% par année");
        System.out.println("combien d'annéés de blockage: ");
        int nombreAnnee=scanner.nextInt();
        scanner.nextLine();
        double mantantActuelle= compte.getSoldeActuelle();
        double tauxInteret = (nombreAnnee*mantantActuelle*3)/100;
        return tauxInteret;
    }

}
