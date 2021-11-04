import java.util.PriorityQueue;

public class main {
    public static void main(String[] args) {
        //{{0,1,2},{3,4,5},{6,7,8}} goal
        //{{8,1,2},{0,4,3},{7,6,5}} not solvable
        //{{1,2,5},{3,4,0},{6,7,8}} example
     int board [][] = {{1,2,5},{3,4,0},{6,7,8}};
     int board2 [][] = {{1,2,5},{3,4,0},{6,7,8}};
        BoardState state = new BoardState(board,0,null,0);
//        BoardState state2 = new BoardState(board2,0,null,0);
//        PriorityQueue<BoardState> priorityQueue= new PriorityQueue<>(new BoardComparator());
//        state.getManhattan();
//        priorityQueue.add(state);
//        state2.getManhattan();
//        priorityQueue.add(state2);
//        while (!priorityQueue.isEmpty()){
//            System.out.println(priorityQueue.poll().action);
//        }


//       SolveMethods bfs = new BfsMethod(state);
//        SolveMethods dfs = new DfsMethod(state);
        SolveMethods aman = new AManhattan(state);

    }
}
