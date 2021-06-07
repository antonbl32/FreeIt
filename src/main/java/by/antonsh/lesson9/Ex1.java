package by.antonsh.lesson9;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Задачи решаются двумя способами, используя библиотеку java.util и java.time
По введенной дате вывести название месяца.
По введенной дате вывести возраст
Вывести дату в формате даты (DD/MM/YYYY) + время hh:mm:ss

 */
public class Ex1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String myInputDate = null;
        boolean isGood=false;
        while(!isGood){
            myInputDate=scanner.next();
            if(isCheckIn(myInputDate)){
                isGood=true;
                break;
            }
        }
        myInputDate=myInputDate.replaceAll("[\\.\\-]","/");
        Date date= null;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(myInputDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        /*
        Get Month
         */
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        System.out.println(calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH ));
        /*
        How much time between date
         */
        Calendar resultCalendar=Calendar.getInstance();
        Date dateNow=resultCalendar.getTime();
        resultCalendar.setTimeInMillis(Math.abs(dateNow.getTime() - date.getTime()));
        System.out.println("Years:"+(resultCalendar.get(Calendar.YEAR)-1970)
                +" months:"+resultCalendar.get(Calendar.MONTH));
        /*
        Display (DD/MM/YYYY) + время hh:mm:ss
         */
        System.out.println(new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(date));
        System.out.println("--------------------------------");
        /*
        Get Month with LocalDate
         */
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate=LocalDate.parse(myInputDate,dateTimeFormatter);
        System.out.println(localDate.getMonth());
        /*
        How much time between localDate
         */
        LocalDate nowDate=LocalDate.now();
        Period period= Period.between(localDate,nowDate);
        System.out.println( "Years: "+period.getYears()+ " months: "+period.getMonths());
        /*
        Display (DD/MM/YYYY) + время hh:mm:ss with localDate
        time set now
         */
        LocalTime localTime=LocalTime.now();
        LocalDateTime localDateTime=LocalDateTime.of(localDate,localTime);
        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss")));
    }

    /**
     * This method check input format date {dd/mm/yyyy, dd-mm-yyyy or dd.mm.yyyy}
     * @param text for check
     * @return result of checks
     */
   static boolean isCheckIn(String text){
        String regex= "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)" +
                "(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})" +
                "$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)" +
                "?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))" +
                "$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)" +
                "(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(text);
        if(matcher.find()){
            return true;
        }
        return false;
    }
}
