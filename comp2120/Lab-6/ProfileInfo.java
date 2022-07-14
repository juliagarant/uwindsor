package Lab6;

import java.util.ArrayList;

public class ProfileInfo {
    private String name;
    private DOB dob;
    private String gender;
    private Address address;


    private Relative relative;
    private Contact contact;
    private Visit visit;
    private String disease;
    private Specialist specialist;

//noura@uwindsor.ca
    private ArrayList<Contact> contactList = new ArrayList<>();
    private ArrayList<Relative> relativeList = new ArrayList<>();
    private ArrayList<Visit> visitList = new ArrayList<>();
    private ArrayList<String> diseaseList = new ArrayList<>();
    private ArrayList<Specialist> specList = new ArrayList<>();

    public ProfileInfo(String name, DOB dob, String gender, Address address){
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
    }

    public ProfileInfo(String name, DOB dob, String gender, Address address, Relative relative, Contact contact, Visit visit, String disease, Specialist specialist){
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.address = address;

        this.relative = relative;
        this.contact = contact;
        this.visit = visit;
        this.disease = disease;
        this.specialist = specialist;

        relativeList.add(relative);
        contactList.add(contact);
        visitList.add(visit);
        diseaseList.add(disease);
        specList.add(specialist);
    }

    @Override
    public String toString() {
        return "Profile{" +name +" "+ dob +" "+ gender +" "+ address + "\n"+ relative +" "+ contact +" "+ visit+" "+ disease +" "+ specialist+'}';
        //"\n"+ contactList +" "+ relativeList +" "+ visitList +" "+diseaseList +" "+specList + '}';
    }
}
