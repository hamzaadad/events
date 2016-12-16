var express = require('express');
var router = express.Router();
var mongoose = require('mongoose');

var Event = require("../models/event.js");



router.get('/', function(req, res) {

 var jsonData = {
   'name': 'node-express-api-boilerplate',
   'api-status':'OK'
 }

 // respond with json data
 res.json(jsonData)
});

router.get('/events', function(req, res){
 Event.find(function(err, data){
   // if err or no animals found, respond with error
   if(err || data == null){
     var error = {status:'ERROR', message: 'Could not find animals'};
     return res.json(error);
   }

   // otherwise, respond with the data

   var jsonData = {
     status: 'OK',
     events: data
   }

   res.json(jsonData);

 })

});

router.post('/events', function(req, res){


 var event = new Event({
   name: req.body.name,
   description: {
     text: req.body.description.text,
     images: req.body.description.image
   },
   url: req.body.url,
 });

 event.save(function(err,data){
   // if err saving, respond back with error
   if (err){
     var error = {status:'ERROR', message: 'Error saving animal', stack: err};
     return res.json(error);
   }

   console.log('saved a new event!');
   console.log(data);

   // now return the json data of the new animal
   var jsonData = {
     status: 'OK',
     event: data
   }

   return res.json(jsonData);

 })
});

module.exports = router;
