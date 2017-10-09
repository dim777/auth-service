/**
 * Created by rb052775 on 07.07.2015.
 */
'use strict';
var xegexControllers = angular.module('xegexControllers', []);
xegexControllers
    .controller('LoginCtrl', ['$scope', '$http', '$location', '$window', 'md5',
        function($scope,  $http, $location, $window, md5) {
            var authenticate = function(credentials, callback) {
                var headers = credentials ? {
                    authorization : "Basic " + btoa(credentials.username + ":" + credentials.password)
                } : {};

                $http.get('/user', {headers : headers}).success(function(data) {
                    if (data.name) {
                        $scope.authenticated = true;
                    } else {
                        $scope.authenticated = false;
                    }
                    callback && callback();
                }).error(function() {
                    $scope.authenticated = false;
                    callback && callback();
                });

            }

            authenticate();
            $scope.credentials = {};

            $scope.login = function() {
                authenticate($scope.credentials, function() {
                    if ($scope.authenticated) {
                        //$window.location = "dashboard/";
                        $location.path("dashboard/");
                        $scope.error = false;
                    } else {
                        $location.path("/login");
                        $scope.error = true;
                    }
                });
            };

            $scope.logout = function() {
                $http.post('logout', {}).success(function() {
                    $scope.authenticated = false;
                    $location.path("/");
                }).error(function(data) {
                    $scope.authenticated = false;
                });
            }
        }
    ])
	.controller('DashboardCtrl', ['$scope', '$http', '$location', '$window',
        function($scope,  $http, $location, $window) {
            
        }
    ]);
