#!/bin/bash

docker stack rm monitor client
yes | docker volume prune 
docker network rm app
