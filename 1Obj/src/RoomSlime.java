import java.util.Random;


public class RoomSlime extends Room{
	Random rand = new Random();
	Route1 r;
	
	public RoomSlime(TextAdventureGame t, Chara c, Route1 r) {
		super(t, c);
		this.r = r;
	}

	@Override
	public void choice(String choice) {
		if (choice.equals("戦う")) {
            t.storeStoryE(2, 1);
            story();
        } else if (choice.equals("喋りかける")) {
            t.storeStoryE(2, 2);
            story();
        } else if (choice.equals("逃げる")) {
            t.storeStoryE(2, 3);
            story();
        }
	}

	
	@Override
	public void story()  {
		int event = t.getStoryE(2);
        if (event == 0) {
            t.storeStr("真っ直ぐ進むと、半透明な青いスライムと遭遇した。スライムはゆらゆらと揺れながらこちらに近づいてくる。まるで水のように滑らかな動きで、光が反射してキラキラと輝いている。");
            t.addStr("その様子は一見美しくもあるが、近づくにつれてその不気味さが増していく。あなたは武器を構え、スライムに対峙する。<br>");
            t.updateChoices(new String[]{"戦う", "喋りかける", "逃げる"});
        } else if (event == 1) {//fight
        	int damage = (100-c.getPower()) / 8;
        	t.storeStr("");
            if(t.damage(damage)==1) {
            	t.addStr("スライムを倒した。<br>"
            			+ "戦闘力が7上がった。<br>");
            	c.power(7);
            	t.updateChoices(new String[]{"先に進む", "", ""});
            }else {
            	//死亡slime=false
            	r.slimeFalse();
            }
        } else if (event == 2) {
        	int n = rand.nextInt(3);
        	switch (n) {
            case 1:
            case 0:
                t.storeStr("スライムに挨拶した。<br>" +
                           "スライムの攻撃。");
                break;
            case 2:
                t.storeStr("スライムのことが好きと伝えた。<br>" +
                           "スライムの攻撃。");
                break;
        	}
        	
            int damage = (100-c.getPower()) / 8;
            if(t.damage(damage)==0) {
            	//死亡slime = false;
            	r.slimeFalse();
            	
            }else {
            	t.addStr("スライムには言葉は通じなかった。<br>");
            	t.updateChoices(new String[]{"戦う", "喋りかける", "逃げる"});
            }
        } else if (event == 3) {
            t.storeStr("素早くスライムの攻撃をかわすと、スライムを無視して先に進んだ。<br>");
            t.updateChoices(new String[]{"先に進む", "", ""});
        }
	}
    
}
