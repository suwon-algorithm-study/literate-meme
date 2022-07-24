package yeonuk.programmers.거리두기_확인하기;

import java.util.*;

public class Solution {

    public int[] solution(String[][] places) {
        List<Room> rooms = new ArrayList<>();
        for (String[] roomInput : places) {
            Room room = new Room(5, 5, roomInput);
            rooms.add(room);
        }

        return rooms.stream()
                .mapToInt(Room::verifyRoom)
                .toArray();
    }
}

class Room {

    private final Place[][] places;

    private final int[][] visited;

    public Room(int row, int col, String[] roomInput) {
        this.places = new Place[row][col];

        for (int i = 0; i < roomInput.length; i++) {
            String symbols = roomInput[i];
            for (int j = 0; j < symbols.length(); j++) {
                char symbol = symbols.charAt(j);
                Place place = Place.of(symbol);
                places[i][j] = place;
            }
        }

        this.visited = new int[row][col];
    }

    public int verifyRoom() {
        for (int i = 0; i < places.length; i++) {
            for (int j = 0; j < places[i].length; j++) {
                Place place = places[i][j];

                if (place == Place.PERSON && !validRule(i, j)) {
                    return 0;
                }
            }
        }

        return 1;
    }

    private boolean validRule(int i, int j) {
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(i, j));
        visited[i][j] = 1;

        while (!queue.isEmpty()) {
            Location location = queue.poll();

            int x = location.getX();
            int y = location.getY();

            if (existNearPerson(x, y)) {
                return false;
            }

            for (Direction direction : Direction.ofAllMoveDirection()) {
                int dx = direction.getDx();
                int dy = direction.getDy();

                int nx = x + dx;
                int ny = y + dy;

                if (canMove(nx, ny) && places[nx][ny] == Place.PERSON) {
                    if (existBetweenTable(x, y, nx, ny)) {
                        return false;
                    }

                    queue.add(new Location(nx, ny));
                    visited[nx][ny] = 1;
                }
            }
        }

        return true;
    }

    private boolean existNearPerson(int x, int y) {
        for (Direction direction : Direction.ofAllNearDirection()) {
            int dx = direction.getDx();
            int dy = direction.getDy();

            int nx = x + dx;
            int ny = y + dy;

            if (canMove(nx, ny) && places[nx][ny] == Place.PERSON) {
                return true;
            }
        }
        return false;
    }

    private boolean canMove(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < places.length && ny < places[nx].length && visited[nx][ny] == 0;
    }

    private boolean existBetweenTable(int x, int y, int nx, int ny) {
        if (Math.abs(x - nx) == 1) {
            return places[x][ny] == Place.TABLE || places[nx][y] == Place.TABLE;
        } else if (Math.abs(x - nx) == 0) {
            return places[x][Math.abs(y + ny) / 2] == Place.TABLE;
        } else if (Math.abs(y - ny) == 0) {
            return places[Math.abs(x + nx) / 2][y] == Place.TABLE;
        }

        return false;
    }
}

enum Place {
    PERSON('P', "응시자"),
    TABLE('O', "테이블"),
    PARTITION('X', "파티션"),
    ;

    private final char symbol;
    private final String description;

    Place(char symbol, String description) {
        this.symbol = symbol;
        this.description = description;
    }

    public static Place of(char symbol) {
        return Arrays.stream(values())
                .filter(p -> p.symbol == symbol)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Not Found Place : symbol=" + symbol));
    }
}

class Location {

    private int x;

    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class Direction {

    private int dx;
    private int dy;

    public static List<Direction> ofAllNearDirection() {
        return Arrays.asList(
                Direction.of(0, 1),
                Direction.of(1, 0),
                Direction.of(0, -1),
                Direction.of(-1, 0)
        );
    }

    public static List<Direction> ofAllMoveDirection() {
        return Arrays.asList(
                Direction.of(0, 2),
                Direction.of(1, 1),
                Direction.of(2, 0),
                Direction.of(1, -1),
                Direction.of(0, -2),
                Direction.of(-1, -1),
                Direction.of(-2, 0),
                Direction.of(-1, 1)
        );
    }

    private static Direction of(int nx, int ny) {
        Direction direction = new Direction();
        direction.dx = nx;
        direction.dy = ny;
        return direction;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }
}
