#!/bin/sh
git fetch 
git rebase
rm -rf src/main/java/com/tongbaotu/fits/thrift/idl/*
thrift -r --gen java -out src/main/java thrift/fits.thrift 
mvn install
