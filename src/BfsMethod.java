import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BfsMethod extends  SolveMethods{


    BfsMethod(BoardState boardState) {
        super(boardState);
        solve(boardState);
    }

    private void solve(BoardState boardState) {
        Queue<BoardState> queue= new LinkedList<>();
        queue.add(boardState);
        HashSet<String> set = new HashSet<>();
        set.add(boardState.toString());
        int con =0 ;

        while (queue.isEmpty() == false ){
            BoardState currState = queue.peek();
            currState.printBoard();
            queue.remove();
            con++;
            if(currState.isGoal()){
                System.out.println("ssssssssss");
                super.nodesExpanded = con;
                super.sucess(currState);
                break;
            }
            ArrayList<BoardState> neighbours = currState.getNeighbours();
            for(BoardState state : neighbours){
                if(set.contains(state.toString()) == false){
                    queue.add(state);
                    set.add(state.toString());
                }
            }
        }
    }

}
