import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class heroesOfCodeAndLogic {
    static class Hero{
        String name;
        int manaPoints;
        int hitPoints;

        public Hero(String name, int manaPoints, int hitPoints) {
            this.name = name;
            this.manaPoints = manaPoints;
            this.hitPoints = hitPoints;
        }

        public String getName() {
            return name;
        }

        public int getManaPoints() {
            return manaPoints;
        }

        public void setManaPoints(int manaPoints) {
            this.manaPoints = manaPoints;
        }

        public int getHitPoints() {
            return hitPoints;
        }

        public void setHitPoints(int hitPoints) {
            this.hitPoints = hitPoints;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Hero> heroProfile = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] heroParameters = scanner.nextLine().split(" ");
            Hero hero = new Hero(heroParameters[0], Integer.parseInt(heroParameters[2]), Integer.parseInt(heroParameters[1]));
            heroProfile.put(hero.getName(), hero);
        }
        String input = scanner.nextLine();
        while (!input.equals("End")){
            String[] commandParts = input.split(" - ");
            switch (commandParts[0]){
                case "CastSpell":
                    String heroName = commandParts[1];
                    int neededMP = Integer.parseInt(commandParts[2]);
                    String spellName = commandParts[3];
                    if(heroProfile.get(heroName).getManaPoints()>=neededMP){
                        heroProfile.get(heroName).setManaPoints(heroProfile.get(heroName).getManaPoints()-neededMP);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroProfile.get(heroName).getName(), spellName, heroProfile.get(heroName).getManaPoints());
                    }else{
                        System.out.printf("%s does not have enough MP to cast %s!%n",heroName,spellName);
                    }
                    break;
                case "TakeDamage":
                    String heroName1 = commandParts[1];
                    int damage = Integer.parseInt(commandParts[2]);
                    String attacker = commandParts[3];
                    int leftHp = heroProfile.get(heroName1).getHitPoints() - damage;
                    if(leftHp>0){
                        heroProfile.get(heroName1).setHitPoints(leftHp);
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName1, damage, attacker, heroProfile.get(heroName1).getHitPoints());
                    }else{
                        heroProfile.remove(heroName1);
                        System.out.printf("%s has been killed by %s!%n",heroName1,attacker);
                    }
                    break;
                case "Recharge":
                    String heroName2 = commandParts[1];
                    int amount = Integer.parseInt(commandParts[2]);
                    int initialManaPoints = heroProfile.get(heroName2).getManaPoints();
                    heroProfile.get(heroName2).setManaPoints(Math.min(amount + heroProfile.get(heroName2).getManaPoints(), 200));
                    System.out.printf("%s recharged for %d MP!%n", heroName2, heroProfile.get(heroName2).getManaPoints()-initialManaPoints);
                    break;
                case "Heal":
                    String heroName3 = commandParts[1];
                    int amount1 = Integer.parseInt(commandParts[2]);
                    int initialHP = heroProfile.get(heroName3).getHitPoints();
                    heroProfile.get(heroName3).setHitPoints(Math.min(amount1 + heroProfile.get(heroName3).getHitPoints(), 100));
                    System.out.printf("%s healed for %d HP!%n", heroName3, heroProfile.get(heroName3).getHitPoints()-initialHP);
                    break;
            }
            input =scanner.nextLine();
        }
        for (Hero hero: heroProfile.values()) {
            System.out.printf("%s%n  HP: %d%n  MP: %d%n", hero.getName(), hero.getHitPoints(), hero.getManaPoints());
        }
    }
}
