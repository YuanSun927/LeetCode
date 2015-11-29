/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/
public class _118_PascalTriangle {

	public List<List<Integer>> generate(int numRows) {
		if (numRows < 0)
			return null;
		List<List<Integer>> result = new ArrayList<List<Integer>>(numRows);
		if (numRows == 0)
			return result;
		for (int i = 1; i <= numRows; i++) {
			ArrayList<Integer> row = new ArrayList<Integer>(i);
			row.add(1);
			if (i > 1) {
				List<Integer> ref = result.get(i - 2);
				for (int j = 1; j < i - 1; j++) {
					if (j <= (i / 2)) {
						row.add(ref.get(j - 1) + ref.get(j));
					} else {
						row.add(row.get(i - j - 1));
					}
				}
				row.add(1);
			}
			result.add(row);
		}
		return result;
	}

}