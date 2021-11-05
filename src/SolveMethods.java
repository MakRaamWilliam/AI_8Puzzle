import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class SolveMethods {
    private BoardState boardState;
    private ArrayList<String> pathToGoal;
    private ArrayList<BoardState> boardsPath;
    private FileWriter outtxt = null;

    String [] dir = {"","Up","Down","Left","Right"};
    int goalCost;
    int nodesExpanded;
    int searchDepth;
    Long runtime;

    SolveMethods(BoardState boardState){
       pathToGoal = new ArrayList<>();
       this.boardState = boardState;
        try {
            outtxt = new FileWriter("output.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   public  void sucess(BoardState state){
       this.goalCost = state.cost;
        this.searchDepth = state.depth;
        boardsPath = new ArrayList<>();
        while (state.parent != null){
            pathToGoal.add(0,dir[state.action]);
            boardsPath.add(0,state);
            state = state.parent;
        }
        boardsPath.add(0,state);
        printPath();
       System.out.println("Cost= " + this.goalCost);
       System.out.println("nodes expanded= "+ nodesExpanded);
       System.out.println("Depth search= "+ this.searchDepth);
       System.out.println("Run Time= "+ this.runtime+" ms");
       System.out.println("--------------------");
       System.out.println("--------------------");

       try {
           outtxt.write("Cost= " + this.goalCost+"\n");
           outtxt.write("nodes expanded= "+ nodesExpanded+"\n");
           outtxt.write("Depth search= "+ this.searchDepth+"\n");
           outtxt.write("Run Time= "+ this.runtime+" ms\n");
           outtxt.write("--------------------\n");
           outtxt.write("--------------------\n");
           outtxt.close();
       } catch (IOException e) {
           e.printStackTrace();
       }


   }

   public void  failure (){
       System.out.println("it's not solvable ");
       try {
           outtxt.write(boardState.printPathBoard());
           outtxt.write("it's not solvable\n");
           outtxt.write("--------------------\n");
           outtxt.write("--------------------\n");
           outtxt.close();

       } catch (IOException e) {
           e.printStackTrace();
       }

   }
  public void printPath(){
        System.out.print("Path to goal: ");
        for(String x : pathToGoal) {
            System.out.print(x + " ");
            try {
                outtxt.write(x+" ");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
      try {
          outtxt.write("\n");
      } catch (IOException e) {
          e.printStackTrace();
      }
      for(BoardState board : boardsPath){
          try {
              outtxt.write(board.printPathBoard());
              outtxt.write("\n");
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
  }
}
