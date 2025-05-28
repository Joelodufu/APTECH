const express = require('express');
const router = express.Router();

userController = require('../controllers/user.controller')

router.get('/', usercontroller.getAllUsers);
router.post('/', usercontroller.createUser);

module.exports = router;