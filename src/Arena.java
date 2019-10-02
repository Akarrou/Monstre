import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

/**
 * Arene de combat
 *
 * @author jerome
 * @version 0001
 */
public class Arena {
    public static void main(String[] args) {
        FireMonster sameleche = new FireMonster("Sameleche");
        WaterMonster carapute = new WaterMonster("Carapute");
        GrassMonster boulebizarre = new GrassMonster("Boulbizarre");

        Monster[] monsterArray = {sameleche, carapute, boulebizarre};

        System.out.println("Veullez choisir votre monstre");

        for (int i = 0; i < monsterArray.length; i++) {
            System.out.println(i+1 + ": " + monsterArray[i].getName());
        }


        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt() - 1;

        System.out.println(monsterArray[i].getName() + " Go !");
        System.out.println();

        Random r = new Random();
        int nb = r.nextInt(2);
        while (nb == i) {
            nb = r.nextInt(2);
        }
        System.out.println(monsterArray[nb].getName() + " est votre adversaire !");
        System.out.println();

        while (monsterArray[i].getLife() > 0 && monsterArray[nb].getLife() > 0) {
            monsterArray[i].takeHit(monsterArray[nb]);
            System.out.println();
            if (monsterArray[i].getLife() <= 0) {
                break;
            }
            monsterArray[nb].takeHit(monsterArray[i]);
            System.out.println();
        }

    }
}
