import Model.GameStatus;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       System.out.println("\n======>> TicTacToe game");
       TictacToeGame game =  new TictacToeGame();
       game.initializeGame();
        GameStatus status = game.startGame();
         switch (status){
             case WIN: System.out.println(game.winner.name + " won the game");
             break;

             case DRAW: System.out.println("Its draw");
             break;
             default:
                 System.out.print("Game Ends");
                 break;

         }

    }
}