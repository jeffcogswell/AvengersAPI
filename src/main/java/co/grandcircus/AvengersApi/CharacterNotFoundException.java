package co.grandcircus.AvengersApi;

public class CharacterNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CharacterNotFoundException(String id) {
		super("Could not find character with id " + id);
	}
}
