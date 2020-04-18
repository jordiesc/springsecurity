# springsecurity

Spring security play ground

# main ruls

log into the mini applicaiton http://localhost:8080 and follow the link

user jordi password jordi.

# Tools
Hal epxplorer for the RestReporsitory  http://localhost:8080/api

http://localhost:8080/h2-console see credenditals and url in application.properties.

# Basic autentication

To include user and password in Basic wity curl.

```bash
$ curl http://localhost:8080/restapi/current
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100   114    0   114    0     0   3677      0 --:--:-- --:--:-- --:--:--  3800{"timestamp":1586800270464,"status":401,"error":"Unauthorized","message":"Unauthorized","path":"/restapi/current"}

$ curl http://localhost:8080/restapi/current -u jordi:jordi
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100    26    0    26    0     0    268      0 --:--:-- --:--:-- --:--:--   270{"id":null,"name":"jordi"}

```

# Custom Filter

nyapa per probar el custom  filtre

curl http://localhost:8080/restapi/current  -H "skip: jordi"