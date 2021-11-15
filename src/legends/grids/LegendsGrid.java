package legends.grids;

import legends.characters.heroes.Hero;
import legends.grids.cells.Cell;
import legends.grids.cells.CommonSpace;
import legends.grids.cells.Inaccessible;
import legends.grids.cells.InaccessibleCell;
import legends.grids.cells.NexusCell;
import legends.players.LegendsPlayer;

import java.util.ArrayList;
import java.util.Random;

public class LegendsGrid extends Grid {
    private Cell[][] grid;
    private ArrayList<Cell> cells;
    public LegendsGrid(){
        super(8,8);
        grid = new Cell[8][8];
        cells = new ArrayList<Cell>();
    }


    // TODO - !!Need to add algorithm to make sure the player is not born in a dead end!!
    public void initCells(){
        for (int i=0; i<getNumRows()*getNumCols(); i++){
            if(i<(int)getNumRows()*getNumCols()*0.2){
                cells.add(new InaccessibleCell(-1,-1));
            }else if((int)getNumRows()*getNumCols()*0.2<=i && i<(int)getNumRows()*getNumCols()*0.5){
                cells.add(new NexusCell(-1,-1));
            }else{
                cells.add(new CommonSpace(-1,-1));
            }
        }
    }


    public Cell getRandCell(int row, int col){
        Random r = new Random();
        int n = r.nextInt(getNumCols()*getNumRows());
        Cell c = null;
        c = cells.get(n);
        c.setRow(row);
        c.setCol(col);
        return c;
    }

    public void initGrid(){
        initCells();
        for(int i=0; i<getNumRows(); i++){
            for(int j=0; j<getNumCols(); j++){
                grid[i][j] = getRandCell(i,j);
            }
        }

    }

//    public void printGrid(Hero h){
//        for(int i=0; i<getNumRows(); i++){
//            for(int j=0; j<getNumCols(); j++){
//                if(j<getNumCols()-1){
////                    if(i%2==0){
////                        System.out.printf("__");
////                    }else {
//                        if(p.getPRow() == i && p.getPCol() == j){
//                            System.out.printf("| P ");
//                        } else{
//                            System.out.printf("| " + grid[i][j].getIcon()+" ");
//                    if(h.getRow() == i && h.getCol() == j){
////                            System.out.printf("| P ");
////                            String context = String.format("%-2s\uFE31", symbol);
//                        System.out.print("| " + 'P' + " ");
//                    } else{
//                        System.out.printf("| " + grid[i][j].getIcon()+" ");
////                        }
//                    }
//                }else{
////                    if(i%2==0){
////                        System.out.printf("___\n");
////                    }else{
//                        if(h.getRow() == i && h.getCol() == j){
//                            System.out.printf("| P |\n");
//                        } else{
//                            System.out.printf("| " + grid[i][j].getIcon()+" |\n");
//                        }
//                    }
//                }
//            }
////       }
//    }


    /**
     * land on a cell and prompt the corresponding scenarios. When finished, let player make another move
     * @param row
     * @param col
     * @param p
     * @param cell
     */
    public void land(int row, int col, Hero h, Cell cell, String move){
//        printGrid(p);
        String icon = grid[row][col].getIcon();
        switch(icon){
            case "I":
                InaccessibleCell i = (InaccessibleCell) grid[row][col];
                i.land(move, h);
                h.makeMove(this);
                break;

            case "N":
                NexusCell n = (NexusCell) grid[row][col];
                n.land(h);
                h.makeMove(this);
                break;

            case " ":
//                CommonSpace c = (CommonSpace) cell;
//                c.land(p);
//                p.makeMove(this);
                CommonSpace c = (CommonSpace)grid[row][col];
                c.land(p);
                p.makeMove(this);
                break;

        }
    }

}
