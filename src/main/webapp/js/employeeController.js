var app= angular.module("EmployeeManagement",[]);



app.controller("EmployeeController", function($scope, $http, $location) {

	$scope.employees = [];
	$scope.employeeForm = {
			empId : -1,
			firstName :"",
			lastName :"",
			employeeAddress :{
				county : "",
				city : "",
				state : "",
			},
			bankAccounts :[{
				id : "",
				accNo : "",
				bank : "",
				branch : "",
			}],
			departments :[{
				id : "",
				departmentName : "",
			}]
			
	};

//	Now load the data from server
	_refreshEmployeesData();

//	HTTP POST/PUT methods for add/edit country 
//	with the help of id, we are going to find out whether it is put or post operation

	$scope.submitCountry = function() {

		var method = "";
		var url = "";
		if ($scope.employeeForm.empId == -1) {
			//Id is absent in form data, it is create new country operation
			method = "POST";
			url = '/CustomSpringRest/employees';
		} else {
			//Id is present in form data, it is edit country operation
			method = "PUT";
			url = '/CustomSpringRest/employees';
		}

		$http({
			method : method,
			url : url,
			data : angular.toJson($scope.employeeForm),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then( _success, _error );
	};

//	HTTP DELETE- delete country by Id
	$scope.deleteEmployee = function(employee) {
		$http({
			method : 'DELETE',
			url : '/CustomSpringRest/employees',
			data : employee,
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(_success, _error);
	};

//	In case of edit, populate form fields and assign form.id with country id
	$scope.editEmployee = function(employee) {
		console.log(JSON.stringify(employee));
		console.log(JSON.stringify(employee.bankAccounts));

		$scope.employeeForm.empId = employee.empId;
		$scope.employeeForm.firstName = employee.firstName;
		$scope.employeeForm.lastName = employee.lastName;

		$scope.employeeForm.employeeAddress.county = employee.employeeAddress.county;
		$scope.employeeForm.employeeAddress.city = employee.employeeAddress.city;
		$scope.employeeForm.employeeAddress.state = employee.employeeAddress.state;
		
		$scope.employeeForm.bankAccounts = employee.bankAccounts;
		$scope.employeeForm.departments = employee.departments;
	};

	$scope.addBankAcc =function (){
		console.log("In addBankAcc")
		var bankAccount ={
			id : "",
			accNo : "",
			bank : "",
			branch : "",
		};
		$scope.employeeForm.bankAccounts.push(bankAccount);
	};
	
	$scope.addDeprtmnt =function (){
		console.log("In addDeprtmnt")		
		var department ={
			id : "",
			departmentName : "",
		};
		$scope.employeeForm.departments.push(department);

	};
	
	$scope.logout = function(){
		console.log("In logout")
		$http({
			method : 'GET',
			url : '/CustomSpringRest/logout'
		}).then(function logoutSuccess(response){
			
			$location.path('/CustomSpringRest/login');
		});
	};
	
	/* Private Methods */
//	HTTP GET- get all Employees collection
	function _refreshEmployeesData() {
		$http({
			method : 'GET',
			url : 'http://localhost:8080/CustomSpringRest/employees'
		}).then(function successCallback(response) {
			console.log(JSON.stringify(response));
			$scope.employees = response.data;
		}, function errorCallback(response) {
			console.log(response.statusText);
		});
	}

	function _success(response) {
		_refreshEmployeesData();
		_clearFormData()
	}

	function _error(response) {
		console.log(response.statusText);
	}

//	Clear the form
	function _clearFormData() {
		$scope.employeeForm = {
				empId : -1,
				firstName :"",
				lastName :"",
				employeeAddress :{
					county : "",
					city : "",
					state : "",
				},
				bankAccounts :[{
					id : "",
					accNo : "",
					bank : "",
					branch : "",
				}],
				departments :[{
					id : "",
					departmentName : "",
				}]
		}

	}

})
