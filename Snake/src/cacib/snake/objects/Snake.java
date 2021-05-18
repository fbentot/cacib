package cacib.snake.objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Snake {

	// Matrice de positions
	// Clé : Numéro de bloc, liste [x,y]
	public HashMap<Integer, ArrayList<Integer>> positionsOccupees = new HashMap<Integer, ArrayList<Integer>>(); 
	// Taille du serpent
	public Integer snakeLength;

	//--------------- Constructeur --------------- 
	public Snake(Integer snakeLength) {
		super();
		init(snakeLength);
	}
	
	//--------------- Get/Set --------------- 
	public HashMap<Integer, ArrayList<Integer>> getPositionsOccupees() {
		return positionsOccupees;
	}

	public void setPositionsOccupees(HashMap<Integer, ArrayList<Integer>> positionsOccupees) {
		this.positionsOccupees = positionsOccupees;
	}

	public Integer getSnakeLength() {
		return snakeLength;
	}

	public void setSnakeLength(Integer snakeLength) {
		this.snakeLength = snakeLength;
	}
	
	//--------------- Methodes ----------------
	
	// Placement initial à l'horizontale
	public void init(Integer snakeLength) {
		this.snakeLength = snakeLength;
		for (int i = 0; i < snakeLength; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();

			list.add(i); // composante x
			list.add(0); // composante y

			positionsOccupees.put(i, list);
		}
	}

	// Seule la tête bouge, le corps suit
	public ArrayList<Integer> moveHead(String move) throws InvalidMoveException {
		ArrayList<Integer> positionTete = positionsOccupees.get(snakeLength - 1);
		Integer x = positionTete.get(0);
		Integer y = positionTete.get(1);

		switch (move) {
		case "H":
			y++;
			break;
		case "B":
			y--;
			break;
		case "D":
			x++;
			break;
		case "G":
			x--;
			break;
		default:
			throw new InvalidMoveException("Move " + move + " is incorrect. Allowed moveset : H, B, D, G");
		}

		ArrayList<Integer> newPos = new ArrayList<Integer>();
		newPos.add(x);
		newPos.add(y);

//		System.out.println("Nouvelle projection de la tête (" + x + "," + y + ")");

		return newPos;

	}

	// Déplacement du corps
	public String moveBody(String move) throws InvalidMoveException, PositionOccupiedException {

		// Vérification si le mouvment est autorisé
		ArrayList<Integer> newPosHead = moveHead(move);

		checkMove(newPosHead);

		// On bouge le corps avant la tête
		for (int i = 0; i < snakeLength - 1; i++) {
			ArrayList<Integer> newPos = positionsOccupees.get(i + 1);

			positionsOccupees.replace(i, newPos);

//			System.out.println("Nouvelle position du bloc " + i + " (" + newPos.get(0) + "," + newPos.get(1) + ")");

		}

		positionsOccupees.replace(snakeLength - 1, newPosHead);
		
//		System.out.println("Tête placée en (" + newPosHead.get(0) + "," + newPosHead.get(1) + ")");
		
		return ("Position finale de la tête : (x=" + newPosHead.get(0)+  ", y=" + newPosHead.get(1)+")");


	}

	// Vérification si la nouvelle position de la tête n'est pas déjà occupée par un
	// élément du corps
	public void checkMove(ArrayList<Integer> newPosHead) throws PositionOccupiedException {
		Iterator<ArrayList<Integer>> iter = positionsOccupees.values().iterator();
		while (iter.hasNext()) {
			ArrayList<Integer> position = iter.next();
			if (newPosHead.equals(position)) {
				throw new PositionOccupiedException(
						"Position (" + position.get(0) + "," + position.get(1) + ") already occupied by a body part");
			}
		}
	}

}
