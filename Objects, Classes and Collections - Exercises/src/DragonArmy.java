import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class DragonArmy {
    //90/100 time limit test_5
    private static String DEFAULT_DAMAGE = "45";
    private static String DEFAULT_ARMOR = "10";
    private static String DEFAULT_HEALTH = "250";
    private static Map<String, List<Dragon>> dragonsByType = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int line = Integer.parseInt(in.nextLine());

        for (int i = 0; i < line; i++) {
            String[] stats = in.nextLine().split("\\s+");

            String currentType = stats[0];
            String currentName = stats[1];
            String currentDamage = stats[2];
            if (currentDamage.equals("null")) {
                currentDamage = DEFAULT_DAMAGE;
            }
            String currentHealth = stats[3];
            if (currentHealth.equals("null")) {
                currentHealth = DEFAULT_HEALTH;
            }
            String currentArmor = stats[4];
            if (currentArmor.equals("null")) {
                currentArmor = DEFAULT_ARMOR;
            }

            Dragon d = new Dragon(currentName, Integer.parseInt(currentDamage), Integer.parseInt(currentHealth), Integer.parseInt(currentArmor));

            List<Dragon> temp = new ArrayList<>();
            boolean isSameDragon = false;
            if (dragonsByType.containsKey(currentType)) {
                temp = dragonsByType.get(currentType);
                for (Dragon dragon : temp) {
                    if (dragon.getName().equals(currentName)) {
                        isSameDragon = true;
                        dragon.setArmor(Integer.parseInt(currentArmor));
                        dragon.setDamage(Integer.parseInt(currentDamage));
                        dragon.setHealth(Integer.parseInt(currentHealth));
                    }
                }
            }
            if (!isSameDragon) {
                temp.add(d);
            }
            dragonsByType.put(currentType, temp);
        }
        print();

    }

    private static void print() {
        for (String s : dragonsByType.keySet()) {
            List<Dragon> dragons = dragonsByType.get(s);
            double avgDam = calculateAverageDamage(dragons);
            double avgHeal = calculateAverageHealth(dragons);
            double avgArm = calculateAverageArmor(dragons);
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", s, avgDam, avgHeal, avgArm);
            dragons = dragons.stream().sorted(Comparator.comparing(Dragon::getName)).collect(Collectors.toList());
            for (Dragon dragon : dragons) {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", dragon.name, dragon.damage, dragon.health, dragon.armor);
            }
        }

    }

    private static double calculateAverageHealth(List<Dragon> dragons) {
        double avg = 0;
        for (Dragon dragon : dragons) {
            avg += dragon.getHealth();
        }
        return avg / dragons.size();
    }

    private static double calculateAverageArmor(List<Dragon> dragons) {
        double avg = 0;
        for (Dragon dragon : dragons) {
            avg += dragon.getArmor();
        }
        return avg / dragons.size();
    }

    private static double calculateAverageDamage(List<Dragon> dragons) {
        double avg = 0;
        for (Dragon dragon : dragons) {
            avg += dragon.getDamage();
        }
        return avg / dragons.size();

    }

}

class Dragon {
    String name;
    int damage;
    int health;
    int armor;

    Dragon(String name, int damage, int health, int armor) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.armor = armor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    String getName() {
        return name;
    }

    int getDamage() {
        return damage;
    }

    int getHealth() {
        return health;
    }

    int getArmor() {
        return armor;
    }

}
