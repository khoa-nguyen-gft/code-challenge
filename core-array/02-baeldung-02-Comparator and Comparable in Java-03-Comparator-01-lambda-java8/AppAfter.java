import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class App {
	public static void main(String[] args) {
		List<Player> players = Arrays.asList(
				new Player(59, "John", 20), new Player(67, "Roger", 22), new Player(45, "Steven", 24));
		
		System.out.println("Before sort: " + players);

		Comparator<Player> rankingCompatator = (p1, p2) -> p1.getRanking() - p2.getRanking();
		Collections.sort(players, rankingCompatator);
		System.out.println("After sort ranking: " + players);
		
		Comparator<Player> ageComparator = (p1, p2) -> p1.getAge() - p2.getAge();
		Collections.sort(players, ageComparator);
		System.out.println("After sort age: " + players);
	}

}

//class RankingComparator implements Comparator<Player>{
//
//	@Override
//	public int compare(Player o1, Player o2) {
//		return o1.getRanking() - o2.getRanking();
//	}
//}
//
//class AgeComparator implements Comparator<Player>{
//
//	@Override
//	public int compare(Player o1, Player o2) {
//		return o1.getAge() - o2.getAge();
//	}
//	
//}

class Player{
	private int ranking;
	private String name;
	private int age;

	public Player(int ranking, String name, int age) {
		super();
		this.ranking = ranking;
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Player [ranking=" + ranking + ", name=" + name + ", age=" + age + "]";
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}