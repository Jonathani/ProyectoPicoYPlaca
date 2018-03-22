package com.picoyplaca.main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

import com.picoyplaca.negocio.ServicioVehiculo;

public class PicoYPlaca {

	public static void main(String[] args) throws ParseException {
		String licensePlateNumber;
		String date;
		String time;
		DateFormat format = new SimpleDateFormat("HH:mm:ss"); 
		ServicioVehiculo servicioVehiculo = new ServicioVehiculo();

			do{
				licensePlateNumber = JOptionPane.showInputDialog(null,
						"Introduzca su número de PLACA");
			}while(!servicioVehiculo.getPatron(licensePlateNumber));
			
			do{
				date  = JOptionPane.showInputDialog(null,
						"Introduzca el día");
			}while(!servicioVehiculo.getDate(date));			
			
			do{
				time = JOptionPane.showInputDialog(null,
						"Introduzca la hora (HH:mm:ss)");
			}while(!servicioVehiculo.getHour(time));
			Date hour = format.parse(time); 
			
			
			char ultimoDigito = licensePlateNumber.charAt(licensePlateNumber.length() - 1);
		
			
			if (servicioVehiculo.getLastDigit(ultimoDigito, date)){
				if (servicioVehiculo.getHourRestriction(hour)){
					JOptionPane.showMessageDialog(null, "Tiene restriccion vehicular");
				}else{
					JOptionPane.showMessageDialog(null, "No tiene restriccion vehicular");
				}
			}else{
				JOptionPane.showMessageDialog(null, "No tiene restriccion vehicular");
			}

			

	}

}
