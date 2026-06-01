package ru.alfabank.homework8;

public class Winamp {
    public static void main(String[] args) {
        Playlist playlist = new Playlist("Попса");

        playlist.addSong("Звери - Для тебя");
        playlist.addSong("SEREBRO - Сладко");
        playlist.addSong("Дискотека Авария - Пей пиво!");
        playlist.removeSong(1);
        playlist.updateSong(0, "Моя Мишель - Зима в сердце");
        playlist.getSong(0);

        System.out.println(playlist);
    }
}
