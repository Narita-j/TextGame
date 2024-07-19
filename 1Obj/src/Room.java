import java.util.Random;

public abstract class Room {
	TextAdventureGame t;
    Chara c;
    Route1 r;
    Random rand = new Random();
    
    public Room(TextAdventureGame t, Chara c) {
        this.t = t;
        this.c = c;
    }
    
    
    public abstract void choice(String choice);
    
    public abstract void story();
}
