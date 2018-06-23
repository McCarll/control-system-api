# Service description
## Service for checking list of servers (ping). For control must be created API - must have configure delay time, server list, getting information

# How its work:
 - Server list contains in mq queue - rabbit mq, in future it may be repository in github
 - Default configs contains in application yaml file and may be change by http request
 - REST API
    - created crud operation for control service
 - POST for add new server
 - GET for getting all servers
 - PATCH for update one of the server
 - DELETE for delete some or all servers
   