import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
     int board [][] = {{0,1,2},{3,4,5},{6,7,8}};
     BoardState state = new BoardState(board,0,null,0);
     ArrayList<Integer> poss = state.PossibleActions();
     for(int x : poss){
         System.out.println(x);
     }
     ArrayList<BoardState> states = state.getNeighbours();
     for(BoardState boardState: states){
         boardState.printBoard();
     }
    }
}
