package ma.kriauto.rest.service;

import java.util.List;

import ma.kriauto.rest.dao.CarDao;
import ma.kriauto.rest.domain.Car;
import ma.kriauto.rest.domain.Consumption;
import ma.kriauto.rest.domain.Course;
import ma.kriauto.rest.domain.Event;
import ma.kriauto.rest.domain.Item;
import ma.kriauto.rest.domain.Location;
import ma.kriauto.rest.domain.Notification;
import ma.kriauto.rest.domain.Speed;
import ma.kriauto.rest.domain.Statistic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("carService")
public class CarServiceImpl implements CarService {
	
	@Autowired
	CarDao cardao;
	
	@Override
	public Car getCarByDevice(Integer deviceid, String token) {
		// TODO Auto-generated method stub
		return cardao.getCarByDevice(deviceid,token);
	}
	
	@Override
	public void updateCar(Car car) {
		// TODO Auto-generated method stub
		cardao.updateCar(car);
	}

	@Override
	public List<Car> getAllCarsByToken(boolean group, String token) {
		// TODO Auto-generated method stub
		return cardao.getAllCarsByToken(group, token);
	}

	@Override
	public List<Item> getAllDatesByCar(Integer deviceid) {
		// TODO Auto-generated method stub
		return cardao.getAllDatesByCar(deviceid);
	}
	
	@Override
	public List<Item> getAllDatesByToken(String token) {
		// TODO Auto-generated method stub
		return cardao.getAllDatesByToken(token);
	}

	@Override
	public List<Location> getAllLocationsByToken(String token, String date) {
		// TODO Auto-generated method stub
		return cardao.getAllLocationsByToken(token,date);
	}

	@Override
	public List<Location> getAllLocationsByCar(Integer deviceid, String date, String token) {
		// TODO Auto-generated method stub
		return cardao.getAllLocationsByCar(deviceid,date,token);
	}

	@Override
	public List<Course> getTotalCourseByCar(Integer deviceid) {
		// TODO Auto-generated method stub
		return cardao.getTotalCourseByCar(deviceid);
	}

	@Override
	public List<Speed> getMaxSpeedByCar(Integer deviceid) {
		// TODO Auto-generated method stub
		return cardao.getMaxSpeedByCar(deviceid);
	}

	@Override
	public List<Consumption> getTotalConsumptionByCar(Integer deviceid) {
		// TODO Auto-generated method stub
		return cardao.getTotalConsumptionByCar(deviceid);
	}

	@Override
	public Statistic getCarStatistic(Integer deviceid, String date, String token) {
		// TODO Auto-generated method stub
		return cardao.getCarStatistic(deviceid, date,token);
	}

	@Override
	public List<Notification> getDataNotification(int type) {
		// TODO Auto-generated method stub
		return cardao.getDataNotification(type);
	}

	@Override
	public Location getLastPositionByCar(Integer deviceid) {
		// TODO Auto-generated method stub
		return cardao.getLastLocationByCar(deviceid);
	}

	@Override
	public List<Location> getAllLocationByCarTime(Integer deviceid, String time) {
		// TODO Auto-generated method stub
		return cardao.getAllLocationByCarTime(deviceid, time);
	}

	@Override
	public void initGeoFence() {
		// TODO Auto-generated method stub
		cardao.initGeoFence();
	}

	@Override
	public Event getLastEvent(Integer deviceid, String date) {
		// TODO Auto-generated method stub
		return cardao.getLastEvent(deviceid, date);
	}

	@Override
	public List<Location> getLocationsBefore(Integer deviceid, Integer to, String date) {
		// TODO Auto-generated method stub
		return cardao.getLocationsBefore(deviceid, to, date);
	}

	@Override
	public List<Location> getLocationsAfter(Integer deviceid, Integer from, String date) {
		// TODO Auto-generated method stub
		return cardao.getLocationsAfter(deviceid, from, date);
	}

	@Override
	public List<Location> getLocationsByDate(Integer deviceid, String date) {
		// TODO Auto-generated method stub
		return cardao.getLocationsByDate(deviceid, date);
	}

	@Override
	public List<Location> getLocationsBetween(Integer deviceid, Integer from,
			Integer to, String date) {
		// TODO Auto-generated method stub
		return cardao.getLocationsBetween(deviceid, from, to, date);
	}

	@Override
	public Location getLocationById(Integer id) {
		// TODO Auto-generated method stub
		return cardao.getLocationById(id);
	}

	@Override
	public Location getLastLocationByCar(Integer deviceid, String date, String token) {
		// TODO Auto-generated method stub
		return cardao.getLastLocationByCar(deviceid,date,token);
	}

	@Override
	public String getGoodleAdresse(Double Lat, Double Lng) {
		// TODO Auto-generated method stub
		return cardao.getGoodleAdresse(Lat, Lng);
	}

	@Override
	public Event getLastEvent(Integer deviceid) {
		// TODO Auto-generated method stub
		return cardao.getLastEvent(deviceid);
	}

	@Override
	public Location getLastLocationByCar(Integer deviceid) {
		// TODO Auto-generated method stub
		return cardao.getLastLocationByCar(deviceid);
	}
}
