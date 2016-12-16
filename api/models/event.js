var mongoose = require('mongoose');
var Schema = mongoose.Schema;

var eventSchema = new Schema({
	name: String,tags: [String],
	description: {
		text: String,
		images: String
	},
	url: String,
	dateAdded : { type: Date, default: Date.now },
})

module.exports = mongoose.model('Event',eventSchema);
