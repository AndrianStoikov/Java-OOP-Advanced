//package P02_KingsGambit.groups;
//
//import P02_KingsGambit.attackable.Attackable;
//
//import java.util.LinkedHashMap;
//
//
//
//public class KingGroup implements Group {
//    private Attackable king;
//    private Map<String, Killablee> killables;
//    private Writer writer;
//
//    public KingGroup(Writer writer) {
//        this.writer = writer;
//        this.killables = new LinkedHashMap<>();
//    }
//
//    @Override
//    public void addAttackable(Attackable attackable) {
//        this.king = attackable;
//    }
//
//    @Override
//    public void addKillable(Killablee killable) {
//        this.killables.put(killable.getName(), killable);
//    }
//
//    @Override
//    public void killKillable(String name) {
//        this.killables.remove(name);
//    }
//
//    @Override
//    public void attackAttackable() {
//        writer.print(this.king.attack());
//        for (Killablee killable : this.killables.values()) {
//            writer.print(killable.kill());
//        }
//    }
//}
