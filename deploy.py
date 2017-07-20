import requests
import json


#deploy visualizations and dashboard from elasticsearch instance running in port 9200 to instance running in port 9100
#9200 is loaed with stuff
#9100 is where we want to put stuff in


#visualizations

#get visualization from elasticsearch
response = requests.get("http://localhost:9200/.kibana/visualization/_search?pretty=true")
j = json.loads(response.text)
visualizationId = j["hits"]["hits"][0]["_id"]

#visualization json
visualization = (j["hits"]["hits"][0]["_source"])
putUrl = "http://localhost:9100/.kibana/visualization/" + visualizationId + "/"

#send put request
putResponse = requests.put(putUrl, json=visualization)
print (putResponse.status_code)


#dashboard

#get dahsboard from elasticsearch
response = requests.get("http://localhost:9200/.kibana/dashboard/_search?pretty=true")
j = json.loads(response.text)
dashboardId = j["hits"]["hits"][0]["_id"]

#dashboard json object
dashboard = (j["hits"]["hits"][0]["_source"])
putUrl = "http://localhost:9100/.kibana/dashboard/" + dashboardId + "/"

#send put request
putResponse = requests.put(putUrl, json=dashboard)
print (putResponse.status_code)

