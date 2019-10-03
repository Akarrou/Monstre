import java.util.Random;

public class WaterMonster extends Monster {
    public WaterMonster(String name,boolean capture) {
        super(name,capture);
        setType("Water");
        setDamage(10);
        String[] t = {"Plongon", "Marrée", "Eclaboussure"};
        setNameAttac(t);
    }

    @Override
    public void takeHit(Monster adversaire, char attac) {

        Random r = new Random();
        int nb = r.nextInt(9);
        switch (attac) {
            case 'P':
                setDamage(10);
                break;
            case 'M':
                setDamage(5);
                break;
            case 'E':
                setDamage(20);
                break;
            default:
        }

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
