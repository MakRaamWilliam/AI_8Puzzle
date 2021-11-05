import java.util.*;

public class DfsMethod extends  SolveMethods{

    Long time;
    boolean flag = false;

    public DfsMethod(BoardState boardState) {
        super(boardState);
        time = System.currentTimeMillis();
        solve(boardState);
    }

    private void solve(BoardState boardState) {
        Stack<BoardState> stack= new Stack<>();
        stack.push(boardState);
        HashSet<String> set = new HashSet<>();
        set.add(boardState.toString());
        int con =0 ;

        while (!stack.isEmpty()){
            BoardState currState = stack.peek();
            currState.printBoard();
            stack.pop();
            con++;
            if(currState.isGoal()){
                flag = true;
                super.nodesExpanded = con - 1;
                super.runtime = System.currentTimeMillis() - time;
                super.sucess(currState);
                break;
            }
            ArrayList<BoardState> neighbours = currState.getNeighbours();
            Collections.reverse(neighbours);
            for(BoardState state : neighbours){
                if(!set.contains(state.toString())){
                    stack.push(state);
                    set.add(state.toString());
                }
            }
        }
        if(!flag)
            super.failure();
    }

}
