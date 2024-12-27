import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //objects
        Scanner scanner=new Scanner(System.in);
         Client client = new Client();
         CompteCourant compteCourant=new CompteCourant();
         CompteEpargne compteEpargne=new CompteEpargne();



         //menuprincipalse
        int choix;
        do {
            System.out.println("*********** Menu principale *****************");
            System.out.println("1: Gestion des clients");
            System.out.println("2: Gestion des comptes");
            System.out.println("3: Gestion des opérations");
            System.out.println("4: break!!");
            System.out.println("entrer votre choix: ");
            choix=scanner.nextInt();
            scanner.nextLine();
            switch (choix){
                case 1:
                    client.MenuGestionClient();
                    break;
                case 2:
                    compteCourant.MenuGestionComptes();
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }

        }while (choix!=4);




//         client.AjouterClient();
//         client.Afficher();
    }
}