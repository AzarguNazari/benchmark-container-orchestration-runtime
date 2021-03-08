#!/bin/bash

echo $(($(date +%s%N)/1000000)) 
docker network create -d overlay app
docker stack deploy -c docker-compose-monitor.yml monitor

sleep 5

docker stack deploy -c docker-compose-client.yml client

