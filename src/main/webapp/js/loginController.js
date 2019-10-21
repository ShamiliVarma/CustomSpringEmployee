 var app = angular.module("login", []);
 app.controller("loginController",[$scope,$http,function($scope,$http){
	 console.log("Login Please")
	 
	 $scope.loginSubmit = function() {
		 console.log("Login Submit")
         $http({
             method : "POST",
             url : "/login",
             data : angular.toJson($scope.loginForm),
             headers : {
                 'Content-Type' : 'application/json'
             }
         }).then( _success, _error );
     };
     
     function _success(response) {
         _clearFormData()
     }

     function _error(response) {
         console.log(response.statusText);
     }

     //Clear the form
     function _clearFormData() {
         $scope.loginForm.username = "";
         $scope.loginForm.password = "";
     }
     
	 
 }]);
         