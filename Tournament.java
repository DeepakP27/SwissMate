import java.util.Scanner;
import java.util.ArrayList;

public class Tournament {

  //Instance Variables
  private ArrayList<Player> players;
  private int totalRounds;
  private int currentRound;
  private int boards;
  private ArrayList<Round> rounds;

  //Constructor
  public Tournament(ArrayList<Player> players, int rounders){
    this.players = players;
    totalRounds = rounders;
    currentRound = 0;
    boards = players.size()  / 2;
    rounds = new ArrayList<Round>();
  }

  Scanner input = new Scanner(System.in);

  //Add Round Method
  public void addRound(){
    currentRound++;
    
    if(currentRound > 1){
      rounds.add(new Round(rounds.get(currentRound - 2).getPlayers()));
      }
    else{
      rounds.add(new Round(players));
    }
    
  }

  public void printPairings(){
    rounds.get(currentRound-1).createPairings();
  }

   public void askResults(){
     for(int i=0; i < boards; i++){
     System.out.println();
     System.out.println("ENTER RESULTS FOR BOARD " + (i+1));
     double result = input.nextDouble();
     rounds.get(currentRound-1).inputResults(result,i);
       }
   }

    public void printWallChart(){
    ArrayList<Player> ref = new ArrayList<Player>();
    ref = rounds.get(currentRound-1).getPlayers();

    //Max to Min for points in the ref ArrayList
    for (int i = 0; i < ref.size(); i++) {
      Player max = ref.get(i);
      int maxIndex = i;

      for (int j = i + 1; j < ref.size(); j++) {
        if (ref.get(j).getPoints() > max.getPoints()) {
          max = ref.get(j);
          maxIndex = j;
        }
      }
      Player temp = ref.get(i);
      ref.set(i, max);
      ref.set(maxIndex, temp);
      
    }

      System.out.println();
      System.out.print("Name             ");

      for (int i = 0; i < rounds.size(); i++) {
        System.out.print("Round " + (i+1) + "             ");
      }

      Player p;
      boolean white = false;
      Player [][] temp;
      Player o;
      int index = 0;
     //////////////////////////////////////////////////////////
      

      for(int i=0; i < ref.size(); i++){
        white = false;
        p = ref.get(i);
        System.out.println();
        System.out.print((i+1) + ". " + ref.get(i).getName() + "             ");
        for(int j=0; j < rounds.size(); j++){
          temp = rounds.get(j).getPairings();
          
          for(int k=0; k < temp.length; k++){
            if(temp[k][0].getName().equals(p.getName())){
              white = true;
            }
          }

          o = p.getOpponents().get(j);

          if(o == null){
            System.out.print("BYE (" + p.getUpdatedScore().get(j) + ")");   
            for (int k = 0; k < 14 -p.getName().length(); k++) {
              System.out.print(" ");
            } 
          }
          else{
          for(int x = 0; x < ref.size(); x++){
            if(ref.get(x) != null && ref.get(x).getName().equals(o.getName())){
              index = x;
            }
          }
          
          if(white == true){
            System.out.print("W " + (index+1)  + " (" + p.getUpdatedScore().get(j) + ")");
            for (int k = 0; k < 14 - p.getName().length(); k++) {
              System.out.print(" ");
            }
            
          }
          else{
            System.out.print("B " + (index+1)  + " (" + p.getUpdatedScore().get(j) + ")");
            for (int k = 0; k < 14 - p.getName().length(); k++) {
              System.out.print(" ");
            }            
          }
          }
        }
        System.out.println();
        System.out.println("--------------------------------");
      }
  }

  public void printFinalResults(){
    ArrayList<Player> ref = new ArrayList<Player>();
    ref = rounds.get(currentRound-1).getPlayers();
    System.out.println();
    System.out.println("NAME               TOTAL POINTS");
    Player p;
    for(int i=0; i < ref.size(); i++){
      p = ref.get(i);
      System.out.println((i+1) + ". " + p.getName() + "        " + p.getPoints());
    }
  }
  

  
  //Getter Methods
  public int getBoards(){
    return boards;
  }

  public int getTotalRounds(){
    return totalRounds;
  }

  //Add a Player to a Tournament
  public void addPlayer(Player player) {
    players.add(player);
    player.addPoints(0.5);
  }

  //Withdraw a player from the Tournament
  public void withdrawPlayer(Player player) {
    int index = 0;
    for(int i=0; i < players.size(); i++){
      if(players.get(i).getName().equals(player.getName())){
        index = i;
      }
    }
    players.remove(index);
  }

  
  
  
}