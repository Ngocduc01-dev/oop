/******************************************************************************
 *  Compilation:  javac RandomWalk.java
 *  Execution:    java RandomWalk n
 *  Dependencies: StdDraw.java
 *
 *  % java RandomWalk 20
 *  total steps = 300
 *
 *  % java RandomWalk 50
 *  total steps = 2630
 *
 *  Simulates a 2D random walk and plots the trajectory.
 *
 *  Remarks: works best if n is a divisor of 600.
 *
 ******************************************************************************/


public class RandomWalk {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setScale(-n - 0.5, n + 0.5);
        StdDraw.clear(StdDraw.GRAY);
        StdDraw.enableDoubleBuffering();

        int x = 0, y = 0;
        int steps = 0;
        int stepLength = 1;
        int direction = 0;
        int turns = 0;

        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.filledSquare(x, y, 0.45);
        StdDraw.show();

        while (Math.abs(x) < n && Math.abs(y) < n) {
            for(int i = 0; i < stepLength ; i++) {
                if (direction == 0) {
                    x++;
                } else if (direction == 1) {
                    y++;
                } else if (direction == 2) {
                    x--;
                } else if (direction == 3) {
                    y--;
                }
                steps++;
                StdDraw.setPenColor(StdDraw.BLUE);
                StdDraw.filledSquare(x, y, 0.45);
                StdDraw.show();
                StdDraw.pause(40);
                if (Math.abs(x) >= n || Math.abs(y) >= n) break;
            }

            direction = (direction+1) % 4;
            turns++;
            if(turns % 2 == 0) {
                stepLength++;
            }
        }
        System.out.println("Total steps = " + steps);
    }
}

