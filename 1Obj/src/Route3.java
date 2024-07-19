import java.awt.event.ActionEvent;

import javax.swing.JButton;

public class Route3 extends Route{

	public Route3(TextAdventureGame t, Chara c) {
		super(t, c);
		Route1 r1 = new Route1(t,c);
		this.b2 = new Roombook2(t,c);
        this.mis = new RoomMist(t,c,r1);
        this.yado = new  RoomYadokari(t,c,r1);
        
	}

	@Override
	public void choice(ActionEvent e) {
		JButton sourceButton = (JButton) e.getSource();
        String choice = sourceButton.getText();

		if(choice.equals("先に進む")){
            next();
        }else if (book2) {
        	b2.choice(choice);
        }else if (mist) {
            mis.choice(choice);
        }else if (yadokari) {
            yado.choice(choice);
        } else {
            if (choice.equals("左の通路を進む")) {
                b2.story();
                book2 = true;
            } else if (choice.equals("真ん中の通路を進む")) {
                mis.story();
                mist = true;
            } else if (choice.equals("右の通路を進む")) {
                yado.story();
                yadokari = true;
            }else if(choice.equals("転生する")) {
            	TextAdventureGame.main(new String[]{});
            }
        }
	}

    private void next() {
    	mist = false;
        book2 = false;
        yadokari = false;
        t.Ichi = 3;
    	t.storeStr("あなたは通路の先に進んだ。<br><br>");
        t.updateChoices(new String[]{"左の通路を進む", "真ん中の通路を進む", "右の通路を進む"});
    }	
}


