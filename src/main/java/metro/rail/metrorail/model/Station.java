package metro.rail.metrorail.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Station {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name="station_name")
	private String stationName;
	
	@Column(name="station_sequence")
	private int stationSequence;

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public int getStationSequence() {
		return stationSequence;
	}

	public void setStationSequence(int stationSequence) {
		this.stationSequence = stationSequence;
	}
}
