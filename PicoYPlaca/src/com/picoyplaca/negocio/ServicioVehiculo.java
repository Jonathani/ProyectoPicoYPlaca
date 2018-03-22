package com.picoyplaca.negocio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class ServicioVehiculo {

	public boolean getHourRestriction(Date time) {
		System.out.println(time);
		boolean restriction = false;
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

		String hour1 = "07:00:00";
		String hour2 = "09:30:00";
		String hour3 = "16:00:00";
		String hour4 = "19:30:00";
		String currentTime = dateFormat.format(time);

		if ((hour1.compareTo(currentTime) <= 0)
				&& (hour2.compareTo(currentTime) >= 0)
				|| (hour3.compareTo(currentTime) <= 0)
				&& (hour4.compareTo(currentTime) >= 0)) {
			restriction = true;
		} else {
			restriction = false;
		}
		return restriction;
	}

	public boolean getPatron(String licensePlateNumber) {
		boolean patron = false;
		String patron1 = "[A-Z][A-Z][A-Z][-][0-9][0-9][0-9][0-9]";
		String patron2 = "[A-Z][A-Z][A-Z][-][0-9][0-9][0-9]";

		Pattern pat = Pattern.compile(patron1);
		Matcher mat = pat.matcher(licensePlateNumber);

		Pattern pat2 = Pattern.compile(patron2);
		Matcher mat2 = pat2.matcher(licensePlateNumber);

		if (mat.matches() || mat2.matches()) {
			patron = true;
		} else {
			JOptionPane.showMessageDialog(null, "Placa no valida");
			patron = false;
		}
		return patron;
	}

	public boolean getHour(String hour) {
		boolean patron = false;

		String patron1 = "[0-2][0-9][:][0-5][0-9][:][0-5][0-9]";

		Pattern pat = Pattern.compile(patron1);
		Matcher mat = pat.matcher(hour);

		if (mat.matches()) {
			patron = true;
		} else {
			JOptionPane.showMessageDialog(null, "Hora no valida");
			patron = false;
		}
		return patron;
	}

	public boolean getDate(String date) {
		boolean resp = false;
		if (date.toLowerCase().equals("lunes")
				|| date.toLowerCase().equals("martes")
				|| date.toLowerCase().equals("miercoles")
				|| date.toLowerCase().equals("jueves")
				|| date.toLowerCase().equals("viernes")) {
			resp = true;
		} else {
			JOptionPane.showMessageDialog(null,
					"Ingresar correctamente el día sin espacios");
			resp = false;
		}
		return resp;
	}

	public boolean getLastDigit(char lastDigit, String day) {
		boolean restriction = false;
		switch (lastDigit) {
		case '1':
		case '2':
			if (day.toLowerCase().equals("lunes")) {
				restriction = true;
			}
			break;
		case '3':
		case '4':
			if (day.toLowerCase().equals("martes")) {
				restriction = true;
			}
			break;
		case '5':
		case '6':
			if (day.toLowerCase().equals("miercoles")) {
				restriction = true;
			}
			break;
		case '7':
		case '8':
			if (day.toLowerCase().equals("jueves")) {
				restriction = true;
			}
			break;
		case '9':
		case '0':
			if (day.toLowerCase().equals("viernes")) {
				restriction = true;
			}
			break;
		}
		return restriction;
	}

}
