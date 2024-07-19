
public class RoomSkelton extends Room{
	int i;
	public RoomSkelton(TextAdventureGame t, Chara c) {
		super(t, c);
	}

	@Override
	public void choice(String choice) {
		switch (choice) {
        case "喋りかける":
            t.storeStoryE(3, 1);
            story();
            break;
        case "戦う":
            t.storeStoryE(3, 2);
            story();
            break;
        case "舞踊":
            t.storeStoryE(3, 3);
            story();
            break;
        case "何してるの？":
        	t.storeStoryE(3, 4);
            story();
            break;
        case "戦わないの？":
        	t.storeStoryE(3, 5);
            story();
            break;
        case "さらに話す":
        	t.storeStoryE(3, 6);
            story();
            break;
        default:
            // その他の選択肢に対するデフォルトの処理
            break;
		}
	}

	

	@Override
	public void story() {
		int event = t.getStoryE(3);
        if (event == 0) {
            t.storeStr("あなたは右の通路を進んだ。<br><br>");
            t.addStr("通路の先でスケルトンが踊っているのに気づいた。<br>"
            		+ "スケルトンの頭には赤いハットを被っている。");
            t.addStr("隙をつけそうだ。<br>");
            t.updateChoices(new String[]{"喋りかける", "戦う", "先に進む"});
        } else if (event == 1) {
        	t.storeStr("スケルトンにしゃべりかけた。<br>"
        			+ "「おや、まだこんなところに生きてるヤツがいたのかい？<br>"
        			+ "ふふ、ボーンジョーって名前で覚えておいてくれ。<br>"
        			+ "俺の骨がちょっと踊りたくなったら、いつでも声をかけてくれよ！」<br>");
        	t.updateChoices(new String[]{"何してるの？", "戦う", "戦わないの？"});
            
        } else if (event == 2) {
        	t.storeStr("「わっ!！何するんだい！」<br>");
        	t.addStr("すごいスピードで逃げられてしまった・・・。先に進もう。<br>");
        	t.updateChoices(new String[]{"先に進む", "", ""});
        } else if (event == 3) {//satti
        	t.storeStr("「わぉ...！<br>"
        			+ "なんて素敵な踊りなんだ。君は今まで出会ってきたニンゲンのなかで一番美しいよ。<br>"
        			+ "素敵な踊りには素敵な踊りで返さなくちゃね。」<br><br>"
        			+ "ボーンジョーンと一緒に踊りつづけた。ボーンジョーンの動きを学習して戦闘力が8上がった。<br><br>"
        			+ "「そうだ！これを受け取ってくれ！<br>"
        			+ "君と話せた楽しい時間のお礼だよ」<br><br>"
        			+ "'謎の骨'を手に入れた。<br><br>"
        			+ "「必ずまた会いに来いよ！兄弟」");
        	c.power(18);
        	t.updateChoices(new String[]{"先に進む","", ""});
        } else if (event == 4) {//なにしてるの？
        	t.storeStr("「ふふ、今はちょっとボーンダンスの練習をしているんだ。"
        			+ "この骨がちょっとでもスムーズに動くように、ね。<br>"
        			+ "戦うことは、ちょっと得意ではないんだ。俺は平和主義者のスケルトンだからね。"
        			+ "でも、もしも自分を守る必要があるときは、ちょっとした骨を投げてみるくらいならできるよ。」");
        	t.updateChoices(new String[]{"さらに話す", "舞踊", ""});
        } else if (event == 5) {//"戦わないの？"
        	t.storeStr("「おおっ、なんて質問をするんだい！俺が君を襲う理由なんてないよ。"
        			+ "今日はちょっと骨の調子が良くてねえ。ついつい踊りたくなっちゃったんだよ！"
        			+ "でも、君と話していると面白いことができそうな気がするから、"
        			+ "今は襲わないでおくよ。<br>"
        			+ "君も、"
        			+ "迷宮をクリアしたいのかい？<br>"
        			+ "......<br>"
        			+ "俺はそんなことやめてここで生活するのも悪くないと思うよ。");
        	t.updateChoices(new String[]{"さらに話す", "", ""});
        }else if (event ==6) { //さらに話す
        	t.storeStr("「そうだ！これを受け取ってくれ！<br>"
        			+ "君と話せた楽しい時間のお礼だよ<br>"
        			+ "きっと役に立つよ！」<br>"
        			+ "<br><br>"
        			+ "ボーンジョーンのあばら骨を手に入れた。<br><br>"
        			+ "「またしゃべりかけてくれ！兄弟」<br>");
        	t.updateChoices(new String[]{"先に進む", "", ""});
        }
	}
	
}
