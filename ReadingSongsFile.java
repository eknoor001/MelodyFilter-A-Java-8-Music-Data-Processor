package iodemo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadingSongsFile {
	ArrayList<Songs> list = null;
	Songs obj = null;

	public ReadingSongsFile() {
		try {
			fetchdata();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private ArrayList<Songs> fetchdata() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("songs_N.txt"));
		list = new ArrayList<Songs>();
		while (true) {
			String line = reader.readLine();
			if (line == null) {
				break;
			}
			String[] parts = line.split("/");
			obj = new Songs();

			if (parts.length == 4) {
				obj.setName(parts[0]);
				obj.setArtistname(parts[1]);
				obj.setYear(parts[2]);
				obj.setNotes(parts[3]);
				list.add(obj);
			}
		} // end of while
		reader.close();
		System.out.println(list.size());
		return list;
	}

	void songNames() throws IOException {
		list.stream().distinct().forEach((song) -> System.out.println(song.getName().toUpperCase()));
	}

	void artistName() throws IOException {
		List<String> distinctArtists = list.stream().map(Songs::getArtistname).distinct().collect(Collectors.toList());
//        Set<String> lis = list.stream().map(Songs::getArtistname).collect(Collectors.toSet());
		distinctArtists.forEach(System.out::println);

	}

	void allYear() {
		list.sort((song1, song2) -> (song1.getYear().compareTo(song2.getYear())));

		list.stream().map(song -> song.getYear()).distinct().forEach(year -> System.out.print(year + " "));
	}

	void fetchByYear(String year) {
		list.stream().filter(song -> song.getYear().equalsIgnoreCase(year)).forEach(System.out::println);
	}

	void fetchByArtistName(String name) {
		list.stream().filter(song -> song.getArtistname().equalsIgnoreCase(name)).forEach(
				song -> System.out.printf("%-20s%-10s%-30s\n", song.getName(), song.getYear(), song.getNotes()));
	}

	void fetchForAllArtist() {
		List<String> artistnamelist = list.stream().map(song -> song.getArtistname()).distinct()
				.collect(Collectors.toList());

		artistnamelist.forEach(artistname -> {
			System.out.println("\nArtist Name :: " + artistname);

			list.stream().filter(artist -> artist.getArtistname().equalsIgnoreCase(artistname)).forEach(
					song -> System.out.printf("%-20s%-10s%-30s\n", song.getName(), song.getYear(), song.getNotes()));
		});

	}

	void searchArstistName(String name) {
		Stream<Songs> stream = list.stream().filter(song -> song.getArtistname().equalsIgnoreCase(name));
		stream.forEach(song -> System.out.println(song.getName()));
		stream = list.stream().filter(song -> song.getArtistname().equalsIgnoreCase(name));
		if (stream.count() == 0) {
			System.out.println("Not found any result");
		} else {
			System.out.println("Available!");
		}
	}

}
