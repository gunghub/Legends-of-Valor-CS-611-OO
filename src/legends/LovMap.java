package legends;

import legends.characters.heroes.Hero;
import legends.games.LegendsOfValor;
import legends.grids.Grid;
import legends.grids.cells.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Legends of Valor Map
 * It consists of 8 x 8 cells;
 */
public class LovMap extends Grid {
    private static final int LOV_MAP_SIZE_OF_CELLS = 8;

    private LegendsOfValor legendsOfValor;
    private CellType [][]cellTypes = {
            {CellType.NEXUS, CellType.NEXUS, CellType.INACCESSIBLE, CellType.NEXUS, CellType.NEXUS, CellType.INACCESSIBLE, CellType.NEXUS, CellType.NEXUS},
            {generateCellTypeAtRandom(), generateCellTypeAtRandom(), CellType.INACCESSIBLE, generateCellTypeAtRandom(), generateCellTypeAtRandom(), CellType.INACCESSIBLE, generateCellTypeAtRandom(), generateCellTypeAtRandom()},
            {generateCellTypeAtRandom(), generateCellTypeAtRandom(), CellType.INACCESSIBLE, generateCellTypeAtRandom(), generateCellTypeAtRandom(), CellType.INACCESSIBLE, generateCellTypeAtRandom(), generateCellTypeAtRandom()},
            {generateCellTypeAtRandom(), generateCellTypeAtRandom(), CellType.INACCESSIBLE, generateCellTypeAtRandom(), generateCellTypeAtRandom(), CellType.INACCESSIBLE, generateCellTypeAtRandom(), generateCellTypeAtRandom()},
            {generateCellTypeAtRandom(), generateCellTypeAtRandom(), CellType.INACCESSIBLE, generateCellTypeAtRandom(), generateCellTypeAtRandom(), CellType.INACCESSIBLE, generateCellTypeAtRandom(), generateCellTypeAtRandom()},
            {generateCellTypeAtRandom(), generateCellTypeAtRandom(), CellType.INACCESSIBLE, generateCellTypeAtRandom(), generateCellTypeAtRandom(), CellType.INACCESSIBLE, generateCellTypeAtRandom(), generateCellTypeAtRandom()},
            {generateCellTypeAtRandom(), generateCellTypeAtRandom(), CellType.INACCESSIBLE, generateCellTypeAtRandom(), generateCellTypeAtRandom(), CellType.INACCESSIBLE, generateCellTypeAtRandom(), generateCellTypeAtRandom()},
            {CellType.NEXUS, CellType.NEXUS, CellType.INACCESSIBLE, CellType.NEXUS, CellType.NEXUS, CellType.INACCESSIBLE, CellType.NEXUS, CellType.NEXUS},
    };

    public LovMap(LegendsOfValor legendsOfValor) {
        super(LOV_MAP_SIZE_OF_CELLS, LOV_MAP_SIZE_OF_CELLS);
        this.legendsOfValor=legendsOfValor;
        display();
    }

    /**
     * generate a CellType at random
     * @return a CellType
     */
    private CellType generateCellTypeAtRandom(){
        final double CAVE_PROPORTION=0.2;
        final double BUSH_PROPORTION=0.2;
        final double KOULOU_PROPORTION=0.2;


        double randomValue = Math.random();
        if (randomValue <= CAVE_PROPORTION){
            return CellType.CAVE;
        }
        else if (randomValue <= CAVE_PROPORTION+BUSH_PROPORTION){
            return CellType.BUSH;
        }
        else if (randomValue <= CAVE_PROPORTION+BUSH_PROPORTION+KOULOU_PROPORTION){
            return CellType.KOULOU;
        }
        else{
            return CellType.PLAIN;
        }
    }


    private static String getOuterCellStr(String cellIcon){


        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            str.append(cellIcon).append(" - ");
        }
        str.append(cellIcon).append("   ");
        return str.toString();
    }

    private void createOuterCell(CellType[][] map, List<StringBuilder> printableMap, int row, int col) {
        int cellRow = row/3;
        switch (map[cellRow][col]){
            case NEXUS:
                grid[cellRow][col] = new NexusCell(cellRow, col);
                printableMap.get(row).append(getOuterCellStr(grid[cellRow][col].getIcon()));
                break;
            case PLAIN:
                grid[cellRow][col] = new PlainCell(cellRow, col);
                printableMap.get(row).append(getOuterCellStr(grid[cellRow][col].getIcon()));
                break;
            case KOULOU:
                grid[cellRow][col] = new KoulouCell(cellRow, col);
                printableMap.get(row).append(getOuterCellStr(grid[cellRow][col].getIcon()));
                break;
            case CAVE:
                grid[cellRow][col] = new CaveCell(cellRow, col);
                printableMap.get(row).append(getOuterCellStr(grid[cellRow][col].getIcon()));
                break;
            case BUSH:
                grid[cellRow][col] = new BushCell(cellRow, col);
                printableMap.get(row).append(getOuterCellStr(grid[cellRow][col].getIcon()));
                break;
            case INACCESSIBLE:
                grid[cellRow][col] = new InaccessibleCell(cellRow, col);
                printableMap.get(row).append(getOuterCellStr(grid[cellRow][col].getIcon()));
                break;
        }
    }



    private static String getInnerCellStr(String component){
        return "| " + component + " |   ";
    }

    /**
     *
     * @param row row of cells
     * @param col
     * @return
     */
    private String getCellComponent(int row, int col){
        final String HERO_ICON="H";
        final String MONSTER_ICON="M";

        StringBuilder result=new StringBuilder();
        boolean hasHero=false;
        for (int i = 0; i < legendsOfValor.getHeroes().size(); i++){
            if (row == legendsOfValor.getHeroes().get(i).getRow() && col == legendsOfValor.getHeroes().get(i).getCol()){
                 result.append(HERO_ICON).append(i + 1);
                 hasHero=true;
                 break;
            }
        }

        if(!hasHero) result.append("  ");

        boolean hasMonster=false;
        for (int j = 0; j < legendsOfValor.getMonsters().size(); j++){
            if (row == legendsOfValor.getMonsters().get(j).getRow() && col == legendsOfValor.getMonsters().get(j).getCol()){
                result.append (" "+MONSTER_ICON + (j + 1)+"");
                hasMonster=true;
                break;
            }
        }

        if(!hasMonster) result.append("   ");

        return result.toString();
    }




    private void createInnerCell(CellType[][] map, List<StringBuilder> printableMap, int row, int col) {
        String component = getCellComponent(row/3, col);
        if (map[row/3][col] == CellType.INACCESSIBLE)
            component = "X X X";
        printableMap.get(row).append(getInnerCellStr(component));
    }



    /**
     *
     * Display the map, heroes, and monsters.
     * @author Gung
     *
     */
    public void display(){

        List<StringBuilder> printable = new ArrayList<>();
        for (int row = 0; row < LOV_MAP_SIZE_OF_CELLS * 3; row++) {
            printable.add(new StringBuilder());
            if ((row / 3) % 2 == 0){
                for (int col = 0; col < LOV_MAP_SIZE_OF_CELLS; col++) {
                    if (row % 2 == 0){
                        createOuterCell(cellTypes, printable, row, col);
                    }else{
                        createInnerCell(cellTypes, printable, row, col);
                    }

                    if (col == LOV_MAP_SIZE_OF_CELLS - 1)
                        printable.get(row).append("\n");
                }
            }else{
                for (int col = 0; col < LOV_MAP_SIZE_OF_CELLS; col++) {
                    if (row % 2 == 1){
                        createOuterCell(cellTypes, printable, row, col);
                    }else{
                        createInnerCell(cellTypes, printable, row, col);
                    }

                    if (col == LOV_MAP_SIZE_OF_CELLS - 1)
                        printable.get(row).append("\n");
                }
            }

            if (row % 3 == 2)
                printable.get(row).append("\n");
        }

        for (int i = 0; i < LOV_MAP_SIZE_OF_CELLS * 3; i++) {
            System.out.print(printable.get(i));
        }
    }


    /**
     * land on a cell. Prompt the corresponding scenarios after landing on the cell
     * @param row row of the landed cell
     * @param col column of the landed cell
     * @param hero
     * @param cell The
     * @param move
     */
    public void land(int row, int col, Hero hero, Cell cell, String move){
//        printGrid(p);
        String icon = grid[row][col].getIcon();
        switch(icon){
            case "I":
                InaccessibleCell inaccessiblecell = (InaccessibleCell) grid[row][col];
                inaccessiblecell.land(move, hero);
//                hero.makeMove(this);
                break;

            case "N":
                NexusCell nexuscell = (NexusCell) grid[row][col];
                nexuscell.land(hero);
//                hero.makeMove(this);
                break;

            case "P":
                grid[row][col].setHashero(true);
//                hero.makeMove(this);
                break;

            case "B":
                grid[row][col].setHashero(true);
                BushCell bushcell = (BushCell) grid[row][col];
                bushcell.land(hero);
//                hero.makeMove(this);
                break;

            case "C":
                grid[row][col].setHashero(true);
                CaveCell cavecell = (CaveCell) grid[row][col];
                cavecell.land(hero);
//                hero.makeMove(this);
                break;

            case "K":
                grid[row][col].setHashero(true);
                KoulouCell kouloucell = (KoulouCell) grid[row][col];
                kouloucell.land(hero);
//                hero.makeMove(this);
                break;

        }
    }
}
