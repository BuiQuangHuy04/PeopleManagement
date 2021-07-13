import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Getter@Setter
    protected String FullName;
    @Getter@Setter
    protected Date DoB;
    @Getter@Setter
    protected GENDER Gender;

}
