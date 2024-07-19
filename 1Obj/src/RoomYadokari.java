
public class RoomYadokari extends Room{
	int i;
	Route1 r;
	
	public RoomYadokari(TextAdventureGame t, Chara c ,Route1 r) {
		super(t, c);
		this.r = r;
	}

	@Override
	public void choice(String choice) {
		switch (choice) {
        case "戦う":
            t.storeStoryE(6, 1);
            story();
            break;
        case "平服する":
            t.storeStoryE(6, 2);
            story();
            break;
        case "喋る":
            t.storeStoryE(6, 3);
            story();
            break;
        default:
            // その他の選択肢に対するデフォルトの処理
            break;
		}
	}

	

	@Override
	public void story() {
		int event = t.getStoryE(6);
        if (event == 0) {
        	if(c.getApp()>70) {
        		t.storeStr("「おい！お前！"
                		+ "持っているものすべて置いていけ！<br>"
                		+ "...いや、お前は綺麗な顔をしているな。<br>"
                		+ "その命ももらうぜ」<br><br>"
                		+ "あなたは突然声をかけられた。"
                		+ "足元を見ると２０㎝程のヤドカリがいる。");
        		t.updateChoices(new String[]{"戦う", "", "平服する"});
        	}else {
        		t.storeStr("「おい！お前！"
                		+ "持っているものすべて置いていけ！」<br><br>"
                		+ "あなたは突然声をかけられた。"
                		+ "足元を見ると２０㎝程のヤドカリがいる。");
                t.updateChoices(new String[]{"戦う", "喋る", "平服する"});
        	}
            
        } else if (event == 1) {
        	t.storeStr("");
        	int damage = (100-c.getPower())/10;
        	if(t.damage(damage)==1) {
            	t.addStr("ヤドカリを踏みつぶした<br>"
            			+ "戦闘力が5上がった。<br>");
            	c.power(5);
            	t.updateChoices(new String[]{"先に進む", "", ""});
            }else {
            	//死亡slime=false
            }
        } else if (event == 2) {//平服
        	t.storeStr("「そんな平服に意味はない」<br>");
        } else if (event == 3) {//喋る
        	t.storeStr("「私は海の支配者である。こうべをたれよ！」<br>");
        } 
	}
	
}
