package ru.alfabank.homework8;

import java.util.ArrayList;

public class Playlist {

    private String playlistName;
    private final ArrayList<String> songs = new ArrayList<>();

    public Playlist(String playlistName) {
        this.playlistName = playlistName;
    }

    public void addSong(String song) {
        songs.add(song);
        System.out.printf("Добавлена песня \"%s\"\n", song);
    }

    public void removeSong(int index) {
        String songToDelete = songs.remove(index);
        System.out.printf("Удалена песня \"%s\"\n", songToDelete);
    }

    public void updateSong(int index, String song) {
        String songToUpdate = songs.get(index);
        songs.set(index, song);
        System.out.printf("Песня \"%s\" обновлена на \"%s\"\n", songToUpdate, song);
    }

    public String getSong(int index) {
        String song = songs.get(index);
        System.out.printf("Выбрана песня \"%s\"\n", song);
        return song;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public ArrayList<String> getSongs() {
        return songs;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    @Override
    public String toString() {
        return String.format(
                """         
                \nПлейлист: \"%s\"
                Песни: %s
                """,
                playlistName,
                songs);
    }
}
