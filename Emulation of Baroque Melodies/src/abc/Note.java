package abc;

/**
 * Represents a single note in a tune.
 * 
 * Mantra: A note should be able to get its information
 * raw from an abc file, and be able to turn its data
 * into a correctly formatted abc note.
 * @author Evan S.
 *
 */
public class Note {

	/**
	 * Can be ^ (sharp), = (natural), or _ (flat)
	 */
	char accidental;

	/**
	 * Can be A-G
	 */
	char pitch;

	/**
	 * An octave of 0 means the octave
	 * beginning at Middle-C
	 * An octave of n is n octaves above
	 * or below octave 0.
	 */
	int octave=0;

	/**
	 * The length of a note, where units
	 * are the default note length of the tune.
	 * A length of -n is equal to 1/(2n)
	 */
	int length;

	/**
	 * Initialize all values given a string.
	 * Reminder: This is the note regex:
	 * ([\^=_]?[a-gA-G][,']*|z)[\d/]?
	 */
	public Note(String note) {
		// PARSE BABY PARSE
		// This is gonna be stupid.
		int i = 0;
		if (setAccidental(note.charAt(i)+"")) i++;
		if (setPitch(note.charAt(i)+"")) i++;
		while(note.charAt(i)=='\''||note.charAt(i)==','){
			if (note.charAt(i)=='\'') {
				octave++;
				i++;
			} else if (note.charAt(i)==',') {
				octave--;
				i++;
			}
		}
		// TODO handle length;
		
	}

	/**
	 *  Want to preserve the default constructor
	 *  so I can hand-build notes as required.
	 */
	public Note() {};

	/***********************
	 *   Getters/Setters   *
	 ***********************/

	/**
	 * Accidental
	 */
	public char getAccidental() {
		return accidental;
	}

	/**
	 * @return true if S is a valid accidental,
	 * false otherwise.
	 */
	public boolean setAccidental(String s) {
		if (s.equals("^")||s.equals("=")||s.equals("_")) {
			accidental = s.charAt(0);
			return true;
		}
		return false;
	}

	/**
	 * Pitch
	 */
	public char getPitch() {
		return pitch;
	}

	public boolean setPitch(String s) {
		if (s.matches("[A-G]|z")) {
			pitch = s.charAt(0);
			return true;
		}
		// If it's lowercase, it's actually a higher octave
		else if (s.matches("[a-g]")) {
			pitch = (char)(s.charAt(0) - 32); // cast it to uppercase
			octave++;
			return true;
		}
		return false;
	}

	/**
	 * Octave
	 */
	public int getOctave() {
		return octave;
	}

	public boolean setOctave(int n) {
		octave = n;
		return true;
	}

	/**
	 * Length
	 */
	public int getLength() {
		return length;
	}

	public boolean setLength(int n) {
		length = n;
		return true;
	}

	/**
	 * Process a string representation of length,
	 * mainly one that contains one or more "/"
	 * @param n
	 * @return
	 */
	public boolean setLength(String n) {
		//TODO implement setLength
		return false;
	}


	/**
	 * TODO: Finish This
	 * Returns this note written in its proper 
	 * abc notation format.
	 */
	public String toString() {
		String note = "";
		note += getAccidental();
		// handling stuff for different octaves
		// completely sucks.
		if (getOctave() >= 1)
		{
			//pitch += 
		}
		note += getPitch();
		return "";
	}
}