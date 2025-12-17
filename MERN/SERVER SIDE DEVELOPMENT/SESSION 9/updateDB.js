const { MongoClient } = require("mongodb");

const mongoURL = "mongodb://localhost:27017";
const databaseName = "Library";
const collectionName = "Books";

const client = new MongoClient(mongoURL);

//connecting to the new instance

client
  .connect()
  .then(() => {
    const db = client.db(databaseName);
    const collection = db.collection(collectionName);
    /*
  FIND THE DOCUMENT WE WANT TO UPDATE
  @ 1. define the filtering criteria
  */
    const filter = { Book_id: 102 };
    const update = {
      $set: {
        Book_name: "Agents Of Shield",
        Author_name: "Basit Ishola",
        Price: 23000,
      },
    };

    return collection.updateOne(filter, update);
  })
  .then((result) => {
    if (result.matchedCount === 0) {
      console.log("No matching document found for the book id");
    } else {
      console.log("Document Updated: ", result.modifiedCount);
    }
  })
  .catch((err) => {
    console.log("Error: ", err);
  })
  .finally(() => {
    client.close();
  });
