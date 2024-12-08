import java.util.ArrayList;
public class Player {
  
  private String name;
  private double points;
  private int whiteCounter;
  private ArrayList<Player> opponents;
  private boolean hasBye;
  private ArrayList<Double> updatedScore;
  
  public Player(String name){
    this.name = name;
    points = 0;
    whiteCounter = 0;
    opponents = new ArrayList<Player>();
    hasBye = false;
    updatedScore = new ArrayList<Double>();
  }

  public ArrayList<Double> getUpdatedScore() {
    return updatedScore;
  }

  public void setUpdatedScore(ArrayList<Double> updated) {
    updatedScore = updated;
  }
  public String getName() {
    return name;
  }

  public double getPoints() {
    return points;
  }

  public void setPoints(double points){
    this.points += points;
  }

  public int getWhiteCounter(){
    return whiteCounter;
  }

  public void addWhite() {
    whiteCounter++;
  }

  public void addPoints(double point) {
    points += point;
  }

  public ArrayList<Player> getOpponents(){
    return opponents;
  }

  public boolean getBye(){
    return hasBye;
  }

  public void setBye(boolean bye){
    hasBye = bye;
  }

}