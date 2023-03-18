import java.util.*;

class Solution {
    private class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return x == position.x && y == position.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    public List<String> printKMoves(int K) {
        char[] direction = {'L', 'U', 'R', 'D'};
        int[][] offset = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        Position curPos = new Position(0, 0);
        int cutDir = 2;
        Set<Position> blackSet = new HashSet<>();
        while (K > 0) {
            Position cut = new Position(curPos.x, curPos.y);
            if (blackSet.add(cut)) {
                cutDir = (cutDir + 1) % 4;
            } else {
                cutDir = (cutDir + 3) % 4;
                blackSet.remove(cut);
            }
            curPos.x += offset[cutDir][0];
            curPos.y += offset[cutDir][1];
            K--;
        }
        int left = curPos.x, top = curPos.y, right = curPos.x, bottom = curPos.y;
        for (Position pos : blackSet) {
            left = Math.min(pos.x, left);
            top = Math.min(pos.y, top);
            right = Math.max(pos.x, right);
            bottom = Math.max(pos.y, bottom);
        }
        char[][] grid = new char[bottom - top + 1][right - left + 1];
        for (char[] row : grid) {
            Arrays.fill(row, '_');
        }
        for (Position pos : blackSet) {
            grid[pos.y - top][pos.x - left] = 'X';
        }
        grid[curPos.y - top][curPos.x - left] = direction[cutDir];
        List<String> res = new ArrayList<>();
        for (char[] row : grid) {
            res.add(new String(row));
        }
        return res;
    }
}