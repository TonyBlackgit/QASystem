package com.util;

import com.entity.Reverse;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static com.mongodb.client.model.Filters.*;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;	
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MongoConn {
	
	static com.mongodb.client.MongoClient mongoClient;
	static MongoDatabase database;
	static MongoCollection<Reverse> collection;
//	static MongoCollection<Document> collection;
	
	public  void init() {
//		CodecRegistry codecRegistry =
//				CodecRegistries.fromRegistries(CodecRegistries.fromCodecs(new UuidCodec(UuidRepresentation.STANDARD)),
//				                               MongoClientSettings.getDefaultCodecRegistry());
//
//				// globally
//				MongoClientSettings settings = MongoClientSettings.builder()
//				        .codecRegistry(codecRegistry).build();
//				mongoClient = MongoClients.create(settings);
//				System.out.println("get MongoClient");
//
//				// or per database
//				database = mongoClient.getDatabase("QASystem")
//				                               .withCodecRegistry(codecRegistry);
//				System.out.println("get database");
//
//				// or per collection
//				collection = database.getCollection("reverse")
//				                              .withCodecRegistry(codecRegistry);
//				System.out.println("get collection");
		CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
		MongoClientSettings settings = MongoClientSettings.builder()
		        .codecRegistry(pojoCodecRegistry)
		        .build();
		mongoClient = MongoClients.create(settings);
		System.out.println("get MongoClient");
		database = mongoClient.getDatabase("QASystem").withCodecRegistry(pojoCodecRegistry);;
		System.out.println("get database");
	}
	public void getCol(String colname) {
		collection = database.getCollection(colname, Reverse.class);
		System.out.println("get collection");
	}
	
	public Reverse query(String str) {

		FindIterable<Reverse> list = collection.find(eq("key", str));
		return list.first();
	}
	
	public void closeConn() {
		try {
			if(mongoClient != null) mongoClient.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	public static void main(String[] args) {
//		MongoConn.init();
//		MongoConn.getCol("reverse");
//		MongoConn.query("隶属于");
//	}
//	public static void query(String str) {
//		Block<Document> printBlock = new Block<Document>() {
//		       public void apply(final Document document) {
//		           System.out.println(document.toJson());
//		       }
//		};
//		collection.find(eq("key", str))
//        .forEach(printBlock);
//	}
}
