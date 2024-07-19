import java.util.Random;

public class RoomGirl extends Room{
	Random rand = new Random();
	
    public RoomGirl(TextAdventureGame t, Chara c) {
		super(t, c);
		// TODO 自動生成されたコンストラクター・スタブ
	}
    
    //girlをfalseに変える
    
	@Override
	public void choice(String choice) {
		switch (choice) {
        case "喋りかける":
            t.storeStoryE(1, 1);
            story();
            break;
        case "戦う":
            t.storeStoryE(1, 2);
            story();
            break;
        case "口説く":
            t.storeStoryE(1, 3);
            story();
            break;
        default:
            // その他の選択肢に対するデフォルトの処理
            break;
		}
	}



	@Override
	public void story() {
		int event = t.getStoryE(1);
        if (event == 0) {
            t.storeStr("あなたは左の通路を進んだ。<br><br>");
            t.addStr("20代の女性が立っている。<br>");
            t.addStr("あなたのことに気づいたようだ。<br>");
            t.addStr("<br>");
            t.updateChoices(new String[]{"喋りかける", "戦う", "口説く"});
        } else if (event == 1) {
            if(c.getApp()>70) {
            	t.storeStr("女性にしゃべりかけた。<br>");
            	t.addStr("「こんにちは！キミも迷宮に挑戦してるんだ。私も夢があって挑戦してるんだ。<br>");
            	t.addStr("よかったら協力しない？私のことはメリッサってよんで。」<br><br>");
            	t.addStr("「そうだ．．．これをあげル！」<br><br>");
            	t.addStr("脱ぎたてマントをくれた。戦闘力が１８増えた。<br><br>");
            	t.addStr("「また会えた時はよろしくね！」<br>");
            	t.addStr("メリッサに別れを告げると、小さく手を振ってくれた。かわいい。先に進もう。<br><br>");
            	c.power(18);
            	t.updateChoices(new String[]{"先に進む", "", ""});
            }else if(c.getApp()<30) {
            	t.storeStr("女性にしゃべりかけた。<br>");
            	t.addStr("「こんにちは．．．。君たぶん見た目のせいで損してると思う。<br>");
            	t.addStr("これ使ってみて。」<br><br>");
            	t.addStr("特製BBくりーむをもらった。塗るったとたん肌がつるつるに光りだした。");
            	t.addStr("外見が20上がった！<br><br>");
            	t.addStr("「またね。」<br><br>");
            	c.app(20);
            	t.updateChoices(new String[]{"先に進む", "", ""});
            }else {
            	t.storeStr("女性にしゃべりかけた。<br>");
            	t.addStr("「こんにちは。お互いがんばりましょう！<br>");
            	t.addStr("あ、これよかったらどうぞ！」<br><br>");
            	t.addStr("メリッサ特製ドリンクをもらった。飲むと身体にいい味がした。<br>");
            	t.addStr("外見が7上がった。<br><br>");
            	t.addStr("「じゃあね！」<br><br>"
            			+ "女性に別れを告げる。"
            			+ "先に進もう。");
            	c.app(7);
            	t.updateChoices(new String[]{"先に進む", "", ""});
            }
        } else if (event == 2) {
        	t.storeStr("「ちょっ!なにするの！」<br>");
        	t.addStr("すごいスピードで逃げられてしまった・・・。先に進もう。<br>");
        	t.updateChoices(new String[]{"先に進む", "", ""});
        } else if (event == 3) {
        	t.storeStr("素っ気ない返事だ。<br>");
        	t.updateChoices(new String[]{"先に進む", "", ""});
        }
	}

}
