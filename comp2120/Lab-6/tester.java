package Lab6;
/*
This was an absolute BITCH to get user input for.
Still don't think I did everything required of me for this lab but oh well
 */

import java.util.ArrayList;
import java.util.Scanner;

public class tester {
    public static void main (String[] args)
    {
        ArrayList<ProfileInfo> PatientList = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        System.out.println("Name:");
        String name = in.next();

        System.out.println("MM DD YYYY");
        int m1 = in.nextInt();
        int d1 = in.nextInt();
        int y1 = in.nextInt();

        System.out.println("Gender:");
        String g = in.next();

        System.out.println("ADDRESS\nOptional(Apt#) House# Street City Province PostalCode");
        int house1 = in.nextInt();
        String street1 = in.next();
        String city1 = in.next();
        String province1 = in.next();
        String postal1 = in.next();

        System.out.println("RELATIVE\nName {Areacode Number} Relationship Priority(int)");
        String rn = in.next();
        int area2 = in.nextInt();
        int num2 = in.nextInt();
        String rel = in.next();
        int pri = in.nextInt();

        System.out.println("YOUR CONTACT\nAreacode Number:");
        int area1 = in.nextInt();
        int num1 = in.nextInt();

        System.out.println("VISIT\nDate(MM DD YYYY) Reason Script Note");
        int m2 = in.nextInt();
        int d2 = in.nextInt();
        int y2 = in.nextInt();
        String reason = in.next();
        String script = in.next();
        String note = in.next();

        System.out.println("DISEASES: ");
        String dis = in.next();

        System.out.println("SPECIALIST\nName Specialty {Areacode Number} Optional(Apt#) House# Street City Province PostalCode");
        String sn = in.next();
        String spe = in.next();
        int area3 = in.nextInt();
        int num3 = in.nextInt();
        int house2 = in.nextInt();
        String street2 = in.next();
        String city2 = in.next();
        String province2 = in.next();
        String postal2 = in.next();

        ProfileInfo patient = new ProfileInfo(name,new DOB(m1,d1,y1),g,new Address(house1,street1,city1,province1,postal1),new Relative(rn,new Contact(area2,num2),rel,pri), new Contact(area1,num1),new Visit(new DOB(m2,d2,y2), reason, script, note), dis, new Specialist(sn, spe, new Contact(area3,num3),new Address(house2,street2,city2,province2,postal2)));

        PatientList.add(patient);
//------------------------------------------------------------------------------------------------------------------------------------------
        ProfileInfo patient1 = new ProfileInfo("Sky",new DOB(02,10,2001),"Female",new Address(1890,"Brook","Windsor","ON","w6tv3e"));
        PatientList.add(patient1);
//------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------
        ProfileInfo patient2 = new ProfileInfo("Conner",new DOB(07,12,2001),"Male",new Address(890,"Dominion","Windsor","ON","N8f8h6"));
        PatientList.add(patient2);
//------------------------------------------------------------------------------------------------------------------------------------------
        System.out.println("Remove at 0 - "+(PatientList.size()-1));
        int remove = in.nextInt();
        PatientList.remove(remove);

        System.out.println("modify at 0 - "+(PatientList.size()-1));
        int index = in.nextInt();
        System.out.println("Name:");
        name = in.next();

        System.out.println("MM DD YYYY");
        m1 = in.nextInt();
        d1 = in.nextInt();
        y1 = in.nextInt();

        System.out.println("Gender:");
        g = in.next();

        System.out.println("ADDRESS\nOptional(Apt#) House# Street City Province PostalCode");
        house1 = in.nextInt();
        street1 = in.next();
        city1 = in.next();
        province1 = in.next();
        postal1 = in.next();
        PatientList.set(index, new ProfileInfo(name,new DOB(m1,d1,y1),g,new Address(house1,street1,city1,province1,postal1)));

        System.out.println(PatientList);
    }
}
