#!/bin/bash

echo $project
echo $PROJECT

set -e -u -x


cd source-code/
./mvnw package
