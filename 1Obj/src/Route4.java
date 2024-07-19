import java.awt.event.ActionEvent;

import javax.swing.JButton;

public class Route4 extends Route{

	public Route4(TextAdventureGame t, Chara c) {
		super(t, c);
		Route1 r1 = new Route1(t,c);
		this.b3 = new Roombook3(t,c);
		this.s = new RoomSlime(t,c,r1);
		this.ice = new RoomIceGolem(t,c,r1);
        
	}

	@Override
	public void choice(ActionEvent e) {
		JButton sourceButton = (JButton) e.getSource();
        String choice = sourceButton.getText();

		if(choice.equals("先に進む")){
            next();
        }else if (book3) {
        	b3.choice(choice);
        }else if (slime) {
            s.choice(choice);
        }else if (icegolem) {
            ice.choice(choice);
        } else {
            if (choice.equals("左の通路を進む")) {
                b3.story();
                book3 = true;
            } else if (choice.equals("真ん中の通路を進む")) {
                s.story();
                slime = true;
            } else if (choice.equals("右の通路を進む")) {
                ice.story();
                icegolem = true;
            }else if(choice.equals("転生する")) {
            	TextAdventureGame.main(new String[]{});
            }
        }
	}

    private void next() {
        slime = false;
        book3 = false;
        icegolem = false;
        t.Ichi = 4;
        t.storeStoryE(2, 0);
    	t.storeStr("あなたは通路の先に進んだ。<br><br>");
        t.updateChoices(new String[]{"左の通路を進む", "真ん中の通路を進む", "右の通路を進む"});
    }	
}


