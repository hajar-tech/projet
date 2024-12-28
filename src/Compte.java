import java.util.ArrayList;
import java.util.Scanner;

abstract public class Compte {

    //objects
    Scanner scanner = new Scanner(System.in);



    //declaration des variable
    protected static ArrayList<Compte> comptesBancaires = new ArrayList<>();
   private long numeroCompte;
    private Client proprietaire;
   private String type;
    private double soldeInicile;
    private double soldeActuelle;

    //getter and setter


    public static ArrayList<Compte> getComptesBancaires() {
        return comptesBancaires;
    }

    public static void setComptesBancaires(ArrayList<Compte> comptesBancaires) {
        Compte.comptesBancaires = comptesBancaires;
    }

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
        this.proprietaire=client;
        comptesBancaires.add(this);

    }
    public Compte (){}

    //definition de la methode CreerCompte
    abstract public void CreerCompte();

    // la methode  AfficherCompte
     public static void AfficherCompte(){

            for (Compte compte : Compte.getComptesBancaires()) {
                System.out.println(compte.toString());
            }
    }

     //implimentation to string()
    @Override
    public String toString() {
        return "Compte{" +
                "\n numeroCompte=" + numeroCompte +
                "\n proprietaire=" + proprietaire +
                "\n solde Actuelle=" + soldeActuelle +
                '}';
    }

    //fonction recherche client
    public Client RechercheClientIdExiste(int idClient){
        for (Client client : Client.clients){
            if (idClient==client.getId()){
                return client;
            }
        }
        return null;
    }

//fonction pour rechercher un comte à partir de son numéro
    public static Compte RechercheCompteNumero(long numeroCompte){
         for (Compte compte : comptesBancaires){
             if (numeroCompte == compte.getNumeroCompte()){
                 return compte;
             }
         }return null;
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
                                compteEpargne.CreerCompte();
                                break;
                            case 3:
                                break;
                        }
                    }while (choixCompte!= 3);
                    break;
                case 2:
                    int choixAffichage;
                    do {
                        System.out.println("1: pour l'affichge des compte courant ");
                        System.out.println("2: pour l'affichage des compte épargne ");
                        System.out.println("3: pour l'affichage des tout les compte");
                        System.out.println("4: pour quitter!!");
                        System.out.println("entrer votre choix: ");
                        choixAffichage=scanner.nextInt();
                        scanner.nextLine();
                        switch (choixAffichage){
                            case 1:
                                CompteCourant.AfficherCompteCourant();
                                break;
                            case 2:
                                CompteEpargne.AfficherCompteEpargne();
                                break;
                            case 3:
                                AfficherCompte();
                                break;
                            case 4:
                                break;
                        }
                    }while (choixAffichage!= 4);



                    System.out.println("afficher un compte");
                    Compte.AfficherCompte();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("choisir en nombre existe dans le menu!!");
            }

        }while(choix!=3);

    }



}
