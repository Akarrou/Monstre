import java.util.Random;
import java.util.Scanner;

/**
 * Arene de combat
 *
 * @author jerome
 * @version 0001
 */
public class Arena {
    private static int monstre1;
    public static Monster[] monsterArray;
    public static int hautBas=1;
    public static int droitegauche=1;
    public static void main(String[] args) {

        boolean promene = true;
        /*
         * Creation des object monstre libre
         */
        Monster salapete = new FireMonster("Salapete", false);
        Monster kronamburg = new WaterMonster("Kronamburg", false);
        Monster arbritus = new GrassMonster("Arbritus", false);
        Monster crapete = new FireMonster("Crapete", false);
        Monster goblette = new WaterMonster("Goblette", false);
        Monster tagaton = new GrassMonster("Tagaton", false);
        /*
         *Creation des montre capture
         */
        Monster sameleche = new FireMonster("Saleche", true);
        Monster carapute = new WaterMonster("Carabotte", true);
        Monster boulebizarre = new GrassMonster("Boulbizarre", true);

        Arena.setMonstre1(monsterHasard());
        monsterArray = new Monster[]{salapete, kronamburg, arbritus, crapete, goblette, tagaton, sameleche, carapute, boulebizarre};

        System.out.println("****************");
        System.out.println("Vous vous promener dans la forêt de Bouconne quand vous soudain un petit monstre sort d’un buisson. C’est un "
                + monsterArray[getMonstre1()].getName() +
                ", qui vous menace. ");
        System.out.println("Voulez vous le capture ?");
        System.out.println("Taper c = combattre / p = continuer votre promenade / f = ou fuir");

        /*
         *
         */
        while (promene == true) {
            Scanner sc = new Scanner(System.in);
            String reponse = sc.next();
            switch (reponse) {
                case "p":
                    /*
                     * Cherche un monstre non capure
                     */
                    map();
                    Arena.setMonstre1(monsterHasard());
                    while (monsterArray[Arena.getMonstre1()].isCapture()) {
                        Arena.setMonstre1(monsterHasard());
                    }
                    System.out.println("Vous rechercher un monstre...");

                    System.out.println("Surgissant devant vous un " + monsterArray[Arena.getMonstre1()].getName() + " vous defis.\n");
                    System.out.println("Voulez vous le capture ?");
                    System.out.println("Taper c = combattre / p = continuer votre promenade / f = ou fuir");
                    break;
                case "f":
                    promene = false;
                    break;
                case "c":
                    combat();
                    System.out.println("Voulez vous continuer votre pronenade ?");
                    System.out.println("Taper p = continuer votre promenade / f = ou fuir");

                    break;
                default:
            }

        }
    }

    /*
     *
     */
    public static void attrape(Monster adv, Monster choisi) {
        System.out.println(adv.getName() + " est votre adversaire !");
        System.out.println();

        if (choisi.getLife() <= 10) {
            System.out.println("Brigitte Bardo sort d'un buisson \n elle ne peu pas vous laisse faire ce combat \n et emporte votre monstre ");
            System.out.println(choisi.getName() + " est retourner a la vie sauvage");
            choisi.setLife(100);
            choisi.setCapture(false);

        } else {


            while (choisi.getLife() > 0 && adv.getLife() > 0) {

                if (choisi.getLife() <= 0) {
                    break;
                }
                System.out.println("Choisissez de quelle façon " + choisi.getName() + " attaque:");
                for (String v : choisi.getNameAttac()) {
                    System.out.println(v.charAt(0) + ": " + v);
                }
                Scanner sc = new Scanner(System.in);
                String attac = sc.next();
                char letter = attac.charAt(0);

                /*Vous attaquer*/
                System.out.println(choisi.getName() + " attaque ");
                choisi.takeHit(adv, letter);
                if (choisi.victoire(adv, "Joueur")) {
                    break;
                }


                /*IL attaquer*/
                Random r = new Random();
                int nb = r.nextInt(2);

                String att = adv.getNameAttac()[nb];

                char lettre = att.charAt(0);
                System.out.println(adv.getName() + " attaque avec " + att);

                adv.takeHit(choisi, lettre);
                if (adv.victoire(choisi, "Ordi")) {
                    break;
                }


            }
        }
    }

    /*
     *Donne un nombre au hazard pour la selction des monstre dans le tableau ds monstres
     */
    public static int monsterHasard() {
        Random r = new Random();
        int monstre = r.nextInt(9);
        return monstre;
    }


    public static int getMonstre1() {
        return monstre1;
    }

    public static void setMonstre1(int monstre1) {
        Arena.monstre1 = monstre1;
    }

    /*
     *Demarage du combat de monstre
     */
    public static void combat() {
        System.out.printf("Dans votre poche vous avez des petit monstres, lequel choisissez vous pour affronter %s "
                , monsterArray[Arena.getMonstre1()].getName());

        System.out.println("Veullez choisir votre monstre");
        /*Cherche les monstre capturer
         */
        for (int i = 0; i < monsterArray.length; i++) {
            if (monsterArray[i].isCapture()) {
                System.out.println(i + 1 + ": " + monsterArray[i].getName());
            }

        }
        Scanner sc = new Scanner(System.in);
        int choisi = sc.nextInt() - 1;
        /*
         *Si le monstre choisi est trop faible
         */
        if (monsterArray[choisi].getLife() <= 30) {
            System.out.println(monsterArray[choisi].getName() + " est tres fatiqué, il lui reste " + monsterArray[choisi].getLife());
            System.out.println("Voulez vous lui donner une pilule magique, pour remoter sa force de combat");
            System.out.println("Taper o = oui / n = non");
            Scanner sca = new Scanner(System.in);
            String reponse = sca.next();
            if (reponse.equals("o")) {
                monsterArray[choisi].setLife(100);
            } else {
                System.out.println("Votre monstre est trop faible, mais accepte de combatre");
                Arena.setMonstre1(monsterHasard());

            }

        }
        /*
         *Lancement de la methode
         * attrape
         */
        attrape(monsterArray[Arena.getMonstre1()], monsterArray[choisi]);
    }

    public static void map() {
        String[][] boucone =
                        {{"a", "b", "c"},
                        {"d", "e", "f"},
                        {"g", "h", "i"}};

        String reponse="e";

        while (!reponse.equals("R")){



            switch (boucone[hautBas][droitegauche]) {
                case "a":
                    System.out.println("Vous vous trouver au bord du lac");
                    System.out.println("Vous pouvez tounner a Droite ou Bas ");
                    System.out.println("Ou Rechercher un monstre dans le coin");
                    break;
                case "b":
                    System.out.println("Vous vous trouver dans une prairie");
                    System.out.println("Vous pouvez tounner a Droite ou a Gauche ou Bas");
                    System.out.println("Ou Rechercher un monstre dans le coin");
                    break;
                case "c":
                    System.out.println("Vous vous trouver sur le chemin des vache");
                    System.out.println("Vous pouvez tounner a Droite ou a Gauche");
                    System.out.println("Ou Rechercher un monstre dans le coin");
                    break;
                case "d":
                    System.out.println("Vous vous trouver sur le terrain de foot");
                    System.out.println("Vous pouvez tounner a Droite ou Haut ou Bas ");
                    System.out.println("Ou Rechercher un monstre dans le coin");
                    break;
                case "e":
                    System.out.println("Vous vous trouver au milieu de nulle part");
                    System.out.println("Vous pouvez tounner a Droite ou Gauche ou Haut ou Bas ");
                    System.out.println("Ou Rechercher un monstre dans le coin");
                    break;
                case "f":
                    System.out.println("Vous vous trouver sur le terrain de golf");
                    System.out.println("Vous pouvez tounner a Gauche ou  Haut ou Bas ");
                    System.out.println("Ou Rechercher un monstre dans le coin");
                    break;
                case "g":
                    System.out.println("Vous vous trouver au bord de la riviere");
                    System.out.println("Vous pouvez tounner a Droit ou Haut");
                    System.out.println("Ou Rechercher un monstre dans le coin");
                    break;
                case "h":
                    System.out.println("Vous vous trouver sur l'auturoute A7");
                    System.out.println("Vous pouvez tounner a Droit ou Gauche ou Haut");
                    System.out.println("Ou Rechercher un monstre dans le coin");
                    break;
                case "i":
                    System.out.println("Vous vous trouver a la Wild Code School");
                    System.out.println("Vous pouvez tounner a Gauche ou Haut");
                    System.out.println("Ou Rechercher un monstre dans le coin");
                    break;
            }
            Scanner sc = new Scanner(System.in);
            reponse = sc.next();

            if (reponse.equals("H")){
                if((hautBas-1)!=0 && (hautBas-1)!=1 &&(hautBas-1)!=2){
                    System.out.println("Vous ne pouvez pas aller par là");
                }else{
                    hautBas-=1;
                }
            }

            if (reponse.equals("B")){
                if((hautBas+1)!=0 && (hautBas+1)!=1 &&(hautBas+1)!=2){
                    System.out.println("Vous ne pouvez pas aller par là");
                }else{
                    hautBas+=1;
                }
            }

            if (reponse.equals("D")){
                if((droitegauche+1)!=0 && (droitegauche+1)!=1 &&(droitegauche+1)!=2){
                    System.out.println("Vous ne pouvez pas aller par là");
                }else{
                    droitegauche+=1;
                }

            }
            if (reponse.equals("G")){
                if((droitegauche-1)!=0 && (droitegauche-1)!=1 &&(droitegauche-1)!=2){
                    System.out.println("Vous ne pouvez pas aller par là");
                }else{
                    droitegauche-=1;
                }

            }
        }


    }


}


