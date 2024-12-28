import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client {
    Scanner scanner = new Scanner(System.in);

    //declaration des variable
    static ArrayList<Client> clients = new ArrayList<>();
    static int idIncriment = 1;
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String adresse;
    private String telephone;

    //getter and setter

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String nom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {

    }

    public String getTelephone() {
        return telephone;
    }

    //constructors
    public Client( String nom, String prenom, String email, String adresse, String telephone) {
        this.id=idIncriment;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse = adresse;
        this.telephone = telephone;
        idIncriment++;
    }
    public Client(){}

    //fonction pou valider le telephone
    public boolean ValidationTelephon (String telephone){
        String regex = "(^(06|05|07)( )\\d{2}( )\\d{2}( )\\d{2}( )\\d{2})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(telephone);
        return matcher.matches();
    }

    //fonction pour valider la structure de l'email
    public boolean ValidationEmail(String email){
        String regex = "[\\w-]{1,20}@\\w{2,20}\\.\\w{2,3}$";
        Pattern pattern = Pattern.compile(regex);//pour compiler le rejex s'il est correct
        Matcher matcher = pattern.matcher(email);//pour creer un macher (analyseur) pour analyser la valeur de email entrer avac le rejex
        return matcher.matches();//retun true si la vateur matcher le regex et false si nom
    }

    //fonction ajouter
    public void AjouterClient() {
        System.out.println("entrer le nombre de Clients à ajouter: ");
        int nombre = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < nombre; i++) {
            System.out.println("entrer le nom du client " + (i + 1) + ": ");
            String nom = scanner.nextLine();
            System.out.println("entrer le prénom du client " + (i + 1) + ": ");
            String prenom = scanner.nextLine();
            boolean valide;
            String email;
            do {
                System.out.println("entrer l'email [(a-z A-Z 0-9 -)@(a-z A-Z 0-9).(a-z A-Z 0-9) ]du client " + (i + 1) + ": ");
                email = scanner.nextLine();
                valide = ValidationEmail(email);
                if (!valide){
                    System.out.println("email invalide!!");
                }
            }while (!valide);


            System.out.println("entrer l'adresse du client " + (i + 1) + ": ");
            String adresse = scanner.nextLine();
            boolean valideTele;
            String telephone;
            do {
                System.out.println("entrer le telephone du client " + (i + 1) + ": ");
                telephone = scanner.nextLine();
                valideTele = ValidationTelephon(telephone);
            }while (!valideTele);
            Client c = new Client(nom, prenom, email, adresse, telephone);
            clients.add(c);
        }
    }

    //to String

    @Override
    public String toString() {
        return "{\n id: "+id+
                "\n nom:'" + nom + '\'' +
                "\n prenom:'" + prenom + '\'' +
                "\n email:'" + email + '\'' +
                "\n adresse:'" + adresse + '\'' +
                "\n telephone:'" + telephone + '\'' +
                '}';
    }


    public void AfficherClient(){
        for (Client client: clients){
            System.out.println(client);
//            System.out.println("Id: "+Client.getId()+" |Nom: "+client.getNom()+" |Prenom: "
//             +client.getPrenom()+" |Email: "+client.getEmail()+" |Adresse: "+client.getAdresse()+
//               " |Telephone: "+client.getTelephone());
        }
    }

    //menu du client
    public void MenuGestionClient (){
        int choix;
          do {
              System.out.println("------- Menu gestion de client --------");
              System.out.println("1: Ajouter un client");
              System.out.println("2: Afficher un client");
              System.out.println("3: break!");
              System.out.println("entre votre choix: ");
              choix=scanner.nextInt();
              scanner.nextLine();
              switch (choix){
                  case 1:
                      AjouterClient();
                      break;
                  case 2:
                      AfficherClient();
                      break;
                  case 3:
                      break;
                  default:
                      System.out.println("choisir en nombre existe dans le menu!!");
              }

          }while(choix!=3);
    }
}



