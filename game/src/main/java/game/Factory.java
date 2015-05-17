package game;

public class Factory{

	public static Parsing getParse(String param) {
		
		Parsing parser = null;
		
		switch(param){
		
		case "BD":parser = new BDParser();
			break;
		
		case "XML":parser = new XMLParser();
			break;
		
		case "Excel":parser = new ExcelParser();
		break;
		}
		
		return parser;
	}

}
