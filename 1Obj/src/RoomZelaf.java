import java.awt.Color;

public class RoomZelaf extends Room{
	int i;
	Route1 r;
	
	public RoomZelaf(TextAdventureGame t, Chara c ,Route1 r) {
		super(t, c);
		this.r = r;
	}

	@Override
	public void choice(String choice) {
		switch (choice) {
        case "左の扉":
            t.storeStoryE(9, 1);
            story();
            break;
        case "真ん中の扉":
            t.storeStoryE(9, 2);
            story();
            break;
        case "右の扉":
            t.storeStoryE(9, 3);
            story();
            break;
        case "戻る":
            t.storeStoryE(9, 4);
            story();
            break;
        case "封印を破壊する":
            t.storeStoryE(9, 5);
            story();
            break;
        case "戦う":
            t.storeStoryE(9, 6);
            story();
            break;
        case "剣を突き立てる":
            t.storeStoryE(9, 7);
            story();
            break;
        case "逃げる":
            t.storeStoryE(9, 8);
            story();
            break;
        default:
            // その他の選択肢に対するデフォルトの処理
            break;
		}
	}

	

	@Override
	public void story() {
		int event = t.getStoryE(9);
        if (event == 0) {
        	t.storeStr("かなり瘴気が濃くなってきた。<br>");
        	if(c.skill.get("耐性")==true) {
        		t.addStr("あなたは耐性を持っていたので、瘴気の影響を受けない。");
        	}else {
        		t.addStr("あなたは瘴気の影響で、能力が下がってしまう。<br>"
        				+ "戦闘力が15下がる。<br>"
        				+ "体力が10下がる。<br>");
        		c.power(-15);
        		if(c.getHp()<10) {
        			c.setHp(1);
        		}else {
        			c.hp(-10);
        		}
        	}
        	t.addStr("もうすぐダンジョンの最奥のようだ。<br>"
        			+ "目の前に三つの扉と看板がある。<br><br>"
        			+ "看板を読んだ。<br>"
        			+ "「左：ボーンドラゴン<br>"
        			+ "真ん中：封印の間<br>"
        			+ "右：時の扉」<br>");
        	t.updateChoices(new String[]{"左の扉", "真ん中の扉", "右の扉"});
        } else if (event == 1) {//左
        	t.storeStr("看板がある。<br>「外出中」<br>");
        	t.updateChoices(new String[]{"", "戻る", ""});
        } else if (event == 2) {//真ん中
        	t.storeStr("部屋の中央には古代の祭壇があり、"
        			+ "その上には巨大な魔法陣が描かれている。"
        			+ "周囲には薄暗い光が漂い、中央には座ったままの姿勢で"
        			+ "巨大な影がそびえている。"
        			+ "封印はかなり劣化しており破壊することは難しくないだろう。<br>");
        	t.updateChoices(new String[]{"封印を破壊する", "戻る", ""});
        } else if (event == 3) {//右
        	t.storeStr("看板がある。<br>「建設中」<br>");
        	t.updateChoices(new String[]{"", "戻る", ""});
        } else if (event == 4) {//modoru
        	t.storeStr("扉の前に戻ってきた<br>");
        	t.updateChoices(new String[]{"左の扉", "真ん中の扉", "右の扉"});
        } else if (event == 5) {//hakai
        	t.panel.setBackground(Color.decode("#2C3333")); //Color
        	t.storeStr("魔法陣が輝き出し、部屋全体が揺れ始める。"
        			+ "巨大な影がゆっくりと動き出し、眠りから覚める。"
        			+ "その時、部屋全体に響く低くて不気味な声が、プレイヤーの耳に届く。<br><br><br>"
        			+ "「.......。汝が私を解放したか。だが、私に剣を向けるとは無謀な者よ。<br>"
        			+ "この力の前に滅びよ。」<br><br><br><br>"
        			+ "推奨㏋60POWER90");
        	t.updateChoices(new String[]{"戦う", "逃げる", ""});
        } else if (event == 6) {//battle
        	t.storeStr("ゼラフが闇の力を集め、その力が一瞬で部屋全体を覆い尽くす。"
        			+ "次第に暗闇が深まり、あなたの周りに絶望の気配が漂う。"
        			+ "暗黒のエネルギーがあなたに向かって急襲する！！！<br><br>");
        	int damage = (150-c.getPower());
        	if(t.damage(damage)==1) {
            	t.addStr("<br><br><br>.........................あなたは攻撃に耐えた。ゼラフに隙が生まれた。<br>");
            	c.power(18);
            	t.updateChoices(new String[]{"剣を突き立てる", "", ""});
            }else {
            	//死亡slime=false
            	r.killerFalse();
            }
        } else if (event == 7) {//battle
        	t.storeStr("あなたの剣はゼラフの胸を貫いた。<br><br>"
        			+ "ゼラフは苦悶の表情を浮かべ、彼の最後の叫びが部屋に響き渡る。"
        			+ "ゼラフの体が崩れ落ちると同時に、周囲の壁や柱がひび割れ始める。"
        			+ "ダンジョン全体が揺れ始め、その地下の深淵が咆哮するように響く。<br><br>"
        			+ "GAME　CLEAR");
        	t.updateChoices(new String[]{"", "", ""});
        }else if (event == 8) {
        	t.storeStr("逃げる場所はない。");
        }
	}
	
}
