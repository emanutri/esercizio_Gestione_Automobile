package it.gestioneautomobile.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

//nel nome della classe vi è Articolo in quanto è una classe specifica
public class UtilityAutomobileForm {

	public static boolean validateInput(String marcaInputParam, String modelloInputParam,
			String cilindrataStringParam, String dataImmatricolazioneStringParam) {
		// prima controlliamo che non siano vuoti
		if (StringUtils.isBlank(marcaInputParam) || StringUtils.isBlank(modelloInputParam)
				|| !NumberUtils.isCreatable(cilindrataStringParam) || StringUtils.isBlank(dataImmatricolazioneStringParam)) {
			return false;
		}
		return true;
	}

	public static Date parseDateImmatricolazioneFromString(String dataImmatricolazioneStringParam) {
		if (StringUtils.isBlank(dataImmatricolazioneStringParam))
			return null;

		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(dataImmatricolazioneStringParam);
		} catch (ParseException e) {
			return null;
		}
	}

}
