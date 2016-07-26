package Labs;
import java.util.*;
public class haversine 
{
	public static final double R = 6372.8; //Radius of the Earth
	public static void main(String[] args)
	{
		//double myLat = 53.3807;
		//double myLong = -6.594596;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your latitude:");
		double myLat = scan.nextDouble();
		System.out.println("Enter your longitude:");
		double myLong = scan.nextDouble();
		double statueLat = 40.6892494;
		double statueLong = -74.0445004;
		System.out.println("Distance between current location and the Statue of Liberty is:");
		System.out.println(distance(myLat, myLong, statueLat, statueLong)+"km");
	}
	public static double distance(double lat1, double long1, double lat2, double long2)
	{
		double dLat = Math.toRadians(lat2 - lat1);
		double dLong = Math.toRadians(long2 - long1);
		lat1 = Math.toRadians(lat1);
		lat2 = Math.toRadians(lat2);
		
		double d = Math.sin(dLat/2) * Math.sin(dLat/2)+Math.sin(dLong/2) *
					Math.sin(dLong/2)*Math.cos(lat1)*Math.cos(lat2);
		double h = 2 * Math.asin(Math.sqrt(d));
		return R * h;
	}
}
