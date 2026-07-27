class Solution {
    private final static int BOARD_SIZE = 9;
    private final static int GRID_SIZE = (int) Math.sqrt(BOARD_SIZE);
    private final static int EMPTY_CELL_BITMASK = 1 << ('.' - '1');
    public boolean isValidSudoku(char[][] board) {
        int rowmasks[] = new int[BOARD_SIZE];
        int columnmasks[] = new int[BOARD_SIZE];
        int gridmasks[] = new int[BOARD_SIZE];
        // Traverse the board for the 9 colums
        for(int c = 0; c < BOARD_SIZE; c++) {
            // Traverse the board for the 9 rows
            // Check & Set validity for each row, column, and grid
            for(int r = 0; r < BOARD_SIZE; r++) {
                int digit_bitmask = 1 << (board[r][c] - '1');
                if (digit_bitmask == EMPTY_CELL_BITMASK) {
                    //System.out.println("empty");
                    continue;
                }
                //System.out.println(String.format("r:%d, c:%d, v:%c -> 0b%s", r, c, board[r][c], Integer.toBinaryString(digit_bitmask)));
                if ((rowmasks[r] & digit_bitmask) != 0) {
                    //System.out.println("row: " + Integer.toBinaryString(rowmasks[r]));
                    return false;
                }
                rowmasks[r] |= digit_bitmask;
                if ((columnmasks[c] & digit_bitmask) != 0) {
                    //System.out.println("column: " + Integer.toBinaryString(rowmasks[r]));
                    return false;
                }
                columnmasks[c] |= digit_bitmask;
                int grid_index = (r / GRID_SIZE) * GRID_SIZE + (c / GRID_SIZE);
                if ((gridmasks[grid_index] & digit_bitmask) != 0) {
                    // System.out.println("grid: " + Integer.toBinaryString(rowmasks[r]));
                    return false;
                }
                gridmasks[grid_index] |= digit_bitmask;
            }
        }
        return true;
    }
}
