package game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

public class TXTParser implements Parsing {


	public TreeSet<String> parse(Object obj) {
		
		TreeSet<String> set = new TreeSet<String>();
		File  txtFile= new File("src\\main\\resources\\city.txt");
			
		try(BufferedReader br=new BufferedReader(new FileReader(txtFile))){
			String line;
			while((line=br.readLine())!=null){
				set.add(line);
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return set;
	}

}
