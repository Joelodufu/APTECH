const User = require('../models/User');

//GET ALL USERS

exports.getAllUsers = async (req, res) => {
    try {
        const users = await User.find();
        res.render('users', {title:'User', users });
    } catch (error) {
        res.status(500).send('Error fetching users');
    }
};

//CREATE USER
exports.createUser = async (req, res) => {
    const { name, email } = req.body;
    try {
        const newUser = new User({ name, email });
        await newUser.save();
        res.redirect('/users');
    } catch (error) {
        res.status(500).send({ message: 'Error creating user' });
    }
};