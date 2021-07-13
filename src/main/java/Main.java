import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Person> people = new ArrayList<>();
        people.add(0,new Person("Bui Quang Huy",App.StringToDate("16-04-2001"), GENDER.Male));
        people.add(1,new Person("Bui Nhu Quynh",App.StringToDate("31-04-2001"), GENDER.Female));
        people.add(2,new Person("Nguyen Quang Sang",App.StringToDate("16-05-2001"), GENDER.Male));
        people.add(3,new Person("Bui Dinh Trung Phong",App.StringToDate("13-08-2003"), GENDER.Male));
        people.add(4,new Person("Nguyen Huy Hoang",App.StringToDate("28-07-2001"), GENDER.Male));

        int check1, check2;

        do{
            System.out.print("\n1.Show List.\n2.Find Person.\n3.Add Person\n0.Exit\nChoose: ");
            check1=sc.nextInt();
            switch (check1){
                case 1:
                    App.sortPersonList(people);
                    System.out.println("-----------------------------------------------------");
                    break;
                case 2:
                    System.out.print("\n1.Find after name.\n2.Find the longest name.\n3.Find the youngest \nChoose: ");
                    check2=sc.nextInt();
                    switch (check2){
                        case 1:
                            App.findPerson(people);
                            System.out.println("-----------------------------------------------------");
                            break;
                        case 2:
                            App.findLongestName(people);
                            System.out.println("-----------------------------------------------------");
                            break;
                    }
                    break;
                case 3:
                    App.addPerson(people);
                    System.out.println("-----------------------------------------------------");
                    break;
                case 0:
                    System.out.println("Closed!!");
                    break;
                default:
                    break;
            }
        }while(check1 != 0);
    }
}
