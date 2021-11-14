package legends.grids.cells;

import legends.characters.heroes.Hero;
import legends.gameplay.Markets;
import legends.utilities.Factory;

public class NexusCell extends Cell {
    public NexusCell(int row, int col){
        super("N", row, col);
        hasmarket = true;
    }

    //when a hero lands on a NexusCell
    public void land(Hero hero){
        if(getRow() == 0){
            Factory fac = new Factory();
            Markets m = fac.newMarkets();
            m.storeConsole(hero);
        }else if(getRow() == 7){
             System.out.println("Congratulations! You won!");
        }
    }

}
