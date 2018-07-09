# Service description
## Service for checking list of servers (ping). For control must be created API - must have configure delay time, server list, getting information

# How its work:
 - Server list contains in inMemoryDb
 - Default configs contains in inMemoryDb
 - REST API
    - created crud operation for control service
 - Use socket for try connect to server via 80 port
 
#API

## Servers control

###Get server list
```
GET /server
```
### Add new server
```
POST /server
{
    "url": "<serverUrl>"
}
```
### Delete server
```
DELETE /server
{
    "url": "<serverUrl>"
}
```

### Update server

```
PATCH /server
{
    "url": "<new server url>"
    "oldUrl":"<old server orl>"
}
```
## Settings control
### Get current settings
```
GET /setting
```
### Update current settings
```
PATCH /setting
{
    "sheduleTime": "<time in mc>"
}
```

## Pinger result
### Just view pinger result
```
GET /pinger/logs
```





