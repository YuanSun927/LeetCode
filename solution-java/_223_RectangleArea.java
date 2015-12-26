/*
Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

Rectangle Area
Assume that the total area is never beyond the maximum possible value of int.
*/
public class _223_RectangleArea {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (F >= D || B >= H || E >= C || A >= G)
            return (C - A) * (D - B) + (G - E) * (H - F);
        int[] x = new int[] {A, C, E, G};
        int[] y = new int[] {B, D, F, H};
        Arrays.sort(x);
        Arrays.sort(y);
        return  (C - A) * (D - B) + (G - E) * (H - F) - (x[2] - x[1]) * (y[2] - y[1]); 
    }
}