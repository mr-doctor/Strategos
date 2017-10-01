package strategos.behaviour;


import strategos.*;
import strategos.terrain.*;
import strategos.units.*;

import java.util.*;


public class TestUtil {

    static Unit getMockUnit() {
    return new Unit() {
        @Override public void setBehaviour(Behaviour behaviour) {

        }

        @Override public Behaviour getBehaviour() {
            return null;
        }

        @Override public MapLocation getPosition() {
            return null;
        }

        @Override public void setPosition(MapLocation position) {

        }

        @Override public void turnTick() {

        }

        @Override public void wary() {

        }

        @Override public void entrench() {

        }

        @Override public void charge() {

        }

        @Override public boolean move(Direction direction) {
            return false;
        }

        @Override public int attack(Unit enemy) {
            return 0;
        }

        @Override public int defend(Unit enemy) {
            return 0;
        }

        @Override public int getStrength() {
            return 0;
        }

        @Override public int getToughness() {
            return 0;
        }

        @Override public UnitOwner getOwner() {
            return null;
        }

        @Override public boolean isAlive() {
            return false;
        }

        @Override public int getSightRadius() {
            return 0;
        }

        @Override public int getActionPoints() {
            return 0;
        }

        @Override public Unit copyUnit() {
            return null;
        }
    };
}

    static GameState getMockGameState() {
    return new GameState() {
        @Override public void addObserver(Observer o) {

        }

        @Override public void setChanged() {

        }

        @Override public boolean hasChanged() {
            return false;
        }

        @Override public void notifyObservers(Object o) {

        }

        @Override public void save() {

        }

        @Override public void load(SaveInstance toRestore) {

        }

        @Override public Unit getUnitAt(MapLocation location) {
            return null;
        }

        @Override
        public void move(Unit unit, Direction direction, int amount) {

        }

        @Override public void attack(Unit unit, int targetX, int targetY) {

        }

        @Override public void attack(Unit unit, MapLocation location) {

        }

        @Override public void wary(Unit unit) {

        }

        @Override public void entrench(Unit unit) {

        }

        @Override
        public List<Unit> getUnitsInRange(MapLocation location, int range) {
            return null;
        }

        @Override public Terrain getTerrainAt(MapLocation location) {
            return null;
        }

        @Override
        public List<MapLocation> getTilesInRange(
                MapLocation location,
                int range
        )
        {
            return null;
        }

        @Override public void nextTurn() {

        }

        @Override public GameCollections getWorld() {
            return null;
        }

        @Override public ArrayList<UnitOwner> getPlayers() {
            return null;
        }

        @Override public List<SaveInstance> getSaves() {
            return null;
        }

        @Override public UnitOwner getCurrentTurn() {
            return null;
        }
    };
}
}
