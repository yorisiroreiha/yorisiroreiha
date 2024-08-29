import java.util.* ;
public class Human{
	String name;
	int maxHp;
	int hp;
	int mp;
	int at;
	int df;
	int protect;
	public Human(String name){
		this.name = name ;
		this.maxHp = diceBot(5,10) ;
		this.hp = this.maxHp ;
		this.mp = diceBot(3,6);
		this.at = diceBot(4,6);
		this.df = diceBot(2,6);
		this.protect = 1 ;
	}
	public static int diceBot(int times,int roll){
		int n = 0 ;
		for( int i = 0 ; i < times ; i++ ){
			int temp = new Random().nextInt(roll)+1;
			n += temp ;
		}
		return n ;
	}
	public void attack(Enemy e){
		int damage = diceBot(this.at,6) ;
		damage = Math.max(1,(damage*5)/(5+e.df)) ;
		e.hp -= damage ;
		System.out.printf("%sの攻撃%n%sに%dのダメージを与えた。%n",this.name,e.name,damage);
	}
	public void defence(){
		if( this.df >= 1 ){
			this.df-- ;
			this.protect++ ;
			this.hp = Math.min(this.maxHp,this.hp+this.maxHp/10);
			System.out.printf("%sは防御態勢を取った%n",this.name);
		}else{
			System.out.printf("%sはDFが足りなかった%n",this.name);
		}
	}
	public void heal(){
		if( this.mp >= 1 ){
			this.mp-- ;
			int temp = this.hp ;
			this.hp = this.maxHp ;
			System.out.printf("%sは%d点回復した%n",this.name,this.hp-temp);
		}else{
			System.out.printf("%sはMPが足りなかった%n",this.name);
		}
	}
	public void magic(Enemy e){
		if( this.mp >= 1 ){
			this.mp-- ;
			int damage = diceBot(this.mp,10) ;
			e.hp -= damage ;
			System.out.printf("%sの攻撃%n%sに%dのダメージを与えた。%n",this.name,e.name,damage);
		}else{
			System.out.printf("%sはMPが足りなかった%n",this.name);
		}
	}
	public void show(){
		System.out.printf("Name:%s%nMaxHP:%d%nHP:%d%nMP:%d%nAt:%d%nDf:%d%nProtect%d%n",this.name,this.maxHp,this.hp,this.mp,this.at,this.df,this.protect);
	}
	public void growth(int select){
		this.maxHp += 5 ;
		this.hp = this.maxHp ;
		this.mp++ ;
		this.at++ ;
		this.df++ ;
		switch(select){
			case 1 :
				this.maxHp += 5;
				this.hp += 5 ;
				System.out.println("HPが成長した");
				break;
			case 2 :
				this.mp += 1 ;
				System.out.println("MPが成長した");
				break;
			case 3 :
				this.at += 1 ;
				System.out.println("Atが成長した");
				break;
			case 4 :
				this.df += 1 ;
				System.out.println("Dfが成長した");
				break;
			default :
				break;
		}
	}
}