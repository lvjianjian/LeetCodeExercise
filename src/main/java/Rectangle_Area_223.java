/**
 * Created by zhongjianlv on 18-3-9.
 * <p>
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * <p>
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 * <p>
 * Rectangle Area
 * Assume that the total area is never beyond the maximum possible value of int.
 */
public class Rectangle_Area_223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int x1 = Math.max(A,E);
        int y1 = Math.max(B,F);
        int x2 = Math.min(C,G);
        int y2 = Math.min(D,H);
        int chong = 0;
        if(x1 < x2 && y1 < y2)
            chong = (x2-x1) * (y2-y1);
        return (C-A) * (D-B) + (E-G) * (F-H) - chong;
    }
}
