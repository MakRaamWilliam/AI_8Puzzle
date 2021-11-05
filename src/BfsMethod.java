import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BfsMethod extends  SolveMethods{

    private Long time;
    private boolean flag = false;

    public BfsMethod(BoardState boardState) {
        super(boardState);
        this.time = System.currentTimeMillis();
        solve(boardState);
    }

    private void solve(BoardState boardState) {
        Queue<BoardState> queue= new LinkedList<>();
        queue.add(boardState);
        HashSet<String> set = new HashSet<>();
        set.add(boardState.toString());
        int con =0 ;

        while (!queue.isEmpty()){
            BoardState currState = queue.peek();
            currState.printBoard();
            queue.remove();
            con++;
            if(currState.isGoal()){
                flag =true;
                super.nodesExpanded = con-1;
                super.runtime = System.currentTimeMillis() - time;
                super.sucess(currState);
                break;
            }
            ArrayList<BoardState> neighbours = currState.getNeighbours();
            for(BoardState state : neighbours){
                if(!set.contains(state.toString())){
                    queue.add(state);
                    set.add(state.toString());
                }
            }
        }
        if(!flag)
           super.failure();
    }

}
