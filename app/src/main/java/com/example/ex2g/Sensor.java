package com.example.ex2g;

import java.util.ArrayList;
import java.util.Objects;

public class Sensor {
    private int sensorId;

    private int roomId;
    private int sensorTypeId;
    private String description;
//    private Room room;
//    private SensorType sensorType;
    private ArrayList<SensorReading> sensorReadings;

    public Sensor(int sensorId, int roomId, int sensorTypeId, String description) {
        this.sensorId = sensorId;
        this.roomId = roomId;
        this.sensorTypeId = sensorTypeId;
        this.description = description;
    }

    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getSensorTypeId() {
        return sensorTypeId;
    }

    public void setSensorTypeId(int sensorTypeId) {
        this.sensorTypeId = sensorTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sensor)) return false;
        Sensor sensor = (Sensor) o;
        return sensorId == sensor.sensorId &&
                roomId == sensor.roomId &&
                sensorTypeId == sensor.sensorTypeId &&
                Objects.equals(description, sensor.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sensorId, roomId, sensorTypeId, description);
    }

    @Override
    public String toString() {
        return Integer.toString(sensorId) +
                ", roomId=" + roomId +
                ", sensorTypeId=" + sensorTypeId +
                ", " + description;
    }

    public ArrayList<SensorReading> getSensorReadings() {
        return sensorReadings;
    }

    public void setSensorReadings(ArrayList<SensorReading> sensorReadings) {
        this.sensorReadings = sensorReadings;
    }

    public int findMinReadingIndex() {
        int index = 0;
        SensorReading minReading = sensorReadings.get(index);

        for (SensorReading sensorReading : sensorReadings) {
            if (minReading.getValue() > sensorReading.getValue()) {
                minReading = sensorReading;
            }
        }
        return sensorReadings.indexOf(minReading);
    }

    public int findMaxReadingIndex() {
        int index = 0;
        SensorReading maxReading = sensorReadings.get(index);

        for (SensorReading sensorReading : sensorReadings) {
            if (maxReading.getValue() < sensorReading.getValue()) {
                maxReading = sensorReading;
            }
        }
        return sensorReadings.indexOf(maxReading);
    }

    public int findMinReadingIndex(int startIndex, int endIndex) {
        int index = startIndex;
        SensorReading minReading = sensorReadings.get(index);
        if (startIndex < endIndex && startIndex > 0 && endIndex < sensorReadings.size() - 1) {
            for (int i = startIndex; i <= endIndex; i++) {
                SensorReading sensorReading = sensorReadings.get(i);
                if (minReading.getValue() > sensorReading.getValue()) {
                    minReading = sensorReading;
                }
            }
            return sensorReadings.indexOf(minReading);
        }
        else throw new IndexOutOfBoundsException();
    }

    public int findMaxReadingIndex(int startIndex, int endIndex) {
        int index = startIndex;
        SensorReading maxReading = sensorReadings.get(index);
        if (startIndex < endIndex && startIndex > 0 && endIndex < sensorReadings.size() - 1) {
            for (int i = startIndex; i <= endIndex; i++) {
                SensorReading sensorReading = sensorReadings.get(i);
                if (maxReading.getValue() < sensorReading.getValue()) {
                    maxReading = sensorReading;
                }
            }
            return sensorReadings.indexOf(maxReading);
        }
        else throw new IndexOutOfBoundsException();
    }
    public int findNextCycleMaxIndex(int startIndex){
        SensorReading rMax = this.sensorReadings.get(startIndex);
        int i = startIndex + 1;

        for (; i < this.sensorReadings.size(); i++) {
            if (rMax.getValue()  < this.sensorReadings.get(i).getValue())
                rMax = this.sensorReadings.get(i);
            else
                break;
        }
        return i - 1;
    }
    public int findNextCycleMinIndex(int startIndex){
        SensorReading rMin = this.sensorReadings.get(startIndex);
        int i = startIndex + 1;

        for (; i < this.sensorReadings.size(); i++) {
            if (rMin.getValue()  > this.sensorReadings.get(i).getValue())
                rMin = this.sensorReadings.get(i);
            else
                break;
        }
        return i - 1;
    }
    public SensorReading getSensorReading(int index){
        return sensorReadings.get(index);
    }
}