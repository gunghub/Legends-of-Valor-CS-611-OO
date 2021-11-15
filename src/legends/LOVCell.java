package legends;

public class LOVCell {
    protected String border;
    protected boolean hashero;
    protected boolean hasmarket;
    protected boolean enterable;

    public LOVCell() {

    }
    public String getBorder() {
        return border;
    }

    public void setBorder(String border) {
        this.border = border;
    }

    private static String getOuterCellStr(char c){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            str.append(c).append(" - ");
        }
        str.append(c).append("   ");
        return str.toString();
    }

    protected boolean hasHero(){
        return hashero;
    }

    protected void heroEnter(){
        hashero = true;
    }

    protected void heroLeft(){
        hashero = false;
    }

}
