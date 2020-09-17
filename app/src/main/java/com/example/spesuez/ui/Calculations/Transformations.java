package com.example.spesuez.ui.Calculations;

import android.os.Build;

import java.io.StreamCorruptedException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Transformations {
	// length
	public enum LenghthUnit {
		m, mm, cm, dm, km, inch, foot
	}

	private HashMap<LenghthUnit, Double> length_map = new HashMap<LenghthUnit, Double>();

	private double getLengthInMetre(LenghthUnit lenghthUnit) {
		return length_map.get(lenghthUnit);
	}

	public double getLength(double number, LenghthUnit inputUnit, LenghthUnit outputunit) {
		double l = number * getLengthInMetre(inputUnit) / getLengthInMetre(outputunit);
		return l;
	}

	// volume
	public enum VolumeUnit {
		m3, mm3, cm3, litre, gallon_us, gallon_uk, inch3, foot3, barrel, acre_foot, pint_us
	}

	private HashMap<VolumeUnit, Double> volume_map = new HashMap<VolumeUnit, Double>();

	private double getVolumeInMetre3(VolumeUnit volumeUnit) {
		return volume_map.get(volumeUnit);
	}

	public double getVolume(double number, VolumeUnit inputUnit, VolumeUnit outputunit) {
		double l = number * getVolumeInMetre3(inputUnit) / getVolumeInMetre3(outputunit);
		return l;

	}

	// Area
	public enum AreaUnit {
		m2, mm2, cm2, dm2, Acre, Ground, Cent, inch2, foot2, hectare, darci, mdarci
	}

	private HashMap<AreaUnit, Double> area_map = new HashMap<AreaUnit, Double>();

	private double getVolumeInMetre2(AreaUnit areaUnit) {
		return area_map.get(areaUnit);
	}

	public double getArea(double number, AreaUnit inputUnit, AreaUnit outputunit) {
		double l = number * getVolumeInMetre2(inputUnit) / getVolumeInMetre2(outputunit);
		return l;
	}

	// Temperature
	public enum TemperatureUnit {
		K, F, C, R
	}

	private HashMap<TemperatureUnit, Double> temperature_map = new HashMap<TemperatureUnit, Double>();

	private double getTemperatureInKelvin(TemperatureUnit temperatureUnit) {
		return temperature_map.get(temperatureUnit);
	}

	public double getTemberature(double number, TemperatureUnit inputUnit, TemperatureUnit outputunit) {
		if (inputUnit == TemperatureUnit.C) {
			number = number + 273.15;
		} else if (inputUnit == TemperatureUnit.F) {
			number = number + 459.67;

		}
		double l = number * getTemperatureInKelvin(inputUnit) / getTemperatureInKelvin(outputunit);
		if (outputunit == TemperatureUnit.C) {
			l = l - 273.15;
		} else if (outputunit == TemperatureUnit.F) {
			l = l - 459.67;
		}
		return l;
	}

	public enum TimeUnit {
		sec, min, hr, day, month, year
	}
	// Time

	private HashMap<TimeUnit, Double> timeMap = new HashMap<TimeUnit, Double>();

	private double getTimeInsec(TimeUnit timeUnit) {
		return timeMap.get(timeUnit);
	}

	public double gettime(double number, TimeUnit inputUnit, TimeUnit outputunit) {
		double l = number * getTimeInsec(inputUnit) / getTimeInsec(outputunit);
		return l;
	}

	// mass-force
	public enum Mass_ForceUnit {
		Kg, g, N, Ib, slug
	}

	private HashMap<Mass_ForceUnit, Double> mass_forceMap = new HashMap<Mass_ForceUnit, Double>();

	private double getMass_forceInN(Mass_ForceUnit mass_forceUnit) {
		return mass_forceMap.get(mass_forceUnit);
	}

	public double getmass_force(double number, Mass_ForceUnit inputUnit, Mass_ForceUnit outputunit) {
		double l = number * getMass_forceInN(inputUnit) / getMass_forceInN(outputunit);
		return l;
	}

	// pressure
	public enum PressureUnit {
		Pa, bar, mmHg, cmHg, atm, kg_per_cm2, psi, mm_H2O
	}

	private HashMap<PressureUnit, Double> pressureMap = new HashMap<PressureUnit, Double>();

	private double getPressureInPa(PressureUnit pressureUnit) {
		return pressureMap.get(pressureUnit);
	}

	public double getpressure(double number, PressureUnit inputUnit, PressureUnit outputunit) {
		double l = number * getPressureInPa(inputUnit) / getPressureInPa(outputunit);
		return l;
	}

	// viscosity
	public enum ViscosityUnit {
		Pa_s, Poise, c_Poise
	}

	private HashMap<ViscosityUnit, Double> viscosityMap = new HashMap<ViscosityUnit, Double>();

	private double getViscosityInPa_s(ViscosityUnit viscosityUnit) {
		return viscosityMap.get(viscosityUnit);
	}

	public double getviscosity(double number, ViscosityUnit inputUnit, ViscosityUnit outputunit) {
		double l = number * getViscosityInPa_s(inputUnit) / getViscosityInPa_s(outputunit);
		return l;
	}

	//
	public enum PressureGradintAndDensitytUnit {
		N_per_m3, g_per_cm3, Ib_per_ft3, ppg, Kg_Per_cm2m, Kg_per_m3, Psi_per_ft, Ib_per_in3
	}

	private HashMap<PressureGradintAndDensitytUnit, Double> pressure_gradien_densitytMap = new HashMap<PressureGradintAndDensitytUnit, Double>();

	private double getPressure_gradientInN_m3(PressureGradintAndDensitytUnit PressureGradintAndDensitytUnit) {
		return pressure_gradien_densitytMap.get(PressureGradintAndDensitytUnit);
	}

	public double getpressure_gradient(double number, PressureGradintAndDensitytUnit inputUnit,
			PressureGradintAndDensitytUnit outputunit) {
		double l = number * getPressure_gradientInN_m3(inputUnit) / getPressure_gradientInN_m3(outputunit);
		return l;
	}

	// flow
	public enum FlowUnit {
		m3_per_sec, cm3_per_sec, barrel_per_day, ft3_per_hr, ft3_per_day,barellel_per_year
	}

	private HashMap<FlowUnit, Double> flowMap = new HashMap<FlowUnit, Double>();

	private double getFlowInm3_sec(FlowUnit flowUnit) {
		return flowMap.get(flowUnit);
	}

	public double getflow(double number, FlowUnit inputUnit, FlowUnit outputunit) {
		double l = number * getFlowInm3_sec(inputUnit) / getFlowInm3_sec(outputunit);
		return l;
	}
	
	// general
	public String[] getUnits(String unit_system) {
		
		if (unit_system.equalsIgnoreCase("Length")) {
			return keysToArrayConventer(length_map);
		} else if (unit_system.equalsIgnoreCase("area")) {
			return keysToArrayConventer(area_map);
			
		}else if (unit_system.equalsIgnoreCase("volume")) {
			return keysToArrayConventer(volume_map);

		}else if (unit_system.equalsIgnoreCase("Viscosity")) {
			return keysToArrayConventer(viscosityMap);

		}else if (unit_system.equalsIgnoreCase("Mass and force")) {
			return keysToArrayConventer(mass_forceMap);

		}else if (unit_system.equalsIgnoreCase("Pressure")) {
			return keysToArrayConventer(pressureMap);

		}else if (unit_system.equalsIgnoreCase("Temperature")) {
			return keysToArrayConventer(temperature_map);

		}else if (unit_system.equalsIgnoreCase("Flow rate")) {
			return keysToArrayConventer(flowMap);

		}else if (unit_system.equalsIgnoreCase("Time")) {
			return keysToArrayConventer(timeMap);

		}else if (unit_system.equalsIgnoreCase("Density and pressure gradient")) {
			return keysToArrayConventer(pressure_gradien_densitytMap);
		}
		return null;
	}

	private String[] keysToArrayConventer(HashMap hashMap) {
		ArrayList<String> arrayList = new ArrayList<String>();
			hashMap.forEach((k, v) -> {
				arrayList.add(k.toString());
			});

		return arrayList.toArray(new String[0]);
	}
	
	public double get(String unit_system,double number,String input_unit,String output_unit) {
	if(unit_system.equalsIgnoreCase("Temperature")) {
		return getTemberature(number,TemperatureUnit.valueOf(input_unit) , TemperatureUnit.valueOf(output_unit));
	}else if(unit_system.equalsIgnoreCase("Pressure")) {
		return getpressure(number,PressureUnit.valueOf(input_unit) , PressureUnit.valueOf(output_unit));
	}else if(unit_system.equalsIgnoreCase("Area")) {
		return getArea(number,AreaUnit.valueOf(input_unit) , AreaUnit.valueOf(output_unit));
	}else if(unit_system.equalsIgnoreCase("Length")) {
		return getLength(number,LenghthUnit.valueOf(input_unit) , LenghthUnit.valueOf(output_unit));
	}else if(unit_system.equalsIgnoreCase("Volume")) {
		return getVolume(number,VolumeUnit.valueOf(input_unit) , VolumeUnit.valueOf(output_unit));
	}else if(unit_system.equalsIgnoreCase("Viscosity")) {
		return getviscosity(number,ViscosityUnit.valueOf(input_unit) , ViscosityUnit.valueOf(output_unit));
	}else if(unit_system.equalsIgnoreCase("Time")) {
		return gettime(number,TimeUnit.valueOf(input_unit) , TimeUnit.valueOf(output_unit));
	}else if(unit_system.equalsIgnoreCase("Density and pressure gradient")) {
		return getpressure_gradient(number,PressureGradintAndDensitytUnit.valueOf(input_unit) , PressureGradintAndDensitytUnit.valueOf(output_unit));
	}else if(unit_system.equalsIgnoreCase("Flow rate")) {
		return getflow(number,FlowUnit.valueOf(input_unit) , FlowUnit.valueOf(output_unit));
	}else if(unit_system.equalsIgnoreCase("Mass and force")) {
		return getmass_force(number,Mass_ForceUnit.valueOf(input_unit) , Mass_ForceUnit.valueOf(output_unit));
	}
	return 0;
	} 
	//general end

	//constructor
	public Transformations() {
		// length
		length_map.put(LenghthUnit.m, 1.00);
		length_map.put(LenghthUnit.cm, 0.01);
		length_map.put(LenghthUnit.mm, .001);
		length_map.put(LenghthUnit.dm, .10);
		length_map.put(LenghthUnit.km, 1000.0);
		length_map.put(LenghthUnit.inch, 0.0254);
		length_map.put(LenghthUnit.foot, 0.3048);
		// volume
		volume_map.put(VolumeUnit.m3, 1.00);
		volume_map.put(VolumeUnit.cm3, .000001);
		volume_map.put(VolumeUnit.mm3, .000000001);
		volume_map.put(VolumeUnit.litre, .0010);
		volume_map.put(VolumeUnit.gallon_us, .003785411784);
		volume_map.put(VolumeUnit.gallon_uk, 0.00454609);
		volume_map.put(VolumeUnit.inch3, 0.000016387064);
		volume_map.put(VolumeUnit.foot3, 0.028316846592);
		volume_map.put(VolumeUnit.barrel, 0.158987294928);
		volume_map.put(VolumeUnit.acre_foot, 1233.48184);
		volume_map.put(VolumeUnit.pint_us, 0.000473176473);
		// Area
		area_map.put(AreaUnit.m2, 1.00);
		area_map.put(AreaUnit.cm2, 0.0001);
		area_map.put(AreaUnit.mm2, .000001);
		area_map.put(AreaUnit.dm2, .010);
		area_map.put(AreaUnit.Acre, 4046.856);
		area_map.put(AreaUnit.Ground, 222.96751177547173);
		area_map.put(AreaUnit.Cent, 40.468564224);
		area_map.put(AreaUnit.inch2, 0.00064516);
		area_map.put(AreaUnit.foot2, 0.0929);
		area_map.put(AreaUnit.hectare, 10000.00);
		area_map.put(AreaUnit.darci, 9.869233e-13);
		area_map.put(AreaUnit.mdarci, 9.869233e-16);

		// Temperature
		temperature_map.put(TemperatureUnit.K, 1.00);
		temperature_map.put(TemperatureUnit.C, 1.00);
		temperature_map.put(TemperatureUnit.F, 5.00 / 9.00);
		temperature_map.put(TemperatureUnit.R, 5.00 / 9.00);

		// Time
		timeMap.put(TimeUnit.sec, 1.00);
		timeMap.put(TimeUnit.min, 60.00);
		timeMap.put(TimeUnit.hr, 3600.00);
		timeMap.put(TimeUnit.day, 86400.00);
		timeMap.put(TimeUnit.month, 2592000.00);
		timeMap.put(TimeUnit.year, 31536000.00);
		// force and mass
		mass_forceMap.put(Mass_ForceUnit.N, 1.00);
		mass_forceMap.put(Mass_ForceUnit.g, 0.00981);
		mass_forceMap.put(Mass_ForceUnit.Kg, 9.81);
		mass_forceMap.put(Mass_ForceUnit.Ib, 4.4482189159);
		mass_forceMap.put(Mass_ForceUnit.slug, 143.1172992729);
		// Pressure
		pressureMap.put(PressureUnit.Pa, 1.00);
		pressureMap.put(PressureUnit.bar, 100000.00);
		pressureMap.put(PressureUnit.mmHg, 133.32239);
		pressureMap.put(PressureUnit.cmHg, 1333.2239);
		pressureMap.put(PressureUnit.atm, 101325.00);
		pressureMap.put(PressureUnit.kg_per_cm2, 98067.00);
		pressureMap.put(PressureUnit.psi, 6894.757);
		pressureMap.put(PressureUnit.mm_H2O, 9.80665);
		// viscosity
		viscosityMap.put(ViscosityUnit.Pa_s, 1.00);
		viscosityMap.put(ViscosityUnit.Poise, 0.1);
		viscosityMap.put(ViscosityUnit.c_Poise, .001);
		// density and pressure gradient
		pressure_gradien_densitytMap.put(PressureGradintAndDensitytUnit.N_per_m3, 1.00);
		pressure_gradien_densitytMap.put(PressureGradintAndDensitytUnit.g_per_cm3, 9806.650);
		pressure_gradien_densitytMap.put(PressureGradintAndDensitytUnit.Ib_per_ft3, 157.08657306188);
		pressure_gradien_densitytMap.put(PressureGradintAndDensitytUnit.ppg, 1175.095863);
		pressure_gradien_densitytMap.put(PressureGradintAndDensitytUnit.Kg_Per_cm2m, 101325.00);
		pressure_gradien_densitytMap.put(PressureGradintAndDensitytUnit.Kg_per_m3, 9.8066500286389);
		pressure_gradien_densitytMap.put(PressureGradintAndDensitytUnit.Psi_per_ft, 22620.5948);
		pressure_gradien_densitytMap.put(PressureGradintAndDensitytUnit.Ib_per_in3, 278013.7805870699813);
		// Fluid Flow
		flowMap.put(FlowUnit.m3_per_sec, 1.00);
		flowMap.put(FlowUnit.cm3_per_sec, .000001);
		flowMap.put(FlowUnit.barrel_per_day, 1.840130728333333e-6);
		flowMap.put(FlowUnit.ft3_per_hr, 3.277407407407407e-7*60);
		flowMap.put(FlowUnit.ft3_per_day, 3.277407407407407e-7);
		flowMap.put(FlowUnit.barellel_per_year, 1.840130728333333e-6/365.00);
	}

	public static void main(String args[]) {
		Transformations transformations = new Transformations();
		DecimalFormat decimalFormat = new DecimalFormat("###.#######");
		System.out.println(decimalFormat.format(transformations.get("Length",1, "foot", "m")));
	}

}
