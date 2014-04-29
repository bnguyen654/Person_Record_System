
package src;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class TestPeople {
    static String[] fnames = {
            "John",
            "Adam"
    };
    static String[] lnames = {
        "Doe",
        "Smith"
    };
    static ArrayList<UUID> ids = new ArrayList<UUID>();
    static ArrayList<Person> res = new ArrayList<Person>();

    public static Person generate() {
        Random rdm = new Random();
        Person p = new Person(fnames[rdm.nextInt(fnames.length)], "", lnames[rdm.nextInt(lnames.length)]);
        int mth = rdm.nextInt(11) + 1;
        int dylmt;
        switch (mth) {
            default: dylmt = 0;
            case 1: dylmt = 31;
            case 2: dylmt = 28;
            case 3: dylmt = 31;
            case 4: dylmt = 30;
            case 5: dylmt = 31;
            case 6: dylmt = 31;
            case 7: dylmt = 30;
            case 8: dylmt = 31;
            case 9: dylmt = 30;
            case 10: dylmt = 31;
            case 11: dylmt = 30;
            case 12: dylmt = 31;
        }
        p.setBirthday(mth, rdm.nextInt(dylmt-1) + 1, 1900 + rdm.nextInt(2014-1900));
        System.out.println("Generated person named " + p.fname + " " + p.lname + " with birthday of " +
                p.bmth + "/" + p.bday + "/" + p.byr + ".");
        return p;
    }
    public static ArrayList<Person> genList(int ct) {
        int i = 0;
        while (i < ct) {
            Person p = generate();
            res.add(p);
            ids.add(p.getRecordID());
            i++;
        }
        return res;
    }
    public static ArrayList<UUID> getIds() {
        return ids;
    }
    public static void clean(){
        res.clear();
        ids.clear();
    }
}
