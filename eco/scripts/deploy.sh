#!/usr/bin/env bash

mvn clean package

echo 'Copy files...'

scp -i
    Z:\eco\eco\target\eco-0.0.1-SNAPSHOT.jar \
    ekoekb@51.250.28.250:/home/ekoekb/

echo 'Restart server...'

ssh -i ekoekb@51.250.28.250 << EOF

pgrep java | xargs kill -9
nohup java -jar eco-0.0.1-SNAPSHOT.jar > log.txt &

EOF

echo 'Bye'