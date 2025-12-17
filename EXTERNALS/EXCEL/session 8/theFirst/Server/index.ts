import 'reflect-metadata';
import express from 'express';
import dotenv from 'dotenv';
import { container } from 'tsyringe';
import { connectToDatabase } from '../Core/config/database';


dotenv.config();

const app = express();
const port = process.env.PORT || 3000;

app.use(express.json());


const startServer = async () => {
  try {
    await connectToDatabase();
    app.listen(port, () => {
      console.log(`Server running on http://localhost:${port}`);
    });
  } catch (error) {
    console.error('Failed to start server:', error);
  }
};

startServer();