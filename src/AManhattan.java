import java.util.*;

public class AManhattan extends  SolveMethods {

    Long time;
    AManhattan(BoardState boardState) {
        super(boardState);
        this.time = System.currentTimeMillis();
        solve(boardState);
    }

    private void solve(BoardState boardState) {
        PriorityQueue<BoardState> priorityQueue= new PriorityQueue<>(new BoardComparator());
        boardState.getManhattan();
        priorityQueue.add(boardState);
        HashSet<String> set = new HashSet<>();
        int con =0 ;

        while (priorityQueue.isEmpty() == false ){
            BoardState currState = priorityQueue.poll();
            set.add(currState.toString());
            currState.printBoard();
            con++;
            if(currState.isGoal()){
                System.out.println("ssssssssss");
                super.nodesExpanded = con-1;
                super.runtime = System.currentTimeMillis() - time;
                super.sucess(currState);
                break;
            }
            ArrayList<BoardState> neighbours = currState.getNeighbours();
            for(BoardState state : neighbours){
                if(set.contains(state.toString()) == false){
                    state.getManhattan();
                    priorityQueue.add(state);
                    set.add(state.toString());
                }
            }
        }
    }

}
