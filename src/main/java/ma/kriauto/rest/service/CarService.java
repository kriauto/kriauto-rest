package ma.kriauto.rest.service;

import java.util.List;

import ma.kriauto.rest.domain.Car;
import ma.kriauto.rest.domain.Consumption;
import ma.kriauto.rest.domain.Course;
import ma.kriauto.rest.domain.Event;
import ma.kriauto.rest.domain.Item;
import ma.kriauto.rest.domain.Location;
import ma.kriauto.rest.domain.Notification;
import ma.kriauto.rest.domain.Speed;
import ma.kriauto.rest.domain.Statistic;

public interface CarService {
	public Car getCarByDevice(Integer deviceid);
	public void updateCar(Car car);
	public List<Car> getAllCarsByToken(boolean group, String token);
	public List<Item> getAllDatesByCar(Integer deviceid);
	public List<Item> getAllDatesByToken(String token);
	public List<Location> getAllLocationsByToken(String token, String date);
	public List<Location> getAllLocationsByCar(Integer deviceid, String date);
	public List<Course> getTotalCourseByCar(Integer deviceid);
	public List<Speed> getMaxSpeedByCar(Integer deviceid);
	public List<Consumption> getTotalConsumptionByCar(Integer deviceid);
	public Statistic getCarStatistic(Integer deviceid, String date);
	public List<Notification> getDataNotification(int type);
	public Location getLastPositionByCar(Integer deviceid);
	public List<Location> getAllLocationByCarTime(Integer deviceid, String time);
	public void initGeoFence();
	public Event getLastEvent(Integer deviceid, String date);
	public List<Location> getLocationsBefore(Integer deviceid, Integer to, String date);
	public List<Location> getLocationsAfter(Integer deviceid, Integer from, String date);
	public List<Location> getLocationsByDate(Integer deviceid, String date);
	public List<Location> getLocationsBetween(Integer deviceid, Integer from, Integer to, String date);
	public Location getLocationById(Integer id);
	public Location getLastLocationByCar(Integer deviceid, String date);
	public Location getLastLocationByCar(Integer deviceid);
	public String getGoodleAdresse(Double Lat, Double Lng);
	public Event getLastEvent(Integer deviceid);
}
