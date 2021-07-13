import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public abstract class App extends Person implements Comparator<Person> {

    public static Date StringToDate(String str) {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = df.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String printPerson(Person person) {
        return "Ho ten: " + person.getFullName() + ", Ngay sinh: " + person.getDoB() + ", Gioi tinh: " + person.getGender();
    }

    public static void sortPersonList(List<Person> people){
        System.out.println("Danh sach da sap xep(theo bang chu cai):");
        for (int i = 0; i < people.size()-2; i++) {
            for (int j = 0; j < people.size()-i-1; j++) {
                if(people.get(j).getFullName().compareTo(people.get(j+1).getFullName())>0){
                    Person temp = people.get(j);
                    people.set(j,people.get(j+1));
                    people.set(j+1,temp);
                }
            }
        }
        for(Person person:people){
            System.out.println(printPerson(person));
        }
    }

    public static void findPerson(List<Person> people){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nNhap ho ten muon tim: ");
        String fullname = sc.nextLine();
        for (Person person:people) {
            if(person.getFullName().equals(fullname)){
                System.out.println("Thong tin nguoi co ten "+person.getFullName()+" :"+" \n"+printPerson(person));
            }
        }
    }

    public static void findLongestName(List<Person> people){
        Person person = null;
        for (int i = 0; i < people.size()-1; i++) {
            if((people.get(i).getFullName().length()>people.get(i+1).getFullName().length())==true){
                person = people.get(i);
            }
        }
        System.out.println("Thong tin nguoi co ten dai nhat: \n"+printPerson(person));
    }

//    public static void findYoungPerson(List<Person> people){
//        Person person = null;
//        for (int i = 0; i < people.size()-1; i++) {
//            if((people.get(i).getDoB()>people.get(i+1).getDoB())==true){
//                person = people.get(i);
//            }
//        }
//        System.out.println("Thong tin nguoi tre tuoi nhat: \n"+printPerson(person));
//    }

    public static void addPerson(List<Person> people){
        Scanner sc = new Scanner(System.in);
        char check = 'y';
        do{
            System.out.print("Nhap ho ten: ");
            String fullname = sc.nextLine();
            System.out.print("Nhap ngay sinh: ");
            String strdob = sc.next();
            Date dob = StringToDate(strdob);
            System.out.print("Nhap gioi tinh: ");
            String gender = sc.next();
            GENDER gender1 = null;
            if(gender.equals("male")||gender.equals("Male")||gender.equals("MALE")){
                gender1=GENDER.Male;
            }else{
                gender1=GENDER.Female;
            }
            Person person = new Person(fullname,dob,gender1);
            people.add(person);
            System.out.println("Ban co muon them nguoi khac? Y/N");
            check = sc.next().charAt(0);
        }while (check == 'y' || check == 'Y');
    }

}
