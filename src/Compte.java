import java.util.ArrayList;
import java.util.Scanner;

abstract public class Compte {

    //objects
    Scanner scanner = new Scanner(System.in);

    //declaration des variable
    static int id;
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
    //fonction recherche client
    public Client RechercheClientId(int idClient){
        System.out.println("entrer id du client: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (Client client : Client.clients){
            if (id==Client.getId()){
                return client;
            }
        }
        return null;
    }



}
