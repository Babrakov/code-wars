package main.java.kyu7.cw17;

/*
Create a function that returns the name of the winner in a fight between two fighters.
Each fighter takes turns attacking the other and whoever kills the other first is victorious.
Death is defined as having health <= 0.
Each fighter will be a Fighter object/instance. See the Fighter class below in your chosen language.
Both health and damagePerAttack (damage_per_attack for python) will be integers larger than 0.
You can mutate the Fighter objects.
 */

public class TwoFightersOneWinner {
    public static void main(String[] args) {
        System.out.println(declareWinner(new Fighter("Lew", 10, 2),new Fighter("Harry", 5, 4), "Lew"));
    }

    public static String myDeclareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        Fighter attacker,defender,temp;
        if (fighter1.name==firstAttacker) {
            attacker = fighter1;
            defender = fighter2;
        } else {
            attacker = fighter2;
            defender = fighter1;
        }
        while (fighter1.health>0 && fighter2.health>0) {
            int health = defender.health- attacker.damagePerAttack;
            defender.health = health;
            temp = defender;
            defender = attacker;
            attacker = temp;
        }
        return (fighter1.health> fighter2.health) ? fighter1.name : fighter2.name;
    }

    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        Fighter a=fighter1, b=fighter2;
        if (firstAttacker.equals(fighter2.name)) {
            a = fighter2; b = fighter1;
        }
        while (true) {
            if ((b.health -= a.damagePerAttack) <= 0) return a.name;  // a wins
            if ((a.health -= b.damagePerAttack) <= 0) return b.name;  // b wins
        }
    }
}

