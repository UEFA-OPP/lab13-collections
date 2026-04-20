public class Character {
    private String name;
    private int hp;

    public Character(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public String getName() { return name; }
    public int getHp() { return hp; }

    public void setHp(int hp) { this.hp = hp; }

    public boolean isAlive() {
        return hp > 0;
    }
}