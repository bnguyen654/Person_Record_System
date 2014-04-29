package src;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

public class Person implements Serializable {
        int index;
        UUID id;
	String fname, lname, mname;
	int bmth, bday, byr;
        boolean alive;
        
	ArrayList<String> aliases, addresses, vehicles;
	String DL;
        
	public Person(String fnamei, String mnamei, String lnamei) {
		fname = fnamei; mname = mnamei; lname = lnamei;
                id = UUID.randomUUID();
	}
        public void setBirthday(int monthi, int dayi, int yri) {
            bmth = monthi; bday = dayi; byr = yri;
        }
        public UUID getRecordID() {
            return id;
        }
        public void setIndex(int i) {
            index = i;
        }
        public void setName() {
            
        }
        public String fBirthday(){
            return bmth + "/" + bday +"/" + byr;
        }
}
