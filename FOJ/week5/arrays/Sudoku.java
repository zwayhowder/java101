/**
 * This class defines a 4x4 sudoku board.
 * To win, you must fill in the numbers so that
 * - each row contains every number 1-4
 * - each column contains every number 1-4
 * - each 2x2 region in each corner contains every number 1-4
 */
public class Sudoku
{
    // The sudoku board has 4 regions.
    private Group[] regs;
    // 4 rows
    private Group[] rows;
    // and 4 columns
    private Group[] cols;

    public Sudoku()
    {
        // If you use an array here, you can also easily use an array loop.
        regs = new Group[4];
        for (int i = 0; i < regs.length; i++)
          regs[i] = new Group();

        // You can use arrays here, but don't bother using a loop - it is too difficult.
        rows = new Group[4];
        for (int i = 0; i < rows.length; i++)
          rows[i] = new Group(regs[i/2*2], regs[i/2*2 + 1], (i%2)*2+1, (i%2)*2+2);

        // You can use arrays here, but don't bother using a loop.
        cols = new Group[4];
        cols[0] = new Group(regs[0], regs[2], 1, 3);
        cols[1] = new Group(regs[0], regs[2], 2, 4);
        cols[2] = new Group(regs[1], regs[3], 1, 3);
        cols[3] = new Group(regs[1], regs[3], 2, 4);
    }

    public void enterNumber(int region, int cell, int number, boolean lock)
    {
        getRegion(region).enterNumber(cell, number, lock);
    }

    // NOTE! The parameter will be in the range 1-4, not 0-3.
    private Group getRegion(int regionNumber)
    {
      return regs[regionNumber-1];
    }

    /**
     * This method returns true if every region, every row and
     * every column is solved (i.e. has all the numbers 1 to 4)
     */
    public boolean isSolved()
    {
        for (int i = 0; i < regs.length; i++)
          if ( !regs[i].isSolved() || !rows[i].isSolved() || !cols[i].isSolved() )
            return false;
          return true;
    }

    public void print()
    {
        System.out.println();
        for (int i = 0; i < rows.length; i++)
          rows[i].print();
        System.out.println();
    }
}
