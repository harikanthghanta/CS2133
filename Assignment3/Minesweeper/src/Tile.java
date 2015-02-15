/**
 * Created by kyle on 2/15/15.
 */
public class Tile {
    private boolean bomb = false;
    private boolean cover = true;
    private boolean flag = false;

    public Tile(){
        bomb = false;
        cover = true;
        flag = false;
    }

    public boolean isBomb(){
        return bomb;
    }

    public void setBomb(boolean bombed){
        bomb = bombed;
    }

    public boolean isCover(){
        return cover;
    }

    public void setCover(boolean covered){
        cover = covered;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
