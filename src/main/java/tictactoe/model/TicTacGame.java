package tictactoe.model;

import tictactoe.view.RenderBoard;

import java.util.Scanner;

public class TicTacGame {
    private char player;
    private boolean hasEndedTurn;
    private int rowChosen;
    private int columnChosen;
    private final Board board;
    private final RenderBoard renderBoard;
    private final Scanner scanner = new Scanner(System.in);

    public TicTacGame (){
        player = 'X';
        hasEndedTurn = false;
        board = new Board(3);
        renderBoard = new RenderBoard(board);
    }

    public void turn() {
        while (board.isInvalidPosition(rowChosen, columnChosen) || !hasEndedTurn) {
            renderBoard.render();

            rowChosen = renderPositionMessage("linha");
            columnChosen = renderPositionMessage("coluna");

            hasEndedTurn = true;

            if (board.isInvalidPosition(rowChosen, columnChosen))
                System.out.println("Oops, movimento inválido! Por favor, repita novamente.\n");
        }
    }

    private boolean checkWinner() {
        return checkColumn() || checkRow() || checkDiagonal();
    }

    private boolean checkDiagonal() {
        if (!board.isEmptyElement(1,1) && board.getElement(0,0) == board.getElement(1,1) && board.getElement(0,0) == board.getElement(2,2))
            return true;
        return !board.isEmptyElement(1,1) && board.getElement(0, 2) == board.getElement(1, 1) && board.getElement(1, 1) == board.getElement(2, 0);
    }

    private boolean checkColumn() {
        for (int i = 0; i < board.size(); i++) {
            if (!board.isEmptyElement(i,0) && board.getElement(i, 0) == board.getElement(i, 1) && board.getElement(i, 0) == board.getElement(i, 2))
                return true;
        }
        return false;
    }

    private boolean checkRow() {
        for (int i = 0; i < board.size(); i++) {
            if (!board.isEmptyElement(0,i) && board.getElement( 0, i) == board.getElement( 1,i) && board.getElement( 0,i) == board.getElement( 2, i)){
                return true;
            }
        }
        return false;
    }

    private int renderPositionMessage(String message){
        System.out.println("\nJogador " + player + " escolha a "+message+" que você deseja jogar");
        return scanner.nextInt();
    }

    private void renderWinner(char winner){
        System.out.println("\nPlayer "+winner+" Win!");
    }

    public void run() {

        while (!board.isFull()) {
            beginTurn();
            turn();

            board.setElement(rowChosen, columnChosen, player);

            if(checkWinner()){
                renderWinner(board.getElement(rowChosen, columnChosen));
                break;
            }
            changePlayer();
        }
        if (board.isFull())
            System.out.println("\nDraw");
    }

    private void beginTurn() {
        hasEndedTurn = false;
    }

    private void changePlayer() {
        if (player == 'X')
            player = 'O';
        else player = 'X';
    }
}