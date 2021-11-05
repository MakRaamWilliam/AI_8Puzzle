import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

public class AEuclidean extends SolveMethods {
    private boolean flag =false;
    private Long time;

    public AEuclidean(BoardState boardState) {
        super(boardState);
        this.time = System.currentTimeMillis();
        solve(boardState);
    }

    private void solve(BoardState boardState) {
        PriorityQueue<BoardState> priorityQueue= new PriorityQueue<>(new BoardComparator());
        boardState.getEuclidean();
        priorityQueue.add(boardState);
        HashSet<String> set = new HashSet<>();
        int con =0 ;

        while (!priorityQueue.isEmpty() && con < 1000000 ){
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
                    state.getEuclidean();
                    priorityQueue.add(state);
                }
            }
        } if(!flag)
            super.failure();
    }

}
