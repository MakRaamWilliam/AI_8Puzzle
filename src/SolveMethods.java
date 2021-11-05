import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class SolveMethods {
    private BoardState boardState;
    private ArrayList<String> pathToGoal;
    private PrintWriter outtxt = null;

    String [] dir = {"","Up","Down","Left","Right"};
    int goalCost;
    int nodesExpanded;
    int searchDepth;
    Long runtime;

    SolveMethods(BoardState boardState){
       pathToGoal = new ArrayList<>();
       this.boardState = boardState;
        try {
            outtxt = new PrintWriter(new FileWriter("output.txt", true), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
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

       outtxt.flush();
       outtxt.write("Cost= " + this.goalCost+"\n");
       outtxt.write("nodes expanded= "+ nodesExpanded+"\n");
       outtxt.write("Depth search= "+ this.searchDepth+"\n");
       outtxt.write("Run Time= "+ this.runtime+" ms\n");
       outtxt.write("--------------------\n");
       outtxt.write("--------------------\n");

       outtxt.close();


   }

   public void  failure (){
       System.out.println("it's not solvable ");
       outtxt.write("it's not solvable ");
       outtxt.write("--------------------\n");
       outtxt.write("--------------------\n");
       outtxt.close();

   }
  public void printPath(){
        System.out.print("Path to goal: ");
        for(String x : pathToGoal) {
            System.out.print(x + " ");
            outtxt.write(x+" ");
        }
        System.out.println();
        outtxt.write("\n");
  }
}
