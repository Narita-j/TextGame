import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class Chara {
    private int hp;
    private int power;
    private int maxHp;
    private int app;
    Random rand = new Random();
    Map<String, Boolean> skill = new HashMap<>();
    
    
    public Chara(){
        // プレイヤーの初期ステータス
        
        hp = rand.nextInt(99) + 1;
        power = rand.nextInt(99) + 1;
        app = rand.nextInt(99) + 1;
        haveSkill(skill);
        
        maxHp=hp;
    }

    public void haveSkill(Map<String, Boolean> skill){
        skill.put("舞踊", rand.nextBoolean());
        skill.put("剣術", rand.nextBoolean());
        skill.put("逃走", rand.nextBoolean());
        skill.put("耐性", rand.nextBoolean());
        skill.put("修復", rand.nextBoolean());

    }

    public String getSkill() {
        StringBuilder str = new StringBuilder("");
        boolean hasSkill = false;
        for (Map.Entry<String, Boolean> entry : skill.entrySet()) {
            if (entry.getValue()) {
                str.append(entry.getKey()).append(", ");
                hasSkill = true;
            }
        }
        if (hasSkill) {
            str.delete(str.length() - 2, str.length());
        } else {
            str.append("無能");
        }
        return str.toString();
    }
    
    


    public void hp(int i) {
        this.hp += i;
    }
    
    public void power(int i) {
        this.power += i;
    }
    
    public void app(int i) {
        this.app += i;
    }

    public int getPower() {
        return this.power;
    }

    public int getHp() {
        return this.hp;
    }
    
    public int setHp(int i) {
        return this.hp = i;
    }
    

    public int getApp() {
        return this.app;
    }
    
    public void maxHp() {
        this.hp = maxHp;
    }
    
}
