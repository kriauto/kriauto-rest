package ma.kriauto.rest.batch;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ma.kriauto.rest.domain.Car;
import ma.kriauto.rest.domain.Location;
import ma.kriauto.rest.domain.Notification;
import ma.kriauto.rest.service.CarService;
import ma.kriauto.rest.service.NotificationService;
import ma.kriauto.rest.service.SenderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
 
@Configuration
@EnableScheduling
public class SpringEnableSchedulingExample {
	
	@Autowired
	CarService carservice;
	
	@Autowired
	SenderService senderservice;
	
	@Autowired
	NotificationService notificationservice;
 
	@Scheduled(fixedDelay = 60000)
    public void executeStopEngine() {
        System.out.println("Start Start/Stop Job " + new Date());
        List<Notification> notifs = carservice.getDataNotification(1);
        for(int i =0; i < notifs.size() ; i++){
        	Notification notif = notifs.get(i);
        	Location location = carservice.getLastLocationByCar(notif.getDeviceid());
        	if(null != location && location.getSpeed() <= 10){
        		String message = "voiture arrete "+notif.getMark()+notif.getModel()+notif.getColor()+notif.getImmatriculation();
        		senderservice.sendSms("KriAuto.ma", notif.getSimnumber(), "stop135791");
        		try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		senderservice.sendSms("KriAuto.ma", notif.getPhone(), message);
        		Car car = carservice.getCarByDevice(notif.getDeviceid());
        		car.setStatus(1);
        		carservice.updateCar(car);
        		notif.setTexte(message);
        		notificationservice.addNotification(notif);
        		System.out.println(message);
        	}
        }
        System.out.println("End Start/Stop Job " + new Date());
    }
	
//	@Scheduled(fixedDelay = 120000)
//    public void executeDefaultGeoFence() {
//        System.out.println("Start Sortie Territoire Job "+new Date());
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Calendar now1 = Calendar.getInstance();
//	    now1.add(Calendar.DAY_OF_YEAR, -120);
//	    Date now2 = now1.getTime(); 
//	    String time = df.format(now2);
//        List<Notification> notifs = carservice.getDataNotification(3);
//        for(int i =0; i < notifs.size() ; i++){
//        	Notification notif = notifs.get(i);
//        	List<Location> locations = carservice.getAllLocationByCarTime(notif.getDeviceid(), time);
//        	for(int j=0 ; j<locations.size() ; j++){
//        		Location location = locations.get(j);
//        		if(isInCeuta(location.getLatitude(), location.getLongitude())){
//        			String message = "La"+notif.getMark()+notif.getModel()+notif.getColor()+notif.getImmatriculation()+"est+a+ceuta";
//        			senderservice.sendSms("KriAuto.ma", notif.getPhone(), message);
//            		Car car = carservice.getCarByDevice(notif.getDeviceid());
//            		car.setIsnotifdefaultgeofence(true);
//            		carservice.updateCar(car);
//            		notif.setTexte(message);
//            		notificationservice.addNotification(notif);
//            		System.out.println(message);
//            		break;
//        		}
//        		if(isInMelilea(location.getLatitude(), location.getLongitude())){
//        			String message = "La"+notif.getMark()+notif.getModel()+notif.getColor()+notif.getImmatriculation()+"est+a+melilia";
//        			senderservice.sendSms("KriAuto.ma", notif.getPhone(), message);
//            		Car car = carservice.getCarByDevice(notif.getDeviceid());
//            		car.setIsnotifdefaultgeofence(true);
//            		carservice.updateCar(car);
//            		notif.setTexte(message);
//            		notificationservice.addNotification(notif);
//            		System.out.println(message);
//            		break;
//        		}
//        		if(isInAlgerie(location.getLatitude(), location.getLongitude())){
//        			String message = "La"+notif.getMark()+notif.getModel()+notif.getColor()+notif.getImmatriculation()+"est+en+algerie";
//        			senderservice.sendSms("KriAuto.ma", notif.getPhone(), message);
//            		Car car = carservice.getCarByDevice(notif.getDeviceid());
//            		car.setIsnotifdefaultgeofence(true);
//            		carservice.updateCar(car);
//            		notif.setTexte(message);
//            		notificationservice.addNotification(notif);
//            		System.out.println(message);
//            		break;
//        		}
//        		if(isInMauritanie(location.getLatitude(), location.getLongitude())){
//        			String message = "La"+notif.getMark()+notif.getModel()+notif.getColor()+notif.getImmatriculation()+"est+en+mauritanie";
//        			senderservice.sendSms("KriAuto.ma", notif.getPhone(), message);
//            		Car car = carservice.getCarByDevice(notif.getDeviceid());
//            		car.setIsnotifdefaultgeofence(true);
//            		carservice.updateCar(car);
//            		notif.setTexte(message);
//            		notificationservice.addNotification(notif);
//            		System.out.println(message);
//            		break;
//        		}
//        	}
//        }
//        System.out.println("End Sortie Territoire Job " + new Date());
//    }
//	
//	@Scheduled(fixedDelay = 180000)
//    public void executeGeoFence() {
//        System.out.println("Start Sortie Zone Job "+new Date());
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Calendar now1 = Calendar.getInstance();
//	    now1.add(Calendar.DAY_OF_YEAR, -120);
//	    Date now2 = now1.getTime();
//	    String time = df.format(now2);
//        List<Notification> notifs = carservice.getDataNotification(2);
//        for(int i =0; i < notifs.size() ; i++){
//        	Notification notif = notifs.get(i);
//        	List<Location> locations = carservice.getAllLocationByCarTime(notif.getDeviceid(), time);
//        	for(int j=0 ; j<locations.size() ; j++){
//        		Location location = locations.get(j);
//        		if(!isInZone(notif, location.getLatitude(), location.getLongitude())){
//        			String message = "La"+notif.getMark()+notif.getModel()+notif.getColor()+notif.getImmatriculation()+"a+quitter+la+zone+virtuelle";
//        			senderservice.sendSms("KriAuto.ma", notif.getPhone(), message);
//            		Car car = carservice.getCarByDevice(notif.getDeviceid());
//            		car.setIsnotifgeofence(true);
//            		carservice.updateCar(car);
//            		notif.setTexte(message);
//            		notificationservice.addNotification(notif);
//            		System.out.println(message);
//            		break;
//        		}
//        	}
//        }
//        System.out.println("End Sortie Zone Job " +new Date());
//    }
//	
//	@Scheduled(cron = "59 59 23 * * *")
//    public void executeInitGeFence() {
//        System.out.println("Start Init GeFence " + new Date());
//        carservice.initGeoFence();
//        System.out.println("End Init GeFence " + new Date());
//    }
//	
//	public boolean isInZone(Notification notif, double lat, double lon) {
//		int j=0;
//        boolean inBound = false;
//        double x = lon;
//        double y = lat;
//        if(null != notif.getLatitude1() && null != notif.getLongitude1() && null != notif.getLatitude2() && null != notif.getLongitude2() && null != notif.getLatitude3() && null != notif.getLongitude3() && null != notif.getLatitude4() && null != notif.getLongitude4() && null != notif.getLatitude5() && null != notif.getLongitude5() && null != notif.getLatitude6() && null != notif.getLongitude6()){
//         double zone[][]  = {{notif.getLatitude1(),notif.getLongitude1()},{notif.getLatitude2(),notif.getLongitude2()},{notif.getLatitude3(),notif.getLongitude3()},{notif.getLatitude4(),notif.getLongitude4()},{notif.getLatitude5(),notif.getLongitude5()},{notif.getLatitude6(),notif.getLongitude6()}};
//         for (int i=0; i < 4 ; i++) {
//          j++;
//          if (j == 4) {j = 0;}
//          if (((zone[i][0] < y) && (zone[j][0]  >= y)) || ((zone[j][0] < y) && (zone[i][0] >= y))) {
//            if ( zone[i][1] + (y - zone[i][0])/(zone[j][0]-zone[i][0])*(zone[j][1] - zone[i][1])<x ) 
//               {
//            	inBound = !inBound;
//               }
//            }
//         } 
//        }
//	    return inBound;
//	}
//	
//	public boolean isInCeuta(double lat, double lon) {
//		int j=0;
//        boolean inBound = false;
//        double x = lon;
//        double y = lat;
//        double ceuta[][]  = {{35.912663,-5.382453},{35.896116,-5.378333},{35.880818,-5.371639},{35.868856,-5.344344},{35.899315,-5.261947},{35.933793,-5.379192}};
//        for (int i=0; i < 4 ; i++) {
//          j++;
//          if (j == 4) {j = 0;}
//          if (((ceuta[i][0] < y) && (ceuta[j][0]  >= y)) || ((ceuta[j][0] < y) && (ceuta[i][0] >= y))) {
//            if ( ceuta[i][1] + (y - ceuta[i][0])/(ceuta[j][0]-ceuta[i][0])*(ceuta[j][1] - ceuta[i][1])<x ) 
//               {
//            	inBound = !inBound;
//               }
//            }
//        }
//	    return inBound;
//	}
//	
//	public boolean isInMauritanie(double lat, double lon) {
//		int j=0;
//        boolean inBound = false;
//        double x = lon;
//        double y = lat;
//        double ceuta[][]  = {{21.333039,-13.014105},{21.333039,-16.940144},{20.784382,-17.064262},{21.284352,-16.914014},{21.284352,-13.014105}};
//        for (int i=0; i < 4 ; i++) {
//          j++;
//          if (j == 4) {j = 0;}
//          if (((ceuta[i][0] < y) && (ceuta[j][0]  >= y)) || ((ceuta[j][0] < y) && (ceuta[i][0] >= y))) {
//            if ( ceuta[i][1] + (y - ceuta[i][0])/(ceuta[j][0]-ceuta[i][0])*(ceuta[j][1] - ceuta[i][1])<x ) 
//               {
//            	inBound = !inBound;
//               }
//            }
//        }
//	    return inBound;
//	}
//	
//	public boolean isInMelilea(double lat, double lon) {
//		int j=0;
//        boolean inBound = false;
//        double x = lon;
//        double y = lat;
//        double ceuta[][]  = {{35.319974,-2.952852},{35.316266,-2.960067},{35.288948,-2.970539},{35.265965,-2.950454},{35.271992,-2.929511},{35.295818,-2.913552}};
//        for (int i=0; i < 4 ; i++) {
//          j++;
//          if (j == 4) {j = 0;}
//          if (((ceuta[i][0] < y) && (ceuta[j][0]  >= y)) || ((ceuta[j][0] < y) && (ceuta[i][0] >= y))) {
//            if ( ceuta[i][1] + (y - ceuta[i][0])/(ceuta[j][0]-ceuta[i][0])*(ceuta[j][1] - ceuta[i][1])<x ) 
//               {
//            	inBound = !inBound;
//               }
//            }
//        }
//	    return inBound;
//	}
//	
//	public boolean isInAlgerie(double lat, double lon) {
//		int j=0;
//        boolean inBound = false;
//        double x = lon;
//        double y = lat;
//        double ceuta[][]  = {{34.936012,-1.973600},{34.879471,-1.972144},{34.842021,-1.893973},{34.806529,-1.888122},{34.802300,-1.859627},{34.743703,-1.739356},{34.855287, -1.860319}};
//        for (int i=0; i < 4 ; i++) {
//          j++;
//          if (j == 4) {j = 0;}
//          if (((ceuta[i][0] < y) && (ceuta[j][0]  >= y)) || ((ceuta[j][0] < y) && (ceuta[i][0] >= y))) {
//            if ( ceuta[i][1] + (y - ceuta[i][0])/(ceuta[j][0]-ceuta[i][0])*(ceuta[j][1] - ceuta[i][1])<x ) 
//               {
//            	inBound = !inBound;
//               }
//            }
//        }
//	    return inBound;
//	}
}
