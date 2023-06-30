// STUDENT1: AZİZ ÖNDER 22050141021
// STUDENT2: UĞUR KUŞ 22050111002
public class NPuzzleRecursiveSolver {
	protected Board solutionBoard;

	Board solve(Board board) {
		initializeSearch();

		searchSolution(new Board(board));

		return solutionBoard;
	}

	void initializeSearch() {
		solutionBoard = null;
	}

	private void searchSolution(Board boardConfiguration) {
		// student code--------------------------------------------
		
		if (boardConfiguration.isFull()) {
			solutionBoard = boardConfiguration;
			return;
		}

		//we should initialize column value after "terminator if statement", otherwise we get NullPointerException
		int column = boardConfiguration.getFirstEmptyColumn();
		
		//loops  through rows (we don't need to loop through all cells, because each column must have only 1 queen)
		for (int row = 0; row < boardConfiguration.height; row++) {
			
		//if position is available adds the queen and recursively then calls the method
		//when all queens placed it terminates. If position isn't available, removes the last placed
		//queen and tries to add queen to the next rows(in the next iterations). 	
			if (!boardConfiguration.canAttackOtherQueens(column, row)) {
				boardConfiguration.addQueen(column, row);
				searchSolution(boardConfiguration);
			}
			if (boardConfiguration.isFull()) {
				return;
			}
			if(boardConfiguration.canAttackOtherQueens(column, row)) {
				boardConfiguration.removeQueen(column);
			}
			
		}
	}

}
