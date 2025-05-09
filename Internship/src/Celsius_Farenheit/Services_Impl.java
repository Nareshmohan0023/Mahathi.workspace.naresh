package Celsius_Farenheit;

public class Services_Impl implements Services {

	@Override
	public  void Cel_to_Far(double cel) {
		double far=(cel*(1.8))+32;
		System.out.printf("the farenheit value is: %.2f",far);
		System.out.println();
	}

	@Override
	public void Far_to_Cel(double Far) {
		double cel=(Far-32)/1.8;
		System.out.printf("the celsius value is: %.2f",cel);
		System.out.println();
	}

}
