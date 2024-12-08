import java.util.ArrayList;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    
    Player p1 = new Player("Sam");
    Player p2 = new Player("Jack");
    Player p3 = new Player("John");
    Player p4 = new Player("Jill");
    Player p5 = new Player("Timothy");
    Player p6 = new Player("Samuel");
    Player p7 = new Player("Barth");
    //Player p8 = new Player("Monkey");


    ArrayList<Player> players = new ArrayList<Player>();

    players.add(p1);
    players.add(p2);
    players.add(p3);
    players.add(p4);
    players.add(p5);
    players.add(p6);
    players.add(p7);
    //players.add(p8);

    Tournament tournament1 = new Tournament(players, 6);

    for(int i=0; i < tournament1.getTotalRounds(); i++){
      tournament1.addRound();
      tournament1.printPairings();
      tournament1.askResults();
      tournament1.printWallChart();
    }

    tournament1.printFinalResults();

   

    
    


    

  }
}