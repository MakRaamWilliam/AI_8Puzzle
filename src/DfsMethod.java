import java.util.*;

public class DfsMethod extends  SolveMethods{


    DfsMethod(BoardState boardState) {
        super(boardState);
        solve(boardState);
    }

    private void solve(BoardState boardState) {
        Stack<BoardState> stack= new Stack<>();
        stack.push(boardState);
        HashSet<String> set = new HashSet<>();
        set.add(boardState.toString());
        int con =0 ;

        while (stack.isEmpty() == false ){
            BoardState currState = stack.peek();
            currState.printBoard();
            stack.pop();
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
                    stack.push(state);
                    set.add(state.toString());
                }
            }
        }
    }

}
