import java.util.Random;

public class WaterMonster extends Monster {
    public WaterMonster(String name) {
        super(name);
        setType("Water");
        setDamage(10);
    }

    @Override
    public void takeHit(Monster adversaire) {
        Random r = new Random();
        int nb = r.nextInt(9);

        if(adversaire.getType().equals("Fire")){
            if ( nb == 1) {
                this.setLife(this.getLife() - adversaire.getDamage());
                System.out.println("Coup Critique ! " + adversaire.getName() + " inflige 10 dégats");
            }
            else {
                this.setLife(this.getLife() - adversaire.getDamage() / 2);
                System.out.println(adversaire.getName() + " inflige 5 dégats");
            }
        }
        if(adversaire.getType().equals("Grass")){
            if ( nb == 1) {
                this.setLife(this.getLife() - adversaire.getDamage()*3);
                System.out.println("Coup Critique ! " + adversaire.getName() + " inflige 30 dégats");
            }
            else {

                this.setLife(this.getLife() - adversaire.getDamage() * 2);
                System.out.println(adversaire.getName() + " inflige 20 dégats");
            }
        }

        if (this.getLife()> 0) {
            System.out.println(this.getName() + " a encore " + this.getLife() + " points de vie.");
        } else {
            System.out.println(this.getName() + " est KO !");
        }
    }
}
