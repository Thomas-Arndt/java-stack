import java.util.HashMap;
import java.util.Set;

public class Hashmatique {

    public void iterateHashmap() {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("Sha-Na-Na", "I said hey! Sha-na-na.  Na-na-na-na-na-na!");
        trackList.put("Hey-Oh!", "I said hey-oh. Listen what I say-oh-oh.");
        trackList.put("Row-Row-Row", "Row, row, row your boat, gently down the stream.");
        trackList.put("Song That Never Ends", "This is the dont that never ends. It just goes on and on, my friends.");
        trackList.remove("Sha-Na-Na");

        Set<String> keys = trackList.keySet();
        for(String key : keys) {
            System.out.printf("%s: %s\n", key, trackList.get(key));
        }
    }
}