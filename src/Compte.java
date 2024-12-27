import java.util.ArrayList;
import java.util.Scanner;

abstract public class Compte {

    //objects
    Scanner scanner = new Scanner(System.in);



    //declaration des variable
    //static int id;
   private long numeroCompte;
    private Client proprietaire;
   private String type;
    private double soldeInicile;
    private double soldeActuelle;

    //getter and setter

    public double getSoldeActuelle(){
        return soldeActuelle;
    }

    public void setSoldeActuelle(double soldeActuelle){
        this.soldeActuelle=soldeActuelle;
    }

    public long getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(long numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public Client getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Client proprietaire) {
        this.proprietaire = proprietaire;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getSoldeInicile() {
        return soldeInicile;
    }

    public void setSoldeInicile(double soldeInicile) {
        this.soldeInicile = soldeInicile;
    }

    //constractors
    public Compte (long numeroCompte,double soldeActuelle,Client client){
        this.numeroCompte=numeroCompte;
        this.soldeActuelle=soldeActuelle;
        proprietaire=client;

    }
    public Compte (){}

    //definition de la methode CreerCompte
    abstract public void CreerCompte();

    //definition de la methode  AfficherCompte
    abstract public void AfficherCompte();

     //implimentation to string()


    @Override
    public String toString() {
        return "Compte{" +
                "numeroCompte=" + numeroCompte +
                ", proprietaire=" + proprietaire +
                ", soldeInicile=" + soldeInicile +
                '}';
    }

    //fonction recherche client
    public Client RechercheClientIdExiste(int idClient){
        for (Client client : Client.clients){
            if (idClient==Client.getId()){
                return client;
            }
        }
        return null;
    }


    //fonction Menu de gestion des comptes
    public void MenuGestionComptes(){
        CompteCourant compteCourant = new CompteCourant();
        CompteEpargne compteEpargne = new CompteEpargne();

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
                                compteCourant.CreerCompte();
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
