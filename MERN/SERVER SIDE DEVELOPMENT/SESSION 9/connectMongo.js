const { MongoClient } = require("mongodb");

const mongoURL = "mongodb://localhost:27017";
const databaseName = "Library";
const collectionName = "Books";

const dataToAdd = [
  {
    Book_id: 101,
    Book_name: "The Lord Of The Ring",
    Author_name: "James Fisher",
    Price: 10000,
  },
  {
    Book_id: 102,
    Book_name: "The song of ice and fire",
    Author_name: "James farmer",
    Price: 15000,
  },
  {
    Book_id: 103,
    Book_name: "The 48 laws of Power",
    Author_name: "James cooker",
    Price: 20000,
  },
];

//create an instance of the client using the connection string
const client = new MongoClient(mongoURL);
client
  .connect()
  .then(() => {
    //create the database
    const db = client.db(databaseName);

    //inside the database, create the bool collection
    const collections = db.collection(collectionName);

    //insert the sample data into the collection
    return collections.insertMany(dataToAdd);
  })
  .then((result) =>
    console.log(
      `${result.insertedCount} Books have been added to the book collection`
    )
  )
  .catch((err) => {
    console.log("Error Connecting: ", err);
  })
  .finally(() => {
    client.close();
  });
