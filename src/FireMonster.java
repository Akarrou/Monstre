import java.util.Random;

public class FireMonster extends Monster {

    public FireMonster(String name, boolean capture) {
        super(name, capture);
        setType("Fire");
        setDamage(10);
        String[] t = {"Fire Boullet", "Allumete", "Barbuc"};
        setNameAttac(t);
    }

    @Override
    public void takeHit(Monster adversaire, char attac) {

        Random r = new Random();
        int nb = r.nextInt(9);
        /*Choix de l'attaque du monstre*/
        switch (attac) {
            case 'F':
                setDamage(10);
                break;
            case 'A':
                setDamage(5);
                break;
            case 'B':
                setDamage(20);
                break;
            default:
        }
        /*Set des domage en fonction du Type de monstre*/
        if (adversaire.getType().equals("Water")) {
            adversaire.setLife(adversaire.getLife() - getDamage() / 2);
            System.out.println(adversaire.getName() + " reçois " + getDamage() / 2 + " de dommage il lui reste " +adversaire.getLife() + " points de vie\n");
        }
        if (adversaire.getType().equals("Fire")) {
            adversaire.setLife(adversaire.getLife() - getDamage());
            System.out.println(adversaire.getName() + " reçois " + getDamage() + " de dommage il lui reste " +adversaire.getLife() + " points de vie\n");
        }
        if (adversaire.getType().equals("Grass")) {
            adversaire.setLife(adversaire.getLife() - getDamage() * 2);
            System.out.println(adversaire.getName() + " reçois " + getDamage() * 2 + " de dommage il lui reste " +adversaire.getLife() + " points de vie\n");
        }

    }
}
