public class Hero {
    private final String mName;
    private int mHP;
    public Hero(String name) {
        mName = name;
        mHP = 100;
    }
    public String getName() {
        return mName;
    }
    public int getHitPoints() {
        return mHP;
    }
    @Override
    public String toString() {
        return("Hero{name='" + mName + "', hitPoints=" + mHP + "}");
    }
    public void attack(Hero opponent) {
        double rand = Math.random();
       if (rand < 0.5) {
            opponent.damage();
       }
       else {
           damage();
       }
    }
    private void damage() {
        mHP -= 10;
    }
    public void senzuBean() {
        mHP = 100;
    }
    private void fightUntilTheDeathHelper(Hero opponent) {
        while (mHP > 0 && opponent.mHP > 0) {
            attack(opponent);
        }
    }
    public String fightUntilTheDeath(Hero opponent) {
        senzuBean();
        opponent.senzuBean();
        fightUntilTheDeathHelper(opponent);
        return (mName + ": " + mHP + "\t" + mName + ": " + opponent.mHP);
    }
    private int[] nFightsToTheDeathHelper(Hero opponent, int n) {
        int heroWins = 0;
        int oppWins = 0;
        for (int i = 0; i < n; i++) {
            fightUntilTheDeath(opponent);
            if (mHP < 1) {
                oppWins += 1;
            }
            else {
                heroWins += 1;
            }
        }
        return new int[]{heroWins, oppWins};
    }
    public String nFightsToTheDeath(Hero opponent, int n) {
        int[] wins = nFightsToTheDeathHelper(opponent, n);
        if (wins[0] > wins[1]) {
            return (mName + ": " + wins[0] + " wins\n" + opponent.mName + ": " + wins[1] + " wins\n" + mName + " wins!");
        }
        else if (wins[0] < wins[1]) {
            return (mName + ": " + wins[0] + " wins\n" + opponent.mName + ": " + wins[1] + " wins\n" + opponent.mName + " wins!");
        }
        return (mName + ": " + wins[0] + " wins\n" + opponent.mName + ": " + wins[1] + " wins\nOMG! It was actually a draw!");
    }

}
