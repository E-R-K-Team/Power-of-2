import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * Game field and operations with it
 * @author Kirill
 */
public class Board {
    private final int sideLength;
    private List<Tile> tiles;
    private boolean wasMoved = false;
    private int lastMergedX;
    private int lastMergedY;
    private GameState currentState;
    private final SecureRandom random = new SecureRandom();

    public Board(int sideLength) {
        this.sideLength = sideLength;
        initializeBoard(sideLength);
        spawnTile();
    }

    public List<Tile> getTiles() {
        return tiles;
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
        checkGameState();
        lastMergedX=-1;
        lastMergedY=-1;
    }

    /**
     * @return value , that should be spawned to empty tile ( 2 or 4 )
     */
    private int takeSpawnTileValue() {
        return random.nextDouble() < GameConstants.CHANCE_TO_SPAWN_FOUR ? 4 : 2;
    }

    private int coordinatesToIndex(int y, int x) {
        return y * sideLength + x;
    }

    private ArrayList<Tile> findEmptyTiles() {
        List<Tile> tilesList = tiles.stream().filter(tile -> tile.getValue() == 0).toList();
        return new ArrayList<>(tilesList);
    }

    private int getHighestTileValue() {
        return getTiles().stream().mapToInt(Tile::getValue).max().getAsInt();
    }

    private void checkGameState() {
        if (getHighestTileValue() == GameConstants.WIN_TILE_VALUE) {
            currentState = GameState.WIN;
        } else if (getTiles().stream().noneMatch(tile -> tile.getValue() == 0)) {
            currentState = GameState.LOSE;
        } else {
            currentState = GameState.IN_PROGRESS;
        }
    }

    public GameState getGameState() {
        return currentState;
    }

    public void slideUp() {
        for (int x = 0; x < sideLength; x++) {
            for (int y = 1; y < sideLength; y++) {
                if (trySlide(getTileByCoordinates(y, x), -1, 0)) {
                    wasMoved = true;
                }
            }
        }
    }

    public void slideDown() {
        for (int x = 0; x < sideLength; x++) {
            for (int y = sideLength - 2; y >= 0; y--) {
                if (trySlide(getTileByCoordinates(y, x), 1, 0)) {
                    wasMoved = true;
                }
            }
        }
    }

    public void slideRight() {
        for (int y = 0; y < sideLength; y++) {
            for (int x = sideLength - 2; x >= 0; x--) {
                if (trySlide(getTileByCoordinates(y, x), 0, 1)) {
                    wasMoved = true;
                }
            }
        }
    }

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
     *
     * @param tile current tile, that might be merged with with another tile
     * @return true, if tile was merged with another tile, otherwise false
     */
    private boolean trySlide(Tile tile, int yDirection, int xDirection) {
        if (tile.getValue() != 0) {
            int neighbourY = tile.getY() + yDirection;
            int neighbourX = tile.getX() + xDirection;
            if (isCoordinatesInBound(neighbourY, neighbourX) && (neighbourX!=lastMergedX || neighbourY!=lastMergedY)) {
                Tile neighbour = getTileByCoordinates(neighbourY, neighbourX);
                if (neighbour.getValue() == tile.getValue()) {
                    neighbour.setValue(neighbour.getValue()*2);
                    tile.setValue(0);
                    lastMergedX=neighbourX;
                    lastMergedY=neighbourY;
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

    private boolean isCoordinatesInBound(int y, int x) {
        return y >= 0 && y < sideLength && x >= 0 && x < sideLength;
    }

    private Tile getTileByCoordinates(int y, int x) {
        return getTiles().get(coordinatesToIndex(y, x));
    }

    public boolean wasMoved() {
        return wasMoved;
    }

}