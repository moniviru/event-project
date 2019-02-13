module.controller('eventController', ['eventService', "$scope", '$window', function (eventService, $scope, $window) {
    
    $scope.eventList = [];    
    
    $scope.states = ["AL","AR","AZ","CA","CO","CT","DC","DE","FL","GA","HI","IA","ID","IL","IN","KS","KY","LA","MA","MD","ME","MI","MN","MO","MS","MT","NC","ND","NE","NH","NJ","NM","NV","NY","OH","OK","OR","PA","RI","SC","SD","TN","TX","UT","VA","VT","WA","WI","WV","WY"];
    
    $scope.times = [
    	{"id": "00:00:00","value": "12:00 AM"}, 
    	{"id": "01:00:00","value": "01:00 AM"}, 
    	{"id": "02:00:00","value": "02:00 AM"},
    	{"id": "03:00:00","value": "03:00 AM"},
    	{"id": "04:00:00","value": "04:00 AM"},
    	{"id": "05:00:00","value": "05:00 AM"},
    	{"id": "06:00:00","value": "06:00 AM"},
    	{"id": "07:00:00","value": "07:00 AM"},
    	{"id": "08:00:00","value": "08:00 AM"},
    	{"id": "09:00:00","value": "09:00 AM"},
    	{"id": "10:00:00","value": "10:00 AM"},
    	{"id": "11:00:00","value": "11:00 AM"},
    	{"id": "12:00:00","value": "12:00 PM"},
    	{"id": "13:00:00","value": "01:00 PM"},
    	{"id": "14:00:00","value": "02:00 PM"},
    	{"id": "15:00:00","value": "03:00 PM"},
    	{"id": "16:00:00","value": "04:00 PM"},
    	{"id": "17:00:00","value": "05:00 PM"},
    	{"id": "18:00:00","value": "06:00 PM"},
    	{"id": "19:00:00","value": "07:00 PM"},
    	{"id": "20:00:00","value": "08:00 PM"},
    	{"id": "21:00:00","value": "09:00 PM"},
    	{"id": "22:00:00","value": "10:00 PM"},
    	{"id": "23:00:00","value": "11:00 PM"},
    ];
    
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
                	state: $scope.states[0]
                }
            };
    	
    	$scope.dateComplete = {
        	    date: null,
        	    time: $scope.times[0]
        	  };
	};
		        
    
    $scope.insert = function(event) { 
    	var tempDate = new Date($scope.dateComplete.date+" "+$scope.dateComplete.time.value);
    	
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