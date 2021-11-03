import java.util.ArrayList;

public class SolveMethods {
    BoardState boardState;
    ArrayList<Integer> pathToGoal;
    int goalCost;
    int nodesExpanded;
    int searchDepth;
    double runtime;

    SolveMethods(BoardState boardState){
       pathToGoal = new ArrayList<>();
       this.boardState = boardState;
    }
   public  void sucess(BoardState state){
        while (state.parent != null){
            pathToGoal.add(0,state.action);
            state = state.parent;
        }
        printPath();
        System.out.println("nodes expanded= "+ nodesExpanded);
   }
  public void printPath(){
        System.out.println("Path to goal");
        for(int x : pathToGoal)
            System.out.print(x + " ");
  }
}
