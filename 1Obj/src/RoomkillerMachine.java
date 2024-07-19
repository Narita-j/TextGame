
public class RoomkillerMachine extends Room{
	int i;
	Route1 r;
	
	public RoomkillerMachine(TextAdventureGame t, Chara c ,Route1 r) {
		super(t, c);
		this.r = r;
	}

	@Override
	public void choice(String choice) {
		switch (choice) {
        case "戦う":
            t.storeStoryE(4, 1);
            story();
            break;
        case "剣術":
            t.storeStoryE(4, 2);
            story();
            break;
        case "逃げる":
            t.storeStoryE(4, 3);
            story();
            break;
        default:
            // その他の選択肢に対するデフォルトの処理
            break;
		}
	}

	

	@Override
	public void story() {
		int event = t.getStoryE(4);
        if (event == 0) {
            t.storeStr("突如、洞窟の奥深くから巨大な影が現れる。"
            		+ "その姿は人間の手によるものではなく、鋼鉄と機械の融合体だ。"
            		+ "光を発し、空気を切り裂く音が鳴り響く。"
            		+ "それは何かを求めるように、プレイヤーに近づいてくる。<br><br>"
            		+ "キラーマシーンが現れた。");
           
            t.updateChoices(new String[]{"戦う", "剣術", "逃げる"});
        } else if (event == 1) {
        	t.storeStr("");
        	int damage = 90- (c.getPower() / 4 * 3);
        	if(t.damage(damage)==1) {
            	t.addStr("キラーマシーンは激しい戦いの末、ついに動きを止めた。"
            			+ "壊れた金属の音が響き、戦場に静寂が戻る。<br>"
            			+ "戦闘力が23上がった。<br>");
            	c.power(23);
            	t.updateChoices(new String[]{"先に進む", "", ""});
            }else {
            	//死亡slime=false
            	r.killerFalse();
            }
        } else if (event == 2) {
        	if(c.skill.get("剣術")==true) {
        		t.storeStr("キラーマシーンは力強い一撃を繰り出すが,あなたはその攻撃をかわし、隙を見つけて反撃した。"
        				+ "剣が機械の装甲に深く食い込み、キラーマシーンの動きが一時停止する。"
        				+ "その隙を見逃さず、続けざまに攻撃を仕掛け、"
        				+ "キラーマシーンを倒すことに成功した。<br>"
        				+ "戦闘力が28上がった。<br>");
        		c.power(28);
        		t.updateChoices(new String[]{"先に進む", "", ""});
        	}else {
        		t.storeStr("あなたは剣術を持っていない。");
        	}
        } else if (event == 3) {
        	if(c.skill.get("逃走")==true) {
        		t.storeStr("あなたは一瞬の判断で、部屋の奥から現れたキラーマシーンの脅威を感じ取った。"
        				+ "逃走スキルを駆使して、その場から素早く逃げ出した。"
        				+ "背後から迫るキラーマシーンの音を感じながら、狭い通路を駆け抜ける。"
        				+ "何とか逃げ切れたが少し判断が遅れていたら、逃げ切れなかっただろう。");
        		t.updateChoices(new String[]{"先に進む", "", ""});
        	}else {
        		boolean i = rand.nextBoolean();
        		if(i==true) {
        			t.storeStr("あなたは一瞬の判断で、部屋の奥から現れたキラーマシーンの脅威を感じ取り、"
        					+ "その場から素早く逃げ出した。"
            				+ "背後から迫るキラーマシーンを感じながら、狭い通路を駆け抜けてなんとか振り切った。"
            				+ "運よく逃げ切ることができたが、次も逃げ切れるとは限らないだろう。");
            		t.updateChoices(new String[]{"先に進む", "", ""});
        		}else {
        			t.storeStr("あなたは、その場から逃げ出そうと走り出す。"
            				+ "しかし、キラーマシーンによって逃げ道を破壊されてしまった。"
            				+ "キラーマシーンの攻撃を受ける。");
        			int damage = (100-c.getPower());
                	if(t.damage(damage)==1) {
                    	t.addStr("<br>運が良ければ逃げれるだろう。<br>");
                    	t.updateChoices(new String[]{"先に進む", "", ""});
                    }else {
                    	//死亡slime=false
                    	r.killerFalse();
                    }
            		t.updateChoices(new String[]{"先に進む", "", ""});
        		}
        	}
        }
	}
	
}
