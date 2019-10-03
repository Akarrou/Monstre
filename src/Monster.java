/**
 * creat object Monster
 *
 * @author jerome
 * @version 00001
 */
public abstract class Monster {
    private String name;
    private int damage;
    private int life;
    private String type;
    private boolean capture = false;


    private String[] nameAttac;

    public boolean isCapture() {
        return capture;
    }

    public void setCapture(boolean capture) {
        this.capture = capture;
    }


    public Monster(String name, boolean capture) {
        this.name = name;
        this.damage = 10;
        this.life = 50;
        this.type = "Normal";
        this.capture = capture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getNameAttac() {
        return nameAttac;
    }

    public void setNameAttac(String[] nameAttac) {
        this.nameAttac = nameAttac;
    }

    public boolean victoire(Monster adversaire, String qui) {
        if (qui.equals("Joueur")) {
            if (getLife() <= 0) {
                System.out.println(getName() + " est KO \n");
                System.out.println(adversaire.getName() + " retourne a sa promenade \n");
                return true;
            }
            if (adversaire.getLife() <= 0) {
                System.out.println(adversaire.getName() + " est KO \n");
                System.out.println(getName() + " retourne dans votre poche avec " + adversaire.getName() + "\n");
                System.out.println("Felicitation vous avez un nouveau monstre");
                adversaire.setCapture(true);
                return true;
            }
        }
        if (qui.equals("Ordi")) {
            if (getLife() <= 0) {
                System.out.println(getName() + " est KO \n");
                System.out.println(adversaire.getName() + " retourne a sa promenade \n");
                return true;
            }
            if (adversaire.getLife() <= 0) {
                System.out.println(adversaire.getName() + " est KO \n");
                System.out.println(getName() + " retourne dans votre poche se reposer" + "\n");
                System.out.println("Deseption, vous avez perdu");
                adversaire.setCapture(true);
                return true;
            }
        }
        return false;
    }

    public abstract void takeHit(Monster adversaire, char attac);


}
