public class Main {
    public static void main(String[] args) {
        int xAxis = 20;
        int yAxis = 12;
        int iterations = 30;
        String[][] game = init(yAxis, xAxis);
        print(game);
        for (int i = 0; i < iterations; i++) {
            game = iterate (game);
            print(game);
        }
    }
public static String[][] iterate (String[][]game){
    int height = game.length;
    int width = game[0].length;
    String[][] iteration = new String[height][width];

    for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
            int liveNeighbors = countLiveNeighbors(game, y, x);
            if (game[y][x].equals("[\uD83D\uDE09]")) {
                if (liveNeighbors < 2 || liveNeighbors > 3) {
                    iteration[y][x] = "[\uD83D\uDE21]";
                } else {
                    iteration[y][x] = "[\uD83D\uDE09]";
                }
            } else {
                if (liveNeighbors == 3) {
                    iteration[y][x] = "[\uD83D\uDE09]";
                } else {
                    iteration[y][x] = "[\uD83D\uDE21]";
                }
            }
        }
    }
    return iteration;
}
    public static int countLiveNeighbors(String[][] game, int row, int col) {
        int count = 0;
        int height = game.length;
        int width = game[0].length;
        int[][] neighbors = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1},           {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };
        for (int[] neighbor : neighbors) {
            int neighborRow = row + neighbor[0];
            int neighborCol = col + neighbor[1];
            if (neighborRow >= 0 && neighborRow < height && neighborCol >= 0 && neighborCol < width) {
                if (game[neighborRow][neighborCol].equals("[\uD83D\uDE09]")) {
                    count++;
                }
            }
        }
        return count;
    }
public static void print (String[][] game)
{for (int y = 0; y < game.length; y++) {
    for (int x = 0; x < game[y].length; x++) {
        System.out.print(game[y][x]);
    }
    System.out.println();
}
    System.out.println("------------------------------------------------------------------------------------------");}
public static String[][] init(int yAxis, int xAxis) {
        String[][] game = new String[yAxis][xAxis];
    for (int y = 0; y < yAxis; y++) {
        for (int x = 0; x < xAxis; x++) {
            if (Math.random() > 0.5) {
                game[y][x] = "[\uD83D\uDE09]";
            } else {
                game[y][x] = "[\uD83D\uDE21]";
            }
        }
    }
    return game;
}

}
