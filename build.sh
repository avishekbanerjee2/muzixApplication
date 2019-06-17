#!/bin/bash

export MYSQL_DATABASE=muzixdb
export MYSQL_USER=root
export MYSQL_PASSWORD=root
export MYSQL_CI_URL=jdbc:mysql://localhost:3306/muzixdb
cd muzixmanager
mvn clean install
cd ..
cd accountmanager
mvn clean install
