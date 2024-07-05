package com.kosh.koshmongodb.services;

import org.springframework.stereotype.Service;

import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Service
public class DBClient {

    public void connect() {
        String uri = "";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("db0");
            MongoCollection<Document> collection = database.getCollection("data");
            Document doc = collection.find(eq("title", "FooBar")).first();
            if (doc != null) {
                System.out.println(doc.toJson());
            } else {
                System.out.println("No matching documents found.");
            }
        }
    }

}
