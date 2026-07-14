package ru.alfabank.homework13;

import java.util.List;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MissionReport report = (MissionReport) o;
        return squadSize == report.squadSize &&
                Objects.equals(missionName, report.missionName) && Objects.equals(capturedAliens, report.capturedAliens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(missionName, capturedAliens, squadSize);
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
