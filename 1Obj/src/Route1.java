import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.JButton;

public class Route1 extends Route{
	Random rand = new Random();
    
    
    public Route1( TextAdventureGame t, Chara c) {
		super(t, c);
		this.g = new RoomGirl(t,c);
        this.s = new RoomSlime(t,c,this);
        this.skt = new RoomSkelton(t,c);
	}


	public void choice(ActionEvent e) {
        JButton sourceButton = (JButton) e.getSource();
        String choice = sourceButton.getText();
        
        if(choice.equals("先に進む")){
            next();
        }else if (girl) {
        	g.choice(choice);
        }else if (slime) {
            s.choice(choice);
        }else {
            if (choice.equals("左の通路を進む")) {
                g.story();
                girl = true;
            } else if (choice.equals("真ん中の通路を進む")) {
                s.story();
                slime = true;
            } else if (choice.equals("右の通路を進む")) {
                s.story();
                slime = true;
            }else if(choice.equals("転生する")) {
            	TextAdventureGame.main(new String[]{});
            }
        }
	}

    public void next(){
            girl = false;
            slime = false;
            t.Ichi = 1;
            t.storeStoryE(2, 0);
        	t.storeStr("あなたは通路の先に進んだ。<br><br>");
            t.updateChoices(new String[]{"左の通路を進む", "真ん中の通路を進む", "右の通路を進む"});
    }
    
	public void slimeFalse() {
    	this.slime = false;
    }
	
	public void killerFalse() {
    	this.killerMachine = false;
    }


	public void MistFalse() {
		this.mist = false;
	}
        
}




