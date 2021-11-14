package legends;

public class InaccessbileCell extends LOVCell {
    public InaccessbileCell(){
        super();
        border = "I";
        enterable = false;
    }

    public String getBorder(){
        return border;
    }

}
