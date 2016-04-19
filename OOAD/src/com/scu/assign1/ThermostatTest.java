package com.scu.assign1;

public class ThermostatTest {

	public static void main(String[] args) throws InterruptedException {
		Thermostat t1 = new Thermostat();
		assert(t1.getCurrentTemperature() == Thermostat.DEFAULT && UnitType.F.equals(t1.getUnitType()));
	
		Thermostat t2 = new Thermostat(50.0);
		assert(t2.getCurrentTemperature() ==50 && UnitType.F.equals(t2.getUnitType()));
		
		Thermostat t3 = new Thermostat(60.0, UnitType.F);
		assert(t3.getCurrentTemperature() == 60.0 && UnitType.F.equals(t3.getUnitType()));

		
		Thermostat t4 = new Thermostat(60.0, UnitType.C);
		//out of range, will default to 30F
		assert(t4.getCurrentTemperature() ==Thermostat.DEFAULT && UnitType.F.equals(t4.getUnitType()));
		
		Thermostat t5 = new Thermostat(15.0, UnitType.C);
		assert(t5.getCurrentTemperature() ==15.0 && UnitType.C.equals(t5.getUnitType()));
		
		//Test setTemperature()
		t5.setTemperature(60.0, UnitType.F);
		assert(t5.getCurrentTemperature() ==60.0 && UnitType.F.equals(t5.getUnitType()));
		t5.setTemperature(25.0, UnitType.C);
		assert(t5.getCurrentTemperature() == 25.0 && UnitType.C.equals(t5.getUnitType()));
		
		//Test displayCelcius(), displayFahrenheit(), displayTemperature()
		t5.displayCelsius();
		t5.displayFahrenheit();
		t5.displayTemperature();
		
		//Test reduce() and increase()
		t1.reduce();
		assert(t1.getCurrentTemperature() == Thermostat.DEFAULT);
		
		t2.reduce();
		assert(t2.getCurrentTemperature() == 49.0);
		t2.increase();
		assert(t2.getCurrentTemperature() == 50.0);
		
		t1.clock();
		Thread.sleep(1000);
		t2.clock();
	
	}

}
