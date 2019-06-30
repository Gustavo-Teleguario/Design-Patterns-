#!/usr/bin/env bash
docker volume rm DP_30247228
docker volume create DP_30247228
docker build ./DockerShop/ -t shopserver
docker build ./DockerWarehouse/ -t warehouseserver
docer container run -d -p 5001:5001 -v dp:/server shopserver
docker container run -d -p 5002:5002 -v dp:/server warehouseserver