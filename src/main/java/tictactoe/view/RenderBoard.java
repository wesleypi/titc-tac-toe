package tictactoe.view;

import tictactoe.model.Board;

public class RenderBoard {
    private final Board board;

    public RenderBoard(Board board){
        this.board = board;
    }

    public void render() {
        System.out.println("  1   2   3");
        for (int i = 0; i < board.size(); i++) {
            System.out.print(i+1);
            for (int j = 0; j < board.size(); j++) {
                renderElement(board.getElement(i,j));
                if (j < board.size() -1)
                    renderColumn();
            }
            if (i < board.size() -1)
                renderLine();
        }
        System.out.println();
    }

    private void renderElement(char element) {
        if (!board.isEmptyElement(element)){
            System.out.print((" "+ element +" "));
            return;
        }
        System.out.print("   ");


    }
    private static void renderLine(){
        System.out.print("\n -----------\n");
    }
    private static void renderColumn(){
        System.out.print("|");
    }
}
