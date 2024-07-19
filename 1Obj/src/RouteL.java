import java.awt.event.ActionEvent;

import javax.swing.JButton;

public class RouteL extends Route{

	public RouteL(TextAdventureGame t, Chara c) {
		super(t, c);
		Route1 r1 = new Route1(t,c);
		this.zlf = new RoomZelaf(t,c,r1);
	}

	@Override
	public void choice(ActionEvent e) {
		JButton sourceButton = (JButton) e.getSource();
        String choice = sourceButton.getText();

		if(choice.equals("転生する")) {
        	TextAdventureGame.main(new String[]{});
        }else if(choice.equals("先に進む")){
            next();
        }else if (zelaf) {
        	zlf.choice(choice);
        } else {
            if (choice.equals("左の通路を進む")) {
                zlf.story();
                zelaf = true;
            } else if (choice.equals("真ん中の通路を進む")) {
            	zlf.story();
                zelaf = true;
            } else if (choice.equals("右の通路を進む")) {
            	zlf.story();
                zelaf = true;
            }
        }
	}

    private void next() {
       
        throw new UnsupportedOperationException("Unimplemented method 'next'");
    }	
}


