import java.awt.event.ActionEvent;

import javax.swing.JButton;

public class Route2 extends Route{

	public Route2(TextAdventureGame t, Chara c) {
		super(t, c);
		Route1 r1 = new Route1(t,c);
		this.b1 =new Roombook1(t,c);
        this.skt = new RoomSkelton(t,c);
        this.kill = new  RoomkillerMachine(t,c,r1);
        
	}

	@Override
	public void choice(ActionEvent e) {
		JButton sourceButton = (JButton) e.getSource();
        String choice = sourceButton.getText();

		if(choice.equals("先に進む")){
            next();
        }else if(choice.equals("転生する")) {
        	TextAdventureGame.main(new String[]{});
        }else if (killerMachine) {
        	kill.choice(choice);
        }else if (book1) {
            b1.choice(choice);
        }else if (skelton) {
            skt.choice(choice);
        } else {
            if (choice.equals("左の通路を進む")) {
                kill.story();
                killerMachine = true;
            } else if (choice.equals("真ん中の通路を進む")) {
                b1.story();
                book1 = true;
            } else if (choice.equals("右の通路を進む")) {
                skt.story();
                skelton = true;
            }
        }
	}

    private void next() {
    	skelton = false;
        book1 = false;
        killerMachine = false;
        t.Ichi = 2;
    	t.storeStr("あなたは通路の先に進んだ。<br><br>");
        t.updateChoices(new String[]{"左の通路を進む", "真ん中の通路を進む", "右の通路を進む"});
    }	
}


