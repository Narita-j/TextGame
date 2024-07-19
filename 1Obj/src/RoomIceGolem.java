
public class RoomIceGolem extends Room{
	int i;
	Route1 r;
	
	public RoomIceGolem(TextAdventureGame t, Chara c ,Route1 r) {
		super(t, c);
		this.r = r;
	}

	@Override
	public void choice(String choice) {
		switch (choice) {
        case "修復":
            t.storeStoryE(7, 1);
            story();
            break;
        case "話を聞く":
            t.storeStoryE(7, 2);
            story();
            break;
        case "使命？":
            t.storeStoryE(7, 3);
            story();
            break;
        case "賢者について":
            t.storeStoryE(7, 4);
            story();
            break;

        default:
            // その他の選択肢に対するデフォルトの処理
            break;
		}
	}

	

	@Override
	public void story() {
		int event = t.getStoryE(7);
        if (event == 0) {
            t.storeStr("冷え切った部屋の中に砕けた氷や魔法のコア"
            		+ "のようなものが散らばっている。"
            		+ "よく見ると、ゴーレムの残骸のようだ。");
           
            t.updateChoices(new String[]{"修復", "", "先に進む"});
        } else if (event == 1) {
        	if(c.skill.get("修復")==true) {
        		t.storeStr("あなたは、ゴーレムを修復した。<br>"
        				+ "すると、破片が一つに結びついてき、ゴーレムの体がゆっくりと魔力を帯びて再生されていく。"
        				+ "やがて完全に体の再生が終わると、その体表から古代の文字が浮かび上がる。"
        				+ "ゴーレムは目を開け、プレイヤーを見つめる。"
        				+ "その目には知識と叡智が宿っているかのように輝いている。<br><br>"
        				+ "「私を修復してくれたのは、君か。心から礼を言おう。"
        				+ "私には、まだなすべきことがある。」<br>");
        		t.updateChoices(new String[]{"話を聞く", "", "先に進む"});
        	}else {
        		t.storeStr("あなたは修復を持っていない。");
        	}
        } else if (event == 2) {
        	t.storeStr("「私の名前はアイゼン・グレイハート、フロストフェルム帝国の賢者だ。<br>"
        			+ "この身体に変えられて、長い間、私は忘れられた思い出の中に閉じ込められていた。"
        			+ "この氷の中で自分を見失い、過去の光が暗闇に埋もれていたんだ。<br>"
        			+ "しかし今、記憶の扉が開かれた。<br>"
        			+ "失われた歴史がよみがえり、私の使命を思い出す。<br>"
        			+ "この迷宮は過去と今を繋ぐ鎖だ。私が目指すべき道は、今ここに示されている。私には、私たちにはなすべき使命がある。<br><br>"
        			+ ".....だが、この身体では、いつ身体が操られてもおかしくはない。<br>"
        			+ "君に我々の使命を託したい。」");
        	t.updateChoices(new String[]{"使命？", "", "先に進む"});
        } else if (event == 3) {
        	t.storeStr("「ゼラフを倒す使命だ。私は氷の加護を持っている。<br>"
        			+ "君にこれを譲渡しよう。気に負う必要はない、私が勝手に託したことだ。<br>"
        			+ "君の無事を祈っている。」<br><br>"
        			+ "戦闘力が30上がった");
        	c.power(30);
        	t.updateChoices(new String[]{"賢者について", "", "先に進む"});
        	
        }else if (event == 4) {
        	t.storeStr("「私たちについて話せることはなんでも話そう。<br><br>");
        	
        	if(r.ic > 4)r.ic = 0;
        	if(r.ic==0)t.addStr("サンドレア砂漠王国の賢者の名前はナジール。愉快なやつだった。"
        			+ "サンドレアは金が有名で、貴族は皆、金の装飾品をつけていたんだが、ナジールは金が嫌いな変わり者だった。その代わり、赤いハットをずっとつけていたよ。」");
        	else if(r.ic==1)t.addStr("ミストラーレ公国の賢者には秘密が多い。名前は誰も知らなかったからミストと呼んでいた。"
        			+ "公国は隠された知識と秘儀が眠るとされていて、ミストも何故か知らないはずのことを知ってたりしていた。"
        			+ "人と関わることを避けていたようだが、サンドレアのナジールとは仲が良かったな。」");
        	else if(r.ic==2)t.addStr("ウェーブライダーは海の王だった。人の上に立つ才能に優れていて、海戦ではついに無敗だった。"
        			+ "意外にヤドカリを飼っている可愛いところもあったが、正真正銘の私のライバルだった。"
        			+ "あいつ程の実力者ならば、巨大なサメか、クラーケンにでもなってるかも知れない。君も気を付けてくれ。」");
        	else if(r.ic==3)t.addStr("リアムのいた国はとてもきれいな国だった。フィレンドール共和国という国で、争いが少なく、自然が豊かな国だった。"
        			+ "私の妹もそこに嫁いでいたんだ。<br>...昔の話だ。」<br>");
        	else if(r.ic==4)t.addStr("エルウィン・グリーンリーフは自然魔法の一番の使い手だ。"
        			+ "エルウィンの回復がなければ、私たちは何度全滅していたかわからない。"
        			+ "エルウィンは妖精の声を聞けるから、身体を変えられても自分を保っていられるかも知れない。」");
        	
        	r.ic ++;
        }
        
	}
	
}
