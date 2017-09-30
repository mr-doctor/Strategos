package strategos;

import strategos.units.Unit;

import java.util.List;

public interface UnitOwner {

	public List<Unit> getUnits();

	public List<MapLocation> getVisibleTiles();

	public boolean isNPC();

	public void setUnits(List<Unit> newUnits);

	public UnitOwner copy();
}
