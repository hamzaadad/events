var express   = require('express')
  , bodyParser = require('body-parser')
  , Sequelize = require('sequelize')
  , http      = require('http')
  , restful   = require('sequelize-restful')
  , config    = require('./config')
  , sequelize = new Sequelize(config.db.name, config.db.user, config.db.password, {
            host: config.db.host,
            logging: console.log,
            define: {
                timestamps: false
            }
        })
  , app = express();

var port = process.env.PORT || 3000;
app.use(bodyParser());


var Evenment = sequelize.define('events', {
        title: Sequelize.STRING,
        description: Sequelize.STRING,
        date_start: Sequelize.STRING,
        date_end: Sequelize.STRING,
        organisateur_id: Sequelize.INTEGER
    }
);

var Organisateur = sequelize.define('organisateurs', {
        name: Sequelize.STRING,
        email: Sequelize.STRING
    }
);

Organisateur.hasMany(Evenment,  {foreignKey: 'organisateur_id' })
Evenment.hasOne(Organisateur,  {as: 'organisateur', foreignKey: 'organisateur_id'})
app.use(restful(sequelize, {
  endpoint: '/api/v1',
  allowed: new Array()
}));

app.listen(port);
console.log('Magic happens on port ' + port);
