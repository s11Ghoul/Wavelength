package ua.stryghul.Wavelength;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import io.github.cdimascio.dotenv.Dotenv;
import org.bson.Document;

import java.util.Arrays;

public class PairOfWords {
    private static String word1 = "";
    private static String word2 = "";

    //Conncet to database
    static Dotenv dotenv = Dotenv.load();
    private static String MongoLogin = dotenv.get("MONGO_LOGIN");
    private static String MongoPassword =  dotenv.get("MONGO_PASSWORD");
    static MongoClient mongoClient = MongoClients.create("mongodb+srv://" + MongoLogin + ":" + MongoPassword +"@cluster0.shfeqju.mongodb.net/?retryWrites=true&w=majority");
    static MongoDatabase database = mongoClient.getDatabase("mydb");
    static MongoCollection<Document> collection = database.getCollection("pair_words");

    public static Document getRandomDocument(MongoCollection<Document> collection) {
        Document sampleStage = new Document("$sample", new Document("size", 1));
        return collection.aggregate(Arrays.asList(sampleStage)).first();
    }

    public static String getPairOfWords() {
        Document randomDoc = getRandomDocument(collection);

        word1 = randomDoc.getString("word1");
        word2 = randomDoc.getString("word2");
        return word1 + "/" + word2;
    }



}