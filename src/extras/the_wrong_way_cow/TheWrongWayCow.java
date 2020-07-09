//https://www.codewars.com/kata/the-wrong-way-cow
//
//Task
//Given a field of cows find which one is the Wrong-Way Cow and return her position.
//
//Notes:
//
//There are always at least 3 cows in a herd
//There is only 1 Wrong-Way Cow!
//Fields are rectangular
//The cow position is zero-based [x,y] of her head (i.e. the letter c)
//Examples
//Ex1
//
//cow.cow.cow.cow.cow
//cow.cow.cow.cow.cow
//cow.woc.cow.cow.cow
//cow.cow.cow.cow.cow
//Answer: [6,2]
//
//Ex2
//
//c..........
//o...c......
//w...o.c....
//....w.o....
//......w.cow
//Answer: [8,4]
//
//Notes
//The test cases will NOT test any situations where there are "imaginary" cows, so your solution does not need to worry about such things!
//
//To explain - Yes, I recognize that there are certain configurations where an "imaginary" cow may appear that in fact is just made of three other "real" cows.
//In the following field you can see there are 4 real cows (3 are facing south and 1 is facing north). There are also 2 imaginary cows (facing east and west).
//
//...w...
//..cow..
//.woco..
//.ow.c..
//.c.....

package extras.the_wrong_way_cow;

import java.util.ArrayList;
import java.util.HashMap;

public class TheWrongWayCow {

    public static int[] findWrongWayCow(final char[][] field) {
        // Fill in the code to return the x,y coordinate position of the
        // head (letter 'c') of the wrong way cow!
    	ArrayList<int[]> up = new ArrayList<int[]>();
    	ArrayList<int[]> down = new ArrayList<int[]>();
    	ArrayList<int[]> left = new ArrayList<int[]>();
    	ArrayList<int[]> right = new ArrayList<int[]>();

    	
        for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				if(field[i][j]=='c'&&i<field.length-2&&field[i+1][j]=='o'&&field[i+2][j]=='w') {
					int[] d = {j,i};
					down.add(d);
					}
				if(field[i][j]=='c'&&i>2&&field[i-1][j]=='o'&&field[i-2][j]=='w') {
					int[] u = {j,i};
					up.add(u);
				}
				if(field[i][j]=='c'&&j<field[i].length-2&&field[i][j+1]=='o'&&field[i][j+2]=='w') {
					int[] r = {j,i};
					right.add(r);
				}
				if(field[i][j]=='c'&&j>2&&field[i][j-1]=='o'&&field[i][j-2]=='w') {
					int[] l = {j,i};
					left.add(l);
				}
				}
			}
        System.out.println(right.size()+" rights");
        System.out.println(down.size()+" downs");
        System.out.println(left.size()+" letfs");
        System.out.println(up.size()+" ups");
			if(up.size()==1) {
				return up.get(0);
			}
			if(down.size()==1) {
				System.out.println(down.get(0)[0]+ " downX");
				System.out.println(down.get(0)[1]+ " downY");
				return down.get(0);
			}
			if(left.size()==1) {
				return left.get(0);
			}
			if(right.size()==1) {
				return right.get(0);
			}
			else {
        return null;
			}
    }
}
