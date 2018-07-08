# Service description
## Service for checking list of servers (ping). For control must be created API - must have configure delay time, server list, getting information

# How its work:
 - Server list contains in inMemoryDb
 - Default configs contains in inMemoryDb (imitate mongodb)
 - REST API
    - created crud operation for control service
 - POST for add new server
 - PUT for update shedule time
 - GET for getting all servers and setting