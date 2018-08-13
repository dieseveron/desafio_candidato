#!/usr/bin/env node

var path = require('path');
var express = require('express');
var pkg = require( path.join(__dirname, 'package.json') );

var program = require('commander');

program
	.version(pkg.version)
	.option('-p, --port <port>', '(defaults to 3000)', parseInt)
	.parse(process.argv);

var port = program.port || 3000;


var app = express();
app.use(function(req, res, next) {
	res.header("Access-Control-Allow-Origin", "*");
	res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
	next();
  });

app.use('/', express.static(path.join(__dirname, 'frontend')));
app.use('/formCreate', express.static(path.join(__dirname, 'frontend')));

app.listen(port);

console.log('Gestor de documentos corriendo en puerto ' + port);