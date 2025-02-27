package sk.upjs.sk;

import java.util.Scanner;
import java.util.Stack;

public class Zatvorky {

    // nacitavanie vstupu z konzoly
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            System.out.println(spravneOzatvorkovany(line));
        }
    }

    // () {}
    private static boolean spravneOzatvorkovany(String line) {
        Stack<Character> zasobnik = new Stack<>();
        for (int i = 0; i < line.length(); i++) {
            char zatvorka = line.charAt(i);
            if (zatvorka == '(' || zatvorka == '{') {
                zasobnik.push(zatvorka);
            }
            // prazdny je ked je viac pravych ako lavych
            if (zasobnik.isEmpty()) {
                return false;
            }
            if (zatvorka == ')') {
                if (zasobnik.pop() != '(') {
                    // ak nie je zhoda v type zatvorky
                    return false;
                }
            }
            if (zatvorka == '}') {
                if (zasobnik.pop() != '{') {
                    return false;
                }
            }
        }
        // false ak je viac lavych, cize na konci nie je zasobnik este prazdny
        return zasobnik.isEmpty();
    }


    /*
    * Ak by sme mali zjednodušiť algoritmus iba na jeden typ zátvoriek, tak môžeme mať:
    *   a) 2 počítadla na počet otvaracich a zatvaracich - problem / ))(( /, vysledok 0, nespravne
    *   b) 1 počítadlo, otvaracia je +1, zatvaracia je -1, ak je kedykoľvek záporné číslo, tak vyhodime false
    * */


    /*
    * Implementácia zásobníka pomocou rôznych štruktúr:
    *   operacia            | push  | pop   | peek  | is empty
    * ----------------------------------------------------------
    *   pole                |  O(n) | O(n)  | O(1)  | O(1)
    * ----------------------------------------------------------
    *   pole s kapacitou    | O(1)  | O(1)  | O(1)  | O(1)   - ak nemáme kapacitu, uvažujeme aj O(n)
    * ----------------------------------------------------------
    *   spajany zoznam      | O(1)  |  O(1) |  O(1) |  O(1)    - ak ho implementujeme cez začiatok
    * ----------------------------------------------------------
    * */
}