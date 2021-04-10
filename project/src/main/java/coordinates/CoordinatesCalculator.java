package coordinates;

public class CoordinatesCalculator {
	public static Coordinates calcuateCoordinates(int index, int columnLength) {
		int x = index % columnLength;
		int y = index / columnLength;
		return new Coordinates(x,y);
	}
	
	public static int calculateIndex(int posX, int posY, int columnLength) {
		return posY * columnLength + posX;
	}
}
