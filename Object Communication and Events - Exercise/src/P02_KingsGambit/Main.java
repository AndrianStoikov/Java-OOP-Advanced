//package P02_KingsGambit;
//
//import P02_KingsGambit.attackable.Attackable;
//import P02_KingsGambit.attackable.King;
//import P02_KingsGambit.groups.Group;
//import P02_KingsGambit.groups.KingGroup;
//import P02_KingsGambit.killable.Footman;
//import P02_KingsGambit.killable.Killable;
//import P02_KingsGambit.killable.RoyalGuard;
//import P02_KingsGambit.writers.ConsoleWriter;
//import P02_KingsGambit.writers.Writer;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
///**
// * Created by Andrian on 12.4.2017 г..
// */
//@SuppressWarnings("DefaultFileTemplate")
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
//
//        Writer writer = new ConsoleWriter();
//        Group kingGroup = new KingGroup(writer);
//        String kingName = Console.readLine();
//        Attackable king = new King(kingName);
//        kingGroup.addAttackable(king);
//
//        String[] names = Console.readLine().split(" ");
//        for (String name : names) {
//            Killable royalGuard = new RoyalGuard(name);
//            kingGroup.addKillable(royalGuard);
//        }
//
//        names = Console.readLine().split(" ");
//        for (String name : names) {
//            Killable footmen = new Footman(name);
//            kingGroup.addKillable(footmen);
//        }
//
//        while (true) {
//            String input = Console.readLine();
//            if ("End".equals(input))
//                return;
//
//            execCommand(input, kingGroup);
//        }
//    }
//
//    private static void execCommand(String input, Group kingGroup) {
//        if(input.startsWith("Kill")) {
//            String[] cmdArgs = input.split(" ");
//            kingGroup.killKillable(cmdArgs[1]);
//            return;
//        }
//
//        if(input.startsWith("Attack King")) {
//            kingGroup.attackAttackable();
//        }
//    }
//}
