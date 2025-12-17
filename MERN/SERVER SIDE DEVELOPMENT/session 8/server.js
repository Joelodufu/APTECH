const express = require("express");
const app = express();
const PORT = 3000;

app.use(express.json());

//sample products
const products = [
  { id: 1, title: "Wrist Watch", description: "Rolex", price: 25000 },
  { id: 2, title: "Cocacola", description: "Nice drink", price: 400 },
  { id: 3, title: "Hand Bag", description: "Very durable", price: 50000 },
];

let nextStudentId = 4;

// GET REQUEST

app.get("/products", (req, res) => {
  res.status(200).json(products);
});

// GET REQUEST FOR A SINGLE STUDENT WITH AN ID
app.get("/products/:id", (req, res) => {
  const id = parseInt(req.params.id);
  student = products.find((s) => s.id === id);
  if (student) {
    res.status(200).json(student);
  } else {
    res.status(404).json({
      success: false,
      msg: "No student with such id",
    });
  }
});

//POST REQUEST

app.post("/products", (req, res) => {
  const { title, description, price } = req.body;
  const newStudent = {
    id: nextStudentId++,
    title,
    description,
    price,
  };
  products.push(newStudent);
  res.status(201).json({
    success: true,
    msg: "Created new user",
    data: newStudent,
  });
});

//UPDATE REQUEST
app.put("/products/:id", (req, res) => {
  //get the id passed by the user
  const id = parseInt(req.params.id);

  // find the student who has that id
  const student = products.find((s) => s.id === id);

  //handdle cases where products with that id does not exist
  if (!student) {
    return res.status(404).json({
      success: false,
      msg: "No user with such id",
    });
  }

  // get the update info from the request body

  const { title, description, price } = req.body;

  //replace the existing info with the update info
  student.title = title;
  student.description = description;
  student.price = price;

  res.status(200).json({
    success: true,
    msg: "Updated Student",
    data: student,
  });
});

// DELETE REQUEST

app.delete("/products/:id", (req, res) => {
  //get the ID from the request parameter
  const id = parseInt(req.params.id);

  // find the student that has that id
  const student = products.find((s) => s.id === id);

  // handle the case were there is no student with such id
  if (!student) {
    return res.status(404).json({
      success: false,
      msg: "no student of such",
    });
  }

  //let us delete the student
  const studentIndex = products.findIndex((s) => s.id === id);
  products.splice(studentIndex, 1);
  res.status(200).json({
    success: true,
    msg: "Successfully removed the products",
  });
});

app.listen(PORT, () => {
  console.log(
    `Server started and  listening on port: http://localhost:${PORT}`
  );
});
