#!/bin/bash



#start ElasticSearch with data
echo "Starting dev ElasticSearch"
./Dev/elasticsearch-5.5.0/bin/elasticsearch

#wait 1 seconds
echo "#####################################################################"
#start Kibana
echo "Starting dev Kibana"
./Dev/kibana-5.5.0-linux-x86_64/bin/kibana


echo "#####################################################################"
#start empty ElasticSearch
echo "Starting prod ElasticSearch"
sudo docker run -p 9200:9200 -e "http.host=0.0.0.0" -e "transport.host=127.0.0.1" -e "xpack.security.enabled=false" docker.elastic.co/elasticsearch/elasticsearch:5.5.0

#wait 1 seconds
sleep 1

echo "#####################################################################"
#start empty Kibana
echo "Starting prod Kibana"
./Production/ELK/kibana-5.5.0-linux-x86_64/bin/kibana
