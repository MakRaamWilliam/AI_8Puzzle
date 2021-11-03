import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        //{{0,1,2},{3,4,5},{6,7,8}} goal
        //{{8,1,2},{0,4,3},{7,6,5}} not solvable
        //{{1,2,5},{3,4,0},{6,7,8}} example
     int board [][] = {{1,2,5},{3,4,0},{6,7,8}};
     BoardState state = new BoardState(board,0,null,0);

//     ArrayList<Integer> poss = state.PossibleActions();
//     for(int x : poss){
//         System.out.println(x);
//     }
//     ArrayList<BoardState> states = state.getNeighbours();
//     for(BoardState boardState: states){
//         boardState.printBoard();
//     }
       SolveMethods method = new BfsMethod(state);

    }
}
