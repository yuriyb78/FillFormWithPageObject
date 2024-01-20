package pages.component;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public void setCalendar (String day, String month, String year) {
        String dayOfBirthday = ".react-datepicker__day--0";
        int dayNumber = Integer.parseInt(day);
        if (dayNumber < 10) {
            dayOfBirthday += "0";
        }

        String calendarDay = dayOfBirthday + day + ":not(.react-datepicker__day--outside-month)";

        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(calendarDay).click();
    }
}
