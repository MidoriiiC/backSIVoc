package fr.iutparis8.CSID.backSIVoc.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.iutparis8.CSID.backSIVoc.DTO.EvenementDTO;

@Service
public class EvenementService {

	private List<EvenementDTO> fake = new ArrayList<EvenementDTO>();
	
	public EvenementService() {
		this.fake.add(new EvenementDTO(1, "Misa - Tiempo Pascual", "1 In principio creavit Deus caelum et terram.\n" + 
				"2 Terra autem erat inanis et vacua, et tenebrae super faciem abyssi, et spiritus Dei ferebatur super aquas.\n" + 
				"3 Dixitque Deus: “Fiat lux”. Et facta est lux.\n" + 
				"4 Et vidit Deus lucem quod esset bona et divisit Deus lucem ac tenebras.\n" + 
				"5 Appellavitque Deus lucem Diem et tenebras Noctem. Factumque est vespere et mane, dies unus.\n" + 
				"6 Dixit quoque Deus: “Fiat firmamentum in medio aquarum et dividat aquas ab aquis”.\n" + 
				"7 Et fecit Deus firmamentum divisitque aquas, quae erant sub firmamento, ab his, quae erant super firmamentum. Et factum est ita.\n" + 
				"8 Vocavitque Deus firmamentum Caelum. Et factum est vespere et mane, dies secundus.\n" + 
				"9 Dixit vero Deus: “Congregentur aquae, quae sub caelo sunt, in locum unum, et appareat arida”. Factumque est ita.\n" + 
				"10 Et vocavit Deus aridam Terram congregationesque aquarum appellavit Maria. Et vidit Deus quod esset bonum.\n" + 
				"11 Et ait Deus: “Germinet terra herbam virentem et herbam facientem semen et lignum pomiferum faciens fructum iuxta genus suum, cuius semen in semetipso sit super terram”. Et factum est ita.\n" + 
				"12 Et protulit terra herbam virentem et herbam afferentem semen iuxta genus suum lignumque faciens fructum, qui habet in semetipso sementem secundum speciem suam. Et vidit Deus quod esset bonum.\n",
				"https://upload.wikimedia.org/wikipedia/commons/thumb/5/57/The_Flight_into_Egypt-1500_Vittore_Carpaccio.jpg/1280px-The_Flight_into_Egypt-1500_Vittore_Carpaccio.jpg",
				"https://www.youtube.com/embed/-40OP-OMdNw",
				"30/05/2020", "12:00",
				"Basilica Nuestra Señora del Prado, Talavera de la Reina",
				"Don Manuel Garrigós"));
	}
	
	public List<EvenementDTO> getEvenements() {
		return this.fake;
	}
	
	public EvenementDTO getEvenementParId(int id) {
		for(EvenementDTO e : this.fake) {
			if(e.getId() == id) {
				return e;
			}
		}
		return null;
	}

}
