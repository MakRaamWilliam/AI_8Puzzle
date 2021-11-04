
public class main {
    public static void main(String[] args) {
        //{{0,1,2},{3,4,5},{6,7,8}} goal
        //{{8,1,2},{0,4,3},{7,6,5}} not solvable
        //{{1,2,5},{3,4,0},{6,7,8}} example
     int board [][] = {{8,1,2},{0,4,3},{7,6,5}};
     int board2 [][] = {{1,2,5},{3,4,0},{6,7,8}};
        BoardState state = new BoardState(board,0,null,0);

//          SolveMethods bfs = new BfsMethod(state);
//            SolveMethods dfs = new DfsMethod(state);
//          SolveMethods aman = new AManhattan(state);
          SolveMethods aeuc = new AEuclidean(state);

    }
}
