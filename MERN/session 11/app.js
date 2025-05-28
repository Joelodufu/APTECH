const express = require('express ')
const mongoose = require ('mongoose')
const dotenv = require('dotenv')
const userRoutes = require('./routes/user.route')

//load the env variables

dotenv.config();

const app=express();

//Middlerware
app.use(express.urlenconded({ extended: true }));//Pars form data
app.use(express.static('public')); // Serve Static FIles

//set EJS as Templating Engine
app.set('view engine', 'ejs');

//Connect to MongoDB

const connectDB = require('./config/db');
connectDB();

//ROUTES
app.use('/users', userRoutes);

//HOME ROUTES

app.get('/', (req, res) => {
    res.render('index', {title: 'HOME'})
})


//START SERVER

const PORT = process.env.PORT || 3000
app.listen(PORT, ()=>{
    console.log(`Server running on port ${PORT}`);
})