import java.util.* ;
public class Dungeon{
	public static void main(String[] args){
		int gold = 0 ;
		int select = 0 ;
		int story = 0 ;
		Human player = new Human("test");
		System.out.print("名前を入力してください＞＞");
		String name = new Scanner(System.in).nextLine();
		do{
			Human user = new Human(name);
			user.show();
			System.out.print("問題なければ1を入力してください＞＞");
			select = new Scanner(System.in).nextInt();
			if( select == 1 ){
				player = user ;
				break;
			}
		}while(true);
		while(true){
			story++ ;
			System.out.println();
			System.out.println(story+"階層");
			int enemyLevel = new Random().nextInt(3)+1;
			int enemyRace = new Random().nextInt(3);
			Enemy nowEnemy = new Enemy(enemyLevel*story,enemyRace);
			while(true){
				battleShow(player,nowEnemy);
				select = Battle.playerFight(player,nowEnemy);
				if(select >= 5)break;
				select = Battle.checkVital(player,nowEnemy);
				if(select >= 5)break;
				nowEnemy.attack(player);
				select = Battle.checkVital(player,nowEnemy);
				if(select >= 5)break;
			}
			if( select == 5 ){
				break;
			}else{
				gold += nowEnemy.gold ;
				int status = new Random().nextInt(4)+1 ;
				player.growth(status);
			}
		}
		System.out.println();
		System.out.printf("%d階層潜り、%dG獲得した%n",story,player.hp<=0?gold/2:gold);
		player.show();
	}
	public static void battleShow(Human p,Enemy e){
		System.out.printf("Name:%-10s||Name%-10s%nHP:%-7d/%-4d||HP%-12d%n",p.name,e.name,p.hp,p.maxHp,e.hp);
		System.out.printf("MP:%-12d||Level:%-9d%nAt:%-12d||At:%-12d%n",p.mp,e.level,p.at,e.at);
		System.out.printf("Df:%-12d||Df:%-12d%nProtect:%-7d||Gold:%-10d%n",p.df,e.df,p.protect,e.gold);
	}
}
/*
		Human test = new Human("test");
		Enemy first = new Enemy(2,2);
		first.show();
		player.attack(first);
		first.attack(player);
		player.magic(first);
		player.defence();
		player.heal();
		player.growth(select);
checkVital(Human p,Enemy e)
playerFight(Human p,Enemy e)

*/