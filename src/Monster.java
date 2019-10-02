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


    public Monster(String name) {
        this.name = name;
        this.damage = 10;
        this.life = 100;
        this.type = "Normal";
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


    public abstract void takeHit(Monster adversaire) ;




}
