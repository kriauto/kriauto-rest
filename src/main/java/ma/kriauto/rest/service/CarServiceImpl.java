package ma.kriauto.rest.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date today = Calendar.getInstance().getTime();        
		String date = df.format(today);
		List<Car> cars = cardao.getAllCarsByToken(group, token);
		for(int j = 0; j < cars.size() ; j++){
			double speed = 0, cours=0;
			Car car = getCarByDevice(cars.get(j).getDeviceid(),token);		
			List<Location> locations = getAllLocationsByCar(cars.get(j).getDeviceid(),date, token);
			
			for(int i =0; i < locations.size(); i++){
				if(locations.get(i).getSpeed() < 97 && locations.get(i).getSpeed() > speed){
					speed = locations.get(i).getSpeed();
				}
				if( i != 0){
				  double dist = cardao.distance(locations.get(i-1).getLatitude(), locations.get(i-1).getLongitude(), locations.get(i).getLatitude(), locations.get(i).getLongitude(), 'K');
				  if(dist <= 1){
				    cours = cours + dist;
				  }
				}
			}

			if(cours > 0){
				cars.get(j).setConsumption((double)Math.round(((cours/100)*car.getConsumption())*100)/100);
				cars.get(j).setSpeed((double)Math.round((speed*1.85)*100)/100);
				cars.get(j).setCourse((double)Math.round((cours)*100)/100);
			}else{
				cars.get(j).setConsumption(0.0);
				cars.get(j).setSpeed(0.0);
				cars.get(j).setCourse(0.0);
			}
		}
		return cars;
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

//	@Override
//	public Location getLastPositionByCar(Integer deviceid) {
//		// TODO Auto-generated method stub
//		return cardao.getLastLocationByCar(deviceid);
//	}

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
	public Location getLastLocationByCar(Integer deviceid,String token) {
		// TODO Auto-generated method stub
		return cardao.getLastLocationByCar(deviceid,token);
	}
}
