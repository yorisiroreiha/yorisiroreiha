import java.util.* ;
public class Enemy{
	String[] baseName = {"スライム","ゴブリン","オーガ"};
	int[] baseHp = {1,2,3};
	int[] baseAt = {1,2,3};
	int[] baseDf = {2,1,1};
	String name;
	int level;
	int hp;
	int at;
	int df;
	int gold;
	public Enemy(int level,int race){
		this.name = baseName[race] ;
		this.level = level ;
		this.hp = diceBot(this.baseHp[race],6,level);
		this.at = diceBot(this.baseAt[race],6,level);
		this.df = diceBot(this.baseDf[race],6,level);
		this.gold = level * ( this.baseHp[race] + this.baseAt[race] + this.baseDf[race] ) ;
	}
	public static int diceBot(int times,int roll,int base){
		int n = 0 ;
		for( int i = 0 ; i < times ; i++ ){
			n += new Random().nextInt(roll)+1+base;
		}
		return n ;
	}
	public void attack(Human h){
		int damage = diceBot(this.at,4,0) ;
		if( h.protect >= 1 ){
			h.protect-- ;
			System.out.printf("%sの攻撃は障壁に阻まれた%n",this.name);
		}else{
			damage = Math.max(1,(damage*5)/(5+h.df));
			h.hp -= damage ;
			System.out.printf("%sの攻撃%n%sに%dのダメージを与えた%n",this.name,h.name,damage);
		}
	}
	public void show(){
		System.out.printf("Name:%s%nLevel:%d%nHP:%d%n",this.name,this.level,this.hp);
		System.out.printf("At:%d%nDf:%d%nGold:%d%n",this.at,this.df,this.gold);
	}
}