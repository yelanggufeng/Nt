/*
 * Activiti Modeler component part of the Activiti project
 * Copyright 2005-2014 Alfresco Software, Ltd. All rights reserved.
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.

 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

/*
 * Assignment
 */
var KisBpmAssignmentCtrl = [ '$scope', '$modal', function($scope, $modal) {

    // Config for the modal window
    var opts = {
        template:  'editor-app/configuration/properties/assignment-popup.html?version=' + Date.now(),
        scope: $scope
    };

    // Open the dialog
    $modal(opts);
}];

var KisBpmAssignmentPopupCtrl = [ '$scope','$http', function($scope,$http) {
    	
    // Put json representing assignment on scope
    if ($scope.property.value !== undefined && $scope.property.value !== null
        && $scope.property.value.assignment !== undefined
        && $scope.property.value.assignment !== null) 
    {
        $scope.assignment = $scope.property.value.assignment;
    } else {
        $scope.assignment = {};
    }
	var usersList=[]
	var GroupsList=[]
    $http({method: 'GET',url:"process/config/user?userName="}).success(function (res) {
		console.log('res----',res)
		for (var i=0;i<res.data.length;i++){
			usersList.push({
				value:res.data[i].id,
				name:res.data[i].firstName
			})
		}
	})

	$http({method: 'GET',url:"process/config/group?groupName="}).success(function (res) {
		console.log('res----',res)
		for (var i=0;i<res.data.length;i++){
			GroupsList.push({
				value:res.data[i].id,
				name:res.data[i].name
			})
		}
	})


    if ($scope.assignment.candidateUsers == undefined || $scope.assignment.candidateUsers.length == 0)
    {
    	$scope.assignment.candidateUsers = [];
    }

    $scope.getListStr=function (list) {
		var candidateUsersStr=''
		if(list.length>0){
			for(var i=0;i<list.length;i++){
				if(list[i].value){
					if(i==0){
						candidateUsersStr=list[i].name
					}else{
						candidateUsersStr+=' , '+list[i].name
					}
				}
			}
		}
		return candidateUsersStr
	}

	if ($scope.assignment.candidateGroups == undefined || $scope.assignment.candidateGroups.length == 0)
	{
		$scope.assignment.candidateGroups = [];
	}

	console.log('$scope.assignment.candidateUsers---',$scope.assignment.candidateUsers)
	console.log('$scope.assignment.candidateGroups1---',$scope.assignment.candidateGroups)
	$scope.candidateUsersStr=$scope.getListStr($scope.assignment.candidateUsers)
	$scope.candidateGroupsStr=$scope.getListStr($scope.assignment.candidateGroups)

	$scope.holdDialog=false
	$scope.subList=[]
	$scope.dialogType=''
	$scope.Groups=$scope.assignment.candidateGroups
	$scope.holdDialogShow=function (type) {
		console.log('$scope.Groups---',$scope.Groups)
		console.log('$scope.subList1---',$scope.subList)
		$scope.holdDialog=true
		$scope.subList=[]
		$scope.dialogType=type
		if(type==2){
			$scope.subList=$scope.Groups
			$scope.holdList=GroupsList
		}else {
			$scope.subList=$scope.assignment.candidateUsers
			$scope.holdList=usersList
		}
	}
	$scope.searchVal=''
	$scope.onSearch=function (val) {
		console.log('onSearch---')
		console.log('val---',val)
		console.log('$scope.searchVal---'+$scope.searchVal)
		if($scope.dialogType==2){
			$http({method: 'GET',url:"process/config/group?groupName="+val}).success(function (res) {
				console.log('res----',res)
				var list=[]
				for (var i=0;i<res.data.length;i++){
					list.push({
						value:res.data[i].id,
						name:res.data[i].name
					})
				}
				$scope.holdList=list
			})
		}else{
			$http({method: 'GET',url:'process/config/user?userName='+val}).success(function (res) {
				console.log('res----',res)
				var list=[]
				for (var i=0;i<res.data.length;i++){
					list.push({
						value:res.data[i].id,
						name:res.data[i].firstName
					})
				}
				$scope.holdList=list
			})
		}
	}

	$scope.onDel=function (index) {
		$scope.subList.splice(index,1)
	}
	$scope.onCancel=function () {
		$scope.searchVal=''
		$scope.holdList=[]
		$scope.subList=[]
		$scope.holdDialog=false
	}
	$scope.onSub=function () {
		if($scope.dialogType==2){
			$scope.candidateGroupsStr=$scope.getListStr($scope.subList)
			$scope.assignment.candidateGroups=$scope.subList
		}else{
			$scope.candidateUsersStr=$scope.getListStr($scope.subList)
			$scope.assignment.candidateUsers=$scope.subList
		}
		$scope.searchVal=''
		$scope.holdList=[]
		$scope.subList=[]
		$scope.holdDialog=false
	}
	$scope.onHold=function (item) {
		var has=false
		for(var i=0;i<$scope.subList.length;i++){
			if(item.value==$scope.subList[i].value){
				has=true
			}
		}
		if(!has){
			$scope.subList.push(item)
		}
	}
    // Click handler for + button after enum value
    var userValueIndex = 1;
    $scope.addCandidateUserValue = function(index) {
        $scope.assignment.candidateUsers.splice(index + 1, 0, {value: 'value ' + userValueIndex++});
    };

    // Click handler for - button after enum value
    $scope.removeCandidateUserValue = function(index) {
        $scope.assignment.candidateUsers.splice(index, 1);
    };
    
    if ($scope.assignment.candidateGroups == undefined || $scope.assignment.candidateGroups.length == 0)
    {
    	$scope.assignment.candidateGroups = [{value: ''}];
    }
    
    var groupValueIndex = 1;
    $scope.addCandidateGroupValue = function(index) {
        $scope.assignment.candidateGroups.splice(index + 1, 0, {value: 'value ' + groupValueIndex++});
    };

    // Click handler for - button after enum value
    $scope.removeCandidateGroupValue = function(index) {
        $scope.assignment.candidateGroups.splice(index, 1);
    };

    $scope.save = function() {
		console.log('$scope.assignment----',$scope.assignment)
        $scope.property.value = {};
        handleAssignmentInput($scope);
        $scope.property.value.assignment = $scope.assignment;
        
        $scope.updatePropertyInModel($scope.property);
        $scope.close();
    };

    // Close button handler
    $scope.close = function() {
    	handleAssignmentInput($scope);
    	$scope.property.mode = 'read';
    	$scope.$hide();
    };
    
    var handleAssignmentInput = function($scope) {
    	if ($scope.assignment.candidateUsers)
    	{
	    	var emptyUsers = true;
	    	var toRemoveIndexes = [];
	        for (var i = 0; i < $scope.assignment.candidateUsers.length; i++)
	        {
	        	if ($scope.assignment.candidateUsers[i].value != '')
	        	{
	        		emptyUsers = false;
	        	}
	        	else
	        	{
	        		toRemoveIndexes[toRemoveIndexes.length] = i;
	        	}
	        }
	        
	        for (var i = 0; i < toRemoveIndexes.length; i++)
	        {
	        	$scope.assignment.candidateUsers.splice(toRemoveIndexes[i], 1);
	        }
	        
	        if (emptyUsers)
	        {
	        	$scope.assignment.candidateUsers = undefined;
	        }
    	}
        
    	if ($scope.assignment.candidateGroups)
    	{
	        var emptyGroups = true;
	        var toRemoveIndexes = [];
	        for (var i = 0; i < $scope.assignment.candidateGroups.length; i++)
	        {
	        	if ($scope.assignment.candidateGroups[i].value != '')
	        	{
	        		emptyGroups = false;
	        	}
	        	else
	        	{
	        		toRemoveIndexes[toRemoveIndexes.length] = i;
	        	}
	        }
	        
	        for (var i = 0; i < toRemoveIndexes.length; i++)
	        {
	        	$scope.assignment.candidateGroups.splice(toRemoveIndexes[i], 1);
	        }
	        
	        if (emptyGroups)
	        {
	        	$scope.assignment.candidateGroups = undefined;
	        }
    	}
    };
}];