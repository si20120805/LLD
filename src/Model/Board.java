package Model;

import java.util.ArrayList;
import java.util.List;

public class Board {

    public int size;
    // Board has pieces
    public PlayingPiece[][] board;

    public Board(int size){
        this.size = size;
//        has a realeationship and composition means without this not work
        this.board =  new PlayingPiece[size][size];
    }
//     player move add the piece
    public  boolean addPiece(int row, int column, PlayingPiece playingPiece){
        if(board[row][column] != null){
            return  false;
        }
        board[row][column] = playingPiece;
        return  true;
    }

    public List<GameCell> getFreeCells(){
        List<GameCell> freeCells = new ArrayList<>();
        for(int i=0; i< size; i++){
            for(int j =0; j< size; j++){
                if(board[i][j] == null){
                    freeCells.add(new GameCell(i, j));
                }
            }
        }

        return freeCells;
    }

   public  void PrintBoard(){
        for(int i =0; i<size; i++){
            for(int j=0; j<size; j++){

                if(board[i][j] !=null){
                    System.out.print(board[i][j].pieceType + " ");
                }
                else
                {
                    System.out.print("   ");
                }

                System.out.print(" | ");
            }
            System.out.println();
        }
    }



}
