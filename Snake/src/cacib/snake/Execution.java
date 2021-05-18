package cacib.snake;

import java.util.Scanner;

import cacib.snake.objects.InvalidMoveException;
import cacib.snake.objects.PositionOccupiedException;
import cacib.snake.objects.Snake;

public class Execution {

	public static void main(String[] args) throws InvalidMoveException, PositionOccupiedException {
		
		Scanner clavier = new Scanner(System.in);
		System.out.println("Taille du serpent ? ");
		Integer snakeLength = clavier.nextInt();
		System.out.println("Moveset du serpent ? ");
		String moveSet = clavier.next();
		
		Snake snake = new Snake(5);
		
		String finalPos="";

		for(int i = 0; i < moveSet.length(); i++)
		{
			finalPos = snake.moveBody(String.valueOf(moveSet.charAt(i)));
		}
		
		System.out.println(finalPos);
		

		

	}

}
