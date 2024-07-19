import java.awt.event.ActionEvent;

public abstract class Route {
    TextAdventureGame t;
    Chara c;
    int ic;
    boolean girl = false;  // girl の状態を保持するフィールド
    boolean slime = false;
    boolean skelton = false;
    boolean book1 = false;
    boolean book2 = false;
    boolean book3 = false;
    boolean killerMachine = false;
    boolean mist = false;
    boolean yadokari = false;
    boolean zelaf;
    boolean icegolem = false;
    
    RoomGirl g;
    RoomSlime s;
    RoomSkelton skt;
    RoomMist mis;
    RoomYadokari yado;
    RoomkillerMachine kill;
    Roombook1 b1;
    Roombook2 b2;
    Roombook3 b3;
    RoomZelaf zlf;
    RoomIceGolem ice;
    
    
    public Route( TextAdventureGame t, Chara c) {
            this.t = t;
            this.c = c;
    }
    
    public abstract void choice(ActionEvent e);
    
}
