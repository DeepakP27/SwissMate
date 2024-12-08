
import java.util.ArrayList;
public class Round {
  private double[][] scores;
  private Player gotBye;
  private Player[][] pairings;
  private ArrayList<Player> players;
  private int boards;


  public Round(ArrayList<Player> players) {
    pairings = new Player[players.size() / 2][2];
    boards = players.size()  / 2;
    scores = new double[players.size() / 2][2];
    gotBye = null;
    this.players = players;
  }


  public double[][] getScores() {
    return scores;
  }

  public Player[][] getPairings() {
    return pairings;
  }

  public Player getGotBye() {
    return gotBye;
  }

  public ArrayList<Player> getPlayers() {
    return players;
  }

  public void setScores(double[][] theScores) {
    scores = theScores;
  }

  public void setPairs(Player[][] thePairs) {
    pairings = thePairs;
  }

  public void setGotBye(Player theBye) {
    gotBye = theBye;
  }

  public void createPairings(){
      sort();
      int j = 0;
      
      if (players.size() % 2 == 0) {
        for (int i = 0; i < players.size(); i+=2) {
          
          if (players.get(i).getWhiteCounter() > players.get(i+1).getWhiteCounter()) {
            pairings[j][0] = players.get(i+1);
            pairings[j][1] = players.get(i);
            players.get(i+1).addWhite();
            players.get(i).getOpponents().add(players.get(i+1));
            players.get(i+1).getOpponents().add(players.get(i));
          }
          else if (players.get(i).getWhiteCounter() < players.get(i+1).getWhiteCounter()) {
            pairings[j][1] = players.get(i+1);
            pairings[j][0] = players.get(i);
            players.get(i).addWhite();
            players.get(i).getOpponents().add(players.get(i+1));
            players.get(i+1).getOpponents().add(players.get(i));
          }
          else {
            //if they are same 
            int num = (int)(Math.random() * 2);
            if (num == 0) {
              pairings[j][0] = players.get(i+1);
              pairings[j][1] = players.get(i);
              players.get(i+1).addWhite();
              players.get(i).getOpponents().add(players.get(i+1));
              players.get(i+1).getOpponents().add(players.get(i));
            }
              
            else {
              pairings[j][1] = players.get(i+1);
              pairings[j][0] = players.get(i);
              players.get(i).addWhite();
              players.get(i).getOpponents().add(players.get(i+1));
              players.get(i+1).getOpponents().add(players.get(i));
            }
          }
          j++;
        }
        
        for(int i=0; i < pairings.length; i++){
          System.out.println();
          System.out.println("BOARD # " + (i+1));
          System.out.println("White: " + pairings[i][0].getName() + " (" + pairings[i][0].getPoints() + ")");
          System.out.println("Black: " + pairings[i][1].getName() + " (" +  pairings[i][1].getPoints() + ")");
          System.out.println();
        }  
      }
      
      else {
        for (int i = 0; i < players.size()-1; i+=2) {      
          if (players.get(i).getWhiteCounter() > players.get(i+1).getWhiteCounter()) {
            pairings[j][0] = players.get(i+1);
            pairings[j][1] = players.get(i);
            players.get(i+1).addWhite();
            players.get(i).getOpponents().add(players.get(i+1));
            players.get(i+1).getOpponents().add(players.get(i));

            if(players.get(i).getBye()){
              players.get(i).setBye(false);
            }
            if(players.get(i+1).getBye()){
              players.get(i+1).setBye(false);
            }
          }
          else if (players.get(i).getWhiteCounter() < players.get(i+1).getWhiteCounter()) {
            pairings[j][1] = players.get(i+1);
            pairings[j][0] = players.get(i);
            players.get(i).addWhite();
            players.get(i).getOpponents().add(players.get(i+1));
            players.get(i+1).getOpponents().add(players.get(i));

            if(players.get(i).getBye()){
              players.get(i).setBye(false);
            }
            if(players.get(i+1).getBye()){
              players.get(i+1).setBye(false);
            }
          }
          else {
            //if they are same 
            int num = (int)(Math.random() * 2);
            if (num == 0) {
              pairings[j][0] = players.get(i+1);
              pairings[j][1] = players.get(i);
              players.get(i+1).addWhite();
              players.get(i).getOpponents().add(players.get(i+1));
              players.get(i+1).getOpponents().add(players.get(i));

              if(players.get(i).getBye()){
              players.get(i).setBye(false);
             }
            if(players.get(i+1).getBye()){
              players.get(i+1).setBye(false);
            }
            }
            else {
              pairings[j][1] = players.get(i+1);
              pairings[j][0] = players.get(i);
              players.get(i).addWhite();
              players.get(i).getOpponents().add(players.get(i+1));
            players.get(i+1).getOpponents().add(players.get(i));

              if(players.get(i).getBye()){
              players.get(i).setBye(false);
            }
            if(players.get(i+1).getBye()){
              players.get(i+1).setBye(false);
            }
            }
  
  
          }
        
          j++;
        }
          for(int i=0; i < pairings.length; i++){
            System.out.println();
            System.out.println("BOARD # " + (i+1));
            System.out.println("White: " + pairings[i][0].getName() + " (" + pairings[i][0].getPoints() + ")");
            System.out.println("Black: " + pairings[i][1].getName() + " (" +  pairings[i][1].getPoints() + ")");
            System.out.println();
          }
        
            System.out.println("BYE: " + players.get(players.size()-1).getName() + "(" + players.get(players.size()-1).getPoints() + ") ----> (" + (players.get(players.size()-1).getPoints()+1) + ")");


            players.get(players.size()-1).addPoints(1); 
            players.get(players.size()-1).setBye(true);
            players.get(players.size()-1).getOpponents().add(null);

            Player p = players.get(players.size()-1);
            
    
            double ps;
    
    
            if(p.getUpdatedScore().size() ==  0){
              p.getUpdatedScore().add(1.0);
            }
            else{
              ps = p.getUpdatedScore().get(p.getUpdatedScore().size()-1);   
              p.getUpdatedScore().add(ps + 1.0);    
            }        
            
            gotBye = players.get(players.size()-1);
            
        
      }
      
    }
  

public void sort() {

  for (int i = 0; i < players.size() - 1; i++) {
    int maxIndex = i;
    for (int j = i + 1; j < players.size(); j++) {
      if (players.get(j).getPoints() > players.get(maxIndex).getPoints()) {
        maxIndex = j;
      }
    }
    Player temp = players.get(i);
    players.set(i, players.get(maxIndex));
    players.set(maxIndex, temp);
  }

  boolean filler;
  if(players.size() % 2 == 0){
  for(int i=0; i < players.size(); i+=2){
    filler = false;
    if(checkOpponent(players.get(i), players.get(i+1))){
      for(int j = i+2; j < players.size(); j++){
        if(j % 2 == 0){
          if(!checkOpponent(players.get(i), players.get(j)) && !checkOpponent(players.get(i+1), players.get(j+1))){
            Player temp = players.get(i+1);
            players.set(i+1,players.get(j));
            players.set(j, temp);
            filler = true;
          }
        }
        else{
          if(!checkOpponent(players.get(i), players.get(j)) && !checkOpponent(players.get(i+1), players.get(j-1))){
            Player temp = players.get(i+1);
            players.set(i+1,players.get(j));
            players.set(j, temp);
            filler = true;
          }        
        }
        if(filler == true){
          break;
        }
      }
      if(filler == false){
        for(int k = i; k >=0; k--){
          if(k % 2 == 0){
            if(!checkOpponent(players.get(i), players.get(k)) && !checkOpponent(players.get(i+1), players.get(k+1))){
              Player temp = players.get(i+1);
              players.set(i+1,players.get(k));
              players.set(k, temp);
              filler = true;
            }
          }
          else {
            if(!checkOpponent(players.get(i), players.get(k)) && !checkOpponent(players.get(i+1), players.get(k-1))){
              Player temp = players.get(i+1);
              players.set(i+1,players.get(k));
              players.set(k, temp);
              filler = true;
            }
          }
          if(filler == true){
          break;
          }
        }
      }
    }
  }
  }
  else{
    for(int i=0; i < players.size()-1; i+=2){
      filler = false;
      if(checkOpponent(players.get(i), players.get(i+1))){
        for(int j = i+2; j < players.size(); j++){
          if(j % 2 == 0 && j != players.size() - 1){
            if(!checkOpponent(players.get(i), players.get(j)) && !checkOpponent(players.get(i+1), players.get(j+1))){
              Player temp = players.get(i+1);
              players.set(i+1,players.get(j));
              players.set(j, temp);
              filler = true;
            }
        }
        else{
          if(!checkOpponent(players.get(i), players.get(j)) && !checkOpponent(players.get(i+1), players.get(j-1))){
          Player temp = players.get(i+1);
          players.set(i+1,players.get(j));
          players.set(j, temp);
          filler = true;
        }
        
        }
        if(filler == true){
          break;
        }
      }
      if(filler == false){
        for(int k = i; k >=0; k--){
          if(k % 2 == 0){
        if(!checkOpponent(players.get(i), players.get(k)) && !checkOpponent(players.get(i+1), players.get(k+1))){
          Player temp = players.get(i+1);
          players.set(i+1,players.get(k));
          players.set(k, temp);
          filler = true;
        }
        }
        else{
          if(!checkOpponent(players.get(i), players.get(k)) && !checkOpponent(players.get(i+1), players.get(k-1))){
          Player temp = players.get(i+1);
          players.set(i+1,players.get(k));
          players.set(k, temp);
          filler = true;
        }
        }
        if(filler == true){
          break;
        }
      }
    }
    }
      }
      



        
        
      }
     

        if(players.get(players.size()-1).getBye()){
          for(int g = players.size()-2; g>=0; g--){
          if(!checkOpponent(players.get(players.size()-1), players.get(g))){
          Player temper = players.get(g);
          players.set(g, players.get(players.size()-1));
          players.set(players.size()-1, temper);
          players.get(players.size()-1).setBye(false);
          }
        }
    }
    
    
  }

 public boolean checkOpponent(Player p, Player o){
   for(Player c : p.getOpponents()){
     if(c !=  null && o.getName().equals(c.getName())){
       return true;
     }
   }
   return false;
 }

  public void inputResults(double result, int board){
      if(result == 10){
        pairings[board][0].addPoints(1);

        scores[board][0] = 1;
        scores[board][1] = 0;


        Player p = pairings[board][0];
        Player o = pairings[board][1];

        double ps;
        double os;


        if(p.getUpdatedScore().size() ==  0){
          p.getUpdatedScore().add(1.0);
          o.getUpdatedScore().add(0.0);
        }
        else{
          ps = p.getUpdatedScore().get(p.getUpdatedScore().size()-1);
          os = o.getUpdatedScore().get(o.getUpdatedScore().size()-1);

          p.getUpdatedScore().add(ps + 1.0);
          o.getUpdatedScore().add(os + 0.0);

        }
      }
        
        
      
      else if(result == 0.5){
        pairings[board][0].addPoints(0.5);
        pairings[board][1].addPoints(0.5);
        scores[board][0] = 0.5;
        scores[board][1] = 0.5;

        Player p = pairings[board][0];
        Player o = pairings[board][1];

        double ps;
        double os;


        if(p.getUpdatedScore().size() ==  0){
          p.getUpdatedScore().add(0.5);
          o.getUpdatedScore().add(0.5);
        }
        else{
          ps = p.getUpdatedScore().get(p.getUpdatedScore().size()-1);
          os = o.getUpdatedScore().get(o.getUpdatedScore().size()-1);

          p.getUpdatedScore().add(ps + 0.5);
          o.getUpdatedScore().add(os + 0.5);

        }        


        }
        
      else{
        pairings[board][1].addPoints(1);
        scores[board][0] = 0;
        scores[board][1] = 1;

        Player p = pairings[board][0];
        Player o = pairings[board][1];

        double ps;
        double os;


        if(p.getUpdatedScore().size() ==  0){
          p.getUpdatedScore().add(0.0);
          o.getUpdatedScore().add(1.0);
        }
        else{
          ps = p.getUpdatedScore().get(p.getUpdatedScore().size()-1);
          os = o.getUpdatedScore().get(o.getUpdatedScore().size()-1);

          p.getUpdatedScore().add(ps + 0.0);
          o.getUpdatedScore().add(os + 1.0);

        }

        
        }
        
      }

    
    }

 



