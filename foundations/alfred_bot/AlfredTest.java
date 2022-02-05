public class AlfredTest {

    public static void main(String[] args) {
        AlfredQuotes alfredBot = new AlfredQuotes();

        String testGreeting = alfredBot.basicGreeting();
        String testGuestGreeting = alfredBot.guestGreeting("Beth Kane");
        String testGuestGreeting2 = alfredBot.guestGreeting("Beth Kane", "Day");
        String testGuestGreeting3 = alfredBot.guestGreeting();
        String testDateAnnouncement = alfredBot.dateAnnouncement();

        String alexisTest = alfredBot.respondBeforeAlexis("Alexis! Play some lo-fi beats.");
        String alfredTest = alfredBot.respondBeforeAlexis("I can't find my yo-yo. Maybe Alfred will know where it is.");
        String notRelevantTest = alfredBot.respondBeforeAlexis("Maybe that's what Batman is about. Not winning. But failing...");
        String volumeKnobBroken = alfredBot.alfredShout("I am having trouble controlling the volume of my voice.");

        System.out.println(testGreeting);
        System.out.println(testGuestGreeting);
        System.out.println(testGuestGreeting2);
        System.out.println(testGuestGreeting3);
        System.out.println(testDateAnnouncement);
        System.out.println(alexisTest);
        System.out.println(alfredTest);
        System.out.println(notRelevantTest);
        System.out.println(volumeKnobBroken);
    }
}