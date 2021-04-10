package coordinates;

public class CoordinatesCalculator {
	public Coordinates calcuateCoordinates(int index, int columnLength) {
		int y = index % columnLength;
		int x = index - y;
		return new Coordinates(x,y);
	}
	
	public int calculateIndex(int posX, int posY, int columnLength) {
		return posY * columnLength + posX;
	}
}
