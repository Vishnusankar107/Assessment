package DEMO;

public class Main_Song {
	    public static void main(String[] args) {
	        int capacity = 3;
	        PlaylistManager playlistManager = new PlaylistManager(capacity);

	        playlistManager.addSong("user1", "s1");
	        playlistManager.addSong("user1", "s2");
	        playlistManager.addSong("user1", "s3");
	        playlistManager.printPlaylist("user1"); // Output: s3 s2 s1

	        playlistManager.addSong("user1", "s4");
	        playlistManager.printPlaylist("user1"); // Output: s4 s3 s2

	        playlistManager.addSong("user1", "s2");
	        playlistManager.printPlaylist("user1"); // Output: s2 s4 s3

	        playlistManager.addSong("user1", "s1");
	        playlistManager.printPlaylist("user1"); // Output: s1 s2 s4
	    }
	}