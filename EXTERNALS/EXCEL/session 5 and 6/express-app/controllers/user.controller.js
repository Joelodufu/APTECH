// DEFINE OUR DB
var users = [
  { id: 1, name: "Joel Odufu" },
  { id: 2, name: "Samuel Ordegard" },
  { id: 3, name: "Basit Ishola" },
  { id: 4, name: "Benedict Afebu" },
  { id: 5, name: "Emmanuel Machine" },
];

//Getting all the users
//api/users

const getUsers = (req, res) => {
  res.status(200).json(users);
};

//create user

const createUser = (req, res, next) => {
  try {
    const { name } = req.body;
    if (!name) {
      //throw costum error
      const error = new Error("Name not found");
      error.status = 400;
      throw error;
    }

    const newUser = { id: users.length() + 1, name: name };
    users.push(newUser);
    res.status(201).json(newUser);
  } catch (err) {
    next(err);
  }
};

module.exports = { getUsers, createUser };
