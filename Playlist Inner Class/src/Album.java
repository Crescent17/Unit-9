import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    public boolean addSong(String title, double duration) {
        return this.songs.add(new Song(title, duration));
    }


    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        if (songs.findSong(trackNumber) != null) {
            playList.add(songs.findSong(trackNumber));
            return true;
        }
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        if (songs.findSong(title) != null) {
            playList.add(songs.findSong(title));
            return true;
        }
        return false;
    }

    public static class SongList {
        private ArrayList<Song> songs;

        private SongList() {
            this.songs = new ArrayList<>();
        }

        private boolean add(Song song) {
            if (songs.contains(song)) {
                return false;
            }
            songs.add(song);
            return true;
        }

        private Song findSong(String title) {
            for (Song song :
                    songs) {
                if (song.getTitle().equals(title)) {
                    return song;
                }
            }
            return null;
        }

        private Song findSong(int number) {
            if (songs.size() >= number - 1 && number > 0) {
                return songs.get(number - 1);
            }
            return null;
        }
    }
}
