'use strict';
app.factory('receiptservice', function($http){
	return{
		getreceipts: function(){
		var request = {};
		var promise = $http.post("http://localhost:8000/receipts",request);
		return promise;
		},
		
deletereceipt: function(receipt){
	var request = {"companyid":100,"id":receipt.id};
	var promise = $http.post("http://localhost:8000/deletereceiptbyid",request);
	return promise;
	},
	
		};
		});