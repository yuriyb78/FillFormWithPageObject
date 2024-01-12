package pages.Component;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public void setCalendar (String day, String month, String year) {

        String calendarDay = ".react-datepicker__day--0" + day;

        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(calendarDay).click();
    }
}
