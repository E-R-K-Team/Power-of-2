package power;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * Game field and operations with it
 *
 * @author Kirill
 */
public class Board implements Serializable {
    public  int sideLength;
    private List<Tile> tiles;
    /**
     * true if any tile was moved after last spawn , otherwise false
     */
    private boolean wasMoved = false;
    private int lastMergedX;
    private int lastMergedY;
    private GameState currentState;
    private PlayerPreferences preferences;
    private final SecureRandom random = new SecureRandom();
    private int score;


    public  Board(int sideLength){
        this(sideLength,new PlayerPreferences());
    }

    public Board (int sideLength,PlayerPreferences preferences){
        this.sideLength = sideLength;
        initializeBoard(sideLength);
        this.preferences = preferences;
        spawnTile();
    }


    public GameState getGameState() {
        return currentState;
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public boolean wasMoved() {
        return wasMoved;
    }

    public void setTiles(List<Tile> tiles) {
        this.tiles = tiles;
    }

    private void initializeBoard(int sideLength) {
        setTiles(new ArrayList<>());
        for (int y = 0; y < sideLength; y++) {
            for (int x = 0; x < sideLength; x++) {
                getTiles().add(new Tile(y, x));
            }
        }
    }

    public void spawnTile() {
        ArrayList<Tile> emptyTiles = findEmptyTiles();
        int index = random.nextInt(emptyTiles.size());
        emptyTiles.get(index).setValue(takeSpawnTileValue());
        wasMoved = false;
        updateGameState();
        lastMergedX = -1;
        lastMergedY = -1;
    }


    /**
     * randomly chooses 2 or 4
     *
     * @return value , that should be spawned to empty tile
     */
    private int takeSpawnTileValue() {
        return random.nextDouble() < preferences.chanceToSpawnFour ? 4 : 2;
    }

    private int coordinatesToIndex(int y, int x) {
        return y * sideLength + x;
    }

    /**
     * @return all tiles with 0 value
     */
    public ArrayList<Tile> findEmptyTiles() {
        List<Tile> tilesList = tiles.stream().filter(tile -> tile.getValue() == 0).toList();
        return new ArrayList<>(tilesList);
    }

    public int getHighestTileValue() {
        return getTiles().stream().mapToInt(Tile::getValue).max().orElse(0);
    }


    public void updateGameState() {
        if (getHighestTileValue() == preferences.maxTileValue) {
            currentState = GameState.WIN;
        } else if (getTiles().stream().noneMatch(tile -> tile.getValue() == 0) && !canSlide()) {
            currentState = GameState.LOSE;
        } else {
            currentState = GameState.IN_PROGRESS;
        }
    }

    /**
     * @see #trySlide
     * calls trySlide for all tiles that can be moved up
     */
    public void slideUp() {
        for (int x = 0; x < sideLength; x++) {
            for (int y = 1; y < sideLength; y++) {
                if (trySlide(getTileByCoordinates(y, x), -1, 0)) {
                    wasMoved = true;
                }
            }
        }
    }

    /**
     * @see #trySlide
     * calls trySlide for all tiles that can be moved down
     */
    public void slideDown() {
        for (int x = 0; x < sideLength; x++) {
            for (int y = sideLength - 2; y >= 0; y--) {
                if (trySlide(getTileByCoordinates(y, x), 1, 0)) {
                    wasMoved = true;
                }
            }
        }
    }

    /**
     * @see #trySlide
     * calls trySlide for all tiles that can be moved right
     */
    public void slideRight() {
        for (int y = 0; y < sideLength; y++) {
            for (int x = sideLength - 2; x >= 0; x--) {
                if (trySlide(getTileByCoordinates(y, x), 0, 1)) {
                    wasMoved = true;
                }
            }
        }
    }

    /**
     * @see #trySlide
     * calls trySlide for all tiles that can be moved left
     */
    public void slideLeft() {
        for (int y = 0; y < sideLength; y++) {
            for (int x = 1; x < sideLength; x++) {
                if (trySlide(getTileByCoordinates(y, x), 0, -1)) {
                    wasMoved = true;
                }
            }
        }
    }

    /**
     * slides tiles through neighbour tiles with 0 value or merges with tile with the same value
     *
     * @param tile current tile, that might be merged with  another tile
     * @return true, if tile was merged with another tile, otherwise false
     */
    public boolean trySlide(Tile tile, int yDirection, int xDirection) {
        if (tile.getValue() != 0) {
            int neighbourY = tile.getY() + yDirection;
            int neighbourX = tile.getX() + xDirection;
            if (isCoordinatesInBound(neighbourY, neighbourX) && (neighbourX != lastMergedX || neighbourY != lastMergedY)) {
                Tile neighbour = getTileByCoordinates(neighbourY, neighbourX);
                if (neighbour.getValue() == tile.getValue()) {
                    score += neighbour.getValue() * 2;
                    neighbour.setValue(neighbour.getValue() * 2);
                    tile.setValue(0);
                    lastMergedX = neighbourX;
                    lastMergedY = neighbourY;
                    return true;
                } else if (neighbour.getValue() == 0) {
                    neighbour.setValue(tile.getValue());
                    tile.setValue(0);
                    trySlide(neighbour, yDirection, xDirection);
                    return true;
                }
            }
        }
        return false;
    }

    public List<Integer> getNeighbours(int y, int x) {
        List<Integer> neighbours = new ArrayList<>();
        //left neighbour
        if (y > 0) {
            neighbours.add(tiles.get(x * sideLength + y - 1).getValue());
        }
        //right neighbour
        if (y < sideLength - 1) {
            neighbours.add(tiles.get(x * sideLength + y + 1).getValue());
        }
        //down neighbour
        if (x < sideLength - 1) {
            neighbours.add(tiles.get((x + 1) * sideLength + y).getValue());
        }
        //up neighbour
        if (x > 0) {
            neighbours.add(tiles.get((x - 1) * sideLength + y).getValue());
        }
        return neighbours;
    }

    private boolean canSlide() {
        return tiles.stream().anyMatch(t -> getNeighbours(t.getX(), t.getY()).contains(t.getValue()));
    }

    private boolean isCoordinatesInBound(int y, int x) {
        return y >= 0 && y < sideLength && x >= 0 && x < sideLength;
    }

    private Tile getTileByCoordinates(int y, int x) {
        return getTiles().get(coordinatesToIndex(y, x));
    }
    public int getScore(){return score;}

}