import Model.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TictacToeGame {
    Deque<Players> players;
    Board gameBoard;
    Players winner;

    public void initializeGame(){
       players = new LinkedList<>();
        PieceX corssPiece = new PieceX();
        Players players1 = new Players("Player1", corssPiece);
        PieceO noughtsPiece = new PieceO();
        Players players2 = new Players("Player2", noughtsPiece);

             players.add(players1);
             players.add(players2);

             //Initilailize Game Board
                gameBoard = new Board(3);
    }

    public  GameStatus startGame(){

        boolean noWinner = true;
        while(noWinner){
            Players currentPlayer = players.removeFirst();
            gameBoard.PrintBoard();
            List<GameCell> freeCells = gameBoard.getFreeCells();
            if(freeCells.isEmpty()){
                noWinner = false;
                continue;
            }
            System.out.println("Player: " + currentPlayer.getName() + " Please enter row, columns");
            Scanner inputScanner = new Scanner(System.in);
            // reads the entire line
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);
           boolean validMove = gameBoard.addPiece(inputRow,inputColumn,currentPlayer.getPlayingPiece());

           if(!validMove){
               System.out.println("Incorrect position chosen, try again");
               players.addFirst(currentPlayer);
               continue;
           }
           players.addLast(currentPlayer);

           boolean isWinner = checkWinner(inputRow,inputColumn, currentPlayer.playingPiece.pieceType);
           if(isWinner){
               gameBoard.PrintBoard();
               winner = currentPlayer;
               return GameStatus.WIN;
           }
        }
        return GameStatus.DRAW;
    }

    public boolean checkWinner(int row, int column, PieceType pieceType){
        boolean rowMatch = true;
        boolean coloumnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;
  //for the row
        for(int i =0; i< gameBoard.size; i++){
            if(gameBoard.board[row][i] == null || gameBoard.board[row][i].pieceType != pieceType){
                rowMatch = false;
                break;
            }
        }
        // for the columns
        for(int j=0; j< gameBoard.size; j++){
            if(gameBoard.board[j][column] == null || gameBoard.board[j][column].pieceType != pieceType){
                coloumnMatch = false;
                break;
            }
        }

        // for the the diagnoal
        for(int i=0; i< gameBoard.size; i++ ){
//            for(int j=0; j<gameBoard.size; j++){
                if(gameBoard.board[i][i] == null || gameBoard.board[i][i].pieceType != pieceType ){
                    diagonalMatch = false;
                    break;
                }
//            }
        }
//           for ani_diagnoal
        for(int i=0; i < gameBoard.size; i++ ){
            for(int j = gameBoard.size - 1 - i; j >=0; j--){
                if(gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType ){
                    antiDiagonalMatch = false;
                    break;
                }
            }
        }

        return rowMatch || coloumnMatch || diagonalMatch || antiDiagonalMatch;
    }

}
