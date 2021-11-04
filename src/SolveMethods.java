import java.util.ArrayList;

public class SolveMethods {
    BoardState boardState;
    ArrayList<String> pathToGoal;
    String [] dir = {"","Up","Down","Left","Right"};
    int goalCost;
    int nodesExpanded;
    int searchDepth;
    Long runtime;

    SolveMethods(BoardState boardState){
       pathToGoal = new ArrayList<>();
       this.boardState = boardState;
    }
   public  void sucess(BoardState state){
        this.goalCost = state.cost;
        this.searchDepth = state.depth;
        while (state.parent != null){
            pathToGoal.add(0,dir[state.action]);
            state = state.parent;
        }
        printPath();
       System.out.println("Cost= " + this.goalCost);
       System.out.println("nodes expanded= "+ nodesExpanded);
       System.out.println("Depth search= "+ this.searchDepth);
       System.out.println("Run Time= "+ this.runtime+" ms");
       System.out.println("--------------------");
       System.out.println("--------------------");

   }

   public void  failure (){
        System.out.println("it's not solvable ");
   }
  public void printPath(){
        System.out.print("Path to goal: ");
        for(String x : pathToGoal)
            System.out.print(x + " ");
        System.out.println();
  }
}
