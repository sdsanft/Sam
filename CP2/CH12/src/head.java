/*
1. Show the basic skeleton of a while loop.
*	while (true) {
*		
*	}
2. Show the basic skeleton of a do-while loop.
*	do {
*		
*	} while (true);
3. Implement the following for-loop as a while loop.
	int m;
	for (m = 97; m <= 195; m++)
	{
	k = k * k + 3 * m;
	p = p + m +1;
	}
*	int m = 97;
*	while (m <= 195) {
*		k = k * k + 3 * m;
*		p = p + m +1;
*		m++
*	}
4. Implement the following for loop as a do-while loop.
	for (int v = 2; v <= 195; v*=3)
	{
	k = k * k + 3 * v;
	q = Math.sqrt(q + v +1);
	}
*	int v = 2;
*	do {
*		k = k * k + 3 * v;
*		q = Math.sqrt(q + v +1);
*		v *= 3;
*	} while (v <= 195);
5. What is the loop control expression in the code segment below?
	while (!done)
	{
		if (i < 1)
			{done = true;}
		i--;
	}
*	The while expression
6. What is the error in the code segment below?
	do;
	{
		if (i < 1)
			{done = true;}
		i--;
	}while (!done);
*	there is a semicolon after the do
7. How many times will the loop below iterate?
	int j = 0;
	while(j < 50)
	{
		System.out.println(“Hello World!”);
	}
*	50 times
8. How many times will the loop below iterate?
	int j = 25;
	while (j <= 100 | | j >= 25)
	{
		System.out.println(“Temp variable =” + j);
		j++;
	}
*	76 times
9. Identify the error(s) in the code below:
	j = 155
	while (!done)
	{
		if (j <= 25)
			done = true;
		j = j – 5;
	};
*	no semicolon on line 1
*	semicolon after final bracket
10. What will be the output of the following code:
	int i = 0, j = 0;
	while(i <= 3)
	{
		for(j = 0; j <=2; j++)
		{
			System.out.print(i + “,” + j + “ ”);
		}
		i++;
	}
*	0,0 0,1 0,2 1,0 1,1 1,2 2,0 2,1 2,2 3,0 3,1 3,2
11. What command would you use if something unusual happens in one of your loops and
you wish to exit prematurely (even before the control expression says you can)?
*	break;
12. What loop structure would you use if you want to guarantee that a test condition of the
control expression be tested before the block of code inside the loop could execute?
*	while loop
13. What is printed when the following code runs?
	double m = 92.801;
	int j = 0;
	do
	{
		j += 2;
		if (j > -100)
			continue;
		m+=3;
	}while(j < 6);
	System.out.println(m);
*	92.801	
14. Write a program that will prompt the user to enter an integer. The program should square
the number and then print the squared number. Repeat this process until 0 is entered as
input. Use a do-while-loop to do this.
*/

import java.util.Scanner;
public class head {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int i = 0;
		do {
			System.out.print("Please enter an integer: ");
			
			if(s.hasNextInt()) {
				i = s.nextInt();
			} else {
				i = 5;
				System.out.println("You didn't enter an integer.\n");
				s.nextLine();
				continue;
			}
			
			i *= i;
			System.out.println("Your number squared is: " + i + "\n");
		} while (i != 0);
		s.close();
	}

}
