import java.util.*;

public class AManhattan extends  SolveMethods {

    Long time;
    boolean flag = false;
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

        while (priorityQueue.isEmpty() == false && con < 10000000 ){
            BoardState currState = priorityQueue.poll();
            set.add(currState.toString());
            currState.printBoard();
            con++;
            if(currState.isGoal()){
                flag = true;
                super.nodesExpanded = con-1;
                super.runtime = System.currentTimeMillis() - time;
                super.sucess(currState);
                break;
            }
            ArrayList<BoardState> neighbours = currState.getNeighbours();
            for(BoardState state : neighbours){
                if(!set.contains(state.toString())){
                    state.getManhattan();
                    priorityQueue.add(state);
                    set.add(state.toString());
                }
            }
        } if(!flag)
            super.failure();
    }

}
