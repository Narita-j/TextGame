import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class TextAdventureGame extends JFrame {
    private JLabel storyLabel;
    private JButton[] choiceButtons;
    JPanel panel = new JPanel();
    String str;
    int[] storye = new int[20];
    //１girl
    //2slime
    //3skelton
    //4killama
    //5mist
    //6yadokari
    //7golem
    //8
    //9zelaf
    //10boo1
    //11b2
    //12b3
    //13
    //14
    Random rand = new Random();
    Chara c = new Chara();
	private JLabel statusLabel;
	TextAdventureGame game1;
	Route1 r1;
    Route2 r2;
    Route3 r3;
    Route4 r4;
    RouteL rl;
    
    int Ichi=0;

    public TextAdventureGame() {
    	super("Text Adventure Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 2000/3);

        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.decode("#576F72")); //Color

        storyLabel = new JLabel("Welcome to the Adventure Game!");
        panel.add(storyLabel, BorderLayout.NORTH);
        storyLabel.setForeground(Color.decode("#F0EBE3"));//Colortext
        
        // ステータス表示用のラベル
        statusLabel = new JLabel("HP: " + c.getHp() + " Power: " + c.getPower() + " Appearance: " + c.getApp() + " Skill: " + c.getSkill());

        // ステータスパネル
        JPanel statusPanel = new JPanel(new FlowLayout());
        JPanel statusPanel1 = new JPanel();
        JPanel statusPanel2 = new JPanel();
        statusPanel2.setBorder(new EmptyBorder(0, 0, 70,0)); // 上下左右に余白を追加

        // ボタンパネル
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        choiceButtons = new JButton[3];
        choiceButtons[0] = new JButton("左の通路を進む");
        choiceButtons[1] = new JButton("真ん中の通路を進む");
        choiceButtons[2] = new JButton("右の通路を進む");
        for (int i = 0; i < choiceButtons.length; i++) {
            choiceButtons[i].addActionListener(new ChoiceButtonListener(this));  // thisを渡す
            buttonPanel.add(choiceButtons[i]);
        }
        
        statusPanel1.add(statusLabel,BorderLayout.SOUTH); // ステータス表示用のラベルを追加
        statusPanel2.add(buttonPanel); // ボタンパネルをステータスパネルに追加
        
        statusPanel.setBackground(Color.decode("#E4DCCF"));
        statusPanel1.setBackground(Color.decode("#E4DCCF"));
        statusPanel2.setBackground(Color.decode("#E4DCCF"));
        
        Color buttonColor = Color.decode("#F0EBE3"); 
        for (JButton button : choiceButtons) {
            button.setBackground(buttonColor);
            //button.setForeground(Color.WHITE); 
            //button.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
        }

        
        statusPanel.add(statusPanel1);
        statusPanel.add(statusPanel2);
        panel.add(statusPanel, BorderLayout.SOUTH);
        add(panel);
        setVisible(true);
        
        r1 = new Route1(this,c);
        r2 = new Route2(this,c);
        r3 = new Route3(this,c);
        r4 = new Route4(this,c);
        rl = new RouteL(this,c);
        
        
        // 最初のストーリーを表示
        if (c.getHp() > 70 && c.getPower() > 70) {
            str = "あなたは、体力=" + c.getHp() + "、戦闘力=" + c.getPower() + "、外見=" + c.getApp() + "、のベテラン冒険者です。";
            str += "<br><br>横に並ぶ存在がいなくなってしまうほどの強さを持つあなたは、まだ見ぬ富と名声を求めて伝説の迷宮に挑むことをケツイしました。";
            str += "この迷宮は、いまだ誰一人として踏破した者はいないと言われています。あなたは、確かな自信と強い信念を胸に、その門をくぐりました。";
        } else if (c.getHp() < 20 && c.getPower() < 30 && c.getApp() < 30) {
            str = "あなたは、体力=" + c.getHp() + "、戦闘力=" + c.getPower() + "、外見=" + c.getApp() + "、の年老いた冒険者です。";
            str += "<br><br>あなたは、人生の終着点を求めて伝説の迷宮に挑むことをケツイしました。";
            str += "この迷宮はいまだ誰一人として踏破した者はいないと言われています。あなたは、外の世界に別れを告げてその門をくぐりました。";
        } else if (c.getHp() < 25) {
            str = "あなたは、体力=" + c.getHp() + "、戦闘力=" + c.getPower() + "、外見=" + c.getApp() + "、の少年です。";
            str += "<br><br>あなたは、馬鹿にしてきたいじめっ子を見返すために、伝説の迷宮に挑むことをケツイしました。";
            str += "この迷宮はいまだ誰一人として踏破した者はいないと言われています。あなたは、踏破した後のことを考えると、思わず笑みがこぼれてしまいます。そして、スキップしながらその門をくぐりました。";
        } else {
            str = "あなたは、体力=" + c.getHp() + "、戦闘力=" + c.getPower() + "、外見=" + c.getApp() + "、の若き冒険者です。";
            str += "<br><br>あなたは、まだ見ぬ富と名声を求めて伝説の迷宮に挑むことをケツイしました。この迷宮はいまだ誰一人として踏破した者はいないと言われています。";
            str += "あなたは、深呼吸をし、勇気を奮い立たせてその門をくぐりました。";
        }
        str +=("<br><br>あなたは、");
        str += c.getSkill();
        str+=("を持っています。");
        

        updateStory(str);
    }
    
    
    public void updateStory(String story) {
        String htmlText = "<html><body style='width: 370px; text-align: left;'>" + story + "</body></html>";
        Timer timer = new Timer(5, new ActionListener() {
            public int timerIndex=52;

			@Override
            public void actionPerformed(ActionEvent e) {
                if (timerIndex <= htmlText.length()) {
                    storyLabel.setText(htmlText.substring(0, timerIndex));
                    timerIndex++;
                } else {
                    ((Timer) e.getSource()).stop();
                    enableChoiceButtons(true);
                }
            }
        });

        enableChoiceButtons(false);
        timer.start();
    }

    private void enableChoiceButtons(boolean enable) {
        for (int i = 0; i < choiceButtons.length; i++) {
            choiceButtons[i].setEnabled(enable);
        }
    }



    public void updateChoices(String[] choices) {
        for (int i = 0; i < choices.length; i++) {
            choiceButtons[i].setText(choices[i]);
        }
    }

    private class ChoiceButtonListener implements ActionListener {
        

        public ChoiceButtonListener(TextAdventureGame game) {
            game1 = game;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // 位置に応じてストーリーを更新
            
            if(Ichi==0)r1.choice(e);
            else if (Ichi==1)r2.choice(e);
            else if (Ichi==2)r3.choice(e);
            else if (Ichi==3)r4.choice(e);
            else if (Ichi==4)rl.choice(e);

            updateStory(str);
            updatestatus();
        }
    }
    
    public int damage(int damage) {
    	if(damage<0) {
    		damage = 0;
    	}
        addStr(damage +"ダメージをうけた。<br>");
        if(c.getHp()-damage<=0) {
        	storeStr(""+damage +"ダメージをうけた。<br>"
        			+ "あなたは、力尽きた。<br><br>.<br>.<br>.<br>.<br>...あなたは、次の人生では必ずこの迷宮をクリアすることを誓った。");
        	updateChoices(new String[]{"転生する", "", ""});
        	return 0;
        }
        
        c.hp(-damage);
        updatestatus();
        return 1;
    }
    
    public void updatestatus() {

		statusLabel.setText("HP: " + c.getHp() + " Power: " + c.getPower() + " Appearance: " + c.getApp() + " Skill: " + c.getSkill() + "          ");
    }
    
    public void storeStr(String str) {
        this.str = str;
    }

    public void addStr(String str) {
        this.str += str;
    }

    public void storeStoryE(int i, int k) {
        this.storye[i] = k;
    }

    public int getStoryE(int i) {
        return this.storye[i];
    }
    


    public static void main(String[] args) {
        SwingUtilities.invokeLater(TextAdventureGame::new);
    }
}
