const { MongoClient } = require("mongodb");

const mongoURL = "mongodb://localhost:27017";
const databaseName = "Library";
const collectionName = "Books";

//creating an instance of the client
const client = new MongoClient(mongoURL);

//connecting ti the instance and performing db opperations

client
  .connect()
  .then(() => {
    const db = client.db(databaseName);
    const collection = db.collection(collectionName);
    //find the documents inside that collections
    return collection.find({}).toArray();
  })
  .then((doc) => {
    // log the number of documents that was found
    console.log(`Found ${doc.length} Books in the collections`);
    // log the total documents found
    console.log(doc);
  })
  .catch((err) => {
    console.log("Error connecting to DB: ", err);
  })
  .finally(() => {
    client.close();
  });
