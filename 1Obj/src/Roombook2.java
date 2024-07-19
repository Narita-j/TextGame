
public class Roombook2 extends Room{

	public Roombook2(TextAdventureGame t, Chara c) {
		super(t, c);
		
	}

	@Override
	public void choice(String choice) {
		if (choice.equals("本を読む")) {
            t.storeStoryE(11, 1);
            story();
        } 
	}

	@Override
	public void story() {
		int event = t.getStoryE(11);
        if (event == 0) {
            t.storeStr("無尽蔵に散らばった残骸の中に、一冊の本を見つけた。"
            		+ "かなり汚れていたり破けているページはあるが、まだ読めそうだ。");
            
            t.updateChoices(new String[]{"本を読む", "", "先に進む"});
        } else if (event == 1) {//yomu
        	 t.storeStr("「賢者たちは、ゼラフの力を封じ込めるために、巨大で複雑な迷宮を創り出した。"
        	 		+ "この迷宮は「終焉の迷宮」と呼ばれ、封印を守るために、守護者として賢者がこの迷宮を守った。"
        	 		+ "しかし、長い年月を経て、ゼラフからもれる魔力が賢者たちを魔物へと姿を変えてしまった。」<br>pege2<br><br>"
        	 		+ "この先は読めない。");
        	 t.updateChoices(new String[]{"", "", "先に進む"});
        }
	}

}
