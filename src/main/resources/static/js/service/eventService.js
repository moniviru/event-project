module.factory('eventService', ["$http",function ($http) { 
	var service = {};
    service.all = function() {
        return $http.get("/events");
    }
    
    service.add = function(event) {
        return $http.post("/saveEvent", event);
    }
    return service;
}])