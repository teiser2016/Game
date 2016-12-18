public class BonusData {

    private static ArrayList<Bonus> bonuses = new ArrayList<>();

    public static void setBonuses () {
	//get bonuses from database and add them in the bonuses arraylist above
        //bonuses.add(new Bonus());
    }

    public static ArrayList<Bonus> getBonuses () {
        return bonuses;
    }

    public static Bonus getBonus (int pos) { return bonuses.get(pos); }

}
