angular.module('myApp', [])
.factory('eventService', ["$http",function ($http) { 
	var service = {};
    service.all = function() {
        return $http.get("/events");
    }
    
    service.add = function(event) {
        return $http.post("/saveEvent", event);
    }
    return service;
}])
.controller('eventController', ['eventService', "$scope", '$window', function (eventService, $scope, $window) {
	        
	        $scope.eventList = [];    
	        
	        eventService.all().then(function(data){						
				$scope.eventList = data.data;				
			}, function(error){
				console.info(error);
			});
	        
	        $scope.init = function() {
	        	$scope.event = {
		                id: null,
		                name: null,
		                date: null,
		                venue: {
		                	id: null,
		                	name: null,
		                	city: null,
		                	state: 'AK'
		                }
		            };
	        	
	        	$scope.dateComplete = {
		        	    date: null,
		        	    time: "00:00:00"
		        	  };
			};
				        
	        
	        $scope.insert = function(event) { 
	        	var tempDate = new Date($scope.dateComplete.date+" "+$scope.dateComplete.time);
	        	
	        	event.date = tempDate;
	        	
	        	eventService.add(event).then(function(){
	        		 eventService.all().then(function(data){						
	     				$scope.eventList = data.data;				
	     			}, function(error){
	     				console.info(error);
	     			});
	        		 $('#openModal').modal('hide');
	        	}, function(error){
	        		console.info(error);
	        	});
	          };
}])
.directive('datepicker', function() {
    return {
        restrict: 'A',   
        require : 'ngModel',

        link : function (scope, element, attrs, ngModelCtrl) {
            $(function(){
                element.datepicker({
                    dateFormat:'yy-mm-dd',
                    onSelect:function (date) {
                        ngModelCtrl.$setViewValue(date);
                        scope.valueupdate = date;
                          scope.$apply(); 
                    }
                });
            });
        }
    }
});