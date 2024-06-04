package iodemo;

public class Songs {

	private String name;
	private String Artistname;
	private String year;
	private String notes;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtistname() {
		return Artistname;
	}

	public void setArtistname(String artistname) {
		Artistname = artistname;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "Songs [name=" + name + ", Artistname=" + Artistname + ", year=" + year + ", notes=" + notes + "]";
	}

}
