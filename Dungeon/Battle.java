import java.util.*;
public class Battle{
	public static int checkVital(Human p,Enemy e){
		if( p.hp <= 0 ){
			System.out.printf("%sは倒れた%n",p.name);
			return 5 ;
		}else if( e.hp <= 0 ){
			System.out.printf("%sを倒した%n",e.name);
			return 6 ;
		}else{
			return 0 ;
		}
	}
	public static int playerFight(Human p,Enemy e){
		System.out.println("1:物理攻撃、2:魔法攻撃、3:防御、4:回復、5:脱出");
		System.out.print("行動を選択してください＞＞");
		int select = new Scanner(System.in).nextInt();
		switch(select){
			case 1 :
				p.attack(e);
				return 1 ;
			case 2 :
				p.magic(e);
				return 2 ;
			case 3 :
				p.defence();
				return 3 ;
			case 4 :
				p.heal();
				return 4 ;
			default :
				return 5 ;
		}
	}
}