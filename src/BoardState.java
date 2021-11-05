import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class BoardState {
//   int goal [][] = {{0,1,2},{3,4,5},{6,7,8}};
//    action_dict = {'Up': 1, 'Down': 2, 'Left': 3, 'Right': 4}

    int board[][];
   int cost=0;
   int depth;
   BoardState parent;
   double fn ;
   int action;

   BoardState(int [][] board,int cost,BoardState parent,int action ){
       this.board = board;
       this.parent= parent;
       if(parent != null)
         this.depth=parent.depth+1;
       this.cost= cost;
       this.action = action;
   }
   public ArrayList<Integer> PossibleActions(){
      ArrayList<Integer> actions = new ArrayList<>();
      int indexX=0,indexY=0;
       for(int i=0;i<3;i++){
           for(int j=0;j<3;j++){
               if(board[i][j] == 0 ){
                   indexX= i;
                   indexY=j;
                   break;
               }
           }
       }
       if(indexX > 0)
           actions.add(1);
       if(indexX < 2)
           actions.add(2);
       if (indexY > 0)
           actions.add(3);
       if (indexY < 2)
           actions.add(4);
       return  actions;
   }
   public boolean isGoal(){
       int index = 0;
       for (int i=0;i<3;i++){
           for(int j=0;j<3;j++){
               if(board[i][j] != index)
                   return false;
               index++;
           }
       }
       return true;
   }

   public int[][] getNewBoard(int action ){
       int indexX=0,indexY=0;

       int newBoard[][] = new int[3][3];
       for(int i=0;i<3;i++){
           for(int j=0;j<3;j++){
               if(this.board[i][j] == 0 ){
                   indexX= i;
                   indexY=j;
               }
               newBoard[i][j]=board[i][j];
           }
       }
       if(action == 1){
           newBoard[indexX][indexY] = newBoard[indexX-1][indexY];
           newBoard[indexX-1][indexY]=0;
       }else if(action ==2){
           newBoard[indexX][indexY] = newBoard[indexX+1][indexY];
           newBoard[indexX+1][indexY]=0;
       }else if(action == 3){
           newBoard[indexX][indexY] = newBoard[indexX][indexY-1];
           newBoard[indexX][indexY-1]=0;
       }else{
           newBoard[indexX][indexY] = newBoard[indexX][indexY+1];
           newBoard[indexX][indexY+1]=0;
       }
       return newBoard;
   }

   public  ArrayList<BoardState> getNeighbours(){
       ArrayList<BoardState> states = new ArrayList<>();
       ArrayList<Integer> actions = PossibleActions();
       for(int act : actions ){
           BoardState state = new BoardState(getNewBoard(act),cost+1,this,act);
           states.add(state);
       }
       return  states;
   }

   public void printBoard(){
       for(int i=0;i<3;i++){
           for (int j=0;j<3;j++){
               System.out.print(board[i][j]);
           }System.out.println();
       }
       System.out.println("action "+this.action);
       System.out.println("Cost "+this.cost);
       System.out.println("F(n) "+ this.fn);
       if(parent != null)
         System.out.println("parent: "+ parent.toString());
       System.out.println("-----------------");
   }

    public String printPathBoard(){
       String boardStr = "------------\n";
        for(int i=0;i<3;i++){
            boardStr+="|";
            for (int j=0;j<3;j++){
                boardStr+= board[i][j]+" | ";
            }boardStr+="\n";
        }
        boardStr+="------------\n";
        return boardStr;
    }

   public void getManhattan(){
     int man=0;
     for(int i=0;i<3;i++){
         for(int j=0;j<3;j++){
             int corrX = board[i][j]/3,corrY=board[i][j]%3;
             man+=Math.abs(corrX-i)+Math.abs(corrY-j);
         }
     }
     this.fn = man + this.cost;
   }

    public void getEuclidean(){
        double euc=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                int corrX = board[i][j]/3,corrY=board[i][j]%3;
                euc+= Math.sqrt((corrX-i)*(corrX-i) + (corrY-j)*(corrY-j));
            }
        }
        this.fn = euc + this.cost;
    }

    @Override
    public String toString() {
       String tostring = "";
        for(int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                tostring+=board[i][j];
            }
        }
        return tostring;
    }
}
class BoardComparator implements Comparator<BoardState>{

    @Override
    public int compare(BoardState o1, BoardState o2) {
        if(o1.fn < o2.fn)
            return -1;
        else if(o1.fn > o2.fn)
            return 1;
        else if(o1.fn == o2.fn && o1.action < o2.action)
            return -1;
        else if(o1.fn == o2.fn && o1.action > o2.action)
            return 1;
        return 0;
    }
}