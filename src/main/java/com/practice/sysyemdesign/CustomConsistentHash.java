package com.practice.sysyemdesign;

import com.practice.util.CustomLogger;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.SortedMap;
import java.util.TreeMap;

public class CustomConsistentHash {
    Logger logger = CustomLogger.getLogger(CustomConsistentHash.class);
    SortedMap<Integer, Server> hashRing;
    int virtualNodes;
    CustomConsistentHash(int virtualNodes) {
        this.virtualNodes = virtualNodes;
        this.hashRing = new TreeMap<>();
    }

    public void addNode(Server server) {
        logger.info(" Adding server : {} tot he hash ring", server);
        for (int i = 0; i <virtualNodes; i++) {
            String hKey = server.getServerId() + "NN" + i;
            int hash = getHash(hKey);
            hashRing.put(hash, server);
        }
    }

    private int getHash(String key) {
        //calculate md5 and convert them to bute array, construt a hash value
        try {
            // Create MD5 MessageDigest instance
            MessageDigest md = MessageDigest.getInstance("MD5");
            // Generate MD5 hash and get the byte array
            byte[] hashBytes = md.digest(key.getBytes());
            // Convert to a positive integer
            BigInteger hashInt = new BigInteger(1, hashBytes);
            // Return as an integer (can be used for a 32-bit hash ring)
            int hash = hashInt.mod(BigInteger.valueOf(Integer.MAX_VALUE)).intValue();
            logger.info(" hash for the key: {} is : {}", key, hash);
            return hash;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not found", e);
        }
    }

    public void removeNode(Server server) {
        logger.info(" Removing server : {} tot he hash ring", server);
        for (int i = 0; i <virtualNodes; i++) {
            String hKey = server.getServerId() + "NN" + i;
            int hash = getHash(hKey);
            hashRing.remove(hash);
        }
    }

    /**
     * Use the same hash Function to calculate the hash and determine the corresonding server node
     * @param key
     * @return
     */
    public Server getServer(String key) {
        logger.info(" Getting the server for the key {} from the hash ring", key);
        if (hashRing.isEmpty()) {
            return null;
        }
        int hash = getHash(key);
        SortedMap<Integer, Server> tailMap = hashRing.tailMap(hash);
        Integer targetHash = tailMap.isEmpty() ? hashRing.firstKey() : tailMap.firstKey();
        Server server = hashRing.get(targetHash);
        logger.info(" Got  the server : {} for the key {} from the hash ring", server, key);
        return server;
    }

    public static class Server {
        private final String serverId;

        public Server(String serverId) {
            this.serverId = serverId;
        }

        public String getServerId() {
            return serverId;
        }

        @Override
        public int hashCode() {
            return serverId.hashCode();
        }

        @Override
        public String toString() {
            return "Server{" +
                    "serverId='" + serverId + '\'' +
                    '}';
        }
    }



    public static void main(String[] args) {
        // Take some physical nodes and distribute them to a fixed number of Virtual nodes , have a hashing algo to map the current requests
        // the corresponding nodes. Data structrues likes SOrtedMap have helper methods to find out all the hash more than a give hash

        CustomConsistentHash consistentHash = new CustomConsistentHash(5);

        consistentHash.addNode(new Server("192.176.5.2"));
        consistentHash.addNode(new Server("156.176.7.2"));
        consistentHash.addNode(new Server("132.176.8.2"));

        consistentHash.getServer("115.173.25.6");
        consistentHash.getServer("172.173.25.6");
        consistentHash.getServer("192.173.25.6");
    }
}
