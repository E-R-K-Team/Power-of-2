import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int sideLength;
    private ArrayList<Tile> board;
    private boolean wasMoved = false;

    private static class Tile{
        private final int y;
        private final int x;
        public int value = 0;

        public Tile(int y ,int x){
            this.y = y;
            this.x = x;
        }

        public int getY(){
            return y;
        }

        public int getX(){
            return x;
        }

    }

    public Board(int sideLength){
        this.sideLength=sideLength;
        initializeBoard(sideLength);
    }

    private void initializeBoard(int sideLength){
        board = new ArrayList<>();
        for(int y = 0 ; y<sideLength; y++){
            for(int x = 0 ; x<sideLength ; x++) {
                board.add(new Tile(y,x));
            }
        }
    }

    public void spawnTile(){
        ArrayList<Tile> emptyTiles = findEmptyTiles();
        int index = (int)(Math.random() * ((emptyTiles.size() )));
        emptyTiles.get(index).value= 2;
    }

    @Override
    public  String toString(){
        String result = "";
        for(int y = 0 ;y<sideLength; y++){
            for(int x = 0 ; x<sideLength;x++){
                result+=board.get(coordinatesToIndex(y,x)).value+" ";
            }
            result+="\n";
        }
        return result;
    }

    private int coordinatesToIndex(int y , int x){
        return y*sideLength + x;
    }

    private ArrayList<Tile> findEmptyTiles(){
        List<Tile> tilesList = board.stream().filter(tile->tile.value==0).toList();
        return new ArrayList<>(tilesList);
    }

    public boolean isGameOver(){
        return board.stream().noneMatch(tile->tile.value==0);
    }

    public void slideUp(){
        wasMoved=false;
        for(int y = 1 ;y<sideLength; y++){
            for(int x = 0 ; x<sideLength;x++){
                if(trySlide(getTileByCoordinates(y,x),-1,0)){
                    wasMoved=true;
                }
            }
        }
    }

    public void slideDown(){
        wasMoved=false;
        for(int y = sideLength-2;y>=0; y--){
            for(int x = 0 ; x<sideLength;x++){
                if(trySlide(getTileByCoordinates(y,x),1,0)){
                    wasMoved=true;
                }
            }
        }
    }

    public void slideRight(){
        wasMoved=false;
        for(int y = 0 ;y<sideLength; y++){
            for(int x = sideLength-2 ; x>=0;x--){
                if(trySlide(getTileByCoordinates(y,x),0,1)){
                    wasMoved=true;
                }
            }
        }
    }

    public void slideLeft(){
        wasMoved=false;
        for(int y = 0 ;y<sideLength; y++){
            for(int x = 1 ; x<sideLength;x++){
                if(trySlide(getTileByCoordinates(y,x),0,-1)){
                    wasMoved=true;
                }
            }
        }
    }


    private boolean trySlide(Tile tile, int yDirection, int xDirection){
        if(tile.value!= 0){
            int neighbourY = tile.getY() + yDirection;
            int neighbourX = tile.getX() + xDirection;
            if(isCoordinatesInBound(neighbourY,neighbourX)) {
                Tile neighbour = getTileByCoordinates(neighbourY, neighbourX);
                if (neighbour.value == tile.value) {
                    neighbour.value *= 2;
                    tile.value = 0;
                    return true;
                }
                if (neighbour.value == 0) {
                    neighbour.value = tile.value;
                    tile.value = 0;
                    trySlide(neighbour, yDirection, xDirection);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isCoordinatesInBound(int y,int x){
        return y>=0 && y<sideLength && x>=0 && x<sideLength;
    }

    private Tile getTileByCoordinates(int y ,int x){
        return board.get(coordinatesToIndex(y,x));
    }

    public boolean wasMoved(){
        return wasMoved;
    }

}