package ru.alfabank.homework13;

import java.util.List;

public class MissionReport {

    private final String missionName;
    private final List<Alien> capturedAliens;
    private final int squadSize;

    public MissionReport(String missionName, List<Alien> capturedAliens, int squadSize) {
        this.missionName = missionName;
        this.capturedAliens = capturedAliens;
        this.squadSize = squadSize;
    }

    public String getMissionName() {
        return missionName;
    }

    public List<Alien> getCapturedAliens() {
        return capturedAliens;
    }

    public int getSquadSize() {
        return squadSize;
    }

    @Override
    public String toString() {
        return String.format(
                           """
                           Миссия: %s
                           Поймано пришельцев: %d
                           Размер отряда: %d
                           """,
                           missionName,
                           capturedAliens.size(),
                           squadSize
        );
    }
}
