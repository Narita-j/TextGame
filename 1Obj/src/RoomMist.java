
public class RoomMist extends Room{
	int i;
	Route1 r;
	
	public RoomMist(TextAdventureGame t, Chara c ,Route1 r) {
		super(t, c);
		this.r = r;
	}

	@Override
	public void choice(String choice) {
		switch (choice) {
        case "左に進む":
            t.storeStoryE(5, 1);
            story();
            break;
        case "無視する":
            t.storeStoryE(5, 2);
            story();
            break;
        case " ??? ":
            t.storeStoryE(5, 3);
            story();
            break;
        case "黒の光に進む","黄の光に進む":
            t.storeStoryE(5, 4);
            story();
            break;
        case "赤の光に進む":
            t.storeStoryE(5, 5);
            story();
            break;
        default:
            // その他の選択肢に対するデフォルトの処理
            break;
		}
	}

	

	@Override
	public void story() {
		int event = t.getStoryE(5);
        if (event == 0) {
            t.storeStr("看板がある<br><br>"
            		+ "「左に回復の泉アリ。」");
           
            t.updateChoices(new String[]{"左に進む", "無視する", ""});
        } else if (event == 1) {
            t.storeStr("左に進んで行くとだんだん霧が濃くなってきた。"
            		+ "あなたが異変に気づいた時には、既に霧に囲まれ、視界が白く閉ざされてしまった。"
            		+ "冷たい霧が肌にまとわりつき、方向感覚を失う。"
            		+ "どこからともなく不気味な声が響いてくる。<br><br>"
            		+ "【わたしは霧が深い国で生まれた、あなたを永久に捕らえるもの。"
            		+ "この霧は歩む者を欺き、真実を隠匿する。決断せよ、次なる道は汝の選択にかかっている。"
            		+ "一歩間違えば、永遠に霧に囚われる運命となろう。】");
            			
            t.updateChoices(new String[]{" ??? ", " ??? ", " ??? "});
        } else if (event == 2) {//無視
        	t.storeStr("回復の泉は必要ない。<br>");
        	t.updateChoices(new String[]{"先に進む", "", ""});
        } else if (event == 3) {
        	t.storeStr("不気味な声が響く。<br>"
        			+ "【　霧の奥深く、道を示す光。正しい道には光が導く。<br>"
        			+ "愉快なスケルトンのハットの色。】<br>"
        			+ "遠くで何かが光るのが見えた。");
        	t.updateChoices(new String[]{"赤の光に進む", "黄の光に進む", "黒の光に進む"});
        }  else if (event == 4) {//失敗
        	t.storeStr("かなり進んだが、光はまだかなり先にあるようだ。"
        			+ "霧は一向に晴れない。同じところをぐるぐる回っている気がする。<br>"
        			+ "孤独と不安があなたの心を蝕んでいく。呼吸が荒くなる。");
        	if(t.damage(30)==1) {
            	
            }else {
            	//死亡
            	r.MistFalse();
            }
        	t.updateChoices(new String[]{" ??? ", " ??? ", " ??? "});
        }  else if (event == 5) {//成功
        	t.storeStr("赤い光のそばに来ると霧が晴れ始めた。<br>"
        			+ "【正解だ。】<br>"
        			+ "霧が晴れると目の前に泉が現れた。<br><br>"
        			+ "あなたは回復の泉で体力が回復できた。<br>");
        	c.hp(30);
        	t.updateChoices(new String[]{"先に進む", "", ""});
        } 
	}
	
}
