package ch3;

import redis.clients.jedis.Jedis;

public class MostRecentlyViewedNonDestructive extends AbstractListExample
{

    public ViewedItem getMostRecentForUser(int userId) {

        // get our key
        String key = userHistoryKey(userId);

        try (Jedis jedis = pool.getResource()) {

            // Your code goes here
            return null;
        }

    }

    public static void main(String[] args) {

        try {
            MostRecentlyViewedNonDestructive gmr = new MostRecentlyViewedNonDestructive();
            gmr.init();

            gmr.clearUserHistory(1001);
            gmr.clearUserHistory(3001);
            gmr.addUserHistory(3001);

            ViewedItem item = gmr.getMostRecentForUser(1001);
            prettyPrint("UserId: 1001", item);
            item = gmr.getMostRecentForUser(3001);
            prettyPrint("UserId: 3001", item);

            System.exit(0);
        } catch (Exception e) {
            System.err.println("Failed to execute example");
            e.printStackTrace();
            System.exit(-1);
        }
    }

}
