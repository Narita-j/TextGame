
public class Roombook3 extends Room{

	public Roombook3(TextAdventureGame t, Chara c) {
		super(t, c);
		
	}

	@Override
	public void choice(String choice) {
		if (choice.equals("本を読む")) {
            t.storeStoryE(12, 1);
            story();
        } 
	}

	@Override
	public void story() {
		int event = t.getStoryE(12);
        if (event == 0) {
            t.storeStr("無尽蔵に散らばった残骸の中に、一冊の本を見つけた。"
            		+ "かなり汚れていたり破けているページはあるが、まだ読めそうだ。");
            
            t.updateChoices(new String[]{"本を読む", "", "先に進む"});
        } else if (event == 1) {//yomu
        	 t.storeStr("「そのために、ほとんどの者は記憶をなくし、本能に従って行動するようになった。"
        	 		+ "幸運にも私は記憶を取り戻した。なぜ私だけが記憶を取り戻したのか。"
        	 		+ "いや、私の記憶が戻ったことに意味があるのならば、"
        	 		+ "私は未来のために歴史を残す。---ルミナリア国賢者セリーナ」<br>pege3<br><br>"
        	 		+ "この先はない。");
        	 t.updateChoices(new String[]{"", "", "先に進む"});
        }
	}

}
