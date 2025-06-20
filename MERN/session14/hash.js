const bcrypt = require("bcryptjs");

const hashPassword = async (password) => {
  try {
    const salt = await bcrypt.genSalt(10);
    const hashedPassword = await bcrypt.hash(password, salt);
    return hashedPassword;
  } catch (error) {
    console.error("Error hashing password:", error);
    throw error;
  }
};

let hashedPassword = await hashPassword("aptehr123");

console.log("Hashed password:", hashedPassword);
