import java.util.Date;
import java.text.SimpleDateFormat;
public class AlfredQuotes {

    public String basicGreeting() {
        return "Hello, lovely to see you. How are you?";
    }

    public String guestGreeting(String name) {
        return String.format("Hello, %s. Lovely to see you.", name);
    }

    public String guestGreeting(String name, String dayPeriod) {
            return String.format("Good %s, %s. Lovely to see you.", dayPeriod.toLowerCase(), name);
    }

    public String guestGreeting() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("k");
        String hour = formatter.format(date);
        if(Integer.parseInt(hour) > 1 && Integer.parseInt(hour) < 12){
            return "Good Morning.";
        }
        else if (Integer.parseInt(hour) > 12 && Integer.parseInt(hour) < 18){
            return "Good Afternoon.";
        } else {
            return "Good Evening.";
        }
    }

    public String dateAnnouncement() {
        Date date = new Date();
        return String.format("It is currently %s", date);
    }

    public String respondBeforeAlexis(String conversation) {
        if (conversation.indexOf("Alexis") != -1) {
            return "Right away, sir. She certainly isn't sophisticated enough for that.";
        } 
        else if (conversation.indexOf("Alfred") != -1) {
            return "At your service. As you wish, naturally.";
        } else {
            return "Right. And with that I shall retire.";
        }
    }

    public String alfredShout(String sentence) {
        return sentence.toUpperCase();
    }
}