import GUI.Tabella;
import GameSide.Scacchiera;

public class testScac {
    public static void main(String[] args) {
        Scacchiera s = Scacchiera.scacchieraStandard();

        System.out.println(s);

        Tabella t = new Tabella();
    }
}
 