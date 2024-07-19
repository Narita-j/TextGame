
public class Roombook1 extends Room{

	public Roombook1(TextAdventureGame t, Chara c) {
		super(t, c);
		
	}

	@Override
	public void choice(String choice) {
		if (choice.equals("本を読む")) {
            t.storeStoryE(10, 1);
            story();
        } 
	}

	@Override
	public void story() {
		int event = t.getStoryE(10);
        if (event == 0) {
            t.storeStr("無尽蔵に散らばった残骸の中に、一冊の本を見つけた。"
            		+ "かなり汚れていたり破けているページはあるが、まだ読めそうだ。");
            
            t.updateChoices(new String[]{"本を読む", "", "先に進む"});
        } else if (event == 1) {//yomu
        	 t.storeStr("「千年前、国が１０つに分かれていた時代、ある強大な魔王「ゼラフ」が現れ、世界を闇に包もうとした。"
        	 		+ "ゼラフは絶大な力を持ち、その力で人々を恐怖に陥れた。１０の王国の賢者たちは力を合わせ、ゼラフを封印することに成功した。"
        	 		+ "しかし、その封印は完全ではなく、ゼラフの力を完全に抑えるためには、特別な迷宮を創り出す必要があった。」<br>pege1<br><br>"
        	 		+ "この先は読めない。");
        	 t.updateChoices(new String[]{"", "", "先に進む"});
        }
	}

}
