package com.example.spesuez.ui.Calculations.Flow;
import com.example.spesuez.ui.Calculations.Transformations;
public class FlowEquations {
	private Transformations transformations=new Transformations();
	
	private double getInMetricSystem(int i
			,double p1,double p2,double ps,
			double r2, double r1,double l, double h,
			double k,double area,double v,double tf,double ts,double B) {
		if(i==0||i==2) {
			return k*area*(p1-p2)/(v*l*B);
		}else if(i==1) {
			return k*area*(p1*p1-p2*p2)/(2*v*l*B*p2);
		}
		else if(i==3) {
			return k*area*(p1*p1-p2*p2)/(2*v*l*ps*B)*ts/tf;
		}else if(i==4||i==6) {
			return 2*Math.PI*k*h*(p1-p2)/(v*B*Math.log(r2/r1));
		}else if(i==5) {
			return Math.PI*k*h*(p1*p1-p2*p2)/(v*B*Math.log(r2/r1)*p2);
		}else if(i==7) {
			return (Math.PI*k*h*(p1*p1-p2*p2)/(v*B*Math.log(r2/r1)*ps)*ts/tf);
		}
	return 0;
	}
	public double getFlowRate(int i,double p1,Transformations.PressureUnit pressureUnit,
			double p2,Transformations.PressureUnit pressureUnit2,double ps,Transformations.PressureUnit pressureUnit3,
			double r2, Transformations.LenghthUnit lenghthUnit,double r1, Transformations.LenghthUnit lenghthUnit2,
			double l, Transformations.LenghthUnit lenghthUnit3,double h,Transformations.LenghthUnit lenghthUnit4,
			double k ,Transformations.AreaUnit areaUnit,double area ,Transformations.AreaUnit areaUnit2,
			double v ,Transformations.ViscosityUnit viscosityUnit,double tf ,
			Transformations.TemperatureUnit temperatureUnit,double ts ,Transformations.TemperatureUnit temperatureUnit2
			,double B,Transformations.FlowUnit flowUnit) {
		double q=getInMetricSystem(i,transformations.getpressure(p1, pressureUnit,Transformations.PressureUnit.Pa), 
				transformations.getpressure(p2, pressureUnit2,Transformations.PressureUnit.Pa),
				transformations.getpressure(ps, pressureUnit3,Transformations.PressureUnit.Pa),
				transformations.getLength(r2, lenghthUnit,Transformations.LenghthUnit.m),
				transformations.getLength(r1, lenghthUnit2,Transformations.LenghthUnit.m),
				transformations.getLength(l, lenghthUnit3,Transformations.LenghthUnit.m),
				transformations.getLength(h,lenghthUnit4,Transformations.LenghthUnit.m),
				transformations.getArea(k, areaUnit, Transformations.AreaUnit.m2),
				transformations.getArea(area, areaUnit2, Transformations.AreaUnit.m2),
				transformations.getviscosity(v, viscosityUnit,Transformations.ViscosityUnit.Pa_s ),
				transformations.getTemberature(tf, temperatureUnit, Transformations.TemperatureUnit.R),
				transformations.getTemberature(ts, temperatureUnit2, Transformations.TemperatureUnit.R),
				B);
		return transformations.getflow(q, Transformations.FlowUnit.m3_per_sec, flowUnit);
	}
	
	
}
